package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarType;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarTypePO;
import org.hqu.production_ms.service.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/carType")
public class CarTypeController {
	
		@Autowired
		private CarTypeService carTypeService;
		
		@RequestMapping("/get/{typeid}")
		@ResponseBody
		public CarType getItemById(@PathVariable int typeid) throws Exception{
			CarType carType = carTypeService.get(typeid);
			return carType;
		}
		
		@RequestMapping("/get_data")
		@ResponseBody
		public List<CarType> getData() throws Exception{
			 List<CarType> list = carTypeService.find();
			return list;
		}
		
		@RequestMapping("/find")
		public String find() throws Exception{
			return "carType_list";                                                                                                                                                                                                                                                                                                 
		}
		
		@RequestMapping("/add_judge")
		@ResponseBody
		public Map<String,Object> carTypeAddJudge() throws Exception{
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
				if(!subject.isPermitted("carType:add")){
					map.put("msg", "您没有权限，请切换用户登录！");
				}
			}
			return map;
		}
		
		@RequestMapping("/add")
		public String add() throws Exception{
			return "carType_add";
		}
		
		@RequestMapping("/edit_judge")
		@ResponseBody
		public Map<String,Object> carTypeEditJudge() throws Exception{
			Subject subject = SecurityUtils.getSubject();
			ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
			Map<String,Object> map = new HashMap<String,Object>();
			if(!activeUser.getUserStatus().equals("1")){
				map.put("msg", "您的账户已被锁定，请切换账户登录！");
			}else if(!activeUser.getRoleStatus().equals("1")){
				map.put("msg", "当前角色已被锁定，请切换账户登录！");
			}else{
				if(!subject.isPermitted("carType:edit")){
					map.put("msg", "您没有权限，请切换用户登录！");
				}
			}
			return map;
		}
		
		@RequestMapping("/edit")
		public String edit() throws Exception{
			return "carType_edit";
		}
		
		@RequestMapping("/list")
		@ResponseBody
		public EUDataGridResult getList(Integer page, Integer rows, CarType carType) throws Exception{
			EUDataGridResult result = carTypeService.getList(page, rows, carType);
			return result;
		}
		
		@RequestMapping(value="/insert", method=RequestMethod.POST)
		@ResponseBody
		private CustomResult insert(@Valid CarTypePO carType, BindingResult bindingResult) throws Exception {
			CustomResult result;
			if(bindingResult.hasErrors()){
				FieldError fieldError = bindingResult.getFieldError();
				System.out.println(fieldError.getDefaultMessage());
				return CustomResult.build(100, fieldError.getDefaultMessage());
			}else{
				result = carTypeService.insert(carType);
			}
			
			return result;
		}
		
		@RequestMapping(value="/update")
		@ResponseBody
		private CustomResult update(@Valid CarTypePO cCarType, BindingResult bindingResult) throws Exception {
			if(bindingResult.hasErrors()){
				FieldError fieldError = bindingResult.getFieldError();
				return CustomResult.build(100, fieldError.getDefaultMessage());
			}
			return carTypeService.update(cCarType);
		}
		
		@RequestMapping(value="/update_all")
		@ResponseBody
		private CustomResult updateAll(@Valid CarTypePO cCarType, BindingResult bindingResult) throws Exception {
			if(bindingResult.hasErrors()){
				FieldError fieldError = bindingResult.getFieldError();
				return CustomResult.build(100, fieldError.getDefaultMessage());
			}
			return carTypeService.updateAll(cCarType);
		}
		
		@RequestMapping("/delete_judge")
		@ResponseBody
		public Map<String,Object> carTypeDeleteJudge() throws Exception{
			Subject subject = SecurityUtils.getSubject();
			ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
			Map<String,Object> map = new HashMap<String,Object>();
			if(!activeUser.getUserStatus().equals("1")){
				map.put("msg", "您的账户已被锁定，请切换账户登录！");
			}else if(!activeUser.getRoleStatus().equals("1")){
				map.put("msg", "当前角色已被锁定，请切换账户登录！");
			}else{
				if(!subject.isPermitted("carType:delete")){
					map.put("msg", "您没有权限，请切换用户登录！");
				}
			}
			return map;
		}
		
		@RequestMapping(value="/delete")
		@ResponseBody
		private CustomResult delete(int id) throws Exception {
			CustomResult result = carTypeService.delete(id);
			return result;
		}
		
		@RequestMapping(value="/delete_batch")
		@ResponseBody
		private CustomResult deleteBatch(int[] ids) throws Exception {
			CustomResult result = carTypeService.deleteBatch(ids);
			return result;
		}
		
		//搜索
		@RequestMapping("/search_carType_by_brand")
		@ResponseBody
		public EUDataGridResult searchCarTypeByCarTypeBrand(Integer page, Integer rows, String searchValue) 
				throws Exception{
			EUDataGridResult result = carTypeService.searchCarTypeByCarTypeBrand(page, rows, searchValue);
			return result;
		}
		
		//搜索
		@RequestMapping("/search_carType_by_carxh")
		@ResponseBody
		public EUDataGridResult searchCarTypeByCarTypeCarXH(Integer page, Integer rows, String searchValue) 
				throws Exception{
			EUDataGridResult result = carTypeService.searchCarTypeByCarTypeCarXH(page, rows, searchValue);
			return result;
		}
		
		//搜索
		@RequestMapping("/search_carType_by_checknums")
		@ResponseBody
		public EUDataGridResult searchCarTypeByDepartmentCheckNums(Integer page, Integer rows, int searchValue) 
				throws Exception{
			EUDataGridResult result = carTypeService.searchCarTypeByCheckNums(page, rows, searchValue);
			return result;
		}
		
}
