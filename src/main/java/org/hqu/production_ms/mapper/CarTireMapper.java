package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarTire;
import org.hqu.production_ms.domain.CarTireExample;
import org.hqu.production_ms.domain.po.CarTirePO;

public interface CarTireMapper {
	//扩展的mapper接口方法
			int deleteBatch(int[] ids);
			
			List<CarTire> find();
			List<CarTire> find1(String id);
			
			List<CarTire> searchCarTireByCarTireBand(String brand);

			List<CarTire> searchCarTireByCarTireNums(int checkNums);

			List<CarTire> searchCarTireByCarTireCarXH(String carXH);
			
			CarTire selectSingleCarTire(int carTypeId);
			//逆向工程生成的mapper接口
    int countByExample(CarTireExample example);

    int deleteByExample(CarTireExample example);

    int deleteByPrimaryKey(Integer tireId);

    int insert(CarTirePO record);

    int insertSelective(CarTire record);

    List<CarTire> selectByExample(CarTireExample example);

    CarTire selectByPrimaryKey(Integer tireId);

    int updateByExampleSelective(@Param("record") CarTire record, @Param("example") CarTireExample example);

    int updateByExample(@Param("record") CarTire record, @Param("example") CarTireExample example);

    int updateByPrimaryKeySelective(CarTirePO record);

    int updateByPrimaryKey(CarTirePO record);
}