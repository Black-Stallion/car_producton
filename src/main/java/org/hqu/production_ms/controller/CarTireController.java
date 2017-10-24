package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarTire;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarTirePO;
import org.hqu.production_ms.service.CarTireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/carTire")
public class CarTireController {
	
		@Autowired
		private CarTireService carTireService;
		
		@RequestMapping("/get/{typeid}")
		@ResponseBody
		public CarTire getItemById(@PathVariable int typeid) throws Exception{
			CarTire carTire = carTireService.get(typeid);
			return carTire;
		}
		
		@RequestMapping("/get_data")
		@ResponseBody
		public List<CarTire> getData() throws Exception{
			 List<CarTire> list = carTireService.find();
			return list;
		}
		
		@RequestMapping("/find")
		public String find() throws Exception{
			return "carTire_list";                                                                                                                                                                                                                                                                                                 
		}
		
		@RequestMapping("/add_judge")
		@ResponseBody
		public Map<String,Object> carTireAddJudge() throws Exception{
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
				if(!subject.isPermitted("carTire:add")){
					map.put("msg", "您没有权限，请切换用户登录！");
				}
			}
			return map;
		}
		
		@RequestMapping("/add")
		public String add() throws Exception{
			return "carTire_add";
		}
		
		@RequestMapping("/edit_judge")
		@ResponseBody
		public Map<String,Object> carTireEditJudge() throws Exception{
			Subject subject = SecurityUtils.getSubject();
			ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
			Map<String,Object> map = new HashMap<String,Object>();
			if(!activeUser.getUserStatus().equals("1")){
				map.put("msg", "您的账户已被锁定，请切换账户登录！");
			}else if(!activeUser.getRoleStatus().equals("1")){
				map.put("msg", "当前角色已被锁定，请切换账户登录！");
			}else{
				if(!subject.isPermitted("carTire:edit")){
					map.put("msg", "您没有权限，请切换用户登录！");
				}
			}
			return map;
		}
		
		@RequestMapping("/edit")
		public String edit() throws Exception{
			return "carTire_edit";
		}
		
		@RequestMapping("/list")
		@ResponseBody
		public EUDataGridResult getList(Integer page, Integer rows, CarTire carTire,HttpSession session) throws Exception{
			String id = (String) session.getAttribute("departmentId");
			EUDataGridResult result = null;
			int id1 =  (int) session.getAttribute("leve");
			if(2 == id1){
				result = carTireService.getList(page, rows, carTire);
			}else
			{
				result = carTireService.getList1(page, rows, carTire,id);
			}
			return result;
		}
		
		@RequestMapping(value="/insert", method=RequestMethod.POST)
		@ResponseBody
		private CustomResult insert(@Valid CarTirePO carTire, BindingResult bindingResult) throws Exception {
			CustomResult result;
			if(bindingResult.hasErrors()){
				FieldError fieldError = bindingResult.getFieldError();
				System.out.println(fieldError.getDefaultMessage());
				return CustomResult.build(100, fieldError.getDefaultMessage());
			}else{
				result = carTireService.insert(carTire);
			}
			
			return result;
		}
		
		@RequestMapping(value="/update")
		@ResponseBody
		private CustomResult update(@Valid CarTirePO cCarTire, BindingResult bindingResult) throws Exception {
			if(bindingResult.hasErrors()){
				FieldError fieldError = bindingResult.getFieldError();
				return CustomResult.build(100, fieldError.getDefaultMessage());
			}
			return carTireService.update(cCarTire);
		}
		
		@RequestMapping(value="/update_all")
		@ResponseBody
		private CustomResult updateAll(@Valid CarTirePO cCarTire, BindingResult bindingResult) throws Exception {
			if(bindingResult.hasErrors()){
				FieldError fieldError = bindingResult.getFieldError();
				return CustomResult.build(100, fieldError.getDefaultMessage());
			}
			return carTireService.updateAll(cCarTire);
		}
		
		@RequestMapping("/delete_judge")
		@ResponseBody
		public Map<String,Object> carTireDeleteJudge() throws Exception{
			Subject subject = SecurityUtils.getSubject();
			ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
			Map<String,Object> map = new HashMap<String,Object>();
			if(!activeUser.getUserStatus().equals("1")){
				map.put("msg", "您的账户已被锁定，请切换账户登录！");
			}else if(!activeUser.getRoleStatus().equals("1")){
				map.put("msg", "当前角色已被锁定，请切换账户登录！");
			}else{
				if(!subject.isPermitted("carTire:delete")){
					map.put("msg", "您没有权限，请切换用户登录！");
				}
			}
			return map;
		}
		
		@RequestMapping(value="/delete")
		@ResponseBody
		private CustomResult delete(int id) throws Exception {
			CustomResult result = carTireService.delete(id);
			return result;
		}
		
		@RequestMapping(value="/delete_batch")
		@ResponseBody
		private CustomResult deleteBatch(int[] ids) throws Exception {
			CustomResult result = carTireService.deleteBatch(ids);
			return result;
		}
		
		//搜索
		@RequestMapping("/search_carTire_by_brand")
		@ResponseBody
		public EUDataGridResult searchCarTireByCarTireBrand(Integer page, Integer rows, String searchValue) 
				throws Exception{
			EUDataGridResult result = carTireService.searchCarTireByCarTireBrand(page, rows, searchValue);
			return result;
		}
		
		//搜索
		@RequestMapping("/search_carTire_by_carxh")
		@ResponseBody
		public EUDataGridResult searchCarTireByCarTireCarXH(Integer page, Integer rows, String searchValue) 
				throws Exception{
			EUDataGridResult result = carTireService.searchCarTireByCarTireCarXH(page, rows, searchValue);
			return result;
		}
		
		//搜索
		@RequestMapping("/search_carTire_by_checknums")
		@ResponseBody
		public EUDataGridResult searchCarTireByDepartmentCheckNums(Integer page, Integer rows, int searchValue) 
				throws Exception{
			EUDataGridResult result = carTireService.searchCarTireByCheckNums(page, rows, searchValue);
			return result;
		}
		
}
