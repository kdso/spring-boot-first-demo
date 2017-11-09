package com.kdso.demo;

import com.kdso.demo.entity.User;
import com.kdso.demo.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by asus on 2017/11/3.
 */
@Controller
public class PageController {
    @Resource
    private UserRepository userRepository;
    @RequestMapping("/page")
    @ResponseBody
    public List page(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(1, 2, sort);
        Page<User> pages=userRepository.findAll(pageable);
        return pages.getContent();
    }

    @RequestMapping("/save")
    public void save(){
        User user = new User();
        user.setName("123");
        user.setCreateDate(new Date());
        userRepository.save(user);
    }
}
