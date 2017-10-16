package com.example.demo;

import com.example.demo.libraries.JsonHelper;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
		Map<String, Object> q = new HashMap<String, Object>();
//		q.put("id", userService.userNextId());
		q.put("age", 20);
		q.put("name", "xiaohong2");
//		System.out.println("ttm | --> " + JsonHelper.toJson(userService.userSave(q)));
		System.out.println("ttm | == > " + JsonHelper.toJson(userService.userOne(new HashMap<>())));
	}

//	@Test
	public void fetchG() {
//		System.out.println("ttm | --> " + UserDaoImpl.class.getGenericSuperclass());
	}

}
