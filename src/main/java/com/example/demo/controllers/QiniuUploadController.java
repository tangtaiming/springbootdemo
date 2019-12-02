package com.example.demo.controllers;

import com.example.demo.libraries.FileResponseHelper;
import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("qiniu")
public class QiniuUploadController {

    @RequestMapping(value = "/upload")
    @ResponseBody
    public void upload(@RequestParam("upload") MultipartFile file, @RequestParam("CKEditorFuncNum") String cKEditorFuncNum, HttpServletResponse response) {
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
        String newFileName = "up-" + System.currentTimeMillis() + "." + picSuffix;
        String newfile = path.getAbsolutePath() + "\\static\\images\\upload\\" + newFileName;
        System.out.println("newFile = " + newfile);
        File newf = new File(newfile);
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), newf);
        } catch (IOException e) {
//            e.printStackTrace();
            String error = FileResponseHelper.error(0, "无状态异常");
            out.print(error);
        }

        String url = "http://127.0.0.1:8080/static/images/upload/" + newFileName;

//        String success = FileResponseHelper.success(1, newFileName, url, "success");
//        out.print(success);

        // 返回"图像"选项卡并显示图片  request.getContextPath()为web项目名
        out.print("<script type=\"text/javascript\">");
        out.print("window.parent.CKEDITOR.tools.callFunction(" + cKEditorFuncNum
                + ",'" + url + "','')");
        out.print("</script>");
//        System.out.println("path:"+path.getAbsolutePath());
//        return "/qiniu/success";
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
