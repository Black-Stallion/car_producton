package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarSelf;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarSelfPO;
import org.hqu.production_ms.service.CarRegisterService;
import org.hqu.production_ms.service.CarSelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carSelf")
public class CarSelfController {
	@Autowired
	private CarSelfService carSelfService;
	@Autowired
	private CarRegisterService carRegisterService;
	@RequestMapping("/get/{carSelfId}")
	@ResponseBody
	public CarSelf getItemById(@PathVariable int technicalId) throws Exception{
		CarSelf carSelf = carSelfService.get(technicalId);
		return carSelf;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarSelf> getData() throws Exception{
		 List<CarSelf> list = carSelfService.find();
		return list;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "CarSelf_list";                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carSelfAddJudge() throws Exception{
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
			if(!subject.isPermitted("carSelf:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "CarSelf_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carSelfEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carSelf:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "CarSelf_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, CarSelf carSelf,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carSelfService.getList(page, rows, carSelf);
		}else{
			result = carSelfService.getList1(page, rows, carSelf,id);
		}
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarSelfPO carSelf, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			int carId = carSelf.getCarId();
			String depid = carSelf.getDepartmentId();
			boolean re = carRegisterService.updateDepById(depid, carId);
			if(re == true){
			result = carSelfService.insert(carSelf);
			}else{
				return CustomResult.build(201,"新增段内车辆调配信息失败，请刷新一下网页后重新填写！");
			}
		}
		
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarSelfPO cCarSelf, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		int carId = cCarSelf.getCarId();
		String depid = cCarSelf.getDepartmentId();
		boolean re = carRegisterService.updateDepById(depid, carId);
		if(re == true){
			return carSelfService.update(cCarSelf);
		}else{
			return CustomResult.build(201,"修改段内车辆调配信息失败，请刷新一下网页后重新填写！");
		}
		
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarSelfPO cCarSelf, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		int carId = cCarSelf.getCarId();
		String depid = cCarSelf.getDepartmentId();
		boolean re = carRegisterService.updateDepById(depid, carId);
		if(re == true){
			return carSelfService.updateAll(cCarSelf);
		}else{
			return CustomResult.build(201,"修改段内车辆调配失败！");
		}
		
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carSelfDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carSelf:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carSelfService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		CustomResult result = carSelfService.deleteBatch(ids);
		return result;
	}
	
	@RequestMapping("/search_carSelf_by_s1")
	@ResponseBody
	public EUDataGridResult searchCarSelfByCarSelfBrand(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carSelfService.searchCarSelfByCarSelfBrand(page, rows, searchValue);
		}else{
			result = carSelfService.searchCarSelfByCarSelfBrand1(page, rows,id, searchValue);
		}
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carSelf_by_s2")
	@ResponseBody
	public EUDataGridResult searchCarSelfByCarSelfCarXH(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carSelfService.searchCarSelfByCarSelfCarXH(page, rows, searchValue);
		}else{
			result = carSelfService.searchCarSelfByCarSelfCarXH1(page, rows,id, searchValue);
		}
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carSelf_by_checknums")
	@ResponseBody
	public EUDataGridResult searchCarSelfByDepartmentCheckNums(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carSelfService.searchCarSelfByCheckNums(page, rows, searchValue);
		return result;
	}
}
