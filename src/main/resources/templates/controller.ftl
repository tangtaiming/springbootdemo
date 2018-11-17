<#assign basePackage=generator.basePackage >
<#assign subPackage=generator.subPackage!"" >
<#assign beanClassName=generator.beanClassName >
<#assign beanName=generator.beanName >
<#assign beanLowercaseName=generator.beanLowercaseName >
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
<a href="/code/show?beanName=${beanClassName}&freemark=controller&type=mongodb">Mongodb</a>
<a href="/code/show?beanName=${beanClassName}&freemark=controller&type=hibernate">Hibernate</a>
<br />
<br />
<a href="/code/download?beanName=${beanClassName}&freemark=controller&type=${type}" >Download</a>
<pre class="brush: java; toolbar: false;">
    <#assign leftAngle="&lt;" >
    <#assign rightAngle="&gt;" >
<#else>
    <#assign leftAngle="<" >
    <#assign rightAngle=">" >
</#if>
<#if subPackage?? && subPackage != "" >
package ${basePackage}.controller.${subPackage};
<#else>
package ${basePackage}.controller;
</#if>

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ${beanClassName};
import ${basePackage}.service<#if subPackage?? && subPackage != "" >.${subPackage}</#if>.${beanName}Service;
import com.tomtop.application.service.TomtopService;
import com.tomtop.system.core.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "${subPackage}", method = RequestMethod.POST)
public class ${beanName}Controller extends TomtopService {

	@Autowired
	private ${beanName}Service ${beanLowercaseName}Service;

	@RequestMapping(value = "fetch${beanName}List")
	@ResponseBody
	public ServiceResponse fetch${beanName}List(@RequestBody Map${leftAngle}String, Object${rightAngle} query) {
		List${leftAngle}${beanName}${rightAngle} list = new ArrayList<>();
		try {
			list = ${beanLowercaseName}Service.fetch${beanName}List(query);
		} catch (Exception e) {
            return buildExceptionResponse(e);
        }

		return buildSuccessResponse(list);
	}

	@RequestMapping(value = "fetch${beanName}Count")
	@ResponseBody
	public ServiceResponse fetch${beanName}Count(@RequestBody Map${leftAngle}String, Object${rightAngle} query) {
		Long count = null;
        try {
            count = ${beanLowercaseName}Service.fetch${beanName}Count(query);
        } catch (Exception e) {
            return buildExceptionResponse(e);
        }

        return buildSuccessResponse(count);
	}

	@RequestMapping(value = "fetch${beanName}ById/{id}")
	@ResponseBody
	public ServiceResponse fetch${beanName}ById(@PathVariable("id") String id) {
		${beanName} bean = null;
		try {
			bean = ${beanLowercaseName}Service.fetchById(${idClassName}.valueOf(id));
		} catch (Exception e) {
			return buildExceptionResponse(e);
		}
		return buildSuccessResponse(bean);
	}

	@RequestMapping(value = "fetch${beanName}Collection")
	@ResponseBody
	public ServiceResponse fetch${beanName}Collection(@RequestBody Map${leftAngle}String, Object${rightAngle} query) {
		Map${leftAngle}String, Object${rightAngle} collectionMap = new HashMap${leftAngle}${rightAngle}();
        try {
            List${leftAngle}${beanName}${rightAngle} collection = ${beanLowercaseName}Service.fetch${beanName}Collection(query);
            Long count = ${beanLowercaseName}Service.fetch${beanName}CollectionCount(query);
            collectionMap.put(COLLECTION, collection);
			collectionMap.put(COLLECTION_COUNT, count);
        } catch (Exception e) {
			return buildExceptionResponse(e);
		}
		return buildSuccessResponse(collectionMap);
	}

<#if type=="hibernate" >
	@RequestMapping(value = "save${beanName}")
	@ResponseBody
	public ServiceResponse save${beanName}(@RequestBody Map${leftAngle}String, Object${rightAngle} query) {
		try {
			if (${beanLowercaseName}Service.save(query)) {
				return buildSuccessResponse();
			} else {
	            return buildErrorResponse();
			}
		 } catch (Exception e) {
            return buildExceptionResponse(e);
         }
	}

	@RequestMapping(value = "update${beanName}")
	@ResponseBody
	public ServiceResponse update${beanName}(@RequestBody Map${leftAngle}String, Object${rightAngle} query) {
		try {
			if (${beanLowercaseName}Service.update(query)) {
				return buildSuccessResponse();
			} else {
				return buildErrorResponse();
			}
		} catch (Exception e) {
			return buildExceptionResponse(e);
		}
	}
<#else>
	@RequestMapping(value = "saveOrUpdate${beanName}")
	@ResponseBody
	public ServiceResponse saveOrUpdate${beanName}(@RequestBody Map${leftAngle}String, Object${rightAngle} query) {
		try {
			if (${beanLowercaseName}Service.saveOrUpdate(query)) {
				return buildSuccessResponse();
			} else {
				return buildErrorResponse();
			}
		} catch (Exception e) {
			return buildExceptionResponse(e);
		}
	}
</#if>

	@RequestMapping(value = "delete${beanName}ById/{id}")
	@ResponseBody
	public ServiceResponse delete${beanName}ById(@PathVariable("id") String id) {
		try {
			if (${beanLowercaseName}Service.delete(${idClassName}.valueOf(id))) {
				return buildSuccessResponse();
			} else {
				return buildErrorResponse();
			}
		} catch (Exception e) {
			return buildExceptionResponse(e);
		}
	}

}
<#if show??>
</pre>
</#if>