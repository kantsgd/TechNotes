package com.example.example2.controller;

import com.example.example2.entity.Price;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceCalculationController {

    @RequestMapping(path = "/calculatePrice/{priceId}",method = RequestMethod.GET)
    public Price calculatePrice(@PathVariable int priceId) {
        return new Price(priceId, priceId * 20.2, priceId * 2.1);
    }

    @RequestMapping(path = "/errorEndpoint",method = RequestMethod.GET)
    public Price willReturnError() {
        throw new RuntimeException("An error occured");
    }
}
