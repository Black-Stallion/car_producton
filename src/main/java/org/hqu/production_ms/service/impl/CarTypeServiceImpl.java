package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarType;
import org.hqu.production_ms.domain.CarTypeExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarTypePO;
import org.hqu.production_ms.mapper.CarTypeMapper;
import org.hqu.production_ms.service.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CarTypeServiceImpl implements CarTypeService{
	@Autowired
	CarTypeMapper carMapper;
	@Override
	public List<CarType> find() throws Exception {
		CarTypeExample example = new CarTypeExample();
		return carMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarType carType) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarType> list = carMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarType> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CarType get(int carTypeId) throws Exception {
		return carMapper.selectSingleCarType(carTypeId);
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
	public CustomResult insert(CarTypePO carType) throws Exception {
		int i = carMapper.insert(carType);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增车型信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarTypePO carType) throws Exception {
		int i = carMapper.updateByPrimaryKey(carType);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改车型信息失败");
		}
	}

	@Override
	public CustomResult update(CarTypePO carType) throws Exception {
		int i = carMapper.updateByPrimaryKeySelective(carType);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改车型信息失败");
		}
	}

	@Override
	public List<CarType> searchCarTypeByCarTypeName(String carTypeName) throws Exception {
		CarTypeExample example = new CarTypeExample();
		CarTypeExample.Criteria criteria = example.createCriteria();
		criteria.andBrandLike(carTypeName);
		return carMapper.selectByExample(example);
	}

	@Override
	public List<CarType> searchCarTypeByCarTypeId(int carTypeId) throws Exception {
		CarTypeExample example = new CarTypeExample();
		CarTypeExample.Criteria criteria = example.createCriteria();
		criteria.andTypeidEqualTo(carTypeId);
		return carMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchCarTypeByCarTypeBrand(Integer page, Integer rows, String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarType> list = carMapper.searchCarTypeByCarTypeBand(brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarType> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarTypeByCarTypeCarXH(Integer page, Integer rows, String carXH) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarType> list = carMapper.searchCarTypeByCarTypeCarXH(carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarType> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarTypeByCheckNums(Integer page, Integer rows, int checkNums) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarType> list = carMapper.searchCarTypeByCarTypeNums(checkNums);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarType> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

}
