package com.kdso.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisConnectApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void test() throws Exception {
		stringRedisTemplate.opsForValue().set("firstkey", "firstvalue");
		Assert.assertEquals("firstvalue", stringRedisTemplate.opsForValue().get("firstkey"));
	}

	@Test
	public void testObj() throws Exception {
		User user=new User("1", "test","21");
		ValueOperations<String, User> operations=redisTemplate.opsForValue();
		operations.set("userset", user);
		operations.set("userhash", user,1, TimeUnit.SECONDS);
		Thread.sleep(1000);
		//redisTemplate.delete("com.neo.f");
		boolean exists=redisTemplate.hasKey("userhash");
		if(exists){
			System.out.println("exists is true");
		}else{
			System.out.println("exists is false");
		}
		// Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
	}

	/*
	* 定义实体类
	* */
	class User {
		String id;
		String name;
		String age;

		public User(String id, String name, String age) {
			this.id = id;
			this.name = name;
			this.age = age;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}
	}

}
