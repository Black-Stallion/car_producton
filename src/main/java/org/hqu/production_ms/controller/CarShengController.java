package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarSheng;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarShengPO;
import org.hqu.production_ms.service.CarShengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carSheng")
public class CarShengController {
	@Autowired
	private CarShengService carShengService;
	
	@RequestMapping("/get/{carId}")
	@ResponseBody
	public CarSheng getItemById(@PathVariable int carId) throws Exception{
		CarSheng carSheng = carShengService.get(carId);
		return carSheng;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarSheng> getData(HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		 List<CarSheng> list = null;
		 int id1 =  (int) session.getAttribute("leve");
		 if(2 == id1){
			list = carShengService.find();
		}else{
			list = carShengService.find1(id);
		}
		return list;
	}
	
	@RequestMapping("/find1")
	public String find1() throws Exception{
		return "carSheng_list";                                                                                                                                                                                                                                                                                                 
	}
	
//	@RequestMapping("/find_nature")
//	public String findByNature() throws Exception{
//		return "carSheng_list";                                                                                                                                                                                                                                                                                                 
//	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carShengAddJudge() throws Exception{
		//从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		//取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>(); 
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carSheng:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "carSheng_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carShengEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carSheng:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "carSheng_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList1(Integer page, Integer rows, CarSheng carSheng,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carShengService.getList(page, rows, carSheng);
		}else{
			result = carShengService.getList1(page, rows, carSheng,id);
		}
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarShengPO carSheng, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			result = carShengService.insert(carSheng);
		}
		
		return result;
	}
	@RequestMapping(value="/check", method=RequestMethod.POST)
	@ResponseBody
	private Map<String,Object> check(@Valid String carnumber) throws Exception {
		Map<String,Object> map = null;
		map = new HashMap<String,Object>();
		CarSheng car = null;
		car = carShengService.findByCarNumber(carnumber);
		if(car != null){
			map.put("msg", "该车牌号以存在，请重新输入！");
		}
		return map;
	}
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarShengPO cCarSheng, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carShengService.update(cCarSheng);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarShengPO cCarSheng, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carShengService.updateAll(cCarSheng);
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carShengDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carSheng:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carShengService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		CustomResult result = carShengService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carSheng_by_carnumber2")
	@ResponseBody
	public EUDataGridResult searchCarShengByCarShengBrand(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carShengService.searchCarShengByCarShengDriverfrom(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carSheng_by_departmentName2")
	@ResponseBody
	public EUDataGridResult searchCarShengByCarShengCarXH(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carShengService.searchCarShengByCarShengAA(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carSheng_by_username2")
	@ResponseBody
	public EUDataGridResult searchCarShengByDepartmentCheckNums(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carShengService.searchCarShengByCarShengName(page, rows, searchValue);
		return result;
	}
}