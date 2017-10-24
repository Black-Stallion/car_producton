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
import org.hqu.production_ms.domain.CarWbtj;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarWbtjPO;
import org.hqu.production_ms.service.CarWbtjService;
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
@RequestMapping("/carWbtj")
public class CarWbtjController {
	@Autowired
	private CarWbtjService carWbtjService;
	
	@RequestMapping("/get/{carId}")
	@ResponseBody
	public CarWbtj getItemById(@PathVariable int carId) throws Exception{
		CarWbtj carWbtj = carWbtjService.get(carId);
		return carWbtj;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarWbtj> getData(HttpSession session) throws Exception{
		 List<CarWbtj> list = carWbtjService.find1();
		 session.setAttribute("list6", list);
		return list;
	}
	
	@RequestMapping("/get_down")
	public String download(HttpServletResponse response,HttpServletRequest request) throws Exception{
		@SuppressWarnings("unchecked")
		List<CarWbtj> list1 = (List<CarWbtj>) request.getSession().getAttribute("list6");
		ExportExcel x = new ExportExcel();
		x.downlond2(response, list1);
		return "carWbtj_list";
	}
	@RequestMapping("/find1")
	public String find1() throws Exception{
		return "carWbtj_list";                                                                                                                                                                                                                                                                                                 
	}
	
//	@RequestMapping("/find_nature")
//	public String findByNature() throws Exception{
//		return "carWbtj_list";                                                                                                                                                                                                                                                                                                 
//	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carWbtjAddJudge() throws Exception{
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
			if(!subject.isPermitted("carWbtj:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "carWbtj_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carWbtjEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carWbtj:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "carWbtj_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList1(Integer page, Integer rows, CarWbtj carWbtj,HttpSession session) throws Exception{
		
		String departmentId = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carWbtjService.getList1(page, rows, carWbtj);
		}
		else{
			result = carWbtjService.getList(page, rows,departmentId);
		}
		
		 @SuppressWarnings("unchecked")
		 List<CarWbtj> list = (List<CarWbtj>) result.getRows();
		 session.setAttribute("list6", list);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarWbtjPO carWbtj, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			result = carWbtjService.insert(carWbtj);
		}
		
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarWbtjPO cCarWbtj, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carWbtjService.update(cCarWbtj);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarWbtjPO cCarWbtj, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carWbtjService.updateAll(cCarWbtj);
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carWbtjDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carWbtj:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carWbtjService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		CustomResult result = carWbtjService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carWbtj")
	@ResponseBody
	public EUDataGridResult searchCarWbtjByCarWbtjBrand(Integer page, Integer rows,String year6,String month6,String cnumber,CarWbtj carWbtj,HttpServletRequest request,HttpSession session,String[] args) 
			throws Exception{
			EUDataGridResult result = null;
			page = 1;
			rows = 10;
			String dengjitiem =request.getParameter("year6");
			String usenature =request.getParameter("month6");
			String cnumber1 =request.getParameter("cnumber");
			String departmentId = (String) session.getAttribute("departmentId");
			int id1 =  (int) session.getAttribute("leve");
			if(2 == id1 && (usenature.trim().equals("0")) && (dengjitiem.trim().equals("0")) && (cnumber1.trim().equals("0"))){
				result = carWbtjService.getList1(page, rows,carWbtj);
			}else if(2 == id1 && (usenature.trim().equals("0")) && (dengjitiem.trim().equals("0")) && !(cnumber1.trim().equals("0"))){
				result = carWbtjService.searchCarWbtjByCarWbtj1(page, rows,cnumber1);
			}else if(2 == id1 && (usenature.trim().equals("0")) && !(dengjitiem.trim().equals("0")) && cnumber1.trim().equals("0")){
				result = carWbtjService.searchCarWbtjByCarWbtj2(page, rows,dengjitiem);
			}else if(2 == id1 && (usenature.trim().equals("0")) && !(dengjitiem.trim().equals("0")) && !(cnumber1.trim().equals("0"))){
				result = carWbtjService.searchCarWbtjByCarWbtj3(page, rows,cnumber1,dengjitiem);
			}else if(2 == id1 && !(usenature.trim().equals("0")) && !(dengjitiem.trim().equals("0")) && (cnumber1.trim().equals("0"))){
				result = carWbtjService.searchCarWbtjByCarWbtj10(page, rows,dengjitiem,usenature);
			}else if(2 == id1 && !(usenature.trim().equals("0")) && !(dengjitiem.trim().equals("0")) && !(cnumber1.trim().equals("0"))){
				result = carWbtjService.searchCarWbtjByCarWbtj4(page, rows,cnumber1,dengjitiem,usenature);
			}
			else if(2 != id1 && (usenature.trim().equals("0")) && (dengjitiem.trim().equals("0")) && (cnumber1.trim().equals("0"))){
				result = carWbtjService.searchCarWbtjByCarWbtj5(page, rows,departmentId);
			}else if(2 != id1 && (usenature.trim().equals("0")) && (dengjitiem.trim().equals("0")) && !(cnumber1.trim().equals("0"))){
				result = carWbtjService.searchCarWbtjByCarWbtj6(page, rows,departmentId,cnumber1);
			}else if(2 != id1 && (usenature.trim().equals("0")) && !(dengjitiem.trim().equals("0")) && (cnumber1.trim().equals("0"))){
				result = carWbtjService.searchCarWbtjByCarWbtj7(page, rows,departmentId,dengjitiem);
			}else if(2 != id1 && !(usenature.trim().equals("0")) && !(dengjitiem.trim().equals("0")) && (cnumber1.trim().equals("0"))){
				result = carWbtjService.searchCarWbtjByCarWbtj11(page, rows,departmentId,dengjitiem,usenature);
			}else if(2 != id1 && (usenature.trim().equals("0")) && !(dengjitiem.trim().equals("0")) && !(cnumber1.trim().equals("0"))){
				result = carWbtjService.searchCarWbtjByCarWbtj8(page, rows,departmentId,cnumber1,dengjitiem);
			}else{
				result = carWbtjService.searchCarWbtjByCarWbtj9(page, rows,departmentId,cnumber1,dengjitiem,usenature);
			}
			 @SuppressWarnings("unchecked")
			 List<CarWbtj> list = (List<CarWbtj>) result.getRows();
			 session.setAttribute("list6", list);
			 return result;
	}
	
}