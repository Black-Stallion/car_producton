package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarYdtjSelf;
import org.hqu.production_ms.domain.CarYdtjSelfExample;
import org.hqu.production_ms.domain.po.CarYdtjSelfPO;

public interface CarYdtjSelfMapper {
	//扩展的mapper接口方法
		int deleteBatch(int[] ids);
		
		List<CarYdtjSelf> find(String id);
		
		List<CarYdtjSelf> find1();
		
		List<CarYdtjSelf> findByNature(String string);
		List<CarYdtjSelf> get();
		
		List<CarYdtjSelf> searchCarYdtjSelfByCarYdtj1(String brand);

		List<CarYdtjSelf> searchCarYdtjSelfByCarYdtj2(String carXH,String st);
		
		List<CarYdtjSelf> searchCarYdtjSelfByCarYdtj3(String carXH);
		
		List<CarYdtjSelf> searchCarYdtjSelfByCarYdtj4(String checkNums,String st);

		List<CarYdtjSelf> searchCarYdtjSelfByCarYdtj5(String carXH,String st,String str);
		
		CarYdtjSelf selectSingleCarYdtj(int carId);
		//逆向工程生成的mapper接口
	    int countByExample(CarYdtjSelfExample example);

	    int deleteByExample(CarYdtjSelfExample example);

	    int deleteByPrimaryKey(Integer carId);

	    int insert(CarYdtjSelfPO record);

	    int insertSelective(CarYdtjSelf record);

	    List<CarYdtjSelf> selectByExample(CarYdtjSelfExample example);

	    CarYdtjSelf selectByPrimaryKey(Integer carId);

	    int updateByExampleSelective(@Param("record") CarYdtjSelf record, @Param("example") CarYdtjSelfExample example);

	    int updateByExample(@Param("record") CarYdtjSelf record, @Param("example") CarYdtjSelfExample example);

	    int updateByPrimaryKeySelective(CarYdtjSelfPO record);

	    int updateByPrimaryKey(CarYdtjSelfPO record);
}
