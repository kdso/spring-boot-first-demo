package com.kdso.demo.controller;

import com.kdso.demo.entity.Computer;
import com.kdso.demo.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class ComputerRestController {

    @Autowired
    private ComputerService computerService;

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public Computer findOneComputer(@RequestParam(value = "brand", required = true) String brand) {
        return computerService.findComputerByBrand(brand);
    }

}
