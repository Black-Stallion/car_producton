package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.Weigui;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.WeiguiPO;

public interface WeiguiService {

	List<Weigui> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, Weigui weigui) throws Exception;
	
	List<Weigui> find1(String id) throws Exception;  
	
	EUDataGridResult getList1(int page, int rows, Weigui weigui,String id) throws Exception;
	
	Weigui get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(WeiguiPO weigui) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(WeiguiPO weigui) throws Exception;
    
    CustomResult update(WeiguiPO weigui) throws Exception;
    
    
	
	EUDataGridResult searchWeiguiBydrivernum(Integer page, Integer rows,
			String drivernum) throws Exception;

	EUDataGridResult searchWeiguiBycarnum(Integer page, Integer rows,
			int carnum) throws Exception;

}
