package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarBaoyang;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarBaoyangPO;

public interface CarBaoyangService {
	List<CarBaoyang> find() throws Exception; 
	
	List<CarBaoyang> find1() throws Exception; 
	 CarBaoyang get1(int string) throws Exception;
	boolean find2(int id) throws Exception; 
	EUDataGridResult getList(int page, int rows,CarBaoyang carCtj,String id) throws Exception;
	EUDataGridResult getList1(int page, int rows, CarBaoyang carCtj) throws Exception;
	CustomResult insert(CarBaoyangPO carIn) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarBaoyangPO carIn) throws Exception;
    CustomResult updateById(CarBaoyangPO carBaoyang) throws Exception;
    
    CustomResult update(CarBaoyangPO carIn) throws Exception;
    CarBaoyang get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;
}
