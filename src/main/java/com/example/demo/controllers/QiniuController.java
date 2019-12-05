package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    /**
     * ueditor 富文本上传
     *
     */
    @RequestMapping(value = "/ueditor", method = RequestMethod.GET)
    public String ueditor() {
        return "/qiniu/ueditor";
    }

    @RequestMapping(value = "/doService")
    public String doService() {
        return "/qiniu/success";
    }

//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    @ResponseBody
//    public void upload(@RequestParam("upload") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
//        System.out.println("file = " + file.getOriginalFilename());
//        PrintWriter out = null;
//        try {
//            out = response.getWriter();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        if (file.isEmpty()) {
//            String error = FileResponseHelper.error(0, "文件为空");
//            out.print(error);
//        }
//        String filename = file.getOriginalFilename();
//        String picSuffix = getPicSuffix(filename);
//        String picPrefix = getPicPrefix(filename);
//        System.out.println("picSuffix = " + picSuffix);
//        System.out.println("picPrefix = " + picPrefix);
//
//        //获取跟目录
//        File path = null;
//        try {
//            path = new File(ResourceUtils.getURL("classpath:").getPath());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        String newFileName = "up-" + System.currentTimeMillis() + "." + picSuffix;
//        String newfile = path.getAbsolutePath() + "\\static\\images\\upload\\" + newFileName;
//        System.out.println("newFile = " + newfile);
//        File newf = new File(newfile);
//        try {
//            FileUtils.copyInputStreamToFile(file.getInputStream(), newf);
//        } catch (IOException e) {
////            e.printStackTrace();
//            String error = FileResponseHelper.error(0, "无状态异常");
//            out.print(error);
//        }
//
//        String url = "http://127.0.0.1:8080/static/images/upload/" + newFileName;
//
//        String success = FileResponseHelper.success(1, newFileName, url, "success");
//        out.print(success);
////        System.out.println("path:"+path.getAbsolutePath());
////        return "/qiniu/success";
//    }
//
//    /*
//     * 获取扩展名
//     */
//    public String getPicSuffix(String img_path, String sign) {
//        if (img_path == null || img_path.indexOf(sign) == -1) {
//            return ""; //如果图片地址为null或者地址中没有"."就返回""
//        }
//        return img_path.substring(img_path.lastIndexOf(sign) + sign.length()).
//                trim();
//    }
//
//    public String getPicSuffix(String imagePath) {
//        return getPicSuffix(imagePath, ".");
//    }
//
//    /*
//     * 获取扩展名以外的其余部分
//     */
//    public String getPicPrefix(String img_path, String sign) {
//        if (img_path == null || img_path.indexOf(sign) == -1) {
//            return ""; //如果图片地址为null或者地址中没有"."就返回""
//        }
//        return img_path.substring(0, img_path.lastIndexOf(sign)).
//                trim();
//    }
//
//    public String getPicPrefix(String imgPath) {
//        return getPicPrefix(imgPath, ".");
//    }

}
