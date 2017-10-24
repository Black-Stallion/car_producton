package org.hqu.production_ms.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarMaintenance;
import org.hqu.production_ms.domain.CarRegister;
import org.hqu.production_ms.domain.CarSend;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarBaoyangPO;
import org.hqu.production_ms.domain.po.CarSendPO;
import org.hqu.production_ms.service.CarBaoyangService;
import org.hqu.production_ms.service.CarMaintenanceService;
import org.hqu.production_ms.service.CarRegisterService;
import org.hqu.production_ms.service.CarSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carSend")
public class CarSendController {
	@Autowired
	private CarSendService carSendService;
	@Autowired
	private CarRegisterService carRegisterService;
	@Autowired
	private CarMaintenanceService carMaintenanceService;
	@Autowired
	private CarBaoyangService carBaoyangService;
	@RequestMapping("/get/{sendId}")
	@ResponseBody
	public CarSend getItemById(@PathVariable int sendId) throws Exception{
		CarSend carSend = carSendService.get(sendId);
		return carSend;
	}
	@RequestMapping("/get1/{sendIds}")
	public String getItemById1(@PathVariable int sendIds,ModelMap map) throws Exception{
		CarSend carSend = carSendService.get(sendIds);
		map.put("carSend", carSend);
		return "carSend_print";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarSend> getData(HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		List<CarSend> list = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			list = carSendService.find();
		}else{
			int level =  (int) session.getAttribute("level");
			if(level==1){
			list = carSendService.finds(id,id);
			}else{
				list = carSendService.find1(id);
			}
		}
		return list;
	}
	
//	@RequestMapping("/get_find")
//	@ResponseBody
//	public List<CarSend> find1() throws Exception{
//		 List<CarSend> list = carSendService.find1();
//		return list;
//	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "carSend_list";                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carSendAddJudge() throws Exception{
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
			if(!subject.isPermitted("carSend:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "carSend_add";
	}
	
	@RequestMapping("/nowadd")
	public String nowadd() throws Exception{
		return "carSend_nowadd";
	}
	@RequestMapping("/adds")
	public String adds() throws Exception{
		return "carSend_adds";
	}
	
	@RequestMapping("/nowadds")
	public String nowadds() throws Exception{
		return "carSend_nowadds";
	}
	
	@RequestMapping("/print")
	public String print() throws Exception{
		return "carSend_print";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carSendEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carSend:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "carSend_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, CarSend carSend,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carSendService.getList(page, rows, carSend);
		}else{
			int level =  (int) session.getAttribute("level");
			if(level==1){
				result = carSendService.getLists(page, rows, carSend,id,id);
			}else{
			result = carSendService.getList1(page, rows, carSend,id);
			}
		}
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarSendPO carSend, BindingResult bindingResult,HttpSession session) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{  
			 if(carSend.getNote().contains("null,")){
		        	String s2 = carSend.getNote();
		        	String note = s2.replace("null,","");
		        	carSend.setNote(note);
		        }
			 carSend.setSdate(new SimpleDateFormat("yyyy-MM-dd").parse(carSend.getSdates())); 
			result = carSendService.insert(carSend);
			int carId = carSend.getCarId();
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
		}
		
		return result;
	}
	@RequestMapping(value="/insertnow", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insertnow(@Valid CarSendPO carSend, BindingResult bindingResult,HttpSession session) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{Calendar now = Calendar.getInstance();  
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
	       carSend.setSdate(new SimpleDateFormat("yyyy-MM-dd").parse(carSend.getSdates())); 
	        carSend.setSendnums(bianhao);
	        if(carSend.getNote().contains("null,")){
	        	String s2 = carSend.getNote();
	        	String note = s2.replace("null,","");
	        	carSend.setNote(note);
	        }
			result = carSendService.insert(carSend);
			int carId = carSend.getCarId();
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
		}
		
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarSendPO cCarSend, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carSendService.update(cCarSend);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarSendPO cCarSend, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		cCarSend.setSdate(new SimpleDateFormat("yyyy-MM-dd").parse(cCarSend.getSdates()));
		return carSendService.updateAll(cCarSend);
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carSendDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carSend:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carSendService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		CustomResult result = carSendService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carSend_by_s1")
	@ResponseBody
	public EUDataGridResult searchCarSendByCarSendBrand(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carSendService.searchCarSendByCarSendBrand(page, rows, searchValue);
		}else{
			result = carSendService.searchCarSendByCarSendBrand1(page, rows,id, searchValue);
		}
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carSend_by_s2")
	@ResponseBody
	public EUDataGridResult searchCarSendByCarSendCarXH(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carSendService.searchCarSendByCarSendCarXH(page, rows, searchValue);
		}
		else{
			result = carSendService.searchCarSendByCarSendCarXH1(page, rows,id, searchValue);
		}
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carSend_by_s3")
	@ResponseBody
	public EUDataGridResult searchCarSendByDepartmentCheckNums(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carSendService.searchCarSendByCheckNums(page, rows, searchValue);
	}
		else{
			result = carSendService.searchCarSendByCheckNums1(page, rows,id, searchValue);
		}
		return result;
	}
	//搜索
		@RequestMapping("/byCarId/{carId}")
		@ResponseBody
		public EUDataGridResult findByCarId(@PathVariable int carId,Integer page, Integer rows) 
				throws Exception{
			EUDataGridResult result= carSendService.findByCarId(page, rows, carId);
			return result;
		}
}
