package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarIn;
import org.hqu.production_ms.domain.CarMaintenance;
import org.hqu.production_ms.domain.CarRegister;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarBaoyangPO;
import org.hqu.production_ms.domain.po.CarInPO;
import org.hqu.production_ms.service.CarBaoyangService;
import org.hqu.production_ms.service.CarInService;
import org.hqu.production_ms.service.CarMaintenanceService;
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
@RequestMapping("/carIn")
public class CarInController {
	@Autowired
	private CarInService carInService;
	@Autowired
	private CarRegisterService carRegisterService;
	@Autowired
	private CarMaintenanceService carMaintenanceService;
	@Autowired
	private CarBaoyangService carBaoyangService;
	@RequestMapping("/get/{carInId}")
	@ResponseBody
	public CarIn getItemById(@PathVariable int technicalId) throws Exception{
		CarIn carIn = carInService.get(technicalId);
		return carIn;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarIn> getData() throws Exception{
		 List<CarIn> list = carInService.find();
		return list;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "CarIn_list";                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carInAddJudge() throws Exception{
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
			if(!subject.isPermitted("carIn:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "CarIn_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carInEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carIn:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "CarIn_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, CarIn carIn,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carInService.getList(page, rows, carIn);
		}else{
			result = carInService.getList1(page, rows, carIn,id);
		}
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarInPO carIn, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			int carId = carIn.getCarId();
			String depid = carIn.getDepartmentId();
			boolean re = carRegisterService.updateDepById(depid, carId);
			if(re == true){
			result = carInService.insert(carIn);
			boolean result1 = carBaoyangService.find2(carId);
			if(result1 == true){
				CarRegister car = new CarRegister();
				car = carRegisterService.get(carId);
				int typyid = car.getCarType().getTypeid();
				List<CarMaintenance> technical = carMaintenanceService.find1(typyid);
				if(technical.size()==0){
					return CustomResult.build(200,",但本车车型未填维护要求，将无法提示保养提醒！请增加该车型保养要求");
				}else{
				CarMaintenance m = technical.get(0);
				CarBaoyangPO bao = new  CarBaoyangPO();
				bao.setCarId(carId);
				bao.setNotes(m.getMproject());
				bao.setLm(m.getKilometre());
				carBaoyangService.insert(bao);
				}
			}
			return result;	
		}else{
			return CustomResult.build(201,"新增车辆调入信息失败，请刷新一下网页后重新填写！");
		}
		}
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarInPO cCarIn, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carInService.update(cCarIn);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarInPO cCarIn, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		int carid = cCarIn.getCarId();
		String depid = cCarIn.getDepartmentId();
		boolean re = carRegisterService.updateDepById(depid, carid);
		if(re == true){
		return carInService.updateAll(cCarIn);
		}else{
			return CustomResult.build(201,"修改车辆调调入信息失败，请刷新一下网页后重新填写！");
		}
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carInDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carIn:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carInService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		CustomResult result = carInService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carIn_by_i1")
	@ResponseBody
	public EUDataGridResult searchCarInByCarInBrand(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carInService.searchCarInByCarInBrand(page, rows, searchValue);
		}else{
			result = carInService.searchCarInByCarInBrand1(page, rows,id, searchValue);
		}
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carIn_by_i2")
	@ResponseBody
	public EUDataGridResult searchCarInByCarInCarXH(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carInService.searchCarInByCarInCarXH(page, rows, searchValue);
		}else{
			result = carInService.searchCarInByCarInCarXH1(page, rows,id, searchValue);
		}
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carIn_by_checknums")
	@ResponseBody
	public EUDataGridResult searchCarInByDepartmentCheckNums(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carInService.searchCarInByCheckNums(page, rows, searchValue);
		return result;
	}
}
