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
<a href="/code/show?beanName=${beanClassName}&freemark=${support}&type=${type}">${support}</a>
            </#if>
        </#list>
    </#if>
<br />
<br />
<a href="/code/show?beanName=${beanClassName}&freemark=mainService&type=mongodb">Mongodb</a>
<a href="/code/show?beanName=${beanClassName}&freemark=mainService&type=hibernate">Hibernate</a>
<br />
<br />
<a href="/code/download?beanName=${beanClassName}&freemark=mainService&type=${type}" >Download</a>
<pre class="brush: java; toolbar: false;">
    <#assign leftAngle="&lt;" >
    <#assign rightAngle="&gt;" >
<#else>
    <#assign leftAngle="<" >
    <#assign rightAngle=">" >
</#if>
<#if subPackage?? && subPackage != "" >
package ${basePackage}.service.${subPackage};
<#else>
package ${basePackage}.service;
</#if>

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;

import com.tomtop.system.service.RestBasicServiceArgs;
import com.tomtop.system.service.ServiceResult;

<#if attributeClassNames?? && (attributeClassNames?size > 0) >
    <#list attributeClassNames as attributeClassName >
import ${attributeClassName};
    </#list>
</#if>

public class ${beanName}MainService extends RestBasicServiceArgs {

	private static final String FETCH_BEAN_COLLECTION = "/${subPackage}/fetch${beanName}Collection";
	private static final String FETCH_BEAN_BY_ID = "/${subPackage}/fetch${beanName}ById";
	private static final String FETCH_BEAN_LIST = "/${subPackage}/fetch${beanName}List";
<#if type=="hibernate" >
	private static final String SAVE_BEAN = "/${subPackage}/save${beanName}";
	private static final String UPDATE_BEAN = "/${subPackage}/update${beanName}";
<#else>
	private static final String SAVE_OR_UPDATE_BEAN = "/${subPackage}/saveOrUpdate${beanName}";
</#if>
	private static final String DELETE_BEAN_BY_ID = "/${subPackage}/delete${beanName}ById";
	private static final String FETCH_BEAN_COUNT = "/${subPackage}/fetch${beanName}Count";

	public ${beanName} fetchById(String id) {
		String url = FETCH_BEAN_BY_ID + "/" + id;
		setServiceEntry(url);
        return (${beanName}) request(null, ${beanName}.class);
	}

	public Map${leftAngle}String, Object${rightAngle} fetch${beanName}Collection(Map${leftAngle}String, Object${rightAngle} query) {
		setServiceEntry(FETCH_BEAN_COLLECTION);
        Map${leftAngle}String, Object${rightAngle} data = getCollection(query);
        @SuppressWarnings("unchecked")
		List${leftAngle}Map${leftAngle}String, Object${rightAngle}${rightAngle} lists = (List${leftAngle}Map${leftAngle}String, Object${rightAngle}${rightAngle}) data.get("collection");
        List${leftAngle}${beanName}${rightAngle} beanList = new ArrayList${leftAngle}${rightAngle}();
        if (CollectionUtils.isNotEmpty(lists)) {
        	for (Map${leftAngle}String, Object${rightAngle} map : lists) {
        		beanList.add(_mapTo${beanName}(map));
			}
        }
        data.put("collection", beanList);
        return data;
	}

<#if type=="hibernate" >
	public Boolean save(${beanName} bean) {
		if (bean == null) {
			return Boolean.FALSE;
		}
		setServiceEntry(SAVE_BEAN);
		setServiceRequestCreate(bean);
		request();
	    return checkSuccess();
	}

	public Boolean update(${beanName} bean) {
		if (bean == null) {
			return Boolean.FALSE;
		}
		setServiceEntry(UPDATE_BEAN);
		setServiceRequestCreate(bean);
		request();
	    return checkSuccess();
	}
<#else>
	public Boolean saveOrUpdate(${beanName} bean) {
		if (bean == null) {
			return Boolean.FALSE;
		}

		setServiceEntry(SAVE_OR_UPDATE_BEAN);
		String saveOrUpdate = getServiceRequestCreate(bean);
		ServiceResult serviceResult = execute(saveOrUpdate);
		return serviceResult.checkSuccess();
	}
</#if>

	public Boolean delete(${idClassName} id) {
		String url = DELETE_BEAN_BY_ID + "/" + id;
		setServiceEntry(url);
		ServiceResult serviceResult = execute(null);

		return serviceResult.checkSuccess();
	}

	public List${leftAngle}${beanName}${rightAngle} fetch${beanName}List(Map${leftAngle}String, Object${rightAngle} query, Map${leftAngle}String, Object${rightAngle} sort, Map${leftAngle}String, Object${rightAngle} pagination) {
		Map${leftAngle}String, Object${rightAngle} queryFlat = query;
        if (null != queryFlat && queryFlat.size() ${rightAngle} 1 && queryFlat.containsKey("id")) {
            if (!queryFlat.containsKey("_id")) {
                queryFlat.put("_id", queryFlat.get("id"));
            }
            queryFlat.remove("id");
        }

		setServiceEntry(FETCH_BEAN_LIST);
        String serviceRequest = getServiceRequestQuery(queryFlat, sort, pagination);
        List${leftAngle}${beanName}${rightAngle} results = (List${leftAngle}${beanName}${rightAngle}) requestList(serviceRequest, ${beanName}.class);
        return results;
	}

	public Long fetch${beanName}Count(Map${leftAngle}String, Object${rightAngle} query) {
		Map${leftAngle}String, Object${rightAngle} queryFlat = query;
        if (queryFlat.size() ${rightAngle} 1 && queryFlat.containsKey("id")) {
            if ( ! queryFlat.containsKey("_id")) {
                queryFlat.put("_id", queryFlat.get("id"));
            }
            queryFlat.remove("id");
        }

		setServiceEntry(FETCH_BEAN_COUNT);
        String serviceRequest =  getServiceRequestQuery(queryFlat, null, null);
        Object result = request(serviceRequest);
        Long count = 0L;
        if (null != result) {
            count = Long.valueOf(result.toString());
        }
        return count;
	}

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

}
<#if show??>
</pre>
</#if>