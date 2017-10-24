package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarWD;
import org.hqu.production_ms.domain.CarWDExample;

public interface CarWDMapper {
	List<CarWD> find1(String id,String id2,String di2);
    int countByExample(CarWDExample example);

    int deleteByExample(CarWDExample example);

    int insert(CarWD record);

    int insertSelective(CarWD record);

    List<CarWD> selectByExample(CarWDExample example);

    int updateByExampleSelective(@Param("record") CarWD record, @Param("example") CarWDExample example);

    int updateByExample(@Param("record") CarWD record, @Param("example") CarWDExample example);
}