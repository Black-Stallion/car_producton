package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.DriverRecord;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.DriverRecordPO;

public interface DriverRecordService {

	List<DriverRecord> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, DriverRecord driverRecord) throws Exception;
	
	List<DriverRecord> find1(String id) throws Exception;  
	
	EUDataGridResult getList1(int page, int rows, DriverRecord driverRecord,String id) throws Exception;
	
	DriverRecord get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(DriverRecordPO driverRecord) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(DriverRecordPO driverRecord) throws Exception;
    
    CustomResult update(DriverRecordPO driverRecord) throws Exception;
    
    
	
	EUDataGridResult searchDriverRecordBydrivernum(Integer page, Integer rows,
			String drivernum) throws Exception;

	EUDataGridResult searchDriverRecordBydrivername(Integer page, Integer rows,
			String drivername) throws Exception;

}
