package com.hai.idao;

import java.util.List;

import com.hai.model.ImportDetail;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IImportDetailDAO {
	
	public boolean createImportDetail(ImportDetail importDetail);
	public ImportDetail readImportDetail(int importDetailID);
	public boolean updateImportDetail(ImportDetail importDetail);
	public boolean deleteImportDetail(int importDetailID);
	public List<ImportDetail> readAllImportDetails();
	public List<ImportDetail> readImportDetailByProperty(String name, Object value);
	
}
