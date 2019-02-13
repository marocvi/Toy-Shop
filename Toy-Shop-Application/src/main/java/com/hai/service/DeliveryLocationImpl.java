package com.hai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hai.idao.IDeliveryLocationDAO;
import com.hai.iservice.IDeliveryLocationService;
import com.hai.model.DeliveryLocation;

@Service
public class DeliveryLocationImpl implements IDeliveryLocationService {

	@Autowired
	IDeliveryLocationDAO deliveryLocationDAO;

	@Override
	public List<DeliveryLocation> getAllDeliveryLocations() {
		return deliveryLocationDAO.readAllDeliveryLocations();
	}

}
