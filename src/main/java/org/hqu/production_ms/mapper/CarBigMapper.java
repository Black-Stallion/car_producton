package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarBig;
import org.hqu.production_ms.domain.CarBigExample;
import org.hqu.production_ms.domain.po.CarBigPO;

public interface CarBigMapper {
	//扩展的mapper接口方法
		int deleteBatch(int[] ids);
		
		List<CarBig> find();
		
		List<CarBig> find1(String id);
		
		List<CarBig> searchCarBigByCarBig1(String brand);

		List<CarBig> searchCarBigByCarBig2(String carXH);
		List<CarBig> searchCarBigByCarBig1s(String id,String brand);

		List<CarBig> searchCarBigByCarBig2s(String id,String carXH);
		
		List<CarBig> searchCarBigByCarCarID(int carXH);
		
		CarBig selectSingleCarBig(int carTypeId);
		//逆向工程生成的mapper接口
    int countByExample(CarBigExample example);

    int deleteByExample(CarBigExample example);

    int deleteByPrimaryKey(Integer bigId);

    int insert(CarBigPO record);

    int insertSelective(CarBig record);

    List<CarBig> selectByExample(CarBigExample example);

    CarBig selectByPrimaryKey(Integer bigId);

    int updateByExampleSelective(@Param("record") CarBig record, @Param("example") CarBigExample example);

    int updateByExample(@Param("record") CarBig record, @Param("example") CarBigExample example);

    int updateByPrimaryKeySelective(CarBigPO record);

    int updateByPrimaryKey(CarBigPO record);
}