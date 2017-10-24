package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.Employee;
import org.hqu.production_ms.domain.EmployeeExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.EmployeePO;
import org.hqu.production_ms.mapper.EmployeeMapper;
import org.hqu.production_ms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeMapper employeeMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, Employee employee) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Employee> list = employeeMapper.find();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Employee> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public Employee get(String empId) throws Exception {
		return employeeMapper.selectSingleEmployee(empId);
	}

	@Override
	public CustomResult delete(String string) throws Exception {
		int i = employeeMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception {
		int i = employeeMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(EmployeePO employee) throws Exception {
		int i = employeeMapper.insert(employee);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增员工信息失败");
		}
	}

	@Override
	public CustomResult update(EmployeePO employee) throws Exception {
		int i = employeeMapper.updateByPrimaryKeySelective(employee);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改员工信息失败");
		}
	}

	@Override
	public CustomResult updateAll(EmployeePO employee) throws Exception {
		int i = employeeMapper.updateByPrimaryKey(employee);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改员工信息失败");
		}
	}

	@Override
	public List<Employee> find() throws Exception {
		EmployeeExample example = new EmployeeExample();
		return employeeMapper.selectByExample(example);
	}

	@Override
	public List<Employee> searchEmployeeByEmployeeName(String employeeName) throws Exception {
		EmployeeExample example = new EmployeeExample();
		EmployeeExample.Criteria criteria = example.createCriteria();
		criteria.andEmpNameLike(employeeName);
		return employeeMapper.selectByExample(example);
	}
	
	@Override
	public List<Employee> searchEmployeeByEmployeeId(String employeeId) throws Exception {
		EmployeeExample example = new EmployeeExample();
		EmployeeExample.Criteria criteria = example.createCriteria();
		criteria.andEmpIdLike(employeeId);
		return employeeMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchEmployeeByEmployeeId(Integer page,
			Integer rows, String employeeId) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Employee> list = employeeMapper.searchEmployeeByEmployeeId(employeeId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Employee> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchEmployeeByEmployeeName(Integer page,
			Integer rows, String employeeName) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Employee> list = employeeMapper.searchEmployeeByEmployeeName(employeeName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Employee> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchEmployeeByDepartmentName(Integer page,
			Integer rows, String departmentName) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Employee> list = employeeMapper.searchEmployeeByDepartmentName(departmentName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Employee> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
