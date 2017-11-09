package com.kdso.demo;

import com.kdso.demo.entity.Deparment;
import com.kdso.demo.entity.Role;
import com.kdso.demo.entity.User;
import com.kdso.demo.repository.DepartmentRepository;
import com.kdso.demo.repository.RoleRepository;
import com.kdso.demo.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by asus on 2017/11/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class})
public class JpaTest {

    protected static final Logger log = LoggerFactory.getLogger(JpaTest.class);

    @Resource
    UserRepository userRepository;

    @Resource
    DepartmentRepository departmentRepository;

    @Resource
    RoleRepository roleRepository;

    @Before
    public void initData(){
        userRepository.deleteAll();
        departmentRepository.deleteAll();
        roleRepository.deleteAll();

        Deparment deparment = new Deparment();
        deparment.setName("开发部");
        departmentRepository.save(deparment);

        Role role = new Role();
        role.setName("admin");
        roleRepository.save(role);
        Assert.assertNotNull(role.getId());

        User user = new User();
        user.setName("user");
        user.setCreateDate(new Date());
        user.setDeparment(deparment);
        List<Role> roles = roleRepository.findAll();
        Assert.assertNotNull(roles);
        user.setRoles(roles);

        userRepository.save(user);
        Assert.assertNotNull(user.getId());
    }

    @Test
    public void findPage(){
        Pageable pageable = new PageRequest(1, 2, new Sort(Sort.Direction.DESC, "id"));
        Page<User> page = userRepository.findAll(pageable);
        Assert.assertNotNull(page);
        for (User user : page.getContent()){
            //输出日志
            log.info(user.getName()+"--------------------");
        }
    }

}
