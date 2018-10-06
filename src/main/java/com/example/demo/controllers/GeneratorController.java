package com.example.demo.controllers;

import com.example.demo.libraries.enumerate.GeneratorType;
import com.example.demo.orm.Generator;
import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("code")
public class GeneratorController {

    private final static Logger LOGGER = LoggerFactory.getLogger(GeneratorController.class);

    private static Set<String> SUPPORT_FREEMARK;

    static {
        SUPPORT_FREEMARK = Sets.newHashSet(
                "controller",
                "service",
                "serviceImpl",
                "dao",
                "repository",
                "mainService"
        );
    }

    @RequestMapping(value = "show", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView generator(@RequestParam(value="beanName") String beanName,
                                  @RequestParam(value="subPackage", required=false) String subPackage,
                                  @RequestParam(value="basePackage", required=false) String basePackage,
                                  @RequestParam(value="freemark", required=false) String freemark,
                                  @RequestParam(value="type", required=false) String type,
                                  @RequestParam(value="show", required=false) String show) {
        ModelAndView mv = new ModelAndView();
        try {
            GeneratorType generatorType = GeneratorType.mongodb;
            if (GeneratorType.hibernate.getName().equalsIgnoreCase(type)) {
                generatorType = GeneratorType.hibernate;
            }
            Generator generator = new Generator(Class.forName(beanName), basePackage, subPackage, generatorType);
            if (StringUtils.isBlank(freemark) || !SUPPORT_FREEMARK.contains(freemark)) {
                freemark = "controller";
            }
            mv.setViewName(freemark);
            mv.addObject("generator", generator);
            Set<String> attributeClassNames = new HashSet<>();
            attributeClassNames.add(generator.getBeanClassName());
            if (CollectionUtils.isNotEmpty(generator.getComplexAttributes())) {
                List<Generator> complexAttributes = generator.getComplexAttributes();
                for (Generator complexAttribute : complexAttributes) {
                    attributeClassNames.add(complexAttribute.getBeanClassName());
                }
            }
            mv.addObject("attributeClassNames", attributeClassNames);
            mv.addObject("supports", SUPPORT_FREEMARK);
            if (StringUtils.isEmpty(show) || !show.equals("test")) {
                mv.addObject("show", true);
            }
        } catch (Exception e) {
            LOGGER.error("Generator '" + beanName + "' Code Error!", e);
            mv.setViewName("error");
            mv.addObject("errorMsg", "Generator '" + beanName + "' Code Error!");
        }
        return mv;
    }

}
