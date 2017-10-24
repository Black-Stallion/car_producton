package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarMaintenance;
import org.hqu.production_ms.domain.CarRegister;
import org.hqu.production_ms.domain.CarRemove;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarBaoyangPO;
import org.hqu.production_ms.domain.po.CarRemovePO;
import org.hqu.production_ms.service.CarBaoyangService;
import org.hqu.production_ms.service.CarMaintenanceService;
import org.hqu.production_ms.service.CarRegisterService;
import org.hqu.production_ms.service.CarRemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carRemove")
public class CarRemoveController {
	@Autowired
	private CarRemoveService carRemoveService;
	@Autowired
	private CarRegisterService carRegisterService;
	@Autowired
	private CarMaintenanceService carMaintenanceService;
	@Autowired
	private CarBaoyangService carBaoyangService;
	@RequestMapping("/get/{carRemoveId}")
	@ResponseBody
	public CarRemove getItemById(@PathVariable int technicalId) throws Exception{
		CarRemove carRemove = carRemoveService.get(technicalId);
		return carRemove;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarRemove> getData() throws Exception{
		 List<CarRemove> list = carRemoveService.find();
		return list;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "carRemove_list";                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carRemoveAddJudge() throws Exception{
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
			if(!subject.isPermitted("carRemove:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "carRemove_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carRemoveEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carRemove:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "carRemove_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, CarRemove carRemove,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carRemoveService.getList(page, rows, carRemove);
		}else{
			result = carRemoveService.getList1(page, rows, carRemove,id);
		}
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarRemovePO carRemove, BindingResult bindingResult,HttpServletRequest request) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			int carId = carRemove.getCarId();
			String depid = carRemove.getDepartmentId();
			boolean re = carRegisterService.updateDepById(depid, carId);
			if(re == true){
			result = carRemoveService.insert(carRemove);
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
			
		}else{
			return CustomResult.build(201,"新增车辆购入信息失败，请刷新一下网页后重新填写！");
		}
		}
		
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarRemovePO cCarRemove, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carRemoveService.update(cCarRemove);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarRemovePO cCarRemove, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		int carId = cCarRemove.getCarId();
		String depid = cCarRemove.getDepartmentId();
		boolean re = carRegisterService.updateDepById(depid, carId);
		if(re == true){
		return carRemoveService.updateAll(cCarRemove);
		}else{
			return CustomResult.build(201,"修改车辆购入信息失败，请刷新一下网页后重新填写！");
		}
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carRemoveDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carRemove:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carRemoveService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		CustomResult result = carRemoveService.deleteBatch(ids);
		return result;
	}
	
	@RequestMapping("/search_carRemove_by_r1")
	@ResponseBody
	public EUDataGridResult searchCarRemoveByCarRemoveBrand(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carRemoveService.searchCarRemoveByCarRemoveBrand(page, rows, searchValue);
		}else{
			result = carRemoveService.searchCarRemoveByCarRemoveBrand1(page, rows,id, searchValue);
		}
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carRemove_by_r2")
	@ResponseBody
	public EUDataGridResult searchCarRemoveByCarRemoveCarXH(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carRemoveService.searchCarRemoveByCarRemoveCarXH(page, rows, searchValue);
		}else{
			result = carRemoveService.searchCarRemoveByCarRemoveCarXH1(page, rows,id, searchValue);
		}
		return result;
	}
	//搜索
	@RequestMapping("/search_carRemove_by_checknums")
	@ResponseBody
	public EUDataGridResult searchCarRemoveByDepartmentCheckNums(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = carRemoveService.searchCarRemoveByCheckNums(page, rows, searchValue);
		return result;
	}
}
