package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarBaoyang;
import org.hqu.production_ms.domain.CarKeep;
import org.hqu.production_ms.domain.CarMaintenance;
import org.hqu.production_ms.domain.CarRegister;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarBaoyangPO;
import org.hqu.production_ms.service.CarBaoyangService;
import org.hqu.production_ms.service.CarKeepService;
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
@RequestMapping("/carKeep")
public class CarKeepController {
	@Autowired
	private CarKeepService carKeepService;
	@Autowired
	private CarRegisterService carRegisterService;
	@Autowired
	private CarMaintenanceService carMaintenanceService;
	@Autowired
	private CarBaoyangService carBaoyangService;
	@RequestMapping("/get/{carKeepId}")
	@ResponseBody
	public CarKeep getItemById(@PathVariable int technicalId) throws Exception{
		CarKeep carKeep = carKeepService.get(technicalId);
		return carKeep;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarKeep> getData() throws Exception{
		 List<CarKeep> list = carKeepService.find();
		return list;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "carKeep_list";                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carKeepAddJudge() throws Exception{
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
			if(!subject.isPermitted("carKeep:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "carKeep_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carKeepEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carKeep:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "carKeep_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, CarKeep carKeep,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carKeepService.getList(page, rows, carKeep);
		}else{
			result = carKeepService.getList1(page, rows, carKeep,id);
		}
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarKeep carKeep, BindingResult bindingResult) throws Exception {
		int carId = carKeep.getCarId();
		String ks = carKeep.getIntervalkm();
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			double ks1 = Double.parseDouble(ks);
			boolean result1 = carBaoyangService.find2(carId);
			//该汽车的维护要求不存在
			if(result1 == true){
				CarRegister car = new CarRegister();
				car = carRegisterService.get(carId);
				int typyid = car.getCarType().getTypeid();
				List<CarMaintenance> technical = carMaintenanceService.find3(ks1,typyid);
				//位达到要求
				if(technical == null || technical.size()==0){
					return CustomResult.build(201,"本车未达到保养要求或本车车型没有填写保养要求，不能进行保养提醒！");
				}else{
					List<CarMaintenance> technical1 = carMaintenanceService.find2(ks1,typyid);
					if(technical1.size()>1){
						CarMaintenance m = carMaintenanceService.find1(typyid).get(0);
						if(m != null){
							CarBaoyangPO bao = new  CarBaoyangPO();
							bao.setCarId(carId);
							bao.setNotes(m.getMproject());
							bao.setLm(m.getKilometre());
							carBaoyangService.insert(bao);
							result = carKeepService.insert(carKeep);
						}else{
							return CustomResult.build(201,"本车未达到保养要求或本车车型没有填写保养要求，不能进行保养填写！");
						}
						
					}else{
						CarMaintenance m = carMaintenanceService.find1(typyid).get(0);
						if(m!=null){
							CarBaoyangPO bao = new  CarBaoyangPO();
							bao.setCarId(carId);
							bao.setNotes(m.getMproject());
							bao.setLm(m.getKilometre());
							carBaoyangService.insert(bao);
							result = carKeepService.insert(carKeep);
							return CustomResult.build(201,"新增车辆保养信息成功,但本车车型已达最大保养要求，将无法继续提示保养提醒！请增加该车型保养要求");
						}else{
							return CustomResult.build(201,"本车未达到保养要求或本车车型没有填写保养要求，不能进行保养填写！");
						}
						
					}
				}
				//存在车辆保养信息
			}else{
				CarRegister car = new CarRegister();
				car = carRegisterService.get(carId);
				int typyid = car.getCarType().getTypeid();
				List<CarMaintenance> technical = null;
				technical = carMaintenanceService.find2(ks1,typyid);
				if(technical == null || technical.size()==0){
					result = carKeepService.insert(carKeep);
					return CustomResult.build(201,"新增车辆保养信息成功,但本车车型已达最大保养要求，将无法继续提示保养提醒！请增加该车型保养要求");
				}else{
					CarBaoyang cb = carBaoyangService.get1(carId);
					//达到最大保养要求
					if(ks1 < cb.getLm().doubleValue()){
						return CustomResult.build(201,"本车车还没有达到保养要求，不能进行保养添加操作");
					}else{//没有达到最大要求
						CarMaintenance m = technical.get(0);
						if(m !=null){
							CarBaoyangPO bao = new  CarBaoyangPO();
							bao.setCarId(carId);
							bao.setNotes(m.getMproject());
							bao.setLm(m.getKilometre());
							carBaoyangService.updateById(bao);
							result = carKeepService.insert(carKeep);
						}else{
							return CustomResult.build(201,"本车车还没有达到保养要求，不能进行保养添加操作");
						}
						
					}
				}
			}
		}
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarKeep carKeep, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carKeepService.update(carKeep);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarKeep carKeep, BindingResult bindingResult) throws Exception {
		int carId = carKeep.getCarId();
		String ks = carKeep.getIntervalkm();
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			result = carKeepService.updateAll(carKeep);
		boolean result1 = carBaoyangService.find2(carId);
		if(result1 == true){
			CarRegister car = new CarRegister();
			car = carRegisterService.get(carId);
			int typyid = car.getCarType().getTypeid();
			List<CarMaintenance> technical = carMaintenanceService.find1(typyid);
			if(technical.size() >0 ){
				CarMaintenance m = technical.get(0);
				CarBaoyangPO bao = new  CarBaoyangPO();
				bao.setCarId(carId);
				bao.setNotes(m.getMproject());
				bao.setLm(m.getKilometre());
				carBaoyangService.insert(bao);
			}else{
				return CustomResult.build(201,"本车未达到保养要求或本车车型没有填写保养要求，不能进行保养提醒！");
			}
			
		}else{//存在
			double ks1 = Double.parseDouble(ks);
			CarRegister car = new CarRegister();
			car = carRegisterService.get(carId);
			int typyid = car.getCarType().getTypeid();
			List<CarMaintenance> technical;
			technical = carMaintenanceService.find2(ks1,typyid);
			if(technical == null || technical.size()==0){
				List<CarMaintenance> techni = carMaintenanceService.find1(typyid);
				if(techni.size()==0){
					return CustomResult.build(200,",但本车车型已达最大保养要求，将无法继续提示保养提醒！请增加该车型保养要求");
				}else{
				CarMaintenance m = techni.get(0);
				CarBaoyangPO bao = new  CarBaoyangPO();
				bao.setCarId(carId);
				bao.setNotes(m.getMproject());
				bao.setLm(m.getKilometre());
				carBaoyangService.updateById(bao);
				}
			}else{
			CarMaintenance m = technical.get(0);
			if(m !=null){
				CarBaoyangPO bao = new  CarBaoyangPO();
				bao.setCarId(carId);
				bao.setNotes(m.getMproject());
				bao.setLm(m.getKilometre());
				carBaoyangService.updateById(bao);
			}else{
				return CustomResult.build(201,"但本车车型已达最大保养要求，无法继续进行添加保养！");
			}
			}
			}
		}
		return result;
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carKeepDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carKeep:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carKeepService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		CustomResult result = carKeepService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carKeep_by_k1")
	@ResponseBody
	public EUDataGridResult searchCarKeepByCarKeepBrand(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carKeepService.searchCarKeepByCarKeepBrand(page, rows, searchValue);
		}else{
			result = carKeepService.searchCarKeepByCarKeepBrand1(page, rows,id,searchValue);
		}
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carKeep_by_k2")
	@ResponseBody
	public EUDataGridResult searchCarKeepByCarKeepCarXH(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carKeepService.searchCarKeepByCarKeepCarXH(page, rows, searchValue);
		}else{
			result = carKeepService.searchCarKeepByCarKeepCarXH1(page, rows, id,searchValue);
		}
		return result;
	}
	@RequestMapping("/findKeep/{carId}")
	@ResponseBody
	public EUDataGridResult searchCarKeepByCarId(@PathVariable int carId,Integer page, Integer rows) 
			throws Exception{
		EUDataGridResult result = carKeepService.searchCarKeepByCarId(page, rows,carId);
		return result;
	}
	
}
