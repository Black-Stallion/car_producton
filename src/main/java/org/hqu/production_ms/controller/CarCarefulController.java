package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarCareful;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarCarefulPO;
import org.hqu.production_ms.service.CarCarefulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/carCareful")
public class CarCarefulController {
	
		@Autowired
		private CarCarefulService carCarefulService;
		
		@RequestMapping("/get/{typeid}")
		@ResponseBody
		public CarCareful getItemById(@PathVariable int typeid) throws Exception{
			CarCareful carCareful = carCarefulService.get(typeid);
			return carCareful;
		}
		
		@RequestMapping("/get_data")
		@ResponseBody
		public List<CarCareful> getData() throws Exception{
			 List<CarCareful> list = carCarefulService.find();
			return list;
		}
		
		@RequestMapping("/find")
		public String find() throws Exception{
			return "carCareful_list";                                                                                                                                                                                                                                                                                                 
		}
		
		@RequestMapping("/add_judge")
		@ResponseBody
		public Map<String,Object> carCarefulAddJudge() throws Exception{
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
				if(!subject.isPermitted("carCareful:add")){
					map.put("msg", "您没有权限，请切换用户登录！");
				}
			}
			return map;
		}
		
		@RequestMapping("/add")
		public String add() throws Exception{
			return "carCareful_add";
		}
		
		@RequestMapping("/edit_judge")
		@ResponseBody
		public Map<String,Object> carCarefulEditJudge() throws Exception{
			Subject subject = SecurityUtils.getSubject();
			ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
			Map<String,Object> map = new HashMap<String,Object>();
			if(!activeUser.getUserStatus().equals("1")){
				map.put("msg", "您的账户已被锁定，请切换账户登录！");
			}else if(!activeUser.getRoleStatus().equals("1")){
				map.put("msg", "当前角色已被锁定，请切换账户登录！");
			}else{
				if(!subject.isPermitted("carCareful:add")){
					map.put("msg", "您没有权限，请切换用户登录！");
				}
			}
			return map;
		}
		
		@RequestMapping("/edit")
		public String edit() throws Exception{
			return "carCareful_edit";
		}
		
		@RequestMapping("/list")
		@ResponseBody
		public EUDataGridResult getList(Integer page, Integer rows, CarCareful carCareful) throws Exception{
			EUDataGridResult result = carCarefulService.getList(page, rows, carCareful);
			return result;
		}
		
		@RequestMapping(value="/insert", method=RequestMethod.POST)
		@ResponseBody
		private CustomResult insert(@Valid CarCarefulPO carCareful, BindingResult bindingResult) throws Exception {
			CustomResult result;
			if(bindingResult.hasErrors()){
				FieldError fieldError = bindingResult.getFieldError();
				System.out.println(fieldError.getDefaultMessage());
				return CustomResult.build(100, fieldError.getDefaultMessage());
			}else{
				result = carCarefulService.insert(carCareful);
			}
			
			return result;
		}
		
		@RequestMapping(value="/update")
		@ResponseBody
		private CustomResult update(@Valid CarCarefulPO cCarCareful, BindingResult bindingResult) throws Exception {
			if(bindingResult.hasErrors()){
				FieldError fieldError = bindingResult.getFieldError();
				return CustomResult.build(100, fieldError.getDefaultMessage());
			}
			return carCarefulService.update(cCarCareful);
		}
		
		@RequestMapping(value="/update_all")
		@ResponseBody
		private CustomResult updateAll(@Valid CarCarefulPO cCarCareful, BindingResult bindingResult) throws Exception {
			if(bindingResult.hasErrors()){
				FieldError fieldError = bindingResult.getFieldError();
				return CustomResult.build(100, fieldError.getDefaultMessage());
			}
			return carCarefulService.updateAll(cCarCareful);
		}
		
		@RequestMapping("/delete_judge")
		@ResponseBody
		public Map<String,Object> carCarefulDeleteJudge() throws Exception{
			Subject subject = SecurityUtils.getSubject();
			ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
			Map<String,Object> map = new HashMap<String,Object>();
			if(!activeUser.getUserStatus().equals("1")){
				map.put("msg", "您的账户已被锁定，请切换账户登录！");
			}else if(!activeUser.getRoleStatus().equals("1")){
				map.put("msg", "当前角色已被锁定，请切换账户登录！");
			}else{
				if(!subject.isPermitted("carCareful:delete")){
					map.put("msg", "您没有权限，请切换用户登录！");
				}
			}
			return map;
		}
		
		@RequestMapping(value="/delete")
		@ResponseBody
		private CustomResult delete(int id) throws Exception {
			CustomResult result = carCarefulService.delete(id);
			return result;
		}
		
		@RequestMapping(value="/delete_batch")
		@ResponseBody
		private CustomResult deleteBatch(int[] ids) throws Exception {
			CustomResult result = carCarefulService.deleteBatch(ids);
			return result;
		}
		
}
