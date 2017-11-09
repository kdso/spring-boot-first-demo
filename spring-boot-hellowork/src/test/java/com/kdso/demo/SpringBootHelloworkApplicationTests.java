package com.kdso.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootHelloworkApplicationTests.class)
public class SpringBootHelloworkApplicationTests {

	@Test
	public void contextLoads() {
		String a = new String();
		String b="";
		System.out.print(a+"---"+b+"-");
		Assert.assertEquals(a,b);
	}

}
