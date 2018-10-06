package com.example.demo.libraries;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.*;

public class ReflectionUtils {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtils.class);

    private static final String SETTER_PREFIX = "set";
    private static final String GETTER_PREFIX = "get";
    private static final String CGLIB_CLASS_SEPARATOR = "$$";

    public static Object invokeGetter(Object obj, String propertyName) {
        String getterMethodName = GETTER_PREFIX + StringUtils.capitalize(propertyName);
        return invokeMethod(obj, getterMethodName, new Class[0], new Object[0]);
    }

    public static void invokeSetter(Object obj, String propertyName,
                                    Object value) {
        String setterMethodName = SETTER_PREFIX + StringUtils.capitalize(propertyName);
        invokeMethodByName(obj, setterMethodName, new Object[] { value });
    }

    public static Object getFieldValue(Object obj, String fieldName) {
        Field field = getAccessibleField(obj, fieldName);

        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
        }

        Object result = null;
        try {
            result = field.get(obj);
        } catch (IllegalAccessException e) {
            logger.error("不可能抛出的异常{}", e.getMessage());
        }
        return result;
    }

    public static void setFieldValue(Object obj, String fieldName, Object value) {
        Field field = getAccessibleField(obj, fieldName);

        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
        }
        try {
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            logger.error("不可能抛出的异常:{}", e.getMessage());
        }
    }

    public static Object invokeMethod(Object obj, String methodName, Class<?>[] parameterTypes, Object[] args) {
        Method method = getAccessibleMethod(obj, methodName, parameterTypes);
        if (method == null) {
            throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + obj + "]");
        }
        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            throw convertReflectionExceptionToUnchecked(e);
        }
    }

    public static Object invokeStaticMethod(Class<?> clazz, String methodName, Class<?>[] parameterTypes, Object[] args) {
        Method method = getAccessibleMethod(clazz, methodName, parameterTypes);
        if (method == null) {
            throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + clazz + "]");
        }
        try {
            return method.invoke(null, args);
        } catch (Exception e) {
            throw convertReflectionExceptionToUnchecked(e);
        }
    }

    public static Object invokeMethodByName(Object obj, String methodName, Object[] args) {
        Method method = getAccessibleMethodByName(obj, methodName);
        if (method == null) {
            throw new IllegalArgumentException("Could not find method ["
                    + methodName + "] on target [" + obj + "]");
        }
        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            throw convertReflectionExceptionToUnchecked(e);
        }
    }

    public static Field getAccessibleField(Object obj, String fieldName) {
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                Field field = superClass.getDeclaredField(fieldName);
                makeAccessible(field);
                return field;
            } catch (NoSuchFieldException e) {

            }
        }

        return null;
    }

    public static Method getAccessibleMethod(Object obj, String methodName,
                                             Class<?>... parameterTypes) {

        return getAccessibleMethod(obj.getClass(), methodName, parameterTypes);
    }

    public static Method getAccessibleMethod(Class<?> clazz, String methodName,
                                             Class<?>... parameterTypes) {

        for (Class<?> searchType = clazz; searchType != Object.class; searchType = searchType
                .getSuperclass()) {
            try {
                Method method = searchType.getDeclaredMethod(methodName, parameterTypes);
                makeAccessible(method);
                return method;
            } catch (NoSuchMethodException e) {
            }
        }
        return null;
    }

    public static Method getAccessibleMethodByName(Object obj, String methodName) {
        return getAccessibleMethodByName(obj.getClass(), methodName);
    }

    public static Method getAccessibleMethodByName(Class<?> clazz, String methodName) {

        for (Class<?> searchType = clazz; searchType != Object.class; searchType = searchType
                .getSuperclass()) {
            Method[] methods = searchType.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    makeAccessible(method);
                    return method;
                }
            }
        }
        return null;
    }

    public static void makeAccessible(Method method) {
        if (((!Modifier.isPublic(method.getModifiers())) || (!Modifier
                .isPublic(method.getDeclaringClass().getModifiers())))
                && (!method.isAccessible())) {
            method.setAccessible(true);
        }
    }

    public static void makeAccessible(Field field) {
        if (((!Modifier.isPublic(field.getModifiers()))
                || (!Modifier
                .isPublic(field.getDeclaringClass().getModifiers())) || (Modifier
                .isFinal(field.getModifiers()))) && (!field.isAccessible())) {
            field.setAccessible(true);
        }
    }

    public static Class<?> getClassGenricType(Class<?> clazz) {
        return getClassGenricType(clazz, 0);
    }

    public static Class<?> getClassGenricType(Class<?> clazz, int index) {
        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            logger.warn(clazz.getSimpleName()
                    + "'s superclass not ParameterizedType");
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if ((index >= params.length) || (index < 0)) {
            logger.warn("Index: " + index + ", Size of "
                    + clazz.getSimpleName() + "'s Parameterized Type: "
                    + params.length);

            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            logger.warn(clazz.getSimpleName()
                    + " not set the actual class on superclass generic parameter");
            return Object.class;
        }

        return (Class<?>) params[index];
    }

    public static Class<?> getUserClass(Object instance) {
        Class<?> clazz = instance.getClass();
        if ((clazz != null) && (clazz.getName().contains(CGLIB_CLASS_SEPARATOR))) {
            Class<?> superClass = clazz.getSuperclass();
            if ((superClass != null) && (!Object.class.equals(superClass))) {
                return superClass;
            }
        }
        return clazz;
    }

    public static RuntimeException convertReflectionExceptionToUnchecked(Exception e) {
        if (((e instanceof IllegalAccessException))
                || ((e instanceof IllegalArgumentException))
                || ((e instanceof NoSuchMethodException))) {
            return new IllegalArgumentException(e);
        }
        if ((e instanceof InvocationTargetException))
            return new RuntimeException(
                    ((InvocationTargetException) e).getTargetException());
        if ((e instanceof RuntimeException)) {
            return (RuntimeException) e;
        }
        return new RuntimeException("Unexpected Checked Exception.", e);
    }

}
