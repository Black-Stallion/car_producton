package org.hqu.production_ms.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarApply;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarApplyPO;
import org.hqu.production_ms.service.CarApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carApply")
public class CarApplyController {
	@Autowired
	private CarApplyService carApplyService;
	
	@RequestMapping("/get/{carApplyId}")
	@ResponseBody
	public CarApply getItemById(@PathVariable int ApplyId) throws Exception{
		CarApply carApply = carApplyService.get(ApplyId);
		return carApply;
	}
	@RequestMapping("/gets/{sendnums}")
	@ResponseBody
	public CarApply getItemByBian(@PathVariable String sendnums) throws Exception{
		CarApply carApply = carApplyService.findByBian(sendnums);
		return carApply;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarApply> getData(HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		List<CarApply> list = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			 list = carApplyService.find4();
		}else{
			int level =  (int) session.getAttribute("level");
			if(level==1){
			list = carApplyService.finds(id,id);
			}else{
				list = carApplyService.find(id);
			}
		}
		 
		return list;
	}
	
	@RequestMapping("/get_find")
	@ResponseBody
	public List<CarApply> find1(HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		List<CarApply> list = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			 list = carApplyService.findb();
		}else{
			int level =  (int) session.getAttribute("level");
			if(level==1){
					list = carApplyService.find2s(id,id);
				}else{
					list = carApplyService.find2(id);
				}
		}
		 
		return list;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "carApply_list";                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carApplyAddJudge() throws Exception{
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
			if(!subject.isPermitted("carApply:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "carApply_add";
	}
	@RequestMapping("/adds")
	public String adds() throws Exception{
		return "carApply_adds";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carApplyEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carApply:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "carApply_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, CarApply carApply,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
		result = carApplyService.getList1(page, rows, carApply);
		}else{
			int level =  (int) session.getAttribute("level");
			if(level==1){
				result = carApplyService.getLists(page, rows, carApply,id,id);
			}else{
				result = carApplyService.getList(page, rows, carApply,id);
			}
		
		}
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarApplyPO carApply, BindingResult bindingResult,HttpSession session) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			Calendar now = Calendar.getInstance();  
			int year =  now.get(Calendar.YEAR);  
			String month = now.get(Calendar.MONTH) + 1 + "";  
	        int day =  now.get(Calendar.DAY_OF_MONTH);  
	        int hour =  now.get(Calendar.HOUR_OF_DAY);  
	        int minute = now.get(Calendar.MINUTE);  
	        int second =  now.get(Calendar.SECOND);  
	        int mi = now.get(Calendar.MILLISECOND);
	        String bianhao = null;
	        if(day<10 && !(month.equals("10")) || month.equals("11")|| month.equals("12")){
	        	bianhao = "jntxd"+year+"0"+month+"0"+day+hour+minute+second+mi;
	        }else if(day<10 && (month.equals("10")) || month.equals("11")|| month.equals("12")){
	        	bianhao = "jntxd"+year+month+"0"+day+hour+minute+second+mi;
	        }else if(day>=10 && !(month.equals("10")) || month.equals("11")|| month.equals("12")){
	        	bianhao = "jntxd"+year+"0"+month+day+hour+minute+second+mi;
	        }else{
	        	bianhao = "jntxd"+year+month+day+hour+minute+second+mi;
	        }
	        carApply.setBianhao(bianhao);
			result = carApplyService.insert(carApply);
		}
		
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarApplyPO cCarApply, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carApplyService.update(cCarApply);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarApplyPO cCarApply, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carApplyService.updateAll(cCarApply);
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carApplyDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carApply:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carApplyService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		CustomResult result = carApplyService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carApply_by_applyname")
	@ResponseBody
	public EUDataGridResult searchCarApplyByCarApplyBrand(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carApplyService.searchCarApplyByCarApplyBrand(page, rows, searchValue);
		}else{
			result = carApplyService.searchCarApplyByCarApplyBrand1(page, rows,id, searchValue);
		}
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carApply_by_bianhao")
	@ResponseBody
	public EUDataGridResult searchCarApplyByCarApplyCarXH(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carApplyService.searchCarApplyByCarApplyCarXH(page, rows, searchValue);
	}else{
		result = carApplyService.searchCarApplyByCarApplyCarXH1(page, rows,id, searchValue);
	}
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carApply_by_dep")
	@ResponseBody
	public EUDataGridResult searchCarApplyByDepartmentCheckNums(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carApplyService.searchCarApplyByCheckNums(page, rows, searchValue);
	}else{
		result = carApplyService.searchCarApplyByCheckNums1(page, rows,id, searchValue);
	}
		return result;
	}
}
