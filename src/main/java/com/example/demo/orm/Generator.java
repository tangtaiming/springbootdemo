package com.example.demo.orm;

import com.example.demo.libraries.ReflectionUtils;
import com.example.demo.libraries.enumerate.GeneratorType;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.util.*;

public class Generator {

    private static final String DEFAULT_PACKAGE = "com.tomtop.application";

    private static Set<Class<?>> SIMPLE_CLASSES;
    private static Set<Class<?>> COLLECTION_CLASSES;
    private static Map<Class<?>, Class<?>> BASE_CLASSES_MAP = Maps.newHashMap();

    static {
        SIMPLE_CLASSES = Sets.newHashSet(
                boolean.class,Boolean.class,
                int.class,Integer.class,
                long.class,Long.class,
                double.class,Double.class,
                float.class,Float.class,
                byte.class,Byte.class,
                short.class,Short.class,
                char.class,Character.class,
                String.class
        );
        COLLECTION_CLASSES = Sets.newHashSet(Map.class, List.class, Set.class);

        BASE_CLASSES_MAP.put(boolean.class, Boolean.class);
        BASE_CLASSES_MAP.put(int.class, Integer.class);
        BASE_CLASSES_MAP.put(long.class, Long.class);
        BASE_CLASSES_MAP.put(double.class, Double.class);
        BASE_CLASSES_MAP.put(float.class, Float.class);
        BASE_CLASSES_MAP.put(byte.class, Byte.class);
        BASE_CLASSES_MAP.put(short.class, Short.class);
        BASE_CLASSES_MAP.put(char.class, Character.class);
    }

    private String basePackage = DEFAULT_PACKAGE;
    private String subPackage;
    private String beanName;
    private String beanLowercaseName;
    private String idClassName;
    private String attributeName;
    private String attributeLowercaseName;
    private Class<?> beanClass;
    private String beanClassName;
    private String attributeClassName = "Object";
    private Boolean todo;
    private GeneratorType type;
    private List<Generator> complexAttributes;

    public Generator(Class<?> beanClass) {
        this(beanClass, null, null);
    }

    public Generator(Class<?> beanClass, GeneratorType type) {
        this(beanClass, null, null, type);
    }

    public Generator(Class<?> beanClass, String basePackage, String subPackage) {
        this(beanClass, basePackage, subPackage, GeneratorType.mongodb);
    }

    public Generator(Class<?> beanClass, String basePackage, String subPackage, GeneratorType type) {
        if (beanClass == null) {
            throw new NullPointerException("beanClass can not null");
        }
        if (basePackage != null) {
            this.basePackage = basePackage;
        }
        this.subPackage = subPackage;
        String beanName = beanClass.getSimpleName();
        String beanLowercaseName = StringUtils.uncapitalize(beanName);
        this.beanName = beanName;
        this.attributeName = beanName;
        this.beanLowercaseName = beanLowercaseName;
        this.attributeLowercaseName = beanLowercaseName;
        this.beanClass = beanClass;
        this.beanClassName = beanClass.getName();
        this.type = type;
        this.idClassName = getIdClassName(beanClass);
        this.complexAttributes = parseComplexAttributes(beanClass);
    }

    private String getIdClassName(Class<?> beanClass) {
        Field[] fields = beanClass.getDeclaredFields();
        String idClassName = "Long";
        for (Field field : fields) {
            if ("id".equals(field.getName())) {
                idClassName = BASE_CLASSES_MAP.getOrDefault(field.getType(), field.getType()).getSimpleName();
                break;
            }
        }
        return idClassName;
    }

    @SuppressWarnings("unchecked")
    private List<Generator> parseComplexAttributes(Class<?> beanClass) {
        Field[] fields = beanClass.getDeclaredFields();
        List<Generator> results = new ArrayList<>();
        Map<String, Class<?>> mapper = new HashMap<>();
        try {
            mapper = (Map<String, Class<?>>) ReflectionUtils.invokeStaticMethod(beanClass, "getMapper", null, null);
        } catch (Exception e) {
            // skip
        }
        field:for (Field field : fields) {
            if (SIMPLE_CLASSES.contains(field.getType())) {
                continue;
            }
            if (field.getType().isArray()) {
                continue;
            }
            String capFieldName = StringUtils.capitalize(field.getName());
            if (null == ReflectionUtils.getAccessibleMethodByName(beanClass, "get" + capFieldName)) {
                continue;
            }
            for (Class<?> collectionClass : COLLECTION_CLASSES) {
                if (collectionClass.isAssignableFrom(field.getType())) {
                    Class<?> clazz = mapper.get(field.getName());
                    if (null != clazz && !SIMPLE_CLASSES.contains(clazz)) {
                        Generator subGenerator = new Generator(clazz);
                        subGenerator.setAttributeName(capFieldName);
                        subGenerator.setAttributeLowercaseName(field.getName());
                        subGenerator.setAttributeClassName(collectionClass.getSimpleName());
                        results.add(subGenerator);
                    } else if (null == clazz){
                        setTodo(Boolean.TRUE);
                    }
                    continue field;
                }
            }
            Generator subGenerator = new Generator(field.getType());
            subGenerator.setAttributeName(capFieldName);
            subGenerator.setAttributeLowercaseName(field.getName());
            results.add(subGenerator);
        }
        return results;
    }

    public String getBasePackage() {
        return basePackage;
    }
    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }
    public String getSubPackage() {
        return subPackage;
    }
    public void setSubPackage(String subPackage) {
        this.subPackage = subPackage;
    }
    public List<Generator> getComplexAttributes() {
        return complexAttributes;
    }
    public void setComplexAttributes(List<Generator> complexAttributes) {
        this.complexAttributes = complexAttributes;
    }
    public Boolean getTodo() {
        return todo;
    }
    public void setTodo(Boolean todo) {
        this.todo = todo;
    }
    public String getBeanName() {
        return beanName;
    }
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
    public String getBeanLowercaseName() {
        return beanLowercaseName;
    }
    public void setBeanLowercaseName(String beanLowercaseName) {
        this.beanLowercaseName = beanLowercaseName;
    }
    public Class<?> getBeanClass() {
        return beanClass;
    }
    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }
    public String getBeanClassName() {
        return beanClassName;
    }
    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }
    public String getAttributeClassName() {
        return attributeClassName;
    }
    public void setAttributeClassName(String attributeClassName) {
        this.attributeClassName = attributeClassName;
    }
    public String getAttributeName() {
        return attributeName;
    }
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
    public String getAttributeLowercaseName() {
        return attributeLowercaseName;
    }
    public void setAttributeLowercaseName(String attributeLowercaseName) {
        this.attributeLowercaseName = attributeLowercaseName;
    }
    public String getIdClassName() {
        return idClassName;
    }
    public void setIdClassName(String idClassName) {
        this.idClassName = idClassName;
    }
    public GeneratorType getType() {
        return type;
    }
    public void setType(GeneratorType type) {
        this.type = type;
    }

}
