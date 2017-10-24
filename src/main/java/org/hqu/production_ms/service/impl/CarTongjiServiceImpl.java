package org.hqu.production_ms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hqu.production_ms.domain.CarIn;
import org.hqu.production_ms.domain.CarMoney;
import org.hqu.production_ms.domain.CarOut;
import org.hqu.production_ms.domain.CarPublic;
import org.hqu.production_ms.domain.CarRemove;
import org.hqu.production_ms.domain.CarSelf;
import org.hqu.production_ms.domain.CarSend;
import org.hqu.production_ms.domain.CarWD;
import org.hqu.production_ms.domain.CarWE;
import org.hqu.production_ms.domain.CarYidong;
import org.hqu.production_ms.mapper.CarInMapper;
import org.hqu.production_ms.mapper.CarMoneyMapper;
import org.hqu.production_ms.mapper.CarOutMapper;
import org.hqu.production_ms.mapper.CarRegisterMapper;
import org.hqu.production_ms.mapper.CarRemoveMapper;
import org.hqu.production_ms.mapper.CarSelfMapper;
import org.hqu.production_ms.mapper.CarSendMapper;
import org.hqu.production_ms.mapper.CarWDMapper;
import org.hqu.production_ms.mapper.CarWEMapper;
import org.hqu.production_ms.service.CarTongjiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CarTongjiServiceImpl implements CarTongjiService
{
	@Autowired
	CarRegisterMapper carTongji;
	@Autowired
	CarSendMapper carSend;
	@Autowired
	CarWEMapper carWE;
	@Autowired
	CarWDMapper carWD;
	@Autowired
	CarOutMapper carOutMapper;
	@Autowired
	CarInMapper carInMapper;
	@Autowired
	CarSelfMapper carSelfMapper;
	@Autowired
	CarRemoveMapper carRemoveMapper;
	@Autowired
	CarMoneyMapper carMoneyMapper;
	@Override
	public List<CarPublic> findDep() throws Exception {
		return carTongji.finddep();
	}
	@Override
	public List<CarSend> findDepnums(String id1,String id2) throws Exception {
		return carSend.findDepnums(id1,id2);
	}
	@Override
	public List<CarWE> findCarnums(String id1,String id2) throws Exception {
		List<CarWE> list = carWE.find1(id1,id2,id1);
		return list;
	}
	@Override
	public List<CarWD> findDrivernums(String id1,String id2) throws Exception {
		return carWD.find1(id1,id2,id1);
	}
	@Override
	public List<CarPublic> findType() throws Exception {
		return carTongji.findType();
	}
	@Override
	public List<CarPublic> findUsenature() throws Exception {
		return carTongji.findUsenature();
	}
	
	@Override
	public List<CarMoney> findMoney(String id1,String id2) throws Exception {
		return carMoneyMapper.findtj(id1, id2);
	}
	
	@Override
	public List<CarMoney> findFX(String id1) throws Exception {
		List<CarMoney>  list = carMoneyMapper.findfx(id1);
//			for (CarMoney carMoney : list) {
//				for (int i = 1; i < 13; i++) {
//				if(i != Integer.parseInt(carMoney.getMonth1())){
//					CarMoney cari = new CarMoney();
//					cari.setMoney1(new BigDecimal(0));
//					cari.setMonth1(i+"");
//					list.add(cari);
//				}
//			}
//		}
//		Collections.sort(list, new Comparator<CarMoney>(){ 
//			public int compare(CarMoney o1, CarMoney o2) {
//				 if(Integer.parseInt(o1.getMonth1() )> Integer.parseInt(o2.getMonth1())){   
//		             return 1;   
//		         }   
//		         else{return -1;   }   
//			}
//			});
		return list;
	}
	 
	
	@Override
	public List<CarYidong> findYidong() throws Exception {
		List<CarYidong> yidong = new ArrayList<CarYidong>();
		CarYidong c1 = new CarYidong();
		List<CarOut> out = carOutMapper.findCount();
		if(out.size()>0){
			c1.setYidongnums(out.get(0).getYidongnums());
			c1.setStats(out.get(0).getStats());
			yidong.add(c1);
		}if(out.size()<=0){
			c1.setYidongnums(0);
			c1.setStats("调出");
			yidong.add(c1);
		}
		
		CarYidong c2 = new CarYidong();
		List<CarIn> out1 = carInMapper.findCount();
		if(out1.size()>0){
			c2.setYidongnums(out1.get(0).getYidongnums());
			c2.setStats(out1.get(0).getStats());
			yidong.add(c2);
		}
		if(out1.size()<=0){
			c2.setYidongnums(0);
			c2.setStats("调入");
			yidong.add(c2);
		}
		CarYidong c3 = new CarYidong();
		List<CarSelf> out2 = carSelfMapper.findCount();
		if(out2.size()>0){
			c3.setYidongnums(out2.get(0).getYidongnums());
			c3.setStats(out2.get(0).getStats());
			yidong.add(c3);
		}if(out2.size()<=0){
			c3.setYidongnums(0);
			c3.setStats("段内调配");
			yidong.add(c3);
		}
		
		CarYidong c4 = new CarYidong();
		List<CarRemove> out3 = carRemoveMapper.findCount();
		if(out3.size()>0){
			c4.setYidongnums(out3.get(0).getYidongnums());
			c4.setStats(out3.get(0).getStats());
			yidong.add(c4);
		}
		if(out3.size()<=0){
			c4.setYidongnums(0);
			c4.setStats("购入");
			yidong.add(c4);
		}
		
		return yidong;
	}
	
}
