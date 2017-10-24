package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CarMoney;
import org.hqu.production_ms.domain.CarPublic;
import org.hqu.production_ms.domain.CarSend;
import org.hqu.production_ms.domain.CarWD;
import org.hqu.production_ms.domain.CarWE;
import org.hqu.production_ms.domain.CarYidong;

public interface CarTongjiService {
	List<CarPublic> findDep() throws Exception;
	
	List<CarPublic> findType() throws Exception;
	
	List<CarPublic> findUsenature() throws Exception;
	
	List<CarYidong> findYidong() throws Exception;
	
	List<CarMoney> findMoney(String id1,String id2) throws Exception;
	
	List<CarMoney> findFX(String id1) throws Exception;
	List<CarSend> findDepnums(String id,String id2) throws Exception;
	List<CarWE> findCarnums(String id,String id2) throws Exception;
	
	List<CarWD> findDrivernums(String id,String id2) throws Exception;
}
