package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarYou;
import org.hqu.production_ms.domain.CarYouExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarYouPO;
import org.hqu.production_ms.mapper.CarYouMapper;
import org.hqu.production_ms.service.CarYouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarYouServiceImpl implements CarYouService {
	@Autowired
	CarYouMapper carYouMapper;
	@Override
	public List<CarYou> find() throws Exception {
		CarYouExample example = new CarYouExample();
		return carYouMapper.selectByExample(example);
	}
	@Override
	public List<CarYou> find1(String id) throws Exception {
		CarYouExample example = new CarYouExample();
		return carYouMapper.selectByExample(example);
	}
	@Override
	public List<CarYou> find3() throws Exception {
		CarYouExample example = new CarYouExample();
		return carYouMapper.selectByExample(example);
	}
	@Override
	public List<CarYou> find4(String id) throws Exception {
		CarYouExample example = new CarYouExample();
		return carYouMapper.selectByExample(example);
	}
	@Override
	public List<CarYou> find5() throws Exception {
		return carYouMapper.find5();
	}
	@Override
	public List<CarYou> find6(String id) throws Exception {
		return carYouMapper.find6(id);
	}
	@Override
	public EUDataGridResult getList1(int page, int rows, CarYou carYou) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarYou> list = carYouMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarYou> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public EUDataGridResult getList(int page, int rows, CarYou carYou,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarYou> list = carYouMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarYou> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public EUDataGridResult getList3(int page, int rows, CarYou carYou) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarYou> list = carYouMapper.find3();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarYou> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public EUDataGridResult getList4(int page, int rows, CarYou carYou,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarYou> list = carYouMapper.find4(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarYou> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CarYou get(int carYouId) throws Exception {
		return carYouMapper.selectSingleCarYou(carYouId);
	}
	
	@Override
	public CarYou get12(String carYouId) throws Exception {
		return carYouMapper.selectSingleCarYou1(carYouId);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = carYouMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = carYouMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarYouPO carYou) throws Exception {
		int i = carYouMapper.insert(carYou);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarYouPO carYou) throws Exception {
		int i = carYouMapper.updateByPrimaryKey(carYou);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改信息失败");
		}
	}

	@Override
	public CustomResult update(CarYouPO carYou) throws Exception {
		int i = carYouMapper.updateByPrimaryKeySelective(carYou);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改信息失败");
		}
	}


	@Override
	public List<CarYou> searchCarYouByCarYouId(int carYouId) throws Exception {
		CarYouExample example = new CarYouExample();
		CarYouExample.Criteria criteria = example.createCriteria();
		criteria.andYouIdEqualTo(carYouId);
		return carYouMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchCarYouByCarYouBrand(Integer page, Integer rows, String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarYou> list = carYouMapper.searchCarYouByCarYouDriverfrom(brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarYou> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}
	@Override
	public EUDataGridResult searchCarYouByCarYouBrand1(Integer page, Integer rows,String id, String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarYou> list = carYouMapper.searchCarYouByCarYouDriverfrom1(id,brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarYou> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}
	@Override
	public CustomResult updateById(CarYouPO carYou) throws Exception {
		int i = carYouMapper.updateById(carYou);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "审批失败");
		}
	}
	@Override
	public CustomResult updateByYouId(CarYou carYou) throws Exception {
		int i = carYouMapper.updateByYouId(carYou);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "充值失败");
		}
	}
}
