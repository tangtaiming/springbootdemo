package com.example.demo.controllers;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping("qiniu")
public class QiniuController {

    /**
     * 基本上传
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String execute() {
        return "/qiniu/index";
    }

    @RequestMapping(value = "service", method = RequestMethod.GET)
    public String service() {
        return "/qiniu/service";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("upload") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("file = " + file.getOriginalFilename());
        if (file.isEmpty()) {
            System.out.println("File " + file.getName() + " is null!");
        }
        String filename = file.getOriginalFilename();
        String picSuffix = getPicSuffix(filename);
        String picPrefix = getPicPrefix(filename);
        System.out.println("picSuffix = " + picSuffix);
        System.out.println("picPrefix = " + picPrefix);

        //获取跟目录
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String newfile = path.getAbsolutePath() + "\\static\\images\\upload\\up-" + System.currentTimeMillis() + "." + picSuffix;
        System.out.println("newFile = " + newfile);
        File newf = new File(newfile);
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), newf);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("path:"+path.getAbsolutePath());
        return "/qiniu/success";
    }

    /*
     * 获取扩展名
     */
    public String getPicSuffix(String img_path, String sign) {
        if (img_path == null || img_path.indexOf(sign) == -1) {
            return ""; //如果图片地址为null或者地址中没有"."就返回""
        }
        return img_path.substring(img_path.lastIndexOf(sign) + sign.length()).
                trim();
    }

    public String getPicSuffix(String imagePath) {
        return getPicSuffix(imagePath, ".");
    }

    /*
     * 获取扩展名以外的其余部分
     */
    public String getPicPrefix(String img_path, String sign) {
        if (img_path == null || img_path.indexOf(sign) == -1) {
            return ""; //如果图片地址为null或者地址中没有"."就返回""
        }
        return img_path.substring(0, img_path.lastIndexOf(sign)).
                trim();
    }

    public String getPicPrefix(String imgPath) {
        return getPicPrefix(imgPath, ".");
    }

}
