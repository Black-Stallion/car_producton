package org.hqu.production_ms.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.hqu.production_ms.domain.CarMaintenance;
import org.hqu.production_ms.domain.CarMaintenanceExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarMaintenancePO;
import org.hqu.production_ms.mapper.CarMaintenanceMapper;
import org.hqu.production_ms.service.CarMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarMaintenanceServiceImpl implements CarMaintenanceService{
	@Autowired
	CarMaintenanceMapper maintenanceMapper;
	@Override
	public List<CarMaintenance> find() throws Exception {
		CarMaintenanceExample example = new CarMaintenanceExample();
		return maintenanceMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarMaintenance carMaintenance) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarMaintenance> list = maintenanceMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarMaintenance> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CarMaintenance get(int carMaintenanceId) throws Exception {
		return maintenanceMapper.selectSingleCarMaintenance(carMaintenanceId);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = maintenanceMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = maintenanceMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarMaintenancePO carMaintenance) throws Exception {
		int i = maintenanceMapper.insert(carMaintenance);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增技术特性信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarMaintenancePO carMaintenance) throws Exception {
		int i = maintenanceMapper.updateByPrimaryKey(carMaintenance);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public CustomResult update(CarMaintenancePO carMaintenance) throws Exception {
		int i = maintenanceMapper.updateByPrimaryKeySelective(carMaintenance);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public List<CarMaintenance> searchCarMaintenanceByCarMaintenanceName(BigDecimal kilometre) throws Exception {
		CarMaintenanceExample example = new CarMaintenanceExample();
		CarMaintenanceExample.Criteria criteria = example.createCriteria();
		criteria.andKilometreLike(kilometre);
		return maintenanceMapper.selectByExample(example);
	}

	@Override
	public List<CarMaintenance> searchCarMaintenanceByCarMaintenanceId(int carMaintenanceId) throws Exception {
		CarMaintenanceExample example = new CarMaintenanceExample();
		CarMaintenanceExample.Criteria criteria = example.createCriteria();
		criteria.andMaintenanceIdEqualTo(carMaintenanceId);
		return maintenanceMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchCarMaintenanceByCarMaintenanceBrand(Integer page, Integer rows, String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarMaintenance> list = maintenanceMapper.searchCarMaintenanceByCarMaintenanceDriverfrom(brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarMaintenance> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarMaintenanceByCarMaintenanceCarXH(Integer page, Integer rows, String carXH) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarMaintenance> list = maintenanceMapper.searchCarMaintenanceByCarMaintenanceName(carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarMaintenance> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public List<CarMaintenance> find1(int id) throws Exception {
		return maintenanceMapper.find1(id);
	}

	@Override
	public List<CarMaintenance> find2(double str, int id) throws Exception {
		return maintenanceMapper.find2(str,id);
	}
	@Override
	public List<CarMaintenance> find3(double str, int id) throws Exception {
		return maintenanceMapper.find3(str,id);
	}

}
