package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarMaintenance;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarMaintenancePO;
import org.hqu.production_ms.service.CarMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carMaintenance")
public class CarMaintenanceController {
	@Autowired
	private CarMaintenanceService carMaintenanceService;
	
	@RequestMapping("/get/{carMaintenanceId}")
	@ResponseBody
	public CarMaintenance getItemById(@PathVariable int technicalId) throws Exception{
		CarMaintenance carMaintenance = carMaintenanceService.get(technicalId);
		return carMaintenance;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarMaintenance> getData() throws Exception{
		 List<CarMaintenance> list = carMaintenanceService.find();
		return list;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "carMaintenance_list";                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carMaintenanceAddJudge() throws Exception{
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
			if(!subject.isPermitted("maintenance:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "carMaintenance_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carMaintenanceEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("maintenance:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "carMaintenance_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, CarMaintenance carMaintenance) throws Exception{
		EUDataGridResult result = carMaintenanceService.getList(page, rows, carMaintenance);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarMaintenancePO carMaintenance, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			System.out.println(carMaintenance);
			result = carMaintenanceService.insert(carMaintenance);
		}
		
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarMaintenancePO cCarMaintenance, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carMaintenanceService.update(cCarMaintenance);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarMaintenancePO cCarMaintenance, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carMaintenanceService.updateAll(cCarMaintenance);
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carMaintenanceDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("maintenance:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carMaintenanceService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		CustomResult result = carMaintenanceService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carMaintenance_by_brand")
	@ResponseBody
	public EUDataGridResult searchCarMaintenanceByCarMaintenanceBrand(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carMaintenanceService.searchCarMaintenanceByCarMaintenanceBrand(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carMaintenance_by_carxh")
	@ResponseBody
	public EUDataGridResult searchCarMaintenanceByCarMaintenanceCarXH(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carMaintenanceService.searchCarMaintenanceByCarMaintenanceCarXH(page, rows, searchValue);
		return result;
	}
	
}
