package com.hai.idao;

import java.util.List;

import com.hai.model.DeliveryReport;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IDeliveryReportDAO {
	
	public boolean createDeliveryReport(DeliveryReport deliveryReport);
	public DeliveryReport readDeliveryReport(int deliveryReportID);
	public boolean updateDeliveryReport(DeliveryReport deliveryReport);
	public boolean deleteDeliveryReport(int deliveryReportID);
	public List<DeliveryReport> readAllDeliveryReports();
	public List<DeliveryReport> readDeliveryReportByProperty(String name, Object value);
	
}
