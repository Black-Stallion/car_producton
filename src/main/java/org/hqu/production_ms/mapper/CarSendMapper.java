package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarSend;
import org.hqu.production_ms.domain.CarSendExample;
import org.hqu.production_ms.domain.po.CarSendPO;

public interface CarSendMapper {
	
	//扩展的mapper接口方法
	int deleteBatch(int[] ids);
	
	List<CarSend> find();
	List<CarSend> findStat();
	
	List<CarSend> findStat1(String id);
	
	List<CarSend> findDepnums(String id,String id1);
	
	List<CarSend> findCarnums(String id,String id2,String id1,String id3);
	
	List<CarSend> findDrivernums(String id,String id4,String id2,String id1);
	
	List<CarSend> find1(String id);
	List<CarSend> finds(String id,String ids);
	
	List<CarSend> findByDepartment(String id);
	
	List<CarSend> getXX();
	
	List<CarSend> findByCarId(int brand);
	
	List<CarSend> searchCarSendByCarSendDriverfrom(String brand);

	List<CarSend> searchCarSendByCarSendAA(String checkNums);

	List<CarSend> searchCarSendByCarSendName(String carXH);
	
	List<CarSend> searchCarSendByCarSendDriverfrom1(String id,String id1,String brand);

	List<CarSend> searchCarSendByCarSendAA1(String id,String id1,String checkNums);

	List<CarSend> searchCarSendByCarSendName1(String id,String id1,String carXH);
	
	CarSend selectSingleCarSend(int applyId);
		//逆向工程生成的mapper接口
    int countByExample(CarSendExample example);

    int deleteByExample(CarSendExample example);

    int deleteByPrimaryKey(Integer sendId);

    int insert(CarSendPO record);

    int insertSelective(CarSend record);

    List<CarSend> selectByExample(CarSendExample example);

    CarSend selectByPrimaryKey(Integer sendId);

    int updateByExampleSelective(@Param("record") CarSend record, @Param("example") CarSendExample example);

    int updateByExample(@Param("record") CarSend record, @Param("example") CarSendExample example);

    int updateByPrimaryKeySelective(CarSendPO record);

    int updateByPrimaryKey(CarSendPO record);
}