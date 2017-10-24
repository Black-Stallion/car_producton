package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarBig;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarBigPO;
import org.hqu.production_ms.service.CarBigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/carBig")
public class CarBigController {
	
		@Autowired
		private CarBigService carBigService;
		
		@RequestMapping("/get/{typeid}")
		@ResponseBody
		public CarBig getItemById(@PathVariable int typeid) throws Exception{
			CarBig carBig = carBigService.get(typeid);
			return carBig;
		}
		
		@RequestMapping("/get_data")
		@ResponseBody
		public List<CarBig> getData() throws Exception{
			 List<CarBig> list = carBigService.find();
			return list;
		}
		
		@RequestMapping("/find")
		public String find() throws Exception{
			return "carBig_list";                                                                                                                                                                                                                                                                                                 
		}
		
		@RequestMapping("/add_judge")
		@ResponseBody
		public Map<String,Object> carBigAddJudge() throws Exception{
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
				if(!subject.isPermitted("carBig:add")){
					map.put("msg", "您没有权限，请切换用户登录！");
				}
			}
			return map;
		}
		
		@RequestMapping("/add")
		public String add() throws Exception{
			return "carBig_add";
		}
		
		@RequestMapping("/edit_judge")
		@ResponseBody
		public Map<String,Object> carBigEditJudge() throws Exception{
			Subject subject = SecurityUtils.getSubject();
			ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
			Map<String,Object> map = new HashMap<String,Object>();
			if(!activeUser.getUserStatus().equals("1")){
				map.put("msg", "您的账户已被锁定，请切换账户登录！");
			}else if(!activeUser.getRoleStatus().equals("1")){
				map.put("msg", "当前角色已被锁定，请切换账户登录！");
			}else{
				if(!subject.isPermitted("carBig:edit")){
					map.put("msg", "您没有权限，请切换用户登录！");
				}
			}
			return map;
		}
		
		@RequestMapping("/edit")
		public String edit() throws Exception{
			return "carBig_edit";
		}
		
		@RequestMapping("/list")
		@ResponseBody
		public EUDataGridResult getList(Integer page, Integer rows, CarBig carBig,HttpSession session) throws Exception{
			String id = (String) session.getAttribute("departmentId");
			EUDataGridResult result = null;
			int id1 =  (int) session.getAttribute("leve");
			if(2 == id1){
			result = carBigService.getList(page, rows, carBig);
			}else{
				result = carBigService.getList1(page, rows, carBig,id);
			}
			return result;
		}
		
		@RequestMapping(value="/insert", method=RequestMethod.POST)
		@ResponseBody
		private CustomResult insert(@Valid CarBigPO carBig, BindingResult bindingResult) throws Exception {
			CustomResult result;
			if(bindingResult.hasErrors()){
				FieldError fieldError = bindingResult.getFieldError();
				System.out.println(fieldError.getDefaultMessage());
				return CustomResult.build(100, fieldError.getDefaultMessage());
			}else{
				result = carBigService.insert(carBig);
			}
			
			return result;
		}
		
		@RequestMapping(value="/update")
		@ResponseBody
		private CustomResult update(@Valid CarBigPO cCarBig, BindingResult bindingResult) throws Exception {
			if(bindingResult.hasErrors()){
				FieldError fieldError = bindingResult.getFieldError();
				return CustomResult.build(100, fieldError.getDefaultMessage());
			}
			return carBigService.update(cCarBig);
		}
		
		@RequestMapping(value="/update_all")
		@ResponseBody
		private CustomResult updateAll(@Valid CarBigPO cCarBig, BindingResult bindingResult) throws Exception {
			if(bindingResult.hasErrors()){
				FieldError fieldError = bindingResult.getFieldError();
				return CustomResult.build(100, fieldError.getDefaultMessage());
			}
			return carBigService.updateAll(cCarBig);
		}
		
		@RequestMapping("/delete_judge")
		@ResponseBody
		public Map<String,Object> carBigDeleteJudge() throws Exception{
			Subject subject = SecurityUtils.getSubject();
			ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
			Map<String,Object> map = new HashMap<String,Object>();
			if(!activeUser.getUserStatus().equals("1")){
				map.put("msg", "您的账户已被锁定，请切换账户登录！");
			}else if(!activeUser.getRoleStatus().equals("1")){
				map.put("msg", "当前角色已被锁定，请切换账户登录！");
			}else{
				if(!subject.isPermitted("carBig:delete")){
					map.put("msg", "您没有权限，请切换用户登录！");
				}
			}
			return map;
		}
		
		@RequestMapping(value="/delete")
		@ResponseBody
		private CustomResult delete(int id) throws Exception {
			CustomResult result = carBigService.delete(id);
			return result;
		}
		
		@RequestMapping(value="/delete_batch")
		@ResponseBody
		private CustomResult deleteBatch(int[] ids) throws Exception {
			CustomResult result = carBigService.deleteBatch(ids);
			return result;
		}
		
		//搜索
		@RequestMapping("/search_carBig_by_carid")
		@ResponseBody
		public EUDataGridResult searchCarBigByCarBigBrand(Integer page, Integer rows, String searchValue,HttpSession session) 
				throws Exception{
			String id = (String) session.getAttribute("departmentId");
			EUDataGridResult result = null;
			int id1 =  (int) session.getAttribute("leve");
			if(2 == id1){
				result = carBigService.searchCarBig1(page, rows, searchValue);
			}else{
				result = carBigService.searchCarBig1s(page, rows,id, searchValue);
			}
			return result;
		}
		
		//搜索
		@RequestMapping("/search_carBig_by_depname")
		@ResponseBody
		public EUDataGridResult searchCarBigByCarBigCarXH(Integer page, Integer rows, String searchValue,HttpSession session) 
				throws Exception{
			String id = (String) session.getAttribute("departmentId");
			EUDataGridResult result = null;
			int id1 =  (int) session.getAttribute("leve");
			if(2 == id1){
				result = carBigService.searchCarBig2(page, rows, searchValue);
			}else{
				result = carBigService.searchCarBig2s(page, rows,id, searchValue);
			}
			return result;
		}
		
		@RequestMapping("/findBig/{carId}")
		@ResponseBody
		public EUDataGridResult searchCarBigByCarId(@PathVariable int carId,Integer page, Integer rows) 
				throws Exception{
			EUDataGridResult result = carBigService.searchCarBigByCarId(page, rows, carId);
			return result;
		}
		
}
