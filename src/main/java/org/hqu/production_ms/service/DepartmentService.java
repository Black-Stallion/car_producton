package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.Department;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface DepartmentService {
	
	List<Department> find() throws Exception;  
	
	List<Department> dep() throws Exception;  
	
	List<Department> findByLevel(Integer level) throws Exception;  
	
	List<Department> findSecond(String fatherdep) throws Exception;
	
	EUDataGridResult getList(int page, int rows, Department department) throws Exception;
	EUDataGridResult getList1(int page, int rows,String id) throws Exception;
	EUDataGridResult getLists(int page, int rows,String id) throws Exception;
	
	Department get(String string) throws Exception;
	
	Department getDep2(String string) throws Exception;
	
	Department getDep1(String name) throws Exception;
	Department getDep23(String name) throws Exception;
	
	Department getDep11(String name) throws Exception;
	
	CustomResult delete(String string) throws Exception;

	CustomResult deleteBatch(String[] ids) throws Exception;

	CustomResult insert(Department department) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(Department department) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Department department) throws Exception;
    
    //更新备注
    CustomResult updateNote(Department department) throws Exception;
    
    List<Department> searchDepartmentByDepartmentId(String departmentId) throws Exception;

	EUDataGridResult searchDepartmentByDepartmentId(Integer page, Integer rows,
			String departmentId) throws Exception;

	EUDataGridResult searchDepartmentByDepartmentName(Integer page,
			Integer rows, String departmentName) throws Exception;
}
