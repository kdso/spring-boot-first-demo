package com.kdso;

import com.kdso.demo.User;
import com.kdso.demo.UserRepository;
import com.kdso.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;

@Controller
@SpringBootApplication
@ComponentScan("com.kdso.demo.dao")
public class SpringBootMongodbApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbApplication.class, args);
	}

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserDao userDao;

	@Override
	public void run(String... args) throws Exception {

		// 保存两个用户
        repository.save(new User("Lily", "Toysft"));
        repository.save(new User("Lucy", "Toysft"));

	}

	@RequestMapping("/deleteById")
	public String deleteById(@RequestParam(value = "id") String id){
		userDao.deleteById(id);
		return "删除完成";
	}
	@RequestMapping("/findById")
	public String findById(@RequestParam(value = "id") String id){
		User user = repository.findOne(id);
		System.out.print(user.toString());
		return "查找完成";
	}

	//分页查找
	@RequestMapping("/pagelist")
	@ResponseBody
	public void page(){
		//排序方式
		Sort sort = new Sort(Sort.Direction.ASC, "id");
		//分页查找
		Pageable pageable = new PageRequest(0, 2, sort);
		Page<User> pages=repository.findAll(pageable);
        System.out.println(pages.getContent().size());
		Iterator<User> it=pages.iterator();
		while(it.hasNext()){
			System.out.println("value:"+((User)it.next()).id);
		}
	}

}
