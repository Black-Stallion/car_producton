package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarTire;
import org.hqu.production_ms.domain.CarTireExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarTirePO;
import org.hqu.production_ms.mapper.CarTireMapper;
import org.hqu.production_ms.service.CarTireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CarTireServiceImpl implements CarTireService{
	@Autowired
	CarTireMapper carMapper;
	@Override
	public List<CarTire> find() throws Exception {
		CarTireExample example = new CarTireExample();
		return carMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarTire carTire) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarTire> list = carMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarTire> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public List<CarTire> find1(String id) throws Exception {
		CarTireExample example = new CarTireExample();
		return carMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList1(int page, int rows, CarTire carTire,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarTire> list = carMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarTire> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public CarTire get(int carTireId) throws Exception {
		return carMapper.selectSingleCarTire(carTireId);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = carMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = carMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarTirePO carTire) throws Exception {
		int i = carMapper.insert(carTire);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增车型信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarTirePO carTire) throws Exception {
		int i = carMapper.updateByPrimaryKey(carTire);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改车型信息失败");
		}
	}

	@Override
	public CustomResult update(CarTirePO carTire) throws Exception {
		int i = carMapper.updateByPrimaryKeySelective(carTire);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改车型信息失败");
		}
	}

	@Override
	public List<CarTire> searchCarTireByCarTireName(String carTireName) throws Exception {
		CarTireExample example = new CarTireExample();
		CarTireExample.Criteria criteria = example.createCriteria();
		criteria.andChangpaiLike(carTireName);
		return carMapper.selectByExample(example);
	}

	@Override
	public List<CarTire> searchCarTireByCarTireId(int carTireId) throws Exception {
		CarTireExample example = new CarTireExample();
		CarTireExample.Criteria criteria = example.createCriteria();
		criteria.andTireIdEqualTo(carTireId);
		return carMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchCarTireByCarTireBrand(Integer page, Integer rows, String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarTire> list = carMapper.searchCarTireByCarTireBand(brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarTire> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarTireByCarTireCarXH(Integer page, Integer rows, String carXH) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarTire> list = carMapper.searchCarTireByCarTireCarXH(carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarTire> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarTireByCheckNums(Integer page, Integer rows, int checkNums) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarTire> list = carMapper.searchCarTireByCarTireNums(checkNums);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarTire> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

}
