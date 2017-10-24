package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.DriverStudey;

import org.hqu.production_ms.domain.DriverStudeyExample;
import org.hqu.production_ms.domain.po.DriverStudeyPO;

public interface DriverStudeyMapper {
	
	//扩展的mapper接口方法
	int deleteBatch(int[] ids);
	
	List<DriverStudey> find();
	
	List<DriverStudey> find1(String id);
	
	DriverStudey selectSingleDriverStudey(int studyId);
		
		
		//逆向工程生成的mapper接口
    int countByExample(DriverStudeyExample example);

    int deleteByExample(DriverStudeyExample example);

    int deleteByPrimaryKey(Integer studyId);

    int insert(DriverStudeyPO record);

    int insertSelective(DriverStudey record);

    List<DriverStudey> selectByExample(DriverStudeyExample example);

    DriverStudey selectByPrimaryKey(Integer studyId);

    int updateByExampleSelective(@Param("record") DriverStudey record, @Param("example") DriverStudeyExample example);

    int updateByExample(@Param("record") DriverStudey record, @Param("example") DriverStudeyExample example);

    int updateByPrimaryKeySelective(DriverStudey record);

    int updateByPrimaryKey(DriverStudey record);
    
    int updateByPrimaryKey(DriverStudeyPO driverStudey);

   	int updateByPrimaryKeySelective(DriverStudeyPO driverStudey);
}