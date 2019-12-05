package com.example.demo.controllers;

import com.example.demo.libraries.FileResponseHelper;
import com.example.demo.libraries.QiniuCloudHelper;
import com.example.demo.libraries.WangEditorFileResponseHelper;
import org.apache.catalina.LifecycleState;
import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("qiniu")
public class QiniuUploadController {

    @RequestMapping(value = "/wangEditorUpload")
    @ResponseBody
    public void wangEditorUpload(@RequestParam(value = "files") MultipartFile file, HttpServletResponse response) {
        System.out.println("file = " + file.getOriginalFilename());
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file.isEmpty()) {
            String error = WangEditorFileResponseHelper.fail();
            out.print(error);
        }
        //获取文件名称
        String filename = file.getOriginalFilename();
        //获取文件类型
        String picSuffix = getPicSuffix(filename);
        //获取文件名
        String picPrefix = getPicPrefix(filename);
        System.out.println("picSuffix = " + picSuffix);
        System.out.println("picPrefix = " + picPrefix);

        //获取跟目录
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            String error = WangEditorFileResponseHelper.fail();
            out.print(error);
        }
        //创建新文件名称
        String newFileName = "up-" + System.currentTimeMillis() + "." + picSuffix;
        //创建新文件保存地址
        String newfile = path.getAbsolutePath() + "\\static\\images\\upload\\" + newFileName;
        System.out.println("newFile = " + newfile);
        File newf = new File(newfile);
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), newf);
        } catch (IOException e) {
//            e.printStackTrace();
            String error = WangEditorFileResponseHelper.fail();
            out.print(error);
        }

        String url = "http://127.0.0.1:8080/static/images/upload/" + newFileName;
        String success = WangEditorFileResponseHelper.success(Arrays.asList(url));
        out.print(success);
//        QiniuCloudHelper qiniuCloudHelper = new QiniuCloudHelper();
//        qiniuCloudHelper.upload(newfile, "static/images/upload/" + newFileName);
//        String success = FileResponseHelper.success(1, newFileName, url, "");
//        out.print(success);
    }

    @RequestMapping(value = "/upload")
    @ResponseBody
    public void upload(@RequestParam("upload") MultipartFile file, HttpServletResponse response) {
        System.out.println("file = " + file.getOriginalFilename());
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file.isEmpty()) {
            String error = FileResponseHelper.error(0, "文件为空");
            out.print(error);
        }
        //获取文件名称
        String filename = file.getOriginalFilename();
        //获取文件类型
        String picSuffix = getPicSuffix(filename);
        //获取文件名
        String picPrefix = getPicPrefix(filename);
        System.out.println("picSuffix = " + picSuffix);
        System.out.println("picPrefix = " + picPrefix);

        //获取跟目录
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            String error = FileResponseHelper.error(0, "无状态异常-1");
            out.print(error);
        }
        //创建新文件名称
        String newFileName = "up-" + System.currentTimeMillis() + "." + picSuffix;
        //创建新文件保存地址
        String newfile = path.getAbsolutePath() + "\\static\\images\\upload\\" + newFileName;
        System.out.println("newFile = " + newfile);
        File newf = new File(newfile);
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), newf);
        } catch (IOException e) {
//            e.printStackTrace();
            String error = FileResponseHelper.error(0, "无状态异常-2");
            out.print(error);
        }

        String url = "http://127.0.0.1:8080/static/images/upload/" + newFileName;

        QiniuCloudHelper qiniuCloudHelper = new QiniuCloudHelper();
        qiniuCloudHelper.upload(newfile, "static/images/upload/" + newFileName);
        String success = FileResponseHelper.success(1, newFileName, url, "");
        out.print(success);
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
