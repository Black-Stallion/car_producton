package org.hqu.production_ms.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CarMoney;
import org.hqu.production_ms.domain.CarYou;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.CarYouPO;
import org.hqu.production_ms.service.CarMoneyService;
import org.hqu.production_ms.service.CarYouService;
import org.hqu.production_ms.util.FileUtil;
import org.hqu.production_ms.util.Image_fileUtile;
import org.hqu.production_ms.util.uploadExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carYou")
public class CarYouController {
	@Autowired
	private CarYouService carYouService;
	@Autowired
	private CarMoneyService carMoneyService;
	@RequestMapping("/get/{carYouId}")
	@ResponseBody
	public CarYou getItemById(@PathVariable int technicalId) throws Exception{
		CarYou carYou = carYouService.get(technicalId);
		return carYou;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<CarYou> getData(HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		List<CarYou> list = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			list = carYouService.find5();
		}else{
		    list = carYouService.find6(id);
		}
		 
		return list;
	}
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	@ResponseBody
	public CustomResult download(@Valid String uploadyou) throws Exception{
		CustomResult result = null;
		CarMoney carmoney = new CarMoney();
		uploadExcel x = new uploadExcel();
		List<CarYou> list1 = x.loadYou(new Image_fileUtile().uploadName()+uploadyou);
		for (CarYou carYou : list1) {
			if(carYou.getYounumber() != null && !carYou.getYounumber().equals("")){
				CarYou caryou = carYouService.get12(carYou.getYounumber());
				if(caryou != null){
					caryou.setBeiyong2(carYou.getBeiyong2().add(caryou.getBeiyong2()));
					carmoney.setCarnum(carYou.getYounumber());
					carmoney.setMoney(carYou.getBeiyong2());
					carmoney.setDepatmentname(carYou.getDepartmentName());
					carmoney.setDatatime(new Date());
					carMoneyService.insert(carmoney);
					result = carYouService.updateByYouId(caryou);
				}
				else{
					FileUtil.deleteFile(new Image_fileUtile().uploadName()+uploadyou);
					return CustomResult.build(201,""+carYou.getYounumber()+" 的卡号系统内没有找到，导致该卡号以下的油卡充值失败，请检查后重新充值！");
				}
			}
		}
		FileUtil.deleteFile(new Image_fileUtile().uploadName()+uploadyou);
		return result;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "carYou_list";                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping("/moneyfind")
	public String moneyfind() throws Exception{
		return "carYou_moneylist";                                                                                                                                                                                                                                                                                                 
	}
	@RequestMapping("/find2")
	public String find2() throws Exception{
		return "carYou_list2";                                                                                                                                                                                                                                                                                                 
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> carYouAddJudge() throws Exception{
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
			if(!subject.isPermitted("carYou:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	@RequestMapping("/add_judge1")
	@ResponseBody
	public Map<String,Object> carYouAddJudge1() throws Exception{
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
			if(!subject.isPermitted("carYou:money")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	@RequestMapping("/money")
	public String money() throws Exception{
		return "carYou_money";
	}
	
	@RequestMapping("/allmoney")
	public String allmoney() throws Exception{
		return "carYou_allmoney";
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "carYou_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> carYouEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carYou:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "carYou_edit";
	}
	
//	@RequestMapping("/list/{d}")
//	@ResponseBody
//	public EUDataGridResult getList(Integer page, Integer rows, CarYou carYou,String string) throws Exception{
//		EUDataGridResult result = carYouService.getList(page, rows, carYou,string);
//		return result;
//	}
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, CarYou carYou,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carYouService.getList1(page, rows, carYou);
		}else{
		    result = carYouService.getList(page, rows, carYou,id);
		}
		return result;
	}
	@RequestMapping("/listmoney")
	@ResponseBody
	public EUDataGridResult getListmoney(Integer page, Integer rows, CarMoney carYou) throws Exception{
		EUDataGridResult result = null;
			result = carMoneyService.getList(page, rows, carYou);
		return result;
	}
	
	@RequestMapping("/list2")
	@ResponseBody
	public EUDataGridResult getList2(Integer page, Integer rows, CarYou carYou,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carYouService.getList3(page, rows, carYou);
		}else{
		    result = carYouService.getList4(page, rows, carYou,id);
		}
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid CarYouPO carYou, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			System.out.println(fieldError.getDefaultMessage());
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}else{
			
			result = carYouService.insert(carYou);
		}
		
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid CarYouPO cCarYou, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carYouService.update(cCarYou);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid CarYouPO cCarYou, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carYouService.updateAll(cCarYou);
	}
	@RequestMapping(value="/update_money")
	@ResponseBody
	private CustomResult updateMoney(@Valid CarYou cCarYou, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		CarMoney carmoney = new CarMoney();
		carmoney.setCarnum(cCarYou.getYounumber());
		carmoney.setMoney(cCarYou.getBei1());
		carmoney.setDepatmentname(cCarYou.getDepartmentName());
		carmoney.setDatatime(new Date());
		carMoneyService.insert(carmoney);
		cCarYou.setBeiyong2(cCarYou.getBeiyong2().add(cCarYou.getBei1()));
		return carYouService.updateByYouId(cCarYou);
	}
	@RequestMapping(value="/update_id")
	@ResponseBody
	private CustomResult updateById(@Valid CarYouPO carYou, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return carYouService.updateById(carYou);
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> carYouDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("carYou:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(int id) throws Exception {
		CustomResult result = carYouService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(int[] ids) throws Exception {
		CustomResult result = carYouService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_carYou_by_num")
	@ResponseBody
	public EUDataGridResult searchCarYouByCarYouBrand(Integer page, Integer rows, String searchValue,HttpSession session) 
			throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carYouService.searchCarYouByCarYouBrand(page, rows, searchValue);
		}else{
			result = carYouService.searchCarYouByCarYouBrand1(page, rows,id,searchValue);
		}
		return result;
	}
	
}
