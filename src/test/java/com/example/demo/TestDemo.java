package com.example.demo;

import com.example.demo.libraries.JsonHelper;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @auther ttm
 * @date 2017/10/25
 */
public class TestDemo {


    public boolean match(String lineText) {
        String ma = "\\[WARN\\]{1,}\\s{1}[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}\\s{1}[\\w]{1,}";
        Pattern pattern = Pattern.compile(ma);
        Matcher matcher = pattern.matcher(lineText);
        return matcher.find();
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.0000");
        Double tmpProductPrice = 12d;
        Double tomtpPrice = 2d;
        String changeValue12 = "12.00";
        String changeRate1 = "0.01";

        Double changeValue = tmpProductPrice - tomtpPrice;
        Double changeRate = changeValue / tmpProductPrice;
        String cv = df.format(Math.abs(changeValue));
        String cr = df.format(Math.abs(changeRate));
        if (changeValue12.compareTo(cv) >= 0 && changeRate1.compareTo(cr) >= 0) {
            return;
        }

        System.out.println("tomtop = " + tmpProductPrice);
    }

  @Test
    public void contextLoads() throws IOException {
        File file = new File("D:\\19.txt");
        InputStream reader = new FileInputStream(file);
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(reader));
        String str = null;
        List<String> tomtopLoginNameList = new ArrayList<>();
        while (true) {
            str = reader1.readLine();
            if (StringUtils.isNotEmpty(str)) {
                tomtopLoginNameList.add(str.trim());
            } else {
                break;
            }
        }
        reader1.close();
        reader.close();

        File file2 = new File("D:\\catalina.out");
        InputStream reader2 = new FileInputStream(file2);
        BufferedReader reader3 = new BufferedReader(new InputStreamReader(reader2));
        Map<String, Object> erpUserMap = new HashMap<>();
        String str2 = null;
        while (true) {
            String str1 = reader3.readLine();
            if (StringUtils.isNotEmpty(str1)) {
                str2 = str1;
//                erpUserMap = (Map<String, Object>) JsonHelper.fromJson(str1, Map.class);
            } else {
                break;
            }
        }
        reader2.close();
        reader3.close();
        System.out.println("show : " + str2);
//        System.out.println("show tomtop : " + JsonHelper.toJson(tomtopLoginNameList));
        erpUserMap = (Map<String, Object>) JsonHelper.fromJson(str2, Map.class);
        Map<String, String> relationMap = new HashMap<>();
        for (String keys : erpUserMap.keySet()) {
            Map<String, Object> userInfoMap = (Map<String, Object>) erpUserMap.get(keys);
            String erpLoginName = (String) userInfoMap.get("loginName");
            String name = (String) userInfoMap.get("name");
            relationMap.put(name.trim(), erpLoginName);
        }

        for (String name : tomtopLoginNameList) {
            String[] userArr = StringUtils.split(name, "-");
            String userStr = relationMap.get(userArr[1]);
            System.out.println(userArr[0] + " " + userStr + " " + userArr[1]);
        }
    }

}
