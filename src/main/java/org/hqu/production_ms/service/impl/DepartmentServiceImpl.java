package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.Department;
import org.hqu.production_ms.domain.DepartmentExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.mapper.DepartmentMapper;
import org.hqu.production_ms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(rollbackFor=Exception.class)
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentMapper departmentMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, Department department) throws Exception{
		//查询部门列表
		DepartmentExample example = new DepartmentExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<Department> list = departmentMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Department> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	@Override
	public EUDataGridResult getList1(int page, int rows,String id) throws Exception{
		//查询部门列表
		//分页处理
		PageHelper.startPage(page, rows);
		List<Department> list = departmentMapper.find(id,id);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Department> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	@Override
	public EUDataGridResult getLists(int page, int rows,String id) throws Exception{
		//查询部门列表
		//分页处理
		PageHelper.startPage(page, rows);
		List<Department> list = departmentMapper.finds(id);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Department> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public List<Department> findByLevel(Integer level) throws Exception {
		return  departmentMapper.selectDepFrist(level);
		
	}
	
	@Override
	public List<Department> dep() throws Exception {
		return  departmentMapper.dep();
		
	}


	@Override
	public List<Department> findSecond(String fatherdep) throws Exception {
		return  departmentMapper.selectDepSecond(fatherdep);
		
	}
	@Override
	public Department get(String string) throws Exception{
		
		return departmentMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult delete(String string) throws Exception{
		int i = departmentMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception{
		int i = departmentMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(Department department) throws Exception{
		int i = departmentMapper.insert(department);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增部门失败");
		}
	}

	@Override
	public CustomResult update(Department department) throws Exception{
		int i = departmentMapper.updateByPrimaryKeySelective(department);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改部门信息失败");
		}
	}

	@Override
	public CustomResult updateAll(Department department) throws Exception{
		int i = departmentMapper.updateByPrimaryKey(department);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改部门信息失败");
		}
	}

	@Override
	public CustomResult updateNote(Department department) throws Exception{
		int i = departmentMapper.updateNote(department);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改部门职责失败");
		}
	}
	
	@Override
	public List<Department> find() throws Exception{
		DepartmentExample example = new DepartmentExample();
		return departmentMapper.selectByExample(example);
	}

	@Override
	public List<Department> searchDepartmentByDepartmentId(String departmentId) throws Exception{
		DepartmentExample example = new DepartmentExample();
		DepartmentExample.Criteria criteria = example.createCriteria();
		criteria.andDepartmentIdLike(departmentId);
		return departmentMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchDepartmentByDepartmentId(Integer page,
			Integer rows, String departmentId) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<Department> list = departmentMapper.searchDepartmentByDepartmentId(departmentId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Department> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchDepartmentByDepartmentName(Integer page,
			Integer rows, String departmentName) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<Department> list = departmentMapper.searchDepartmentByDepartmentName(departmentName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Department> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public Department getDep1(String name) throws Exception {
		return departmentMapper.searchDepartmentByDepartment(name);
	}
	@Override
	public Department getDep23(String name) throws Exception {
		return departmentMapper.searchDepartmentByDepartment23(name);
	}
	@Override
	public Department getDep11(String name) throws Exception {
		return departmentMapper.searchDepartmentByDepartment1(name);
	}
	@Override
	public Department getDep2(String name) throws Exception {
		return departmentMapper.searchDepartmentByFat(name);
	}
}
