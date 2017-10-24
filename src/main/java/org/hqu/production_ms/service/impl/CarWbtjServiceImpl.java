package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarWbtj;
import org.hqu.production_ms.domain.CarWbtjExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarWbtjPO;
import org.hqu.production_ms.mapper.CarWbtjMapper;
import org.hqu.production_ms.service.CarWbtjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarWbtjServiceImpl implements CarWbtjService{
	@Autowired
	CarWbtjMapper carWbtjMapper;
	@Override
	public List<CarWbtj> find() throws Exception {
		CarWbtjExample example = new CarWbtjExample();
		return carWbtjMapper.selectByExample(example);
	}
	
	@Override
	public List<CarWbtj> find1() throws Exception {
		CarWbtjExample example = new CarWbtjExample();
		return carWbtjMapper.selectByExample(example);
	}
	
	@Override
	public List<CarWbtj> findByNature(String string) throws Exception {
		return carWbtjMapper.findByNature(string);
	}
	
	@Override
	public List<CarWbtj> get() throws Exception {
			List<CarWbtj> list = carWbtjMapper.get();
			return list;
	}

	@Override
	public EUDataGridResult getList(int page, int rows,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarWbtj> list = carWbtjMapper.find(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarWbtj> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public EUDataGridResult getList1(int page, int rows, CarWbtj carWbtj) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarWbtj> list = carWbtjMapper.find1();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarWbtj> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CarWbtj get(int carWbtjId) throws Exception {
		return carWbtjMapper.selectSingleCarWbtj(carWbtjId);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = carWbtjMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = carWbtjMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarWbtjPO carWbtj) throws Exception {
		int i = carWbtjMapper.insert(carWbtj);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增技术特性信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarWbtjPO carWbtj) throws Exception {
		int i = carWbtjMapper.updateByPrimaryKey(carWbtj);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public CustomResult update(CarWbtjPO carWbtj) throws Exception {
		int i = carWbtjMapper.updateByPrimaryKeySelective(carWbtj);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public EUDataGridResult searchCarWbtjByCarWbtj1(Integer page, Integer rows, String args) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarWbtj> list = carWbtjMapper.searchCarWbtjByCarWbtj1(args);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarWbtj> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public EUDataGridResult searchCarWbtjByCarWbtj2(Integer page, Integer rows, String args) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarWbtj> list = carWbtjMapper.searchCarWbtjByCarWbtj2(args);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarWbtj> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarWbtjByCarWbtj3(Integer page, Integer rows, String args, String str1)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarWbtj> list = carWbtjMapper.searchCarWbtjByCarWbtj3(args,str1);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarWbtj> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarWbtjByCarWbtj5(Integer page, Integer rows, String args) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarWbtj> list = carWbtjMapper.searchCarWbtjByCarWbtj5(args);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarWbtj> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarWbtjByCarWbtj6(Integer page, Integer rows, String args, String args1)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarWbtj> list = carWbtjMapper.searchCarWbtjByCarWbtj6(args,args1);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarWbtj> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	@Override
	public EUDataGridResult searchCarWbtjByCarWbtj7(Integer page, Integer rows, String args, String args1)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarWbtj> list = carWbtjMapper.searchCarWbtjByCarWbtj7(args,args1);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarWbtj> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarWbtjByCarWbtj9(Integer page, Integer rows, String args, String st, String args3, String st3) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarWbtj> list = carWbtjMapper.searchCarWbtjByCarWbtj9(args,st,args3,st3);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarWbtj> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarWbtjByCarWbtj8(Integer page, Integer rows, String args, String str, String str1)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarWbtj> list = carWbtjMapper.searchCarWbtjByCarWbtj8(args,str,str1);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarWbtj> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	@Override
	public EUDataGridResult searchCarWbtjByCarWbtj4(Integer page, Integer rows, String args, String str, String str1)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarWbtj> list = carWbtjMapper.searchCarWbtjByCarWbtj4(args,str,str1);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarWbtj> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public EUDataGridResult searchCarWbtjByCarWbtj10(Integer page, Integer rows, String args, String str)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarWbtj> list = carWbtjMapper.searchCarWbtjByCarWbtj10(args,str);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarWbtj> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	@Override
	public EUDataGridResult searchCarWbtjByCarWbtj11(Integer page, Integer rows, String args, String str, String str1)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarWbtj> list = carWbtjMapper.searchCarWbtjByCarWbtj11(args,str,str1);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarWbtj> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
}
