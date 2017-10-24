package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarCompany;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarCompanyPO;
import org.hqu.production_ms.service.CarCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/carCompany")
public class CarCompanyController {
	
		@Autowired
		private CarCompanyService carCompanyService;
		
		@RequestMapping("/get/{typeid}")
		@ResponseBody
		public CarCompany getItemById(@PathVariable int typeid) throws Exception{
			CarCompany carCompany = carCompanyService.get(typeid);
			return carCompany;
		}
		
		@RequestMapping("/get_data")
		@ResponseBody
		public List<CarCompany> getData(HttpSession session) throws Exception{
			String id = (String) session.getAttribute("departmentId");
			List<CarCompany> list = null;
			int id1 =  (int) session.getAttribute("leve");
			if(2 == id1){
			  list = carCompanyService.gets();
			 } else{
				 list = carCompanyService.gets1(id);
			 }
			return list;
		}
		
		@RequestMapping("/find")
		public String find() throws Exception{
			return "carCompany_list";                                                                                                                                                                                                                                                                                                 
		}
		
		@RequestMapping("/add_judge")
		@ResponseBody
		public Map<String,Object> carCompanyAddJudge() throws Exception{
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
				if(!subject.isPermitted("carCompany:add")){
					map.put("msg", "您没有权限，请切换用户登录！");
				}
			}
			return map;
		}
		
		@RequestMapping("/add")
		public String add() throws Exception{
			return "carCompany_add";
		}
		
		@RequestMapping("/edit_judge")
		@ResponseBody
		public Map<String,Object> carCompanyEditJudge() throws Exception{
			Subject subject = SecurityUtils.getSubject();
			ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
			Map<String,Object> map = new HashMap<String,Object>();
			if(!activeUser.getUserStatus().equals("1")){
				map.put("msg", "您的账户已被锁定，请切换账户登录！");
			}else if(!activeUser.getRoleStatus().equals("1")){
				map.put("msg", "当前角色已被锁定，请切换账户登录！");
			}else{
				if(!subject.isPermitted("carCompany:add")){
					map.put("msg", "您没有权限，请切换用户登录！");
				}
			}
			return map;
		}
		
		@RequestMapping("/edit")
		public String edit() throws Exception{
			return "carCompany_edit";
		}
		
		@RequestMapping("/list")
		@ResponseBody
		public EUDataGridResult getList(Integer page, Integer rows, CarCompany carCompany,HttpSession session) throws Exception{
			String id = (String) session.getAttribute("departmentId");
			EUDataGridResult result = null;
			int id1 =  (int) session.getAttribute("leve");
			if(2 == id1){
			result = carCompanyService.getList(page, rows, carCompany);
			}else{
				result = carCompanyService.getList1(page, rows, carCompany,id);
			}
			return result;
		}
		
		@RequestMapping(value="/insert", method=RequestMethod.POST)
		@ResponseBody
		private CustomResult insert(@Valid CarCompanyPO carCompany, BindingResult bindingResult) throws Exception {
			CustomResult result;
			if(bindingResult.hasErrors()){
				FieldError fieldError = bindingResult.getFieldError();
				System.out.println(fieldError.getDefaultMessage());
				return CustomResult.build(100, fieldError.getDefaultMessage());
			}else{
				result = carCompanyService.insert(carCompany);
			}
			
			return result;
		}
		
		@RequestMapping(value="/update")
		@ResponseBody
		private CustomResult update(@Valid CarCompanyPO cCarCompany, BindingResult bindingResult) throws Exception {
			if(bindingResult.hasErrors()){
				FieldError fieldError = bindingResult.getFieldError();
				return CustomResult.build(100, fieldError.getDefaultMessage());
			}
			return carCompanyService.update(cCarCompany);
		}
		
		@RequestMapping(value="/update_all")
		@ResponseBody
		private CustomResult updateAll(@Valid CarCompanyPO cCarCompany, BindingResult bindingResult) throws Exception {
			if(bindingResult.hasErrors()){
				FieldError fieldError = bindingResult.getFieldError();
				return CustomResult.build(100, fieldError.getDefaultMessage());
			}
			return carCompanyService.updateAll(cCarCompany);
		}
		
		@RequestMapping("/delete_judge")
		@ResponseBody
		public Map<String,Object> carCompanyDeleteJudge() throws Exception{
			Subject subject = SecurityUtils.getSubject();
			ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
			Map<String,Object> map = new HashMap<String,Object>();
			if(!activeUser.getUserStatus().equals("1")){
				map.put("msg", "您的账户已被锁定，请切换账户登录！");
			}else if(!activeUser.getRoleStatus().equals("1")){
				map.put("msg", "当前角色已被锁定，请切换账户登录！");
			}else{
				if(!subject.isPermitted("carCompany:delete")){
					map.put("msg", "您没有权限，请切换用户登录！");
				}
			}
			return map;
		}
		
		@RequestMapping(value="/delete")
		@ResponseBody
		private CustomResult delete(int id) throws Exception {
			CustomResult result = carCompanyService.delete(id);
			return result;
		}
		
		@RequestMapping(value="/delete_batch")
		@ResponseBody
		private CustomResult deleteBatch(int[] ids) throws Exception {
			CustomResult result = carCompanyService.deleteBatch(ids);
			return result;
		}
		
}
