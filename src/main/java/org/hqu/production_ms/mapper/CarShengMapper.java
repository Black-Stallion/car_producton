package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarSheng;
import org.hqu.production_ms.domain.CarShengExample;
import org.hqu.production_ms.domain.po.CarShengPO;

public interface CarShengMapper {
	//扩展的mapper接口方法
		int deleteBatch(int[] ids);
		
		List<CarSheng> find();
		
		List<CarSheng> find1(String id);
		
		List<CarSheng> findByNature(String string);
		List<CarSheng> get();
		
		List<CarSheng> searchCarShengByCarShengDriverfrom(String brand);

		List<CarSheng> searchCarShengByCarShengAA(String checkNums);

		List<CarSheng> searchCarShengByCarShengName(String carXH);
		CarSheng findByCarNumber(String id);
		
		CarSheng selectSingleCarSheng(int carId);
		//逆向工程生成的mapper接口
	    int countByExample(CarShengExample example);

	    int deleteByExample(CarShengExample example);

	    int deleteByPrimaryKey(Integer carId);

	    int insert(CarShengPO record);

	    int insertSelective(CarSheng record);

	    List<CarSheng> selectByExample(CarShengExample example);

	    CarSheng selectByPrimaryKey(Integer carId);

	    int updateByExampleSelective(@Param("record") CarSheng record, @Param("example") CarShengExample example);

	    int updateByExample(@Param("record") CarSheng record, @Param("example") CarShengExample example);

	    int updateByPrimaryKeySelective(CarShengPO record);

	    int updateByPrimaryKey(CarShengPO record);
}
