package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarOut;
import org.hqu.production_ms.domain.CarOutExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarOutPO;
import org.hqu.production_ms.mapper.CarOutMapper;
import org.hqu.production_ms.service.CarOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarOutServiceImpl implements CarOutService {

	@Autowired
	CarOutMapper technicalMapper;
	@Override
	public List<CarOut> find() throws Exception {
		CarOutExample example = new CarOutExample();
		return technicalMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarOut carOut) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarOut> list = technicalMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarOut> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public List<CarOut> find1(String id) throws Exception {
		CarOutExample example = new CarOutExample();
		return technicalMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList1(int page, int rows, CarOut carOut,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarOut> list = technicalMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarOut> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CarOut get(int carOutId) throws Exception {
		return technicalMapper.selectSingleCarOut(carOutId);
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
	public CustomResult insert(CarOutPO carOut) throws Exception {
		int i = technicalMapper.insert(carOut);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增技术特性信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarOutPO carOut) throws Exception {
		int i = technicalMapper.updateByPrimaryKey(carOut);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public CustomResult update(CarOutPO carOut) throws Exception {
		int i = technicalMapper.updateByPrimaryKeySelective(carOut);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public List<CarOut> searchCarOutByCarOutName(String driverFrom) throws Exception {
		CarOutExample example = new CarOutExample();
		CarOutExample.Criteria criteria = example.createCriteria();
		criteria.andOutorganLike(driverFrom);
		return technicalMapper.selectByExample(example);
	}

	@Override
	public List<CarOut> searchCarOutByCarOutId(int carOutId) throws Exception {
		CarOutExample example = new CarOutExample();
		CarOutExample.Criteria criteria = example.createCriteria();
		criteria.andOutIdEqualTo(carOutId);
		return technicalMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchCarOutByCarOutBrand(Integer page, Integer rows, String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarOut> list = technicalMapper.searchCarOutByCarOutDriverfrom(brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarOut> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarOutByCarOutCarXH(Integer page, Integer rows, String carXH) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarOut> list = technicalMapper.searchCarOutByCarOutAA(carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarOut> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	@Override
	public EUDataGridResult searchCarOutByCarOutBrand1(Integer page, Integer rows, String brand,String id) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarOut> list = technicalMapper.searchCarOutByCarOutDriverfrom1(id,brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarOut> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarOutByCarOutCarXH1(Integer page, Integer rows, String carXH,String id) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarOut> list = technicalMapper.searchCarOutByCarOutAA1(id,carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarOut> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	@Override
	public EUDataGridResult searchCarOutByCheckNums(Integer page, Integer rows, String checkNums) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarOut> list = technicalMapper.searchCarOutByCarOutName(checkNums);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarOut> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

}
