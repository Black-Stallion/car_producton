package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarCheck;
import org.hqu.production_ms.domain.CarCheckExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarCheckPO;
import org.hqu.production_ms.mapper.CarCheckMapper;
import org.hqu.production_ms.service.CarCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarCheckServiceImpl implements CarCheckService {
	@Autowired
	CarCheckMapper carCheckMapper;
	@Override
	public List<CarCheck> find() throws Exception {
		CarCheckExample example = new CarCheckExample();
		return carCheckMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarCheck carCheck) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarCheck> list = carCheckMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarCheck> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public List<CarCheck> find1(String id) throws Exception {
		CarCheckExample example = new CarCheckExample();
		return carCheckMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList1(int page, int rows, CarCheck carCheck,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarCheck> list = carCheckMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarCheck> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CarCheck get(int carCheckId) throws Exception {
		return carCheckMapper.selectSingleCarCheck(carCheckId);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = carCheckMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = carCheckMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarCheckPO carCheck) throws Exception {
		int i = carCheckMapper.insert(carCheck);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增月检记录信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarCheckPO carCheck) throws Exception {
		int i = carCheckMapper.updateByPrimaryKey(carCheck);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改月检记录信息失败");
		}
	}

	@Override
	public CustomResult update(CarCheckPO CarCheck) throws Exception {
		int i = carCheckMapper.updateByPrimaryKeySelective(CarCheck);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改月检记录信息失败");
		}
	}


	@Override
	public EUDataGridResult searchCarCheckByCarCheckYear(Integer page, Integer rows, int year) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarCheck> list = carCheckMapper.searchCarCheckByCheckyear(year);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarCheck> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarCheckByCarCheckCarId(Integer page, Integer rows, int carnumber) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarCheck> list = carCheckMapper.searchCarCheckByCarCheckCarId(carnumber);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarCheckByCarCheck1(Integer page, Integer rows, String carnumber) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarCheck> list = carCheckMapper.searchCarCheckBy1(carnumber);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarCheckByCarCheck2(Integer page, Integer rows, String carnumber) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarCheck> list = carCheckMapper.searchCarCheckBy2(carnumber);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarCheckByCarCheck1s(Integer page, Integer rows, String id, String carnumber)
			throws Exception {
		PageHelper.startPage(page, rows);
		List<CarCheck> list = carCheckMapper.searchCarCheckBy1s(id,carnumber);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarCheckByCarCheck2s(Integer page, Integer rows, String id, String carnumber)
			throws Exception {
		PageHelper.startPage(page, rows);
		List<CarCheck> list = carCheckMapper.searchCarCheckBy2s(id,carnumber);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}


}
