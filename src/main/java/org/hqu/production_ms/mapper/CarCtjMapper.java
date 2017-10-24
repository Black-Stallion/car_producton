package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarCtj;
import org.hqu.production_ms.domain.CarCtjExample;
import org.hqu.production_ms.domain.po.CarCtjPO;

public interface CarCtjMapper {
	//扩展的mapper接口方法
		int deleteBatch(int[] ids);
		
		List<CarCtj> find(String id);
		
		List<CarCtj> find1();
		
		List<CarCtj> findByNature(String string);
		List<CarCtj> get();
		
		List<CarCtj> searchCarCtjByCarCtj1(String brand);

		List<CarCtj> searchCarCtjByCarCtj2(String checkNums);

		List<CarCtj> searchCarCtjByCarCtj3(String carXH,String st);
		
		List<CarCtj> searchCarCtjByCarCtj4(String carXH,String st,String st2);
		
		List<CarCtj> searchCarCtjByCarCtj5(String carXH);
		
		List<CarCtj> searchCarCtjByCarCtj6(String brand,String st);

		List<CarCtj> searchCarCtjByCarCtj7(String checkNums,String st);

		List<CarCtj> searchCarCtjByCarCtj8(String carXH,String st,String str);
		
		List<CarCtj> searchCarCtjByCarCtj9(String carXH,String st,String str,String str3);
		List<CarCtj> searchCarCtjByCarCtj11(String carXH,String st,String str);
		
		List<CarCtj> searchCarCtjByCarCtj10(String carXH,String st);
		
		CarCtj selectSingleCarCtj(int carId);
		//逆向工程生成的mapper接口
	    int countByExample(CarCtjExample example);

	    int deleteByExample(CarCtjExample example);

	    int deleteByPrimaryKey(Integer carId);

	    int insert(CarCtjPO record);

	    int insertSelective(CarCtj record);

	    List<CarCtj> selectByExample(CarCtjExample example);

	    CarCtj selectByPrimaryKey(Integer carId);

	    int updateByExampleSelective(@Param("record") CarCtj record, @Param("example") CarCtjExample example);

	    int updateByExample(@Param("record") CarCtj record, @Param("example") CarCtjExample example);

	    int updateByPrimaryKeySelective(CarCtjPO record);

	    int updateByPrimaryKey(CarCtjPO record);
}
