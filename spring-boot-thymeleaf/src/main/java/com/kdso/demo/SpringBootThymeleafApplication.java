package com.kdso.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import sun.tools.jar.CommandLine;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;

@Controller
@SpringBootApplication
public class SpringBootThymeleafApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootThymeleafApplication.class, args);
	}

	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("hello","worker!");
		return "index";
	}


}
