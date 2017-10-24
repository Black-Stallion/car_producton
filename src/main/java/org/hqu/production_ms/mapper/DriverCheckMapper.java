package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.DriverCheck;
import org.hqu.production_ms.domain.DriverCheckExample;
import org.hqu.production_ms.domain.po.DriverCheckPO;

public interface DriverCheckMapper {
	
	//扩展的mapper接口方法
		int deleteBatch(int[] ids);
		
		List<DriverCheck> find();
		List<DriverCheck> find1(String id);
		
		List<DriverCheck> searchDriverCheckBydrivernum (String drivernum);

		List<DriverCheck> searchDriverCheckBycarnum (String carnum);
		
		DriverCheck selectSingleDriverCheck(int driveCheckId);
			
			
			//逆向工程生成的mapper接口
    int countByExample(DriverCheckExample example);

    int deleteByExample(DriverCheckExample example);

    int deleteByPrimaryKey(Integer driveCheckId);

    int insert(DriverCheckPO record);

    int insertSelective(DriverCheck record);

    List<DriverCheck> selectByExample(DriverCheckExample example);

    DriverCheck selectByPrimaryKey(Integer driveCheckId);

    int updateByExampleSelective(@Param("record") DriverCheck record, @Param("example") DriverCheckExample example);

    int updateByExample(@Param("record") DriverCheck record, @Param("example") DriverCheckExample example);

    int updateByPrimaryKeySelective(DriverCheck record);

    int updateByPrimaryKey(DriverCheck record);
    
    int updateByPrimaryKey(DriverCheckPO driverCheck);

   	int updateByPrimaryKeySelective(DriverCheckPO driverCheck);
}