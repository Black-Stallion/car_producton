package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarPublic;
import org.hqu.production_ms.domain.CarRegister;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarRegisterPO;
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
@RequestMapping("/carPublic")
public class CarPublicController {
	@Autowired
	private CarRegisterService carRegisterService;
	
	@RequestMapping("/get/{carId}")
	@ResponseBody
	public CarRegister getItemById(@PathVariable int carId) throws Exception{
		CarRegister carRegister = carRegisterService.get(carId);
		return carRegister;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarRegister> getData(HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		List<CarRegister> list = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			list = carRegisterService.get();
		}else{
			list = carRegisterService.get1(id);
		}
		return list;
	}
	@RequestMapping("/get_dataP")
	@ResponseBody
	public List<CarPublic> getDataP(HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		List<CarPublic> list = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			list = carRegisterService.findP();
		}else{
			list = carRegisterService.findP1(id);
		}
		return list;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "carPublic_list";                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping(value="/find_nature/{usenature}",produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<CarRegister> findByNature(@PathVariable String usenature,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId"); 
		List<CarRegister> list = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			list = carRegisterService.findByNature(usenature);
		}else{
			 list = carRegisterService.findByNature1(usenature,id);
		}
		return list;                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carRegisterAddJudge() throws Exception{
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
			if(!subject.isPermitted("carPublic:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "carPublic_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carRegisterEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carPublic:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "carPublic_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, CarRegister carRegister,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			 result = carRegisterService.getList(page, rows, carRegister);
		}else{
			 result = carRegisterService.getList1(page, rows, carRegister,id);
		}
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarRegisterPO carRegister, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			result = carRegisterService.insert(carRegister);
		}
		
		return result;
	}
	@RequestMapping(value="/check", method=RequestMethod.POST)
	@ResponseBody
	private Map<String,Object> check(@Valid String carnumber,String carcjh) throws Exception {
		Map<String,Object> map = null;
		map = new HashMap<String,Object>();
		CarRegister car = null;
		car = carRegisterService.findByCarNumber(carnumber);
		CarRegister cars = carRegisterService.findByCarCJH(carcjh);
		if(car != null){
			map.put("msg", "该车牌号以存在，请检查后重新输入！");
		}
		if(cars != null){
			map.put("msg", "该车架号以存在，请检查后重新输入！");
		}
		return map;
	}
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarRegisterPO cCarRegister, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carRegisterService.update(cCarRegister);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarRegisterPO cCarRegister, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carRegisterService.updateAll(cCarRegister);
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carRegisterDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carPublic:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carRegisterService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		CustomResult result = carRegisterService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carPublic_by_carnumber")
	@ResponseBody
	public EUDataGridResult searchCarRegisterByCarRegisterBrand(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carRegisterService.searchCarRegisterByCarRegisterDriverfrom(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carPublic_by_departmentName")
	@ResponseBody
	public EUDataGridResult searchCarRegisterByCarRegisterCarXH(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carRegisterService.searchCarRegisterByCarRegisterAA(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carPublic_by_username")
	@ResponseBody
	public EUDataGridResult searchCarRegisterByDepartmentCheckNums(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carRegisterService.searchCarRegisterByCarRegisterName(page, rows, searchValue);
		return result;
	}
}
