package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarFold;
import org.hqu.production_ms.domain.CarFoldExample;
import org.hqu.production_ms.domain.po.CarFoldPO;

public interface CarFoldMapper {
	int deleteBatch(int[] ids);
	
	List<CarFold> find();
	
	List<CarFold> find1(String id);
	
	CarFold selectSingleCarFold(int applyId);
	
	List<CarFold> searchCarFoldByCarFoldDriverfrom(String brand);

	List<CarFold> searchCarFoldByCarFoldAA(String checkNums);
	List<CarFold> searchCarFoldByCarFoldDriverfrom1(String id,String brand);

	List<CarFold> searchCarFoldByCarFoldAA1(String id,String checkNums);
	//
    int countByExample(CarFoldExample example);

    int deleteByExample(CarFoldExample example);

    int deleteByPrimaryKey(Integer foldId);

    int insert(CarFoldPO record);

    int insertSelective(CarFold record);

    List<CarFold> selectByExample(CarFoldExample example);

    CarFold selectByPrimaryKey(Integer foldId);

    int updateByExampleSelective(@Param("record") CarFold record, @Param("example") CarFoldExample example);

    int updateByExample(@Param("record") CarFold record, @Param("example") CarFoldExample example);

    int updateByPrimaryKeySelective(CarFoldPO carFold);

    int updateByPrimaryKey(CarFoldPO record);
}