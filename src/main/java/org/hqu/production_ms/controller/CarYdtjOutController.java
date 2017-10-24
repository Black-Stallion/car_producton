package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarYdtjOut;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.service.CarYdtjService;
import org.hqu.production_ms.util.ExportExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carYdtjOut")
public class CarYdtjOutController {
	@Autowired
	private CarYdtjService carYdtjService;
	

	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarYdtjOut> getData(HttpSession session) throws Exception{
		 List<CarYdtjOut> list = carYdtjService.findOut1();
		 session.setAttribute("list1", list);
		return list;
	}
	
	@RequestMapping("/get_down")
	public String download(HttpServletResponse response,HttpServletRequest request) throws Exception{
		@SuppressWarnings("unchecked")
		List<CarYdtjOut> list1 = (List<CarYdtjOut>) request.getSession().getAttribute("list1");
		ExportExcel x = new ExportExcel();
		x.downlond4(response, list1);
		return "CarYdtjOut_list";
	}
	@RequestMapping("/find1")
	public String find1() throws Exception{
		return "CarYdtjOut_list";                                                                                                                                                                                                                                                                                                 
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
	public EUDataGridResult getList1(Integer page, Integer rows, CarYdtjOut carYdtj,HttpSession session) throws Exception{
		
		String departmentname = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carYdtjService.getListOut1(page, rows, carYdtj);
		}
		else{
			result = carYdtjService.getListOut(page, rows,departmentname);
		}
		
		 @SuppressWarnings("unchecked")
		 List<CarYdtjOut> list = (List<CarYdtjOut>) result.getRows();
		 session.setAttribute("list1", list);
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
	@RequestMapping("/search_carYdtjOut")
	@ResponseBody
	public EUDataGridResult searchCarYdtjByCarYdtjBrand(Integer page, Integer rows,String year1,String month1,CarYdtjOut carYdtj,HttpServletRequest request,HttpSession session,String[] args) 
			throws Exception{
			EUDataGridResult result = null;
			page = 1;
			rows = 10;
			String dengjitiem =request.getParameter("year1");
			String usenature =request.getParameter("month1");
			String departmentId = (String) session.getAttribute("departmentId");
			int id1 =  (int) session.getAttribute("leve");
			if(2 == id1 && (usenature.trim().equals("0")) && (dengjitiem.trim().equals("0"))){
				result = carYdtjService.getListOut1(page, rows,carYdtj);
			}else if(2 == id1 && (usenature.trim().equals("0")) && !(dengjitiem.trim().equals("0"))){
				result = carYdtjService.searchCarYdtjByCarYdtjOut1(page, rows,dengjitiem);
			}else if(2 == id1 && !(usenature.trim().equals("0")) && !(dengjitiem.trim().equals("0"))){
				result = carYdtjService.searchCarYdtjByCarYdtjOut2(page, rows,dengjitiem,usenature);
			}
			else if(2 != id1 && (usenature.trim().equals("0")) && (dengjitiem.trim().equals("0"))){
				result = carYdtjService.searchCarYdtjByCarYdtjOut3(page, rows,departmentId);
			}else if(2 != id1 && (usenature.trim().equals("0")) && !(dengjitiem.trim().equals("0"))){
				result = carYdtjService.searchCarYdtjByCarYdtjOut4(page, rows,departmentId,dengjitiem);
			}
			else{
				result = carYdtjService.searchCarYdtjByCarYdtjOut5(page, rows,departmentId,dengjitiem,usenature);
			}
			 @SuppressWarnings("unchecked")
			 List<CarYdtjOut> list = (List<CarYdtjOut>) result.getRows();
			 session.setAttribute("list1", list);
			 return result;
	}
	
}