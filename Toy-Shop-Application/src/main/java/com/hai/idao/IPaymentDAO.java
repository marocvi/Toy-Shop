package com.hai.idao;

import java.util.List;

import com.hai.model.Payment;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IPaymentDAO {
	
	public boolean createPayment(Payment payment);
	public Payment readPayment(int paymentID);
	public boolean updatePayment(Payment payment);
	public boolean deletePayment(int paymentID);
	public List<Payment> readAllPayments();
	public List<Payment> readPaymentByProperty(String name, Object value);
	
}
