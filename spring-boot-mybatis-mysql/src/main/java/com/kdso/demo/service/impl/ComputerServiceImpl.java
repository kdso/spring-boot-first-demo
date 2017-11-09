package com.kdso.demo.service.impl;


import com.kdso.demo.dao.ComputerDao;
import com.kdso.demo.entity.Computer;
import com.kdso.demo.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerServiceImpl implements ComputerService {

    @Autowired
    private ComputerDao computerDao;

    @Override
    public Computer findComputerByBrand(String brand) {

        return computerDao.findByBrand(brand);
    }

}
