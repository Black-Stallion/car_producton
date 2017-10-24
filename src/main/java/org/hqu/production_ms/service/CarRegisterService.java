package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarPublic;
import org.hqu.production_ms.domain.CarRegister;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarRegisterPO;



public interface CarRegisterService {
	
	List<CarRegister> find() throws Exception; 
	
	List<CarRegister> find1(String id) throws Exception; 
	
	List<CarRegister> findByNature(String string) throws Exception; 
	
	List<CarRegister> findByNature1(String string,String id) throws Exception; 
	
	List<CarRegister> get() throws Exception;
	List<CarPublic> findP() throws Exception;
	
	List<CarRegister> findP11() throws Exception;
	List<CarRegister> findP2(String id) throws Exception;
	
	List<CarRegister> get1(String id) throws Exception;
	List<CarPublic> findP1(String id) throws Exception;
	
	EUDataGridResult getList(int page, int rows, CarRegister carRegister) throws Exception;
	EUDataGridResult getList1(int page, int rows, CarRegister carRegister,String id) throws Exception;
	
	CarRegister findByCarNumber(String id);
	
	CarRegister findByCarCJH(String id);
	
	CarRegister get(int string) throws Exception;
	
	CustomResult delete(int string) throws Exception;

	CustomResult deleteBatch(int[] ids) throws Exception;

	CustomResult insert(CarRegisterPO carRegister) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(CarRegisterPO carRegister) throws Exception;
    
    boolean updateDepById(String id,int ids) throws Exception;
    
    boolean updateDepByIds(String id,String ids) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(CarRegisterPO carRegister) throws Exception;
    
    EUDataGridResult searchCarRegisterByCarRegisterDriverfrom(Integer page, Integer rows, String string) throws Exception;
	
	EUDataGridResult searchCarRegisterByCarRegisterAA(Integer page, Integer rows,
			String string) throws Exception;
	
	EUDataGridResult searchCarRegisterByCarRegisterName(Integer page, Integer rows,
			String string) throws Exception;

}
