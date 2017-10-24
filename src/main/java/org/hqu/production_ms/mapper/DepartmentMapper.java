package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.Department;
import org.hqu.production_ms.domain.DepartmentExample;

public interface DepartmentMapper {
	
	//扩展的mapper接口方法
	int deleteBatch(String[] ids);
	
	int updateNote(Department record);
	
	List<Department> dep();
	List<Department> find(String id,String id1);
	
	List<Department> finds(String id);
		
	List<Department> searchDepartmentByDepartmentId(String departmentId);

	List<Department> searchDepartmentByDepartmentName(String departmentName);
	
	Department searchDepartmentByDepartment(String name);
	Department searchDepartmentByDepartment23(String name);
	Department searchDepartmentByDepartment1(String name);
	
	Department searchDepartmentByFat(String name);
		
	//逆向工程生成的mapper接口
    int countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int deleteByPrimaryKey(String departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(String departmentId);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
 
    List<Department> selectDepFrist(Integer level);
    
    List<Department> selectDepSecond(String fatherdep);

   
}