package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.Material;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;;


public interface MaterialService {

    List<Material> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, Material material) throws Exception;
	
	Material get(String string) throws Exception;
	
	CustomResult delete(String string) throws Exception;

	CustomResult deleteBatch(String[] ids) throws Exception;

	CustomResult insert(Material material) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(Material material) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Material material) throws Exception;
    
    //更新备注
    CustomResult updateNote(Material material) throws Exception;
    
    EUDataGridResult searchMaterialByMaterialId(int page, int rows, String materialId) 
    		throws Exception;

	EUDataGridResult searchMaterialByMaterialType(Integer page, Integer rows,
			String materialType) throws Exception;
}
