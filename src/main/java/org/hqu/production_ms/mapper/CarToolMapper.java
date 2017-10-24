package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarTool;
import org.hqu.production_ms.domain.CarToolExample;
import org.hqu.production_ms.domain.po.CarToolPO;

public interface CarToolMapper {
	//扩展的mapper接口方法
		int deleteBatch(int[] ids);
		
		List<CarTool> find();
		
		List<CarTool> find1(String id);
		List<CarTool> find2(String id);
		
		List<CarTool> searchCarToolByCarToolDriverfrom(String brand);

		CarTool selectSingleCarTool(int carToolId);
			//逆向工程生成的mapper接口
    int countByExample(CarToolExample example);

    int deleteByExample(CarToolExample example);

    int deleteByPrimaryKey(Integer toolId);

    int insert(CarToolPO record);

    int insertSelective(CarTool record);

    List<CarTool> selectByExample(CarToolExample example);

    CarTool selectByPrimaryKey(Integer toolId);

    int updateByExampleSelective(@Param("record") CarTool record, @Param("example") CarToolExample example);

    int updateByExample(@Param("record") CarTool record, @Param("example") CarToolExample example);

    int updateByPrimaryKeySelective(CarToolPO record);

    int updateByPrimaryKey(CarToolPO record);
}