package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarDie;
import org.hqu.production_ms.domain.CarDieExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarDiePO;
import org.hqu.production_ms.mapper.CarDieMapper;
import org.hqu.production_ms.service.CarDieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarDieServiceImpl implements CarDieService {

	@Autowired
	CarDieMapper technicalMapper;
	@Override
	public List<CarDie> find() throws Exception {
		CarDieExample example = new CarDieExample();
		return technicalMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarDie carDie) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarDie> list = technicalMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarDie> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public List<CarDie> find1(String id) throws Exception {
		CarDieExample example = new CarDieExample();
		return technicalMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList1(int page, int rows, CarDie carDie,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarDie> list = technicalMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarDie> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public CarDie get(int carDieId) throws Exception {
		return technicalMapper.selectSingleCarDie(carDieId);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = technicalMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = technicalMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarDiePO carDie) throws Exception {
		int i = technicalMapper.insert(carDie);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增技术特性信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarDiePO carDie) throws Exception {
		int i = technicalMapper.updateByPrimaryKey(carDie);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public CustomResult update(CarDiePO carDie) throws Exception {
		int i = technicalMapper.updateByPrimaryKeySelective(carDie);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public List<CarDie> searchCarDieByCarDieName(String driverFrom) throws Exception {
		CarDieExample example = new CarDieExample();
		CarDieExample.Criteria criteria = example.createCriteria();
		criteria.andOutorganLike(driverFrom);
		return technicalMapper.selectByExample(example);
	}

	@Override
	public List<CarDie> searchCarDieByCarDieId(int carDieId) throws Exception {
		CarDieExample example = new CarDieExample();
		CarDieExample.Criteria criteria = example.createCriteria();
		criteria.andDieIdEqualTo(carDieId);
		return technicalMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchCarDieByCarDieBrand(Integer page, Integer rows, String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarDie> list = technicalMapper.searchCarDieByCarDieDriverfrom(brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarDie> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarDieByCarDieCarXH(Integer page, Integer rows, String carXH) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarDie> list = technicalMapper.searchCarDieByCarDieAA(carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarDie> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarDieByCheckNums(Integer page, Integer rows, String checkNums) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarDie> list = technicalMapper.searchCarDieByCarDieName(checkNums);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarDie> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

}
