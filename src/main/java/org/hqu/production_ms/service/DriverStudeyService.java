package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.DriverStudey;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.DriverStudeyPO;

public interface DriverStudeyService {
	
	List<DriverStudey> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, DriverStudey driverStudey) throws Exception;
	List<DriverStudey> find1(String id) throws Exception;  
	
	EUDataGridResult getList1(int page, int rows, DriverStudey driverStudey,String id) throws Exception;
	
	DriverStudey get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(DriverStudeyPO driverStudey) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(DriverStudeyPO driverStudey) throws Exception;
    
    CustomResult update(DriverStudeyPO driverStudey) throws Exception;
    
  
}
