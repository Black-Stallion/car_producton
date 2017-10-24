package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarPublic;
import org.hqu.production_ms.domain.CarRegister;
import org.hqu.production_ms.domain.CarRegisterExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarRegisterPO;
import org.hqu.production_ms.mapper.CarRegisterMapper;
import org.hqu.production_ms.service.CarRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarRegisterServiceImpl implements CarRegisterService{
	@Autowired
	CarRegisterMapper carRegisterMapper;
	@Override
	public List<CarRegister> find() throws Exception {
		CarRegisterExample example = new CarRegisterExample();
		return carRegisterMapper.selectByExample(example);
	}
	
	@Override
	public List<CarRegister> find1(String id) throws Exception {
		CarRegisterExample example = new CarRegisterExample();
		return carRegisterMapper.selectByExample(example);
	}
	
	@Override
	public List<CarRegister> findByNature(String string) throws Exception {
		return carRegisterMapper.findByNature(string);
	}
	@Override
	public List<CarRegister> findByNature1(String string,String id) throws Exception {
		return carRegisterMapper.findByNature1(string,id);
	}
	
	@Override
	public List<CarRegister> get() throws Exception {
			List<CarRegister> list = carRegisterMapper.get();
			return list;
	}
	
	@Override
	public List<CarPublic> findP() throws Exception {
			List<CarPublic> list = carRegisterMapper.findP();
			return list;
	}
	@Override
	public List<CarRegister> findP11() throws Exception {
			List<CarRegister> list = carRegisterMapper.findP11();
			return list;
	}
	@Override
	public List<CarRegister> findP2(String id) throws Exception {
			List<CarRegister> list = carRegisterMapper.findP2(id);
			return list;
	}
	
	@Override
	public List<CarRegister> get1(String id) throws Exception {
			List<CarRegister> list = carRegisterMapper.get1(id);
			return list;
	}
	@Override
	public List<CarPublic> findP1(String id) throws Exception {
			List<CarPublic> list = carRegisterMapper.findP1(id);
			return list;
	}
	@Override
	public EUDataGridResult getList(int page, int rows, CarRegister carRegister) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarRegister> list = carRegisterMapper.find();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarRegister> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public EUDataGridResult getList1(int page, int rows, CarRegister carRegister,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarRegister> list = carRegisterMapper.find1(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarRegister> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public CarRegister get(int carRegisterId) throws Exception {
		return carRegisterMapper.selectSingleCarRegister(carRegisterId);
	}

	@Override
	public CustomResult delete(int string) throws Exception {
		int i = carRegisterMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(int[] ids) throws Exception {
		int i = carRegisterMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "删除信息失败");
		}
	}

	@Override
	public CustomResult insert(CarRegisterPO carRegister) throws Exception {
		int i = carRegisterMapper.insert(carRegister);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增车辆调动失败");
		}
	}
	
	@Override
	public boolean updateDepById(String id,int ids) throws Exception {
		int i = carRegisterMapper.updateDepById(id, ids);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public boolean updateDepByIds(String id,String ids) throws Exception {
		int i = carRegisterMapper.updateDepByIds(id, ids);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public CustomResult updateAll(CarRegisterPO carRegister) throws Exception {
		int i = carRegisterMapper.updateByPrimaryKey(carRegister);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public CustomResult update(CarRegisterPO carRegister) throws Exception {
		int i = carRegisterMapper.updateByPrimaryKeySelective(carRegister);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改技术特性信息失败");
		}
	}

	@Override
	public EUDataGridResult searchCarRegisterByCarRegisterDriverfrom(Integer page, Integer rows, String string)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarRegister> list = carRegisterMapper.searchCarRegisterByCarRegisterDriverfrom(string);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarRegister> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarRegisterByCarRegisterAA(Integer page, Integer rows, String string) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarRegister> list = carRegisterMapper.searchCarRegisterByCarRegisterAA(string);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarRegister> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}

	@Override
	public EUDataGridResult searchCarRegisterByCarRegisterName(Integer page, Integer rows, String string) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<CarRegister> list = carRegisterMapper.searchCarRegisterByCarRegisterName(string);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarRegister> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public CarRegister findByCarNumber(String id) {
		return carRegisterMapper.findByCarNumber(id);
	}
	@Override
	public CarRegister findByCarCJH(String id) {
		return carRegisterMapper.findByCarCJH(id);
	}
}
