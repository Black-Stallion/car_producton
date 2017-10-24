package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarWE;
import org.hqu.production_ms.domain.CarWEExample;

public interface CarWEMapper {
	List<CarWE> find1(String id,String id2,String di2);
    int countByExample(CarWEExample example);

    int deleteByExample(CarWEExample example);

    int insert(CarWE record);

    int insertSelective(CarWE record);

    List<CarWE> selectByExample(CarWEExample example);

    int updateByExampleSelective(@Param("record") CarWE record, @Param("example") CarWEExample example);

    int updateByExample(@Param("record") CarWE record, @Param("example") CarWEExample example);
}