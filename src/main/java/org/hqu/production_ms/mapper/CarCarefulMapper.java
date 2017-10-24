package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarCareful;
import org.hqu.production_ms.domain.CarCarefulExample;
import org.hqu.production_ms.domain.po.CarCarefulPO;

public interface CarCarefulMapper {
	int deleteBatch(int[] ids);
	
	List<CarCareful> find();
	
	List<CarCareful> find1(String id);

	CarCareful selectSingleCarCareful(int carTypeId);
	
    int countByExample(CarCarefulExample example);

    int deleteByExample(CarCarefulExample example);

    int deleteByPrimaryKey(Integer carefulId);

    int insert(CarCarefulPO record);

    int insertSelective(CarCareful record);

    List<CarCareful> selectByExample(CarCarefulExample example);

    CarCareful selectByPrimaryKey(Integer carefulId);

    int updateByExampleSelective(@Param("record") CarCareful record, @Param("example") CarCarefulExample example);

    int updateByExample(@Param("record") CarCareful record, @Param("example") CarCarefulExample example);

    int updateByPrimaryKeySelective(CarCarefulPO record);

    int updateByPrimaryKey(CarCarefulPO record);
}