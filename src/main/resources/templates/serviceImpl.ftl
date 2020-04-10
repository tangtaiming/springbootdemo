<#assign basePackage=generator.basePackage >
<#assign subPackage=generator.subPackage!"" >
<#assign beanClassName=generator.beanClassName >
<#assign beanName=generator.beanName >
<#assign beanLowercaseName=generator.beanLowercaseName >
<#assign complexAttributes = generator.complexAttributes >
<#assign idClassName=generator.idClassName >
<#assign type=generator.type >
<#if show??>
    <#include "syntaxHighlighter.ftl" />
    <#if supports??>
        <#list supports as support>
            <#if !(support=="dao" && type=="hibernate") && !(support=="repository" && type=="mongodb") >
<a href="/code/show?beanName=${beanClassName}&freemark=${support}&type=${type}&subPackage=${subPackage}">${support}</a>
            </#if>
        </#list>
    </#if>
<br />
<br />
<a href="/code/show?beanName=${beanClassName}&freemark=serviceImpl&type=mongodb">Mongodb</a>
<a href="/code/show?beanName=${beanClassName}&freemark=serviceImpl&type=hibernate">Hibernate</a>
<br />
<br />
<a href="/code/download?beanName=${beanClassName}&freemark=serviceImpl&type=${type}" >Download</a>
<pre class="brush: java; toolbar: false;">
    <#assign leftAngle="&lt;" >
    <#assign rightAngle="&gt;" >
<#else>
    <#assign leftAngle="<" >
    <#assign rightAngle=">" >
</#if>
<#if subPackage?? && subPackage != "" >
package ${basePackage}.service.impl.${subPackage};
<#else>
package ${basePackage}.service.impl;
</#if>

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<#if type=="hibernate" >
import com.tomtop.application.repository<#if subPackage?? && subPackage != "" >.${subPackage}</#if>.${beanName}Repository;
<#else>
import com.tomtop.application.dao<#if subPackage?? && subPackage != "" >.${subPackage}</#if>.${beanName}Dao;
</#if>
<#if attributeClassNames?? && (attributeClassNames?size > 0) >
    <#list attributeClassNames as attributeClassName >
import ${attributeClassName};
    </#list>
</#if>
<#if subPackage?? && subPackage != "" >
import ${basePackage}.service<#if subPackage?? && subPackage != "" >.${subPackage}</#if>.${subPackage}.${beanName}Service;
<#else>
import ${basePackage}.service<#if subPackage?? && subPackage != "" >.${subPackage}</#if>.${beanName}Service;
</#if>

@Service("${beanLowercaseName}Service")
public class ${beanName}ServiceImpl implements ${beanName}Service {

	@Autowired
<#if type=="hibernate" >
	private ${beanName}Repository ${beanLowercaseName}Repository;
<#else>
	private ${beanName}Dao ${beanLowercaseName}Dao;
</#if>

	@Override
	public List${leftAngle}${beanName}${rightAngle} fetch${beanName}List(Map${leftAngle}String, Object${rightAngle} query) {
<#if type=="hibernate" >
		return ${beanLowercaseName}Repository.fetchCollection(query);
<#else>
		return ${beanLowercaseName}Dao.fetchCollection(query);
</#if>
	}

	@Override
	public Long fetch${beanName}Count(Map${leftAngle}String, Object${rightAngle} query) {
<#if type=="hibernate" >
		return ${beanLowercaseName}Repository.fetchCollectionCount(query);
<#else>
		return ${beanLowercaseName}Dao.fetchCollectionCount(query);
</#if>
	}

	@Override
	public ${beanName} fetchById(${idClassName} id) {
<#if type=="hibernate" >
		return ${beanLowercaseName}Repository.findOne(query);
<#else>
		return ${beanLowercaseName}Dao.findById(id);
</#if>
	}

<#if type=="hibernate" >
	@Override
	public Boolean save(Map${leftAngle}String, Object${rightAngle} query) {
		return ${beanLowercaseName}Repository.save(query);
	}

	@Override
	public Boolean update(Map${leftAngle}String, Object${rightAngle} query) {
		return ${beanLowercaseName}Repository.update(query);
	}
<#else>
	@Override
	public Boolean saveOrUpdate(Map${leftAngle}String, Object${rightAngle} query) {
    ${beanName} bean = _mapTo${beanName}(query);
		if (null == bean) {
			return Boolean.FALSE;
		}
		if (bean.getId() == null) {
			bean.setId(${idClassName}.valueOf(${beanLowercaseName}Dao.getNextId(${beanName}.class.getName())));
		}
		return ${beanLowercaseName}Dao.saveOrUpdate(bean);
	}
</#if>

	@Override
	public Boolean delete(${idClassName} id) {
<#if type=="hibernate" >
		return ${beanLowercaseName}Repository.delete(id);
<#else>
		return ${beanLowercaseName}Dao.deleteById(id);
</#if>
	}

	@Override
	public List${leftAngle}${beanName}${rightAngle} fetch${beanName}Collection(Map${leftAngle}String, Object${rightAngle} query) {
<#if type=="hibernate" >
		return ${beanLowercaseName}Repository.fetchCollection(query);
<#else>
		return ${beanLowercaseName}Dao.fetchCollection(query);
</#if>
	}

	@Override
	public Long fetch${beanName}CollectionCount(Map${leftAngle}String, Object${rightAngle} query) {
<#if type=="hibernate" >
		return ${beanLowercaseName}Repository.fetchCollectionCount(query);
<#else>
		return ${beanLowercaseName}Dao.fetchCollectionCount(query);
</#if>
	}



<#if type!="hibernate" >
    <#if complexAttributes?? && (complexAttributes?size > 0) >
	@SuppressWarnings("unchecked")
    </#if>
	private ${beanName} _mapTo${beanName}(Map${leftAngle}String, Object${rightAngle} result) {
		if (result != null) {
			try {
    ${beanName} bean = new ${beanName}();
				BeanUtils.populate(bean, result);
    <#if complexAttributes?? && (complexAttributes?size > 0) >
        <#list complexAttributes as complexAttribute >
            <#if complexAttribute.attributeClassName == "Object" >
				Map${leftAngle}String, Object${rightAngle} ${complexAttribute.attributeLowercaseName} = (Map${leftAngle}String, Object${rightAngle}) result.get("${complexAttribute.attributeLowercaseName}");
				if (null != ${complexAttribute.attributeLowercaseName} && !${complexAttribute.attributeLowercaseName}.isEmpty()) {
                ${complexAttribute.beanName} subBean = new ${complexAttribute.beanName}();
					BeanUtils.populate(subBean, ${complexAttribute.attributeLowercaseName});
					bean.set${complexAttribute.attributeName}(subBean);
				}
            <#elseif complexAttribute.attributeClassName == "Map" >
				Map${leftAngle}String, Map${leftAngle}String, Object${rightAngle}${rightAngle} ${complexAttribute.attributeLowercaseName}Map = (Map${leftAngle}String, Map${leftAngle}String, Object${rightAngle}${rightAngle}) result.get("${complexAttribute.attributeLowercaseName}");
				if (null != ${complexAttribute.attributeLowercaseName}Map && !${complexAttribute.attributeLowercaseName}Map.isEmpty()) {
					Map${leftAngle}String, ${complexAttribute.beanName}${rightAngle} subBeanMap = new HashMap${leftAngle}${rightAngle}();
					for (Entry${leftAngle}String, Map${leftAngle}String, Object${rightAngle}${rightAngle} entry : ${complexAttribute.attributeLowercaseName}Map.entrySet()) {
                ${complexAttribute.beanName} subBean = new ${complexAttribute.beanName}();
						BeanUtils.populate(subBean, entry.getValue());
						subBeanMap.put(entry.getKey(), subBean);
					}
					bean.set${complexAttribute.attributeName}(subBeanMap);
				}
            <#elseif complexAttribute.attributeClassName == "List" >
				List${leftAngle}Map${leftAngle}String, Object${rightAngle}${rightAngle} ${complexAttribute.attributeLowercaseName}List = (List${leftAngle}Map${leftAngle}String, Object${rightAngle}${rightAngle}) result.get("${complexAttribute.attributeLowercaseName}");
				if (CollectionUtils.isNotEmpty(${complexAttribute.attributeLowercaseName}List)) {
					List${leftAngle}${complexAttribute.beanName}${rightAngle} subBeanList = new ArrayList${leftAngle}${rightAngle}();
					for (Map${leftAngle}String, Object${rightAngle} map : ${complexAttribute.attributeLowercaseName}List) {
                ${complexAttribute.beanName} subBean = new ${complexAttribute.beanName}();
						BeanUtils.populate(subBean, map);
						subBeanList.add(subBean);
					}
					bean.set${complexAttribute.attributeName}(subBeanList);
				}
            <#elseif complexAttribute.attributeClassName == "Set" >
				List${leftAngle}Map${leftAngle}String, Object${rightAngle}${rightAngle} ${complexAttribute.attributeLowercaseName}Set = (List${leftAngle}Map${leftAngle}String, Object${rightAngle}${rightAngle}) result.get("${complexAttribute.attributeLowercaseName}");
				if (CollectionUtils.isNotEmpty(${complexAttribute.attributeLowercaseName}Set)) {
					Set${leftAngle}${complexAttribute.beanName}${rightAngle} subBeanSet = new HashSet${leftAngle}${rightAngle}();
					for (Map${leftAngle}String, Object${rightAngle} map : ${complexAttribute.attributeLowercaseName}Set) {
                ${complexAttribute.beanName} subBean = new ${complexAttribute.beanName}();
						BeanUtils.populate(subBean, map);
						subBeanSet.add(subBean);
					}
					bean.set${complexAttribute.attributeName}(subBeanSet);
				}
            </#if>
        </#list>
    </#if>
    <#if generator.todo?? && generator.todo >

				// TODO Please Implement getMapper Function
				// public static Map${leftAngle}String, Class${leftAngle}?${rightAngle}${rightAngle} ${beanName}.getMapper()
				// Let Code Generator Know How to Deal With Complex Attributes

    </#if>
				return bean;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
</#if>

}
<#if show??>
</pre>
</#if>