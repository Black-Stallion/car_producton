package org.hqu.production_ms.service;

import java.math.BigDecimal;
import java.util.List;

import org.hqu.production_ms.domain.CarMaintenance;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarMaintenancePO;

public interface CarMaintenanceService {
	List<CarMaintenance> find() throws Exception;
	List<CarMaintenance> find1(int id) throws Exception;  
	List<CarMaintenance> find2(double str,int id) throws Exception;  
	List<CarMaintenance> find3(double str,int id) throws Exception;  
	
	EUDataGridResult getList(int page, int rows, CarMaintenance carMaintenance) throws Exception;
	
	CarMaintenance get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarMaintenancePO carMaintenance) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarMaintenancePO carMaintenance) throws Exception;
    
    CustomResult update(CarMaintenancePO carMaintenance) throws Exception;
    
    List<CarMaintenance> searchCarMaintenanceByCarMaintenanceName(BigDecimal carMaintenanceName) throws Exception;

	List<CarMaintenance> searchCarMaintenanceByCarMaintenanceId(int carMaintenanceId) throws Exception;

	//根据品牌查找车型信息
	EUDataGridResult searchCarMaintenanceByCarMaintenanceBrand(Integer page, Integer rows,
			String brand) throws Exception;

	//根据车型查找车型信息
	EUDataGridResult searchCarMaintenanceByCarMaintenanceCarXH(Integer page, Integer rows,
			String carXH) throws Exception;

}
