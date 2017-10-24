package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarCtj;
import org.hqu.production_ms.domain.CarCtjExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarCtjPO;
import org.hqu.production_ms.mapper.CarCtjMapper;
import org.hqu.production_ms.service.CarCtjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarCtjServiceImpl implements CarCtjService{
	@Autowired
	CarCtjMapper carCtjMapper;
	@Override
	public List<CarCtj> find() throws Exception {
		CarCtjExample example = new CarCtjExample();
		return carCtjMapper.selectByExample(example);
	}
	
	@Override
	public List<CarCtj> find1(String id) throws Exception {
		CarCtjExample example = new CarCtjExample();
		return carCtjMapper.selectByExample(example);
	}
	
	@Override
	public List<CarCtj> findByNature(String string) throws Exception {
		return carCtjMapper.findByNature(string);
	}
	
	@Override
	public List<CarCtj> get() throws Exception {
			List<CarCtj> list = carCtjMapper.get();
			return list;
	}

	@Override
	public EUDataGridResult getList(int page, int rows,CarCtj carCtj) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarCtj> list = carCtjMapper.find1();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarCtj> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public EUDataGridResult getList1(int page, int rows, CarCtj carCtj,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarCtj> list = carCtjMapper.find(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarCtj> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CarCtj get(int carCtjId) throws Exception {
		return carCtjMapper.selectSingleCarCtj(carCtjId);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = carCtjMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = carCtjMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarCtjPO carCtj) throws Exception {
		int i = carCtjMapper.insert(carCtj);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增技术特性信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarCtjPO carCtj) throws Exception {
		int i = carCtjMapper.updateByPrimaryKey(carCtj);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public CustomResult update(CarCtjPO carCtj) throws Exception {
		int i = carCtjMapper.updateByPrimaryKeySelective(carCtj);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public EUDataGridResult searchCarCtjByCarCtj1(Integer page, Integer rows, String args) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarCtj> list = carCtjMapper.searchCarCtjByCarCtj1(args);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarCtj> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public EUDataGridResult searchCarCtjByCarCtj2(Integer page, Integer rows, String args) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarCtj> list = carCtjMapper.searchCarCtjByCarCtj2(args);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarCtj> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarCtjByCarCtj3(Integer page, Integer rows, String args, String str1)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarCtj> list = carCtjMapper.searchCarCtjByCarCtj3(args,str1);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarCtj> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarCtjByCarCtj4(Integer page, Integer rows, String args,String arg,String arg2) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarCtj> list = carCtjMapper.searchCarCtjByCarCtj4(args,arg,arg2);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarCtj> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarCtjByCarCtj5(Integer page, Integer rows, String args)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarCtj> list = carCtjMapper.searchCarCtjByCarCtj5(args);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarCtj> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	@Override
	public EUDataGridResult searchCarCtjByCarCtj6(Integer page, Integer rows, String args, String args1)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarCtj> list = carCtjMapper.searchCarCtjByCarCtj6(args,args1);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarCtj> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	@Override
	public EUDataGridResult searchCarCtjByCarCtj7(Integer page, Integer rows, String args, String args1)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarCtj> list = carCtjMapper.searchCarCtjByCarCtj7(args,args1);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarCtj> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	@Override
	public EUDataGridResult searchCarCtjByCarCtj9(Integer page, Integer rows, String args, String st, String args3, String st3) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarCtj> list = carCtjMapper.searchCarCtjByCarCtj9(args,st,args3,st3);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarCtj> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarCtjByCarCtj8(Integer page, Integer rows, String args, String str, String str1)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarCtj> list = carCtjMapper.searchCarCtjByCarCtj8(args,str,str1);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarCtj> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarCtjByCarCtj10(Integer page, Integer rows, String args, String st) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarCtj> list = carCtjMapper.searchCarCtjByCarCtj10(args,st);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarCtj> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarCtjByCarCtj11(Integer page, Integer rows, String args, String str, String str1)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarCtj> list = carCtjMapper.searchCarCtjByCarCtj11(args,str,str1);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarCtj> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}


}
