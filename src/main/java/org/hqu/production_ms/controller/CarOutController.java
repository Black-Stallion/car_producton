package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarOut;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarOutPO;
import org.hqu.production_ms.service.CarOutService;
import org.hqu.production_ms.service.CarRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carOut")
public class CarOutController {
	@Autowired
	private CarOutService carOutService;
	@Autowired
	private CarRegisterService carRegisterService;
	@RequestMapping("/get/{carOutId}")
	@ResponseBody
	public CarOut getItemById(@PathVariable int technicalId) throws Exception{
		CarOut carOut = carOutService.get(technicalId);
		return carOut;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarOut> getData() throws Exception{
		 List<CarOut> list = carOutService.find();
		return list;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "CarOut_list";                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carOutAddJudge() throws Exception{
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
			if(!subject.isPermitted("carOut:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "CarOut_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carOutEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carOut:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "CarOut_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, CarOut carOut,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carOutService.getList(page, rows, carOut);
		}else{
			result = carOutService.getList1(page, rows, carOut,id);
		}
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarOutPO carOut, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			int carId = carOut.getCarId();
			String depid = carOut.getDepartmentId();
			boolean re = carRegisterService.updateDepById(depid, carId);
			if(re == true){
			result = carOutService.insert(carOut);
			}else{
				return CustomResult.build(201,"新增车辆调出信息失败，请刷新一下网页后重新填写！");
			}
		}
		
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarOutPO cCarOut, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carOutService.update(cCarOut);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarOutPO cCarOut, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		int carId = cCarOut.getCarId();
		String depid = cCarOut.getDepartmentId();
		boolean re = carRegisterService.updateDepById(depid, carId);
		if(re == true){
		return carOutService.updateAll(cCarOut);
		}else{
			return CustomResult.build(201,"修改车辆调出信息失败，请刷新一下网页后重新填写！");
		}
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carOutDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carOut:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carOutService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		CustomResult result = carOutService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carOut_by_brand")
	@ResponseBody
	public EUDataGridResult searchCarOutByCarOutBrand(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carOutService.searchCarOutByCarOutBrand(page, rows, searchValue);
		return result;
	}
	
	@RequestMapping("/search_carOut_by_o1")
	@ResponseBody
	public EUDataGridResult searchCarOutByCarOutBrand(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carOutService.searchCarOutByCarOutBrand(page, rows, searchValue);
		}else{
			result = carOutService.searchCarOutByCarOutBrand1(page, rows,id, searchValue);
		}
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carOut_by_o2")
	@ResponseBody
	public EUDataGridResult searchCarOutByCarOutCarXH(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carOutService.searchCarOutByCarOutCarXH(page, rows, searchValue);
		}else{
			result = carOutService.searchCarOutByCarOutCarXH1(page, rows,id, searchValue);
		}
		return result;
	}
	
}
