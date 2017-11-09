package com.kdso.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootThymeleafApplicationTests {

	@Test
	public void contextLoads() {
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		Assert.assertNull(webApplicationContext);
	}
	@Test
	public void contextLoads2() {

	}
}
