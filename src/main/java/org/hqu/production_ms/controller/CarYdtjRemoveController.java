package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarYdtjRemove;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.service.CarYdtjService;
import org.hqu.production_ms.util.ExportExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carYdtjRemove")
public class CarYdtjRemoveController {
	@Autowired
	private CarYdtjService carYdtjService;
	

	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarYdtjRemove> getData(HttpSession session) throws Exception{
		 List<CarYdtjRemove> list = carYdtjService.findRemove1();
		 session.setAttribute("list2", list);
		return list;
	}
	
	@RequestMapping("/get_down")
	public String download(HttpServletResponse response,HttpServletRequest request) throws Exception{
		@SuppressWarnings("unchecked")
		List<CarYdtjRemove> list1 = (List<CarYdtjRemove>) request.getSession().getAttribute("list2");
		ExportExcel x = new ExportExcel();
		x.downlond6(response, list1);
		return "carYdtjRemove_list";
	}
	@RequestMapping("/find1")
	public String find1() throws Exception{
		return "carYdtjRemove_list";                                                                                                                                                                                                                                                                                                 
	}
	
//	@RequestMapping("/find_nature")
//	public String findByNature() throws Exception{
//		return "carYdtj_list";                                                                                                                                                                                                                                                                                                 
//	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carYdtjAddJudge() throws Exception{
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
			if(!subject.isPermitted("carYdtj:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "carYdtj_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carYdtjEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carYdtj:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "carYdtj_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList1(Integer page, Integer rows, CarYdtjRemove carYdtj,HttpSession session) throws Exception{
		
		String departmentname = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carYdtjService.getListRemove1(page, rows, carYdtj);
		}
		else{
			result = carYdtjService.getListRemove(page, rows,departmentname);
		}
		
		 @SuppressWarnings("unchecked")
		 List<CarYdtjRemove> list = (List<CarYdtjRemove>) result.getRows();
		 session.setAttribute("list2", list);
		return result;
	}
	
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carYdtjDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carYdtj:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	

	//搜索
	@RequestMapping("/search_carYdtjRemove")
	@ResponseBody
	public EUDataGridResult searchCarYdtjByCarYdtjBrand(Integer page, Integer rows,String year2,String month2,CarYdtjRemove carYdtj,HttpServletRequest request,HttpSession session,String[] args) 
			throws Exception{
			EUDataGridResult result = null;
			page = 1;
			rows = 10;
			String dengjitiem =request.getParameter("year2");
			String usenature =request.getParameter("month2");
			String departmentId = (String) session.getAttribute("departmentId");
			int id1 =  (int) session.getAttribute("leve");
			if(2 == id1 && (usenature.trim().equals("0")) && (dengjitiem.trim().equals("0"))){
				result = carYdtjService.getListRemove1(page, rows,carYdtj);
			}else if(2 == id1 && (usenature.trim().equals("0")) && !(dengjitiem.trim().equals("0"))){
				result = carYdtjService.searchCarYdtjByCarYdtjRemove1(page, rows,dengjitiem);
			}else if(2 == id1 && !(usenature.trim().equals("0")) && !(dengjitiem.trim().equals("0"))){
				result = carYdtjService.searchCarYdtjByCarYdtjRemove2(page, rows,dengjitiem,usenature);
			}
			else if(2 != id1 && (usenature.trim().equals("0")) && (dengjitiem.trim().equals("0"))){
				result = carYdtjService.searchCarYdtjByCarYdtjRemove3(page, rows,departmentId);
			}else if(2 != id1 && (usenature.trim().equals("0")) && !(dengjitiem.trim().equals("0"))){
				result = carYdtjService.searchCarYdtjByCarYdtjRemove4(page, rows,departmentId,dengjitiem);
			}
			else{
				result = carYdtjService.searchCarYdtjByCarYdtjRemove5(page, rows,departmentId,dengjitiem,usenature);
			}
			 @SuppressWarnings("unchecked")
			 List<CarYdtjRemove> list = (List<CarYdtjRemove>) result.getRows();
			 session.setAttribute("list2", list);
			 return result;
	}
	
}