package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarYdtjIn;
import org.hqu.production_ms.domain.CarYdtjOut;
import org.hqu.production_ms.domain.CarYdtjRemove;
import org.hqu.production_ms.domain.CarYdtjSelf;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface CarYdtjService {
	List<CarYdtjIn> findIn() throws Exception; 
	
	List<CarYdtjIn> findIn1() throws Exception; 
List<CarYdtjOut> findOut() throws Exception; 
	
	List<CarYdtjOut> findOut1() throws Exception; 
List<CarYdtjSelf> findSelf() throws Exception; 
	
	List<CarYdtjSelf> findSelf1() throws Exception; 
List<CarYdtjRemove> findRemove() throws Exception; 
	
	List<CarYdtjRemove> findRemove1() throws Exception; 
	
	
	EUDataGridResult getListIn(int page, int rows,String id) throws Exception;
	EUDataGridResult getListIn1(int page, int rows, CarYdtjIn carYdtj) throws Exception;
	EUDataGridResult getListOut(int page, int rows,String id) throws Exception;
	EUDataGridResult getListOut1(int page, int rows, CarYdtjOut carYdtj) throws Exception;
	EUDataGridResult getListSelf(int page, int rows,String id) throws Exception;
	EUDataGridResult getListSelf1(int page, int rows, CarYdtjSelf carYdtj) throws Exception;
	EUDataGridResult getListRemove(int page, int rows,String id) throws Exception;
	EUDataGridResult getListRemove1(int page, int rows, CarYdtjRemove carYdtj) throws Exception;
	
    
    EUDataGridResult searchCarYdtjByCarYdtjIn1(Integer page, Integer rows, String args) throws Exception;
	
    EUDataGridResult searchCarYdtjByCarYdtjIn2(Integer page, Integer rows, String arg,String args) throws Exception;
    
    EUDataGridResult searchCarYdtjByCarYdtjIn3(Integer page, Integer rows, String arg) throws Exception;
    
    EUDataGridResult searchCarYdtjByCarYdtjIn4(Integer page, Integer rows, String arg,String args) throws Exception;
    
    EUDataGridResult searchCarYdtjByCarYdtjIn5(Integer page, Integer rows, String arg, String args,String str1) throws Exception;
    //
    EUDataGridResult searchCarYdtjByCarYdtjOut1(Integer page, Integer rows, String args) throws Exception;
	
    EUDataGridResult searchCarYdtjByCarYdtjOut2(Integer page, Integer rows, String arg,String args) throws Exception;
    
    EUDataGridResult searchCarYdtjByCarYdtjOut3(Integer page, Integer rows, String arg) throws Exception;
    
    EUDataGridResult searchCarYdtjByCarYdtjOut4(Integer page, Integer rows, String arg,String args) throws Exception;
    
    EUDataGridResult searchCarYdtjByCarYdtjOut5(Integer page, Integer rows, String arg, String args,String str1) throws Exception;
    //
    EUDataGridResult searchCarYdtjByCarYdtjRemove1(Integer page, Integer rows, String args) throws Exception;
	
    EUDataGridResult searchCarYdtjByCarYdtjRemove2(Integer page, Integer rows, String arg,String args) throws Exception;
    
    EUDataGridResult searchCarYdtjByCarYdtjRemove3(Integer page, Integer rows, String arg) throws Exception;
    
    EUDataGridResult searchCarYdtjByCarYdtjRemove4(Integer page, Integer rows, String arg,String args) throws Exception;
    
    EUDataGridResult searchCarYdtjByCarYdtjRemove5(Integer page, Integer rows, String arg, String args,String str1) throws Exception;
    //
    EUDataGridResult searchCarYdtjByCarYdtjSelf1(Integer page, Integer rows, String args) throws Exception;
	
    EUDataGridResult searchCarYdtjByCarYdtjSelf2(Integer page, Integer rows, String arg,String args) throws Exception;
    
    EUDataGridResult searchCarYdtjByCarYdtjSelf3(Integer page, Integer rows, String arg) throws Exception;
    
    EUDataGridResult searchCarYdtjByCarYdtjSelf4(Integer page, Integer rows, String arg,String args) throws Exception;
    
    EUDataGridResult searchCarYdtjByCarYdtjSelf5(Integer page, Integer rows, String arg, String args,String str1) throws Exception;
    
}
