package com.hai.idao;

import java.util.List;

import com.hai.model.Export;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IExportDAO {
	
	public boolean createExport(Export export);
	public Export readExport(int exportID);
	public boolean updateExport(Export export);
	public boolean deleteExport(int exportID);
	public List<Export> readAllExports();
	public List<Export> readExportByProperty(String name, Object value);
	
}
