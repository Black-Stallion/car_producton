package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarHandover;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarHandoverPO;
import org.hqu.production_ms.service.CarHandoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carHandover")
public class CarHandoverController {
	@Autowired
	private CarHandoverService carHandoverService;
	
	@RequestMapping("/get/{carHandoverId}")
	@ResponseBody
	public CarHandover getItemById(@PathVariable int technicalId) throws Exception{
		CarHandover carHandover = carHandoverService.get(technicalId);
		return carHandover;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarHandover> getData() throws Exception{
		 List<CarHandover> list = carHandoverService.find();
		return list;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "carHandover_list";                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carHandoverAddJudge() throws Exception{
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
			if(!subject.isPermitted("carHandover:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "carHandover_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carHandoverEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carHandover:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "carHandover_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, CarHandover carHandover) throws Exception{
		EUDataGridResult result = carHandoverService.getList(page, rows, carHandover);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarHandoverPO carHandover, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			System.out.println(carHandover);
			result = carHandoverService.insert(carHandover);
		}
		
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarHandoverPO cCarHandover, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carHandoverService.update(cCarHandover);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarHandoverPO cCarHandover, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carHandoverService.updateAll(cCarHandover);
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carHandoverDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carHandover:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carHandoverService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		CustomResult result = carHandoverService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carHandover_by_brand")
	@ResponseBody
	public EUDataGridResult searchCarHandoverByCarHandoverBrand(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carHandoverService.searchCarHandoverByCarHandoverBrand(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carHandover_by_carxh")
	@ResponseBody
	public EUDataGridResult searchCarHandoverByCarHandoverCarXH(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carHandoverService.searchCarHandoverByCarHandoverCarXH(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carHandover_by_checknums")
	@ResponseBody
	public EUDataGridResult searchCarHandoverByDepartmentCheckNums(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carHandoverService.searchCarHandoverByCheckNums(page, rows, searchValue);
		return result;
	}
}
