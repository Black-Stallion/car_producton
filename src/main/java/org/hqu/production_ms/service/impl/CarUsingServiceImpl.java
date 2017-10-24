package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarUsing;
import org.hqu.production_ms.domain.CarUsingExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarUsingPO;
import org.hqu.production_ms.mapper.CarUsingMapper;
import org.hqu.production_ms.service.CarUsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CarUsingServiceImpl implements CarUsingService {

	@Autowired
	CarUsingMapper carUsingMapper;
	@Override
	public List<CarUsing> find() throws Exception {
		CarUsingExample example = new CarUsingExample();
		return carUsingMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarUsing CarUsing) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarUsing> list = carUsingMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarUsing> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public List<CarUsing> find1(String id) throws Exception {
		CarUsingExample example = new CarUsingExample();
		return carUsingMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList1(int page, int rows, CarUsing CarUsing,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarUsing> list = carUsingMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarUsing> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CarUsing get(int CarUsingId) throws Exception {
		return carUsingMapper.selectSingleCarUsing(CarUsingId);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = carUsingMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = carUsingMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarUsingPO CarUsing) throws Exception {
		int i = carUsingMapper.insert(CarUsing);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增车型信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarUsingPO CarUsing) throws Exception {
		int i = carUsingMapper.updateByPrimaryKey(CarUsing);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改车型信息失败");
		}
	}

	@Override
	public CustomResult update(CarUsingPO CarUsing) throws Exception {
		int i = carUsingMapper.updateByPrimaryKeySelective(CarUsing);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改车型信息失败");
		}
	}


	@Override
	public EUDataGridResult searchCarUsingByCarUsingYear(Integer page, Integer rows, int year) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarUsing> list = carUsingMapper.searchCarUsingByUsingyear(year);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarUsing> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarUsingByCarUsingCarId(Integer page, Integer rows, int carnumber) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarUsing> list = carUsingMapper.searchCarUsingByCarUsingCarId(carnumber);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarUsing> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarUsingByCarUsing1(Integer page, Integer rows, String year) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarUsing> list = carUsingMapper.searchCarUsingBy1(year);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarUsing> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarUsingByCarUsing2(Integer page, Integer rows, String year) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarUsing> list = carUsingMapper.searchCarUsingBy2(year);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarUsing> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarUsingByCarUsing1s(Integer page, Integer rows, String id, String year)
			throws Exception {
		PageHelper.startPage(page, rows);
		List<CarUsing> list = carUsingMapper.searchCarUsingBy1s(id,year);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarUsing> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarUsingByCarUsing2s(Integer page, Integer rows, String id, String year)
			throws Exception {
		PageHelper.startPage(page, rows);
		List<CarUsing> list = carUsingMapper.searchCarUsingBy2s(id,year);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarUsing> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	

}
