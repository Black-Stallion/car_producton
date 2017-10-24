package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.Shigu;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.ShiguPO;

public interface ShiguService {

	List<Shigu> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, Shigu shigu) throws Exception;
	
	List<Shigu> find1(String id) throws Exception;  
	
	EUDataGridResult getList1(int page, int rows, Shigu shigu,String id) throws Exception;
	
	Shigu get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(ShiguPO shigu) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(ShiguPO shigu) throws Exception;
    
    CustomResult update(ShiguPO shigu) throws Exception;
    
	
    EUDataGridResult searchShiguBycode(Integer page, Integer rows,
			int code) throws Exception;

	EUDataGridResult searchShiguBycarnum(Integer page, Integer rows,
			String carnum) throws Exception;

	

}
