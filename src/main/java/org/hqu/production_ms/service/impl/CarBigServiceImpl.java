package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarBig;
import org.hqu.production_ms.domain.CarBigExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarBigPO;
import org.hqu.production_ms.mapper.CarBigMapper;
import org.hqu.production_ms.service.CarBigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CarBigServiceImpl implements CarBigService{
	@Autowired
	CarBigMapper carMapper;
	@Override
	public List<CarBig> find() throws Exception {
		CarBigExample example = new CarBigExample();
		return carMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarBig carBig) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarBig> list = carMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarBig> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public List<CarBig> find1(String id) throws Exception {
		CarBigExample example = new CarBigExample();
		return carMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList1(int page, int rows, CarBig carBig,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarBig> list = carMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarBig> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CarBig get(int carBigId) throws Exception {
		return carMapper.selectSingleCarBig(carBigId);
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
	public CustomResult insert(CarBigPO carBig) throws Exception {
		int i = carMapper.insert(carBig);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarBigPO carBig) throws Exception {
		int i = carMapper.updateByPrimaryKey(carBig);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改信息失败");
		}
	}

	@Override
	public CustomResult update(CarBigPO carBig) throws Exception {
		int i = carMapper.updateByPrimaryKeySelective(carBig);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改信息失败");
		}
	}

	@Override
	public List<CarBig> searchCarBigByCarBigName(String carBigName) throws Exception {
		CarBigExample example = new CarBigExample();
		CarBigExample.Criteria criteria = example.createCriteria();
		criteria.andBigcarnumLike(carBigName);
		return carMapper.selectByExample(example);
	}

	@Override
	public List<CarBig> searchCarBigByCarBigId(int carBigId) throws Exception {
		CarBigExample example = new CarBigExample();
		CarBigExample.Criteria criteria = example.createCriteria();
		criteria.andBigIdEqualTo(carBigId);
		return carMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchCarBigByCarBigBrand(Integer page, Integer rows, String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarBig> list = carMapper.searchCarBigByCarBig1(brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarBig> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarBigByCarBigCarXH(Integer page, Integer rows, String carXH) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarBig> list = carMapper.searchCarBigByCarBig2(carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarBig> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarBigByCarId(Integer page, Integer rows, int checkNums) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarBig> list = carMapper.searchCarBigByCarCarID(checkNums);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarBig> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public EUDataGridResult searchCarBig1(Integer page, Integer rows, String checkNums) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarBig> list = carMapper.searchCarBigByCarBig1(checkNums);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarBig> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarBig2(Integer page, Integer rows, String checkNums) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarBig> list = carMapper.searchCarBigByCarBig2(checkNums);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarBig> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public EUDataGridResult searchCarBig1s(Integer page, Integer rows, String id, String checkNums) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarBig> list = carMapper.searchCarBigByCarBig1s(id,checkNums);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarBig> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public EUDataGridResult searchCarBig2s(Integer page, Integer rows, String id, String checkNums) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarBig> list = carMapper.searchCarBigByCarBig2s(id,checkNums);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarBig> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
