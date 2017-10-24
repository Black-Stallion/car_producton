package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarSpecial;
import org.hqu.production_ms.domain.CarSpecialExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarSpecialPO;
import org.hqu.production_ms.mapper.CarSpecialMapper;
import org.hqu.production_ms.service.CarSpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarSpecialServiceImpl implements CarSpecialService{
	@Autowired
	CarSpecialMapper carSpecialMapper;
	@Override
	public List<CarSpecial> find() throws Exception {
		CarSpecialExample example = new CarSpecialExample();
		return carSpecialMapper.selectByExample(example);
	}
	
	@Override
	public List<CarSpecial> find1(String id) throws Exception {
		CarSpecialExample example = new CarSpecialExample();
		return carSpecialMapper.selectByExample(example);
	}
	
	@Override
	public List<CarSpecial> findByNature(String string) throws Exception {
		return carSpecialMapper.findByNature(string);
	}
	
	@Override
	public List<CarSpecial> get() throws Exception {
			List<CarSpecial> list = carSpecialMapper.get();
			return list;
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarSpecial carSpecial) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarSpecial> list = carSpecialMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarSpecial> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public EUDataGridResult getList1(int page, int rows, CarSpecial carSpecial,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarSpecial> list = carSpecialMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarSpecial> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CarSpecial get(int carSpecialId) throws Exception {
		return carSpecialMapper.selectSingleCarSpecial(carSpecialId);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = carSpecialMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = carSpecialMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarSpecialPO carSpecial) throws Exception {
		int i = carSpecialMapper.insert(carSpecial);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarSpecialPO carSpecial) throws Exception {
		int i = carSpecialMapper.updateByPrimaryKey(carSpecial);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改信息失败");
		}
	}

	@Override
	public CustomResult update(CarSpecialPO carSpecial) throws Exception {
		int i = carSpecialMapper.updateByPrimaryKeySelective(carSpecial);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改信息失败");
		}
	}

	@Override
	public EUDataGridResult searchCarSpecialByCarSpecialDriverfrom(Integer page, Integer rows, String string)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarSpecial> list = carSpecialMapper.searchCarSpecialByCarSpecialDriverfrom(string);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarSpecial> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarSpecialByCarSpecialAA(Integer page, Integer rows, String string) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarSpecial> list = carSpecialMapper.searchCarSpecialByCarSpecialAA(string);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarSpecial> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public EUDataGridResult searchCarSpecialByCarSpecialName(Integer page, Integer rows, String string) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarSpecial> list = carSpecialMapper.searchCarSpecialByCarSpecialName(string);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarSpecial> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public CarSpecial findByCarNumber(String id) {
		// TODO Auto-generated method stub
		return carSpecialMapper.findByCarNumber(id);
	}
}
