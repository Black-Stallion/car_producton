package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarYouapply;
import org.hqu.production_ms.domain.CarYouapplyExample;
import org.hqu.production_ms.domain.po.CarYouapplyPO;

public interface CarYouapplyMapper {
	int deleteBatch(int[] ids);
	
	List<CarYouapply> find();
	
	List<CarYouapply> find1(String id);
	
	List<CarYouapply> searchCarYouapplyByCarYouapplyDriverfrom(String brand);

	List<CarYouapply> searchCarYouapplyByCarYouapplyAA(String checkNums);

	List<CarYouapply> searchCarYouapplyByCarYouapplyDriverfrom1(String id,String brand);

	List<CarYouapply> searchCarYouapplyByCarYouapplyAA1(String id,String checkNums);
	
	CarYouapply selectSingleCarYouapply(int applyId);
	//逆向工程生成的mapper接口
    int countByExample(CarYouapplyExample example);

    int deleteByExample(CarYouapplyExample example);

    int deleteByPrimaryKey(Integer yapplyId);

    int insert(CarYouapplyPO record);

    int insertSelective(CarYouapply record);

    List<CarYouapply> selectByExample(CarYouapplyExample example);

    CarYouapply selectByPrimaryKey(Integer yapplyId);

    int updateByExampleSelective(@Param("record") CarYouapply record, @Param("example") CarYouapplyExample example);

    int updateByExample(@Param("record") CarYouapply record, @Param("example") CarYouapplyExample example);

    int updateByPrimaryKeySelective(CarYouapplyPO record);

    int updateByPrimaryKey(CarYouapplyPO record);
}