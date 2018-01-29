package com.example.demo;

import com.example.demo.dao.TomtopShippingTemplateDao;
import com.example.demo.dao.TomtopcomLanguageDao;
import com.example.demo.dao.UserMySqlDao;
import com.example.demo.libraries.JsonHelper;
import com.example.demo.orm.*;
import com.example.demo.service.TomtopOrderListService;
import com.example.demo.service.TomtopProductStatusService;
import com.example.demo.service.TomtopcomLanguageService;
import com.example.demo.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private UserMySqlDao userMySqlDao;

	@Autowired
	private TomtopProductStatusService tomtopProductStatusService;

	@Autowired
	private TomtopShippingTemplateDao shippingTemplateDao;

	@Autowired
	private TomtopOrderListService tomtopOrderListService;

	@Autowired
	private TomtopcomLanguageDao tomtopcomLanguageDao;

	@Autowired
	private TomtopcomLanguageService tomtopcomLanguageService;

	@Test
	public void tomtopShippingTemplateTest() {
		TomtopcomLanguage tomtopcomLanguage = new TomtopcomLanguage();
		List<LanguageId> languageIds = new ArrayList<>();
		LanguageId en = new LanguageId();
		en.setCode("en");
		en.setLanguageid(1);
		en.setName("English");
		LanguageId es = new LanguageId();
		es.setCode("fr");
		es.setLanguageid(5);
		es.setName("Français");
		languageIds.add(en);
		languageIds.add(es);
		tomtopcomLanguage.setId(6);
		tomtopcomLanguage.setLanguageids(languageIds);
		tomtopcomLanguage.setWebiste(4);
		System.out.println("show data:" + JsonHelper.toJson(tomtopcomLanguage));
		tomtopcomLanguageDao.save(tomtopcomLanguage);

		System.out.println("show data : " + JsonHelper.toJson(tomtopcomLanguageService.tomtopLanguageList()));
	}

	public void contextLoads() {

	}

	public void testFormat() {
		Map<String, Object> statusMap = tomtopProductStatusService.tomtopProductFormatList();
		System.out.println("ttm | " + statusMap.toString());
	}

	public void testFetch() {
		List<TomtopProductStatus> tomtopProductStatuses = tomtopProductStatusService.tomtopProductStatusList();
		if (CollectionUtils.isNotEmpty(tomtopProductStatuses)) {
			for (TomtopProductStatus tomtopProductStatus : tomtopProductStatuses) {
				System.out.println("ttm | " + JsonHelper.toJson(tomtopProductStatus));
			}
		}
	}

	public void fetchSave() {
		String statusStr = "{\"ret\":1,\"data\":[{\"id\":113,\"languageId\":1,\"clientId\":1,\"type\":\"PRODUCT_STATUS\",\"value\":\"[{\\\"status\\\":1,\\\"name\\\":\\\"常售/En vente\\\",\\\"enName\\\":\\\"In Stock\\\"},{\\\"status\\\":2,\\\"name\\\":\\\"停售/Désactivé\\\",\\\"enName\\\":\\\"Stop Selling\\\"},{\\\"status\\\":3,\\\"name\\\":\\\"无货在线/En réappro\\\",\\\"enName\\\":\\\"Sold Out\\\"},{\\\"status\\\":40,\\\"name\\\":\\\"预售/En précommande\\\",\\\"enName\\\":\\\"Presale\\\"},{\\\"status\\\":-10,\\\"name\\\":\\\"侵权禁售/Vente interdite\\\",\\\"enName\\\":\\\"Prohibited\\\"}]\",\"name\":\"productStatus\"}]}";
		Map<String, Object> statusMap = (Map<String, Object>) JsonHelper.fromJson(statusStr, Map.class);
		System.out.println("ttm | " + statusMap.toString());
		List<Map<String, Object>> statusValues = (List<Map<String, Object>>) statusMap.get("data");
		List<Map<String, Object>> statusValue2 = (List<Map<String, Object>>) JsonHelper.fromJson(statusValues.get(0).get("value").toString(), List.class, Map.class);
		System.out.println("ttm | " + statusValues.get(0));
		for (Map<String, Object> valueRow : statusValue2) {
			Integer status = (Integer) valueRow.get("status");
			String name = (String) valueRow.get("name");
			String enName = (String) valueRow.get("enName");
			System.out.println("ttm | " + valueRow.get("status"));
			System.out.println("ttm | " + valueRow.get("name"));
			System.out.println("ttm | " + valueRow.get("enName"));
			TomtopProductStatus tomtopProductStatus = new TomtopProductStatus();
			tomtopProductStatus.setStatus(status);
			tomtopProductStatus.setName(name);
			tomtopProductStatus.setEnName(enName);
			boolean saveFlag = tomtopProductStatusService.tomtopProductStatusSave(tomtopProductStatus);
			if (saveFlag) {
				System.out.println("ttm | 成功");
			} else {
				System.out.println("ttm | 失败");
			}
		}
	}

}
