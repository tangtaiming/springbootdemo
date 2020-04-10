<#assign basePackage=generator.basePackage >
<#assign subPackage=generator.subPackage!"" >
<#assign beanClassName=generator.beanClassName >
<#assign beanName=generator.beanName >
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
<a href="/code/show?beanName=${beanClassName}&freemark=service&type=mongodb">Mongodb</a>
<a href="/code/show?beanName=${beanClassName}&freemark=service&type=hibernate">Hibernate</a>
<br />
<br />
<a href="/code/download?beanName=${beanClassName}&freemark=service&type=${type}" >Download</a>
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

import java.util.List;
import java.util.Map;

import ${beanClassName};

public interface ${beanName}Service {

	List${leftAngle}${beanName}${rightAngle} fetch${beanName}List(Map${leftAngle}String, Object${rightAngle} query);

	Long fetch${beanName}Count(Map${leftAngle}String, Object${rightAngle} query);

	${beanName} fetchById(${idClassName} id);

	Boolean saveOrUpdate(Map${leftAngle}String, Object${rightAngle} query);

	Boolean delete(${idClassName} id);

	List${leftAngle}${beanName}${rightAngle} fetch${beanName}Collection(Map${leftAngle}String, Object${rightAngle} query);

	Long fetch${beanName}CollectionCount(Map${leftAngle}String, Object${rightAngle} query);

}
<#if show??>
</pre>
</#if>