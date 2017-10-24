package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.DeviceType;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface DeviceTypeService {
	
	EUDataGridResult getList(int page, int rows, DeviceType deviceType) throws Exception;
	
	DeviceType get(String string) throws Exception;
	
	List<DeviceType> find() throws Exception;
	
	CustomResult insert(DeviceType deviceType) throws Exception;
	
	CustomResult deleteBatch(String[] deviceTypeIds) throws Exception;

    CustomResult update(DeviceType deviceType) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(DeviceType deviceType) throws Exception;

	EUDataGridResult searchDeviceTypeByDeviceTypeId(Integer page, Integer rows,
			String deviceTypeId) throws Exception;

	EUDataGridResult searchDeviceTypeByDeviceTypeName(Integer page,
			Integer rows, String deviceTypeName) throws Exception;
}
