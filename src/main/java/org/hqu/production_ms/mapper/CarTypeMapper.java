package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarType;
import org.hqu.production_ms.domain.CarTypeExample;
import org.hqu.production_ms.domain.po.CarTypePO;

public interface CarTypeMapper {
	//扩展的mapper接口方法
	int deleteBatch(int[] ids);
	
	List<CarType> find();
	
	List<CarType> searchCarTypeByCarTypeBand(String brand);

	List<CarType> searchCarTypeByCarTypeNums(int checkNums);

	List<CarType> searchCarTypeByCarTypeCarXH(String carXH);
	//逆向工程生成的mapper接口
	
    int countByExample(CarTypeExample example);

    int deleteByExample(CarTypeExample example);

    int deleteByPrimaryKey(Integer typeid);

	int insert(CarTypePO carType);
	
    int insertSelective(CarType record);

    List<CarType> selectByExample(CarTypeExample example);

    CarType selectByPrimaryKey(Integer typeid);

    int updateByExampleSelective(@Param("record") CarType record, @Param("example") CarTypeExample example);

    int updateByExample(@Param("record") CarType record, @Param("example") CarTypeExample example);

    int updateByPrimaryKeySelective(CarType record);

	CarType selectSingleCarType(int carTypeId);

	int updateByPrimaryKey(CarTypePO carType);

	int updateByPrimaryKeySelective(CarTypePO carType);

}