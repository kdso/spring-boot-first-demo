package com.kdso.demo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by asus on 2017/11/2.
 */
@Controller
public class HomeController  {

    @RequestMapping("/tostatic1")
    public void toSatic1() throws IOException {
        //构造模板引擎
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");//模板所在目录，相对于当前classloader的classpath。
        resolver.setSuffix(".html");//模板文件后缀
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);

        //构造上下文(Model)
        Context context = new Context();
        context.setVariable("hello", "worker");

        //渲染模板
        FileWriter write = new FileWriter("/result.html");
        templateEngine.process("index", context, write);

    }


    @RequestMapping("/tostatic")
    public void process(final HttpServletRequest request, final HttpServletResponse response)
            throws Exception {

       /* ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setPrefix("/templates/");//模板所在目录，相对于当前classloader的classpath。
        resolver.setSuffix(".html");//模板文件后缀
        resolver.setTemplateMode("HTML");
        resolver.setCacheTTLMs(Long.valueOf(3600000L));
        resolver.setCacheable(true);
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setCharacterEncoding("UTF-8");
        //构造上下文(Model)
		*//*Context context = new Context();
		context.setVariable("hello", "worker");*//*
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = webApplicationContext.getServletContext();

        WebContext ctx = new WebContext(request,
                response,
                servletContext,
                request.getLocale());
        ctx.setVariable("hello", "worker");
        //渲染模板
        FileWriter write = new FileWriter("result.html");
        templateEngine.process("index", ctx,response.getWriter());*/

    }

}
