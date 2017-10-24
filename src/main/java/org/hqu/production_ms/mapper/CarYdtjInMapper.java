package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarYdtjIn;
import org.hqu.production_ms.domain.CarYdtjInExample;
import org.hqu.production_ms.domain.po.CarYdtjInPO;

public interface CarYdtjInMapper {
	//扩展的mapper接口方法
		int deleteBatch(int[] ids);
		
		List<CarYdtjIn> find(String id);
		
		List<CarYdtjIn> find1();
		
		List<CarYdtjIn> findByNature(String string);
		List<CarYdtjIn> get();
		
		List<CarYdtjIn> searchCarYdtjInByCarYdtj1(String year);

		List<CarYdtjIn> searchCarYdtjInByCarYdtj2(String carXH,String st);

		List<CarYdtjIn> searchCarYdtjInByCarYdtj3(String carXH);
		List<CarYdtjIn> searchCarYdtjInByCarYdtj4(String carXH,String st);

		List<CarYdtjIn> searchCarYdtjInByCarYdtj5(String carXH,String st,String str);
		
		CarYdtjIn selectSingleCarYdtj(int carId);
		//逆向工程生成的mapper接口
	    int countByExample(CarYdtjInExample example);

	    int deleteByExample(CarYdtjInExample example);

	    int deleteByPrimaryKey(Integer carId);

	    int insert(CarYdtjInPO record);

	    int insertSelective(CarYdtjIn record);

	    List<CarYdtjIn> selectByExample(CarYdtjInExample example);

	    CarYdtjIn selectByPrimaryKey(Integer carId);

	    int updateByExampleSelective(@Param("record") CarYdtjIn record, @Param("example") CarYdtjInExample example);

	    int updateByExample(@Param("record") CarYdtjIn record, @Param("example") CarYdtjInExample example);

	    int updateByPrimaryKeySelective(CarYdtjInPO record);

	    int updateByPrimaryKey(CarYdtjInPO record);
}
