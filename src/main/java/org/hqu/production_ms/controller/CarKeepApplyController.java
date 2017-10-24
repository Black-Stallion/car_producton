package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarKeepApply;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarKeepApplyPO;
import org.hqu.production_ms.service.CarKeepApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carKeepApply")
public class CarKeepApplyController {
	@Autowired
	private CarKeepApplyService carKeepApplyService;
	
	@RequestMapping("/get/{carKeepApplyId}")
	@ResponseBody
	public CarKeepApply getItemById(@PathVariable int ApplyId) throws Exception{
		CarKeepApply carKeepApply = carKeepApplyService.get(ApplyId);
		return carKeepApply;
	}
	@RequestMapping("/gets/{sendnums}")
	@ResponseBody
	public CarKeepApply getItemByBian(@PathVariable String sendnums) throws Exception{
		CarKeepApply carKeepApply = carKeepApplyService.findByBian(sendnums);
		return carKeepApply;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarKeepApply> getData(HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		List<CarKeepApply> list = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			list = carKeepApplyService.find();
		}else{
			list = carKeepApplyService.find1(id);
		}
		 
		return list;
	}
	
	@RequestMapping("/get_find")
	@ResponseBody
	public List<CarKeepApply> find1(HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		 List<CarKeepApply> list = carKeepApplyService.find1(id);
		return list;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "carKeepApply_list";                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carKeepApplyAddJudge() throws Exception{
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
			if(!subject.isPermitted("carKeepApply:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "carKeepApply_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carKeepApplyEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carKeepApply:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "carKeepApply_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, CarKeepApply carKeepApply,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carKeepApplyService.getList(page, rows, carKeepApply);
		}else{
			result = carKeepApplyService.getList1(page, rows, carKeepApply,id);
		}
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarKeepApplyPO carKeepApply, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			result = carKeepApplyService.insert(carKeepApply);
		}
		
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarKeepApplyPO cCarKeepApply, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carKeepApplyService.update(cCarKeepApply);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarKeepApplyPO cCarKeepApply, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carKeepApplyService.updateAll(cCarKeepApply);
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carKeepApplyDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carKeepApply:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carKeepApplyService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		CustomResult result = carKeepApplyService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carKeepApply_by_brand")
	@ResponseBody
	public EUDataGridResult searchCarKeepApplyByCarKeepApplyBrand(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carKeepApplyService.searchCarKeepApplyByCarKeepApplyBrand(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carKeepApply_by_carxh")
	@ResponseBody
	public EUDataGridResult searchCarKeepApplyByCarKeepApplyCarXH(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carKeepApplyService.searchCarKeepApplyByCarKeepApplyCarXH(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carKeepApply_by_checknums")
	@ResponseBody
	public EUDataGridResult searchCarKeepApplyByDepartmentCheckNums(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carKeepApplyService.searchCarKeepApplyByCheckNums(page, rows, searchValue);
		return result;
	}
	
	//搜索
		@RequestMapping("/findKeepApply/{carId}")
		@ResponseBody
		public EUDataGridResult searchCarKeepApplyByCarId(@PathVariable String carId,Integer page, Integer rows) 
				throws Exception{
			EUDataGridResult result = carKeepApplyService.searchCarKeepApplyByCarId(page, rows,carId);
			return result;
		}
}
