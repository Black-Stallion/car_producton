package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarBS;
import org.hqu.production_ms.domain.CarBSExample;

public interface CarBSMapper {
	List<CarBS> find();
	List<CarBS> find1(String id);
    int countByExample(CarBSExample example);

    int deleteByExample(CarBSExample example);

    int insert(CarBS record);

    int insertSelective(CarBS record);

    List<CarBS> selectByExample(CarBSExample example);

    int updateByExampleSelective(@Param("record") CarBS record, @Param("example") CarBSExample example);

    int updateByExample(@Param("record") CarBS record, @Param("example") CarBSExample example);
}