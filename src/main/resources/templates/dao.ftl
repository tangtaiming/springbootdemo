<#assign basePackage=generator.basePackage >
<#assign subPackage=generator.subPackage!"" >
<#assign beanClassName=generator.beanClassName >
<#assign beanName=generator.beanName >
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
<a href="/code/show?beanName=${beanClassName}&freemark=dao&type=mongodb">Mongodb</a>
<br />
<br />
<a href="/code/download?beanName=${beanClassName}&freemark=dao&type=mongodb" >Download</a>
<pre class="brush: java; toolbar: false;">
    <#assign leftAngle="&lt;" >
    <#assign rightAngle="&gt;" >
<#else>
    <#assign leftAngle="<" >
    <#assign rightAngle=">" >
</#if>
<#if subPackage?? && subPackage != "" >
package ${basePackage}.dao.${subPackage};
<#else>
package ${basePackage}.dao;
</#if>

import org.springframework.stereotype.Component;

import ${beanClassName};

@Component
public class ${beanName}Dao extends Mongo3Dao${leftAngle}${beanName}${rightAngle} {

}
<#if show??>
</pre>
</#if>