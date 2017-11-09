package com.kdso.demo.dao;

import com.kdso.demo.entity.Computer;

/**
 * Created by asus on 2017/10/24.
 */
public interface ComputerDao {
    Computer findByBrand(String brand);
}
