package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarYdtjOut;
import org.hqu.production_ms.domain.CarYdtjOutExample;
import org.hqu.production_ms.domain.po.CarYdtjOutPO;

public interface CarYdtjOutMapper {
	//扩展的mapper接口方法
		int deleteBatch(int[] ids);
		
		List<CarYdtjOut> find(String id);
		
		List<CarYdtjOut> find1();
		
		List<CarYdtjOut> findByNature(String string);
		List<CarYdtjOut> get();
		
		List<CarYdtjOut> searchCarYdtjOutByCarYdtj1(String brand);

		List<CarYdtjOut> searchCarYdtjOutByCarYdtj2(String carXH,String st);
		
		List<CarYdtjOut> searchCarYdtjOutByCarYdtj3(String carXH);
		
		List<CarYdtjOut> searchCarYdtjOutByCarYdtj4(String brand,String st);

		List<CarYdtjOut> searchCarYdtjOutByCarYdtj5(String carXH,String st,String str);
		
		CarYdtjOut selectSingleCarYdtj(int carId);
		//逆向工程生成的mapper接口
	    int countByExample(CarYdtjOutExample example);

	    int deleteByExample(CarYdtjOutExample example);

	    int deleteByPrimaryKey(Integer carId);

	    int insert(CarYdtjOutPO record);

	    int insertSelective(CarYdtjOut record);

	    List<CarYdtjOut> selectByExample(CarYdtjOutExample example);

	    CarYdtjOut selectByPrimaryKey(Integer carId);

	    int updateByExampleSelective(@Param("record") CarYdtjOut record, @Param("example") CarYdtjOutExample example);

	    int updateByExample(@Param("record") CarYdtjOut record, @Param("example") CarYdtjOutExample example);

	    int updateByPrimaryKeySelective(CarYdtjOutPO record);

	    int updateByPrimaryKey(CarYdtjOutPO record);
}
