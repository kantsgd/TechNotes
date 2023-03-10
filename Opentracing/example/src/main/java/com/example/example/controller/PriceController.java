package com.example.example.controller;

import com.example.example.entity.Price;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {

    @RequestMapping(path = "/testPath", method = RequestMethod.GET)
    public Price getPrice() {
        var price = new Price(1, 12.0, 2.0);
        return price;
    }
}
