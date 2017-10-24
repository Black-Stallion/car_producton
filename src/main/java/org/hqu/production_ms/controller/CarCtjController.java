package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarCtj;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarCtjPO;
import org.hqu.production_ms.service.CarCtjService;
import org.hqu.production_ms.util.ExportExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carCtj")
public class CarCtjController {
	@Autowired
	private CarCtjService carCtjService;
	
	@RequestMapping("/get/{carId}")
	@ResponseBody
	public CarCtj getItemById(@PathVariable int carId) throws Exception{
		CarCtj carCtj = carCtjService.get(carId);
		return carCtj;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarCtj> getData(HttpSession session) throws Exception{
		 List<CarCtj> list = carCtjService.find();
		 session.setAttribute("list5", list);
		return list;
	}
	
	@RequestMapping("/get_down")
	public String download(HttpServletResponse response,HttpServletRequest request) throws Exception{
		@SuppressWarnings("unchecked")
		List<CarCtj> list1 = (List<CarCtj>) request.getSession().getAttribute("list5");
		ExportExcel x = new ExportExcel();
		x.downlond(response, list1);
		return "carCtj_list";
	}
	@RequestMapping("/find1")
	public String find1() throws Exception{
		return "carCtj_list";                                                                                                                                                                                                                                                                                                 
	}
	
//	@RequestMapping("/find_nature")
//	public String findByNature() throws Exception{
//		return "carCtj_list";                                                                                                                                                                                                                                                                                                 
//	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carCtjAddJudge() throws Exception{
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
			if(!subject.isPermitted("carCtj:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "carCtj_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carCtjEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carCtj:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "carCtj_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList1(Integer page, Integer rows, CarCtj carCtj,HttpSession session) throws Exception{
		
		String departmentId = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carCtjService.getList(page, rows, carCtj);
		}
		else{
			result = carCtjService.getList1(page, rows,carCtj,departmentId);
		}
		
		 @SuppressWarnings("unchecked")
		 List<CarCtj> list = (List<CarCtj>) result.getRows();
		 session.setAttribute("list5", list);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarCtjPO carCtj, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			result = carCtjService.insert(carCtj);
		}
		
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarCtjPO cCarCtj, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carCtjService.update(cCarCtj);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarCtjPO cCarCtj, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carCtjService.updateAll(cCarCtj);
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carCtjDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carCtj:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carCtjService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		CustomResult result = carCtjService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carCtj")
	@ResponseBody
	public EUDataGridResult searchCarCtjByCarCtjBrand(Integer page, Integer rows,String year5,String month5,String ctype,CarCtj carCtj,HttpServletRequest request,HttpSession session,String[] args) 
			throws Exception{
			EUDataGridResult result = null;
			page = 1;
			rows = 10;
			String dengjitiem =request.getParameter("year5");
			String usenature =request.getParameter("month5");	
			String ctype1= request.getParameter("ctype");
			String departmentId = (String) session.getAttribute("departmentId");
			int id1 =  (int) session.getAttribute("leve");
			if(2 == id1 && (usenature.trim().equals("0")) && (dengjitiem.trim().equals("0")) && ctype1.trim().equals("0")){
				result = carCtjService.getList(page, rows,carCtj);
			}else if(2 == id1 && (usenature.trim().equals("0")) && (dengjitiem.trim().equals("0")) && !(ctype1.trim().equals("0"))){
				result = carCtjService.searchCarCtjByCarCtj1(page, rows,ctype1);
			}else if(2 == id1 && (usenature.trim().equals("0")) && !(dengjitiem.trim().equals("0")) && ctype1.trim().equals("0")){
				result = carCtjService.searchCarCtjByCarCtj2(page, rows,dengjitiem);
			}else if(2 == id1 && (usenature.trim().equals("0")) && !(dengjitiem.trim().equals("0")) && !(ctype1.trim().equals("0"))){
				result = carCtjService.searchCarCtjByCarCtj3(page, rows,ctype1,dengjitiem);
			}else if(2 == id1 && !(usenature.trim().equals("0")) && !(dengjitiem.trim().equals("0")) && (ctype1.trim().equals("0"))){
				result = carCtjService.searchCarCtjByCarCtj10(page, rows,dengjitiem,usenature);
			}else if(2 == id1 && !(usenature.trim().equals("0")) && !(dengjitiem.trim().equals("0")) && !(ctype1.trim().equals("0"))){
				result = carCtjService.searchCarCtjByCarCtj4(page, rows,ctype1,dengjitiem,usenature);
			}
			else if(2 != id1 && (usenature.trim().equals("0")) && (dengjitiem.trim().equals("0")) && (ctype1.trim().equals("0"))){
				result = carCtjService.searchCarCtjByCarCtj5(page, rows,departmentId);
			}else if(2 != id1 && (usenature.trim().equals("0")) && (dengjitiem.trim().equals("0")) && !(ctype1.trim().equals("0"))){
				result = carCtjService.searchCarCtjByCarCtj6(page, rows,departmentId,ctype1);
			}else if(2 != id1 && (usenature.trim().equals("0")) && !(dengjitiem.trim().equals("0")) && (ctype1.trim().equals("0"))){
				result = carCtjService.searchCarCtjByCarCtj7(page, rows,departmentId,dengjitiem);
			}else if(2 != id1 && (usenature.trim().equals("0")) && !(dengjitiem.trim().equals("0")) && !(ctype1.trim().equals("0"))){
				result = carCtjService.searchCarCtjByCarCtj8(page, rows,departmentId,ctype1,dengjitiem);
			}else if(2 != id1 && !(usenature.trim().equals("0")) && !(dengjitiem.trim().equals("0")) && (ctype1.trim().equals("0"))){
				result = carCtjService.searchCarCtjByCarCtj11(page, rows,departmentId,dengjitiem,usenature);
			}else{
				result = carCtjService.searchCarCtjByCarCtj9(page, rows,departmentId,ctype1,dengjitiem,usenature);
			}
			 @SuppressWarnings("unchecked")
			 List<CarCtj> list = (List<CarCtj>) result.getRows();
			 session.setAttribute("list5", list);
			 return result;
	}
	
}