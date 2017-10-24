package org.hqu.production_ms.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarWbtj;
import org.hqu.production_ms.domain.CarWbtjExample;
import org.hqu.production_ms.domain.po.CarWbtjPO;

public interface CarWbtjMapper {
	//扩展的mapper接口方法
		int deleteBatch(int[] ids);
		
		List<CarWbtj> find(String id);
		
		List<CarWbtj> find1();
		
		List<CarWbtj> findByNature(String string);
		List<CarWbtj> get();
		
		List<CarWbtj> searchCarWbtjByCarWbtj1(String brand);

		List<CarWbtj> searchCarWbtjByCarWbtj2(String checkNums);

		List<CarWbtj> searchCarWbtjByCarWbtj3(String carXH,String st);
		
		List<CarWbtj> searchCarWbtjByCarWbtj4(String carXH,String st,String st1);
		
		List<CarWbtj> searchCarWbtjByCarWbtj5(String carXH);
		
		List<CarWbtj> searchCarWbtjByCarWbtj6(String brand,String st);

		List<CarWbtj> searchCarWbtjByCarWbtj7(String checkNums,String st);

		List<CarWbtj> searchCarWbtjByCarWbtj8(String carXH,String st,String str);
		
		List<CarWbtj> searchCarWbtjByCarWbtj9(String carXH,String st,String str,String str1);
		List<CarWbtj> searchCarWbtjByCarWbtj11(String carXH,String st,String str);
		
		List<CarWbtj> searchCarWbtjByCarWbtj10(String carXH,String st);
		
		CarWbtj selectSingleCarWbtj(int carId);
		//逆向工程生成的mapper接口
	    int countByExample(CarWbtjExample example);

	    int deleteByExample(CarWbtjExample example);

	    int deleteByPrimaryKey(Integer carId);

	    int insert(CarWbtjPO record);

	    int insertSelective(CarWbtj record);

	    List<CarWbtj> selectByExample(CarWbtjExample example);

	    CarWbtj selectByPrimaryKey(Integer carId);

	    int updateByExampleSelective(@Param("record") CarWbtj record, @Param("example") CarWbtjExample example);

	    int updateByExample(@Param("record") CarWbtj record, @Param("example") CarWbtjExample example);

	    int updateByPrimaryKeySelective(CarWbtjPO record);

	    int updateByPrimaryKey(CarWbtjPO record);
}
