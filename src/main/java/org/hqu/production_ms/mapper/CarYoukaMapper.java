package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarYouka;
import org.hqu.production_ms.domain.CarYoukaExample;
import org.hqu.production_ms.domain.po.CarYoukaPO;

public interface CarYoukaMapper {
	//扩展的mapper接口方法
			int deleteBatch(int[] ids);
			
			List<CarYouka> find();
			
			List<CarYouka> find1(String id);
			
			List<CarYouka> searchCarYoukaByCarYoukaDriverfrom(String brand);

			List<CarYouka> searchCarYoukaByCarYoukaAA(String checkNums);

			List<CarYouka> searchCarYoukaByCarYoukaDriverfrom1(String id,String brand);
			
			List<CarYouka> searchCarYoukaByCarYoukaAA1(String id,String checkNums);
			
			CarYouka selectSingleCarYouka(int applyId);
			
			CarYouka findByCarId(int carId);
	
    int countByExample(CarYoukaExample example);

    int deleteByExample(CarYoukaExample example);

    int deleteByPrimaryKey(Integer youkaId);

    int insert(CarYoukaPO record);

    int insertSelective(CarYouka record);

    List<CarYouka> selectByExample(CarYoukaExample example);

    CarYouka selectByPrimaryKey(Integer youkaId);

    int updateByExampleSelective(@Param("record") CarYouka record, @Param("example") CarYoukaExample example);

    int updateByExample(@Param("record") CarYouka record, @Param("example") CarYoukaExample example);

    int updateByPrimaryKeySelective(CarYoukaPO record);

    int updateByPrimaryKey(CarYoukaPO record);

	int updateById(CarYoukaPO carYouka);
}