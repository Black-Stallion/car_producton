package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarSelf;
import org.hqu.production_ms.domain.CarSelfExample;
import org.hqu.production_ms.domain.po.CarSelfPO;

public interface CarSelfMapper {
	//扩展的mapper接口方法
			int deleteBatch(int[] ids);
			
			List<CarSelf> find();
			
			List<CarSelf> findCount();
			
			List<CarSelf> find1(String id);
			
			List<CarSelf> searchCarSelfByCarSelfDriverfrom(String brand);

			List<CarSelf> searchCarSelfByCarSelfAA(String checkNums);
			
			List<CarSelf> searchCarSelfByCarSelfDriverfrom1(String id,String brand);

			List<CarSelf> searchCarSelfByCarSelfAA1(String id,String checkNums);

			List<CarSelf> searchCarSelfByCarSelfName(String carXH);
			
			CarSelf selectSingleCarSelf(int carSelfId);
				//逆向工程生成的mapper接口
    int countByExample(CarSelfExample example);

    int deleteByExample(CarSelfExample example);

    int deleteByPrimaryKey(Integer selfId);

    int insert(CarSelfPO record);

    int insertSelective(CarSelf record);

    List<CarSelf> selectByExample(CarSelfExample example);

    CarSelf selectByPrimaryKey(Integer selfId);

    int updateByExampleSelective(@Param("record") CarSelf record, @Param("example") CarSelfExample example);

    int updateByExample(@Param("record") CarSelf record, @Param("example") CarSelfExample example);

    int updateByPrimaryKeySelective(CarSelfPO record);

    int updateByPrimaryKey(CarSelfPO record);
}