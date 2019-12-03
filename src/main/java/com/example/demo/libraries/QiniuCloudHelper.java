package com.example.demo.libraries;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

public class QiniuCloudHelper {

    private static final String ACCESS_KEY = "";
    private static final String SECRET_KEY = "";

    private static final String BUCKETNAME = "imgdemo";

    private static final Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    public void upload(String filePath, String fileName) {
        Configuration cfg = new Configuration();
        UploadManager uploadManager = new UploadManager(cfg);

        String upToken = auth.uploadToken(BUCKETNAME);
        try {
            Response response = uploadManager.put(filePath, fileName, upToken);
            //解析上传成功的结果
            DefaultPutRet ret = (DefaultPutRet) JsonHelper.fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println("key = " + ret.key);
            System.out.println("hash = " + ret.hash);
        } catch (QiniuException e) {
//            e.printStackTrace();
            Response r = e.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                // ignore
            }
        }
    }

}
