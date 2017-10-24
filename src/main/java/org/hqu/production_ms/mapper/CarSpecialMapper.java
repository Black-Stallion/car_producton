package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarSpecial;
import org.hqu.production_ms.domain.CarSpecialExample;
import org.hqu.production_ms.domain.po.CarSpecialPO;

public interface CarSpecialMapper {
	//扩展的mapper接口方法
		int deleteBatch(int[] ids);
		
		List<CarSpecial> find();
		
		List<CarSpecial> find1(String id);
		
		List<CarSpecial> findByNature(String string);
		List<CarSpecial> get();
		
		List<CarSpecial> searchCarSpecialByCarSpecialDriverfrom(String brand);

		List<CarSpecial> searchCarSpecialByCarSpecialAA(String checkNums);

		List<CarSpecial> searchCarSpecialByCarSpecialName(String carXH);
		
		CarSpecial findByCarNumber(String id);
		
		CarSpecial selectSingleCarSpecial(int carId);
		//逆向工程生成的mapper接口
	    int countByExample(CarSpecialExample example);

	    int deleteByExample(CarSpecialExample example);

	    int deleteByPrimaryKey(Integer carId);

	    int insert(CarSpecialPO record);

	    int insertSelective(CarSpecial record);

	    List<CarSpecial> selectByExample(CarSpecialExample example);

	    CarSpecial selectByPrimaryKey(Integer carId);

	    int updateByExampleSelective(@Param("record") CarSpecial record, @Param("example") CarSpecialExample example);

	    int updateByExample(@Param("record") CarSpecial record, @Param("example") CarSpecialExample example);

	    int updateByPrimaryKeySelective(CarSpecialPO record);

	    int updateByPrimaryKey(CarSpecialPO record);
}
