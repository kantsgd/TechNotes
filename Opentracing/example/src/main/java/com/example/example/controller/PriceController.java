package com.example.example.controller;

import com.example.example.client.Example2Client;
import com.example.example.entity.Price;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {

    private final Logger LOGGER = LoggerFactory.getLogger(PriceController.class);

    private final Example2Client client;

    public PriceController(Example2Client client) {
        this.client = client;
    }

    @RequestMapping(path = "/prices/{priceId}", method = RequestMethod.GET)
    public Price getPrice(@PathVariable("priceId") int priceId) {
        return client.getPriceById(priceId);
    }

    @RequestMapping(path = "/errorEndpoint", method = RequestMethod.GET)
    public String getError() {
        String result = "Error Happened";
        try {
            result = client.getError();
        } catch (FeignException e) {
            LOGGER.error("An error occured, the reason is: " + e.getMessage());
        }
        return result;
    }
}
