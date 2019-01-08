package com.hai.idao;

import java.util.List;

import com.hai.model.Import;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IImportDAO {
	
	public boolean createImport(Import imports);
	public Import readImport(int importID);
	public boolean updateImport(Import imports);
	public boolean deleteImport(int importID);
	public List<Import> readAllImports();
	public List<Import> readImportByProperty(String name, Object value);
	
}
