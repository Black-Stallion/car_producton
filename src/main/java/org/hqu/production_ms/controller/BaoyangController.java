package org.hqu.production_ms.controller;

import javax.servlet.http.HttpSession;

import org.hqu.production_ms.domain.CarBS;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.service.CarBSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carBS")
public class BaoyangController {
	@Autowired
	private CarBSService carBsService;
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "carBS_list";                                                                                                                                                                                                                                                                                                 
	}
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, CarBS carBS,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carBsService.getList(page, rows, carBS);
		}
		else{
			result = carBsService.getList1(page, rows, carBS,id);
		}
		return result;
	}
	@RequestMapping("/list1")
	@ResponseBody
	public EUDataGridResult getList1(Integer page, Integer rows, CarBS carBS,HttpSession session) throws Exception{
		String id = (String) session.getAttribute("departmentId");
		EUDataGridResult result = null;
		int id1 =  (int) session.getAttribute("leve");
		if(2 == id1){
			result = carBsService.getList(page, rows, carBS);
		}
		else{
			result = carBsService.getList1(page, rows, carBS,id);
		}
		return result;
	}
}
