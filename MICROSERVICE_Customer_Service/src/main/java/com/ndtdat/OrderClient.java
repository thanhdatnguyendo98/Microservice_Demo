package com.ndtdat;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "order-service")
public interface OrderClient {
	@GetMapping("/")
	public Object getOrdersForCustomer(@RequestParam(name = "customerid") Integer customerid);
}