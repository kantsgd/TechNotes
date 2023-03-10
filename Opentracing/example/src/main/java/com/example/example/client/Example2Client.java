package com.example.example.client;

import com.example.example.entity.Price;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "example2", url = "example2-service:8081")
public interface Example2Client {

    @RequestMapping(method = RequestMethod.GET, value = "/calculatePrice/{priceId}")
    Price getPriceById(@PathVariable("priceId") int priceId);

    @RequestMapping(method = RequestMethod.GET, value = "/errorEndpoint")
    String getError();
}
