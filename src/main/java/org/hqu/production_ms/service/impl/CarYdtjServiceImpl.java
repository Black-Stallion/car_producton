package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CarYdtjIn;
import org.hqu.production_ms.domain.CarYdtjInExample;
import org.hqu.production_ms.domain.CarYdtjOut;
import org.hqu.production_ms.domain.CarYdtjOutExample;
import org.hqu.production_ms.domain.CarYdtjRemove;
import org.hqu.production_ms.domain.CarYdtjRemoveExample;
import org.hqu.production_ms.domain.CarYdtjSelf;
import org.hqu.production_ms.domain.CarYdtjSelfExample;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.mapper.CarYdtjInMapper;
import org.hqu.production_ms.mapper.CarYdtjOutMapper;
import org.hqu.production_ms.mapper.CarYdtjRemoveMapper;
import org.hqu.production_ms.mapper.CarYdtjSelfMapper;
import org.hqu.production_ms.service.CarYdtjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarYdtjServiceImpl implements CarYdtjService{
	@Autowired
	CarYdtjInMapper carYdtjInMapper;
	@Autowired
	CarYdtjOutMapper carYdtjOutMapper;
	@Autowired
	CarYdtjSelfMapper carYdtjSelfMapper;
	@Autowired
	CarYdtjRemoveMapper carYdtjRemoveMapper;
	@Override
	public List<CarYdtjIn> findIn() throws Exception {
		CarYdtjInExample example = new CarYdtjInExample();
		return carYdtjInMapper.selectByExample(example);
	}
	
	@Override
	public List<CarYdtjIn> findIn1() throws Exception {
		CarYdtjInExample example = new CarYdtjInExample();
		return carYdtjInMapper.selectByExample(example);
	}
	@Override
	public List<CarYdtjOut> findOut() throws Exception {
		CarYdtjOutExample example = new CarYdtjOutExample();
		return carYdtjOutMapper.selectByExample(example);
	}
	
	@Override
	public List<CarYdtjOut> findOut1() throws Exception {
		CarYdtjOutExample example = new CarYdtjOutExample();
		return carYdtjOutMapper.selectByExample(example);
	}
	@Override
	public List<CarYdtjSelf> findSelf() throws Exception {
		CarYdtjSelfExample example = new CarYdtjSelfExample();
		return carYdtjSelfMapper.selectByExample(example);
	}
	
	@Override
	public List<CarYdtjSelf> findSelf1() throws Exception {
		CarYdtjSelfExample example = new CarYdtjSelfExample();
		return carYdtjSelfMapper.selectByExample(example);
	}
	@Override
	public List<CarYdtjRemove> findRemove() throws Exception {
		CarYdtjRemoveExample example = new CarYdtjRemoveExample();
		return carYdtjRemoveMapper.selectByExample(example);
	}
	
	@Override
	public List<CarYdtjRemove> findRemove1() throws Exception {
		CarYdtjRemoveExample example = new CarYdtjRemoveExample();
		return carYdtjRemoveMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getListIn(int page, int rows,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarYdtjIn> list = carYdtjInMapper.find(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarYdtjIn> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public EUDataGridResult getListIn1(int page, int rows, CarYdtjIn carYdtj) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarYdtjIn> list = carYdtjInMapper.find1();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarYdtjIn> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public EUDataGridResult getListOut(int page, int rows,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarYdtjOut> list = carYdtjOutMapper.find(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarYdtjOut> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public EUDataGridResult getListOut1(int page, int rows, CarYdtjOut carYdtj) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarYdtjOut> list = carYdtjOutMapper.find1();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarYdtjOut> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public EUDataGridResult getListSelf(int page, int rows,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarYdtjSelf> list = carYdtjSelfMapper.find(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarYdtjSelf> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public EUDataGridResult getListSelf1(int page, int rows, CarYdtjSelf carYdtj) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarYdtjSelf> list = carYdtjSelfMapper.find1();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarYdtjSelf> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public EUDataGridResult getListRemove(int page, int rows,String id) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarYdtjRemove> list = carYdtjRemoveMapper.find(id);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarYdtjRemove> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	@Override
	public EUDataGridResult getListRemove1(int page, int rows, CarYdtjRemove carYdtj) throws Exception {
		//分页处理
				PageHelper.startPage(page, rows);
				List<CarYdtjRemove> list = carYdtjRemoveMapper.find1();
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<CarYdtjRemove> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
				
	}

	@Override
	public EUDataGridResult searchCarYdtjByCarYdtjIn1(Integer page, Integer rows, String args) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYdtjIn> list = carYdtjInMapper.searchCarYdtjInByCarYdtj1(args);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYdtjIn> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarYdtjByCarYdtjIn2(Integer page, Integer rows, String args, String arg) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYdtjIn> list = carYdtjInMapper.searchCarYdtjInByCarYdtj2(args,arg);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYdtjIn> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarYdtjByCarYdtjIn3(Integer page, Integer rows,String arg) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYdtjIn> list = carYdtjInMapper.searchCarYdtjInByCarYdtj3(arg);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYdtjIn> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	@Override
	public EUDataGridResult searchCarYdtjByCarYdtjIn4(Integer page, Integer rows, String args, String arg) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYdtjIn> list = carYdtjInMapper.searchCarYdtjInByCarYdtj4(args,arg);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYdtjIn> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarYdtjByCarYdtjIn5(Integer page, Integer rows,String arg, String args, String str1) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYdtjIn> list = carYdtjInMapper.searchCarYdtjInByCarYdtj5(arg,args,str1);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYdtjIn> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarYdtjByCarYdtjOut1(Integer page, Integer rows, String args) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYdtjOut> list = carYdtjOutMapper.searchCarYdtjOutByCarYdtj1(args);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYdtjOut> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarYdtjByCarYdtjOut2(Integer page, Integer rows, String arg, String args)
			throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYdtjOut> list = carYdtjOutMapper.searchCarYdtjOutByCarYdtj2(arg,args);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYdtjOut> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarYdtjByCarYdtjOut3(Integer page, Integer rows, String arg) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYdtjOut> list = carYdtjOutMapper.searchCarYdtjOutByCarYdtj3(arg);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYdtjOut> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarYdtjByCarYdtjOut4(Integer page, Integer rows, String arg, String args)
			throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYdtjOut> list = carYdtjOutMapper.searchCarYdtjOutByCarYdtj4(arg,args);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYdtjOut> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarYdtjByCarYdtjOut5(Integer page, Integer rows, String arg, String args, String str1)
			throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYdtjOut> list = carYdtjOutMapper.searchCarYdtjOutByCarYdtj5(arg,args,str1);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYdtjOut> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarYdtjByCarYdtjRemove1(Integer page, Integer rows, String args) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYdtjRemove> list = carYdtjRemoveMapper.searchCarYdtjRemoveByCarYdtj1(args);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYdtjRemove> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarYdtjByCarYdtjRemove2(Integer page, Integer rows, String arg, String args)
			throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYdtjRemove> list = carYdtjRemoveMapper.searchCarYdtjRemoveByCarYdtj2(arg,args);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYdtjRemove> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarYdtjByCarYdtjRemove3(Integer page, Integer rows, String arg) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYdtjRemove> list = carYdtjRemoveMapper.searchCarYdtjRemoveByCarYdtj3(arg);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYdtjRemove> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarYdtjByCarYdtjRemove4(Integer page, Integer rows, String arg, String args)
			throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYdtjRemove> list = carYdtjRemoveMapper.searchCarYdtjRemoveByCarYdtj4(arg,args);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYdtjRemove> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarYdtjByCarYdtjRemove5(Integer page, Integer rows, String arg, String args,
			String str1) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYdtjRemove> list = carYdtjRemoveMapper.searchCarYdtjRemoveByCarYdtj5(arg,args,str1);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYdtjRemove> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarYdtjByCarYdtjSelf1(Integer page, Integer rows, String args) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYdtjSelf> list = carYdtjSelfMapper.searchCarYdtjSelfByCarYdtj1(args);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYdtjSelf> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarYdtjByCarYdtjSelf2(Integer page, Integer rows, String arg, String args)
			throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYdtjSelf> list = carYdtjSelfMapper.searchCarYdtjSelfByCarYdtj2(arg,args);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYdtjSelf> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarYdtjByCarYdtjSelf3(Integer page, Integer rows, String arg) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYdtjSelf> list = carYdtjSelfMapper.searchCarYdtjSelfByCarYdtj3(arg);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYdtjSelf> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarYdtjByCarYdtjSelf4(Integer page, Integer rows, String arg, String args)
			throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYdtjSelf> list = carYdtjSelfMapper.searchCarYdtjSelfByCarYdtj4(arg,args);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYdtjSelf> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchCarYdtjByCarYdtjSelf5(Integer page, Integer rows, String arg, String args,
			String str1) throws Exception {
		PageHelper.startPage(page, rows);
		List<CarYdtjSelf> list = carYdtjSelfMapper.searchCarYdtjSelfByCarYdtj5(arg,args,str1);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CarYdtjSelf> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
}
