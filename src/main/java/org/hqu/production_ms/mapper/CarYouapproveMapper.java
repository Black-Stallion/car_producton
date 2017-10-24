package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarYouapprove;
import org.hqu.production_ms.domain.CarYouapproveExample;
import org.hqu.production_ms.domain.po.CarYouapprovePO;

public interface CarYouapproveMapper {
	
	int deleteBatch(int[] ids);
	
	List<CarYouapprove> find(String string);
	
	List<CarYouapprove> find1(String name,String id);
	
	CarYouapprove selectSingleCarYouapprove(int yapplyId);
	
	List<CarYouapprove> searchCarYouapproveByCarYouapproveDriverfrom(String brand,String name);

	List<CarYouapprove> searchCarYouapproveByCarYouapproveAA(String checkNums,String name);
	
	List<CarYouapprove> searchCarYouapproveByCarYouapproveDriverfrom1(String id,String brand,String name);

	List<CarYouapprove> searchCarYouapproveByCarYouapproveAA1(String id,String checkNums,String name);
	
	int updateById(CarYouapprovePO record);
	
    int countByExample(CarYouapproveExample example);

    int deleteByExample(CarYouapproveExample example);

    int deleteByPrimaryKey(Integer yapplyId);

    int insert(CarYouapprovePO record);

    int insertSelective(CarYouapprove record);

    List<CarYouapprove> selectByExample(CarYouapproveExample example);

    CarYouapprove selectByPrimaryKey(Integer yapplyId);

    int updateByExampleSelective(@Param("record") CarYouapprove record, @Param("example") CarYouapproveExample example);

    int updateByExample(@Param("record") CarYouapprove record, @Param("example") CarYouapproveExample example);

    int updateByPrimaryKeySelective(CarYouapprovePO record);

    int updateByPrimaryKey(CarYouapprovePO record);
}