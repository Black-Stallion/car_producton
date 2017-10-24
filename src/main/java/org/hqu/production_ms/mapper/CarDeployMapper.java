package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarDeploy;
import org.hqu.production_ms.domain.CarDeployExample;
import org.hqu.production_ms.domain.po.CarDeployPO;

public interface CarDeployMapper {
	int deleteBatch(int[] ids);
	
	List<CarDeploy> find();
	
	List<CarDeploy> find1(String id);
	
	List<CarDeploy> searchCarDeployByCarDeployDriverfrom(String brand);

	List<CarDeploy> searchCarDeployByCarDeployAA(String checkNums);
	
	List<CarDeploy> searchCarDeployByCarDeployDriverfrom1(String id,String brand);

	List<CarDeploy> searchCarDeployByCarDeployAA1(String id,String checkNums);
	
	CarDeploy selectSingleCarDeploy(int carDieId);
	
    int countByExample(CarDeployExample example);

    int deleteByExample(CarDeployExample example);

    int deleteByPrimaryKey(Integer deployId);

    int insert(CarDeployPO record);

    int insertSelective(CarDeploy record);

    List<CarDeploy> selectByExample(CarDeployExample example);

    CarDeploy selectByPrimaryKey(Integer deployId);

    int updateByExampleSelective(@Param("record") CarDeploy record, @Param("example") CarDeployExample example);

    int updateByExample(@Param("record") CarDeploy record, @Param("example") CarDeployExample example);

    int updateByPrimaryKeySelective(CarDeployPO record);

    int updateByPrimaryKey(CarDeployPO record);
}