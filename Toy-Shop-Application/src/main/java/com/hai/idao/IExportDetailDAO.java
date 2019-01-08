package com.hai.idao;

import java.util.List;

import com.hai.model.ExportDetail;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IExportDetailDAO {
	
	public boolean createExportDetail(ExportDetail exportDetail);
	public ExportDetail readExportDetail(int exportDetailID);
	public boolean updateExportDetail(ExportDetail exportDetail);
	public boolean deleteExportDetail(int exportDetailID);
	public List<ExportDetail> readAllExportDetails();
	public List<ExportDetail> readExportDetailByProperty(String name, Object value);
	
}
