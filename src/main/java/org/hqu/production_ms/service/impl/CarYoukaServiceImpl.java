package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarYouka;
import org.hqu.production_ms.domain.CarYoukaExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarYoukaPO;
import org.hqu.production_ms.mapper.CarYoukaMapper;
import org.hqu.production_ms.service.CarYoukaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarYoukaServiceImpl implements CarYoukaService{
	@Autowired
	CarYoukaMapper carYoukaMapper;
	@Override
	public List<CarYouka> find() throws Exception {
		CarYoukaExample example = new CarYoukaExample();
		return carYoukaMapper.selectByExample(example);
	}
	@Override
	public List<CarYouka> find1(String id) throws Exception {
		CarYoukaExample example = new CarYoukaExample();
		return carYoukaMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList1(int page, int rows, CarYouka carYouka) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarYouka> list = carYoukaMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarYouka> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public EUDataGridResult getList(int page, int rows, CarYouka carYouka,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarYouka> list = carYoukaMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarYouka> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CarYouka get(int carYoukaId) throws Exception {
		return carYoukaMapper.selectSingleCarYouka(carYoukaId);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = carYoukaMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = carYoukaMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarYoukaPO carYouka) throws Exception {
		int i = carYoukaMapper.insert(carYouka);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增技术特性信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarYoukaPO carYouka) throws Exception {
		int i = carYoukaMapper.updateByPrimaryKey(carYouka);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public CustomResult update(CarYoukaPO carYouka) throws Exception {
		int i = carYoukaMapper.updateByPrimaryKeySelective(carYouka);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}


	@Override
	public List<CarYouka> searchCarYoukaByCarYoukaId(int carYoukaId) throws Exception {
		CarYoukaExample example = new CarYoukaExample();
		CarYoukaExample.Criteria criteria = example.createCriteria();
		criteria.andYoukaIdEqualTo(carYoukaId);
		return carYoukaMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchCarYoukaByCarYoukaBrand(Integer page, Integer rows, String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarYouka> list = carYoukaMapper.searchCarYoukaByCarYoukaDriverfrom(brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarYouka> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}
	@Override
	public EUDataGridResult searchCarYoukaByCarYoukaBrand1(Integer page, Integer rows,String id, String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarYouka> list = carYoukaMapper.searchCarYoukaByCarYoukaDriverfrom1(id,brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarYouka> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarYoukaByCarYoukaCarXH(Integer page, Integer rows, String carXH) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarYouka> list = carYoukaMapper.searchCarYoukaByCarYoukaAA(carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYouka> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	@Override
	public EUDataGridResult searchCarYoukaByCarYoukaCarXH1(Integer page, Integer rows,String id, String carXH) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarYouka> list = carYoukaMapper.searchCarYoukaByCarYoukaAA1(id,carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYouka> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public CustomResult updateById(CarYoukaPO carYouka) throws Exception {
		int i = carYoukaMapper.updateById(carYouka);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "审批失败");
		}
	}
	@Override
	public CarYouka findByCarId(int carId) throws Exception {
		return carYoukaMapper.findByCarId(carId);
	}
}
