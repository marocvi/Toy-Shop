package com.hai.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hai.config.RootConfig;
import com.hai.config.SpringWebContextConfig;
import com.hai.iservice.IDeliveryLocationService;
import com.hai.model.DeliveryLocation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {SpringWebContextConfig.class,RootConfig.class})
@WebAppConfiguration
public class TestDeliveryLocationService {

	@Autowired
	IDeliveryLocationService deliveryLocationService;
	
	@Test
	public void testFindAllDeliveryLocation() {
		List<DeliveryLocation> deliveryLocations = deliveryLocationService.getAllDeliveryLocations();
		for (DeliveryLocation deliveryLocation : deliveryLocations) {
			System.out.println(deliveryLocation.getAvailableLocation());
		}
	}
	
}
