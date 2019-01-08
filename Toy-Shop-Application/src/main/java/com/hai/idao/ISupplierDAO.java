package com.hai.idao;

import java.util.List;

import com.hai.model.Supplier;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface ISupplierDAO {
	
	public boolean createSupplier(Supplier supplier);
	public Supplier readSupplier(int supplierID);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(int supplierID);
	public List<Supplier> readAllSuppliers();
	public List<Supplier> readSupplierByProperty(String name, Object value);
	
}
