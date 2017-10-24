package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarSend;
import org.hqu.production_ms.domain.CarSendExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarSendPO;
import org.hqu.production_ms.mapper.CarSendMapper;
import org.hqu.production_ms.service.CarSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarSendServiceImpl implements CarSendService{
	@Autowired
	CarSendMapper carSendMapper;
	@Override
	public List<CarSend> find() throws Exception {
		CarSendExample example = new CarSendExample();
		return carSendMapper.selectByExample(example);
	}
	@Override
	public List<CarSend> findStat() throws Exception {
		return carSendMapper.findStat();
	}
	@Override
	public List<CarSend> findStat1(String id) throws Exception {
		return carSendMapper.findStat1(id);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, CarSend carSend) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarSend> list = carSendMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarSend> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	public List<CarSend> find1(String id) throws Exception {
		CarSendExample example = new CarSendExample();
		return carSendMapper.selectByExample(example);
	}
//	public List<CarSend> find1(HttpRequest) throws Exception {
//		
//		return carSendMapper.find1();
//	}

	@Override
	public EUDataGridResult getList1(int page, int rows, CarSend carSend,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarSend> list = carSendMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarSend> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	public List<CarSend> finds(String id,String ids) throws Exception {
		CarSendExample example = new CarSendExample();
		return carSendMapper.selectByExample(example);
	}
//	public List<CarSend> find1(HttpRequest) throws Exception {
//		
//		return carSendMapper.find1();
//	}

	@Override
	public EUDataGridResult getLists(int page, int rows, CarSend carSend,String id,String ids) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarSend> list = carSendMapper.finds(id,ids);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarSend> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CarSend get(int carSendId) throws Exception {
		return carSendMapper.selectSingleCarSend(carSendId);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = carSendMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = carSendMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarSendPO carSend) throws Exception {
		int i = carSendMapper.insert(carSend);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增技术特性信息失败");
		}
	}

	@Override
	public CustomResult updateAll(CarSendPO carSend) throws Exception {
		int i = carSendMapper.updateByPrimaryKey(carSend);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public CustomResult update(CarSendPO carSend) throws Exception {
		int i = carSendMapper.updateByPrimaryKeySelective(carSend);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public List<CarSend> searchCarSendByCarSendName(String applyname) throws Exception {
		CarSendExample example = new CarSendExample();
		CarSendExample.Criteria criteria = example.createCriteria();
		criteria.andSenduserLike(applyname);
		return carSendMapper.selectByExample(example);
	}

	@Override
	public List<CarSend> searchCarSendByCarSendId(int carSendId) throws Exception {
		CarSendExample example = new CarSendExample();
		CarSendExample.Criteria criteria = example.createCriteria();
		criteria.andApplyIdEqualTo(carSendId);
		return carSendMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchCarSendByCarSendBrand(Integer page, Integer rows, String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarSend> list = carSendMapper.searchCarSendByCarSendDriverfrom(brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarSend> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarSendByCarSendCarXH(Integer page, Integer rows, String carXH) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarSend> list = carSendMapper.searchCarSendByCarSendAA(carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarSend> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarSendByCheckNums(Integer page, Integer rows, String checkNums) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarSend> list = carSendMapper.searchCarSendByCarSendName(checkNums);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarSend> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public EUDataGridResult getListByD(int page, int rows, String id) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarSend> list = carSendMapper.findByDepartment(id);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarSend> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	@Override
	public EUDataGridResult searchCarSendByCarSendBrand1(Integer page, Integer rows, String id,String brand) throws Exception {
			//分页处理
			PageHelper.startPage(page, rows);
			List<CarSend> list = carSendMapper.searchCarSendByCarSendDriverfrom1(id,id,brand);
			//创建一个返回值对象
			EUDataGridResult result = new EUDataGridResult();
			result.setRows(list);
			//取记录总条数
			PageInfo<CarSend> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			return result;
	}

	@Override
	public EUDataGridResult searchCarSendByCarSendCarXH1(Integer page, Integer rows, String id, String carXH) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarSend> list = carSendMapper.searchCarSendByCarSendAA1(id,id,carXH);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarSend> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarSendByCheckNums1(Integer page, Integer rows, String id, String checkNums) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarSend> list = carSendMapper.searchCarSendByCarSendName1(id,id,checkNums);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarSend> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	
	@Override
	public EUDataGridResult findByCarId(Integer page, Integer rows, int id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarSend> list = carSendMapper.findByCarId(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarSend> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

}
