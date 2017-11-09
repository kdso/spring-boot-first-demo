package com.kdso.demo;

import com.kdso.demo.entity.User;
import com.kdso.demo.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}

	@Resource
	private UserRepository userRepository;

	@RequestMapping("/delete")
	public void delete(Long id) {
		userRepository.delete(id);
	}

	@RequestMapping("/deleteById")
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	public void findById(long id){
		User user = userRepository.findById(id);
		System.out.print(user.toString());
	}


}
