package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarDie;
import org.hqu.production_ms.domain.CarDieExample;
import org.hqu.production_ms.domain.po.CarDiePO;

public interface CarDieMapper {
	//扩展的mapper接口方法
	int deleteBatch(int[] ids);
	
	List<CarDie> find();
	List<CarDie> find1(String id);
	
	List<CarDie> searchCarDieByCarDieDriverfrom(String brand);

	List<CarDie> searchCarDieByCarDieAA(String checkNums);

	List<CarDie> searchCarDieByCarDieName(String carXH);
	
	CarDie selectSingleCarDie(int carDieId);
		//逆向工程生成的mapper接口
    int countByExample(CarDieExample example);

    int deleteByExample(CarDieExample example);

    int deleteByPrimaryKey(Integer dieId);

    int insert(CarDiePO record);

    int insertSelective(CarDie record);

    List<CarDie> selectByExample(CarDieExample example);

    CarDie selectByPrimaryKey(Integer dieId);

    int updateByExampleSelective(@Param("record") CarDie record, @Param("example") CarDieExample example);

    int updateByExample(@Param("record") CarDie record, @Param("example") CarDieExample example);

    int updateByPrimaryKeySelective(CarDiePO record);

    int updateByPrimaryKey(CarDiePO record);
}