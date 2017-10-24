package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.DriverRecord;
import org.hqu.production_ms.domain.DriverRecordExample;
import org.hqu.production_ms.domain.po.DriverRecordPO;

public interface DriverRecordMapper {
	
	//扩展的mapper接口方法
	int deleteBatch(int[] ids);
	
	List<DriverRecord> find();
	
	List<DriverRecord> find1(String id);
	
	List<DriverRecord> searchDriverRecordBydrivernum (String drivernum);

	List<DriverRecord> searchDriverRecordBydrivername (String drivername);
	
	DriverRecord selectSingleDriverRecord(int driveRecordId);
		
		
		//逆向工程生成的mapper接口
    int countByExample(DriverRecordExample example);

    int deleteByExample(DriverRecordExample example);

    int deleteByPrimaryKey(Integer driveRecordId);

    int insert(DriverRecordPO record);

    int insertSelective(DriverRecord record);

    List<DriverRecord> selectByExample(DriverRecordExample example);

    DriverRecord selectByPrimaryKey(Integer driveRecordId);

    int updateByExampleSelective(@Param("record") DriverRecord record, @Param("example") DriverRecordExample example);

    int updateByExample(@Param("record") DriverRecord record, @Param("example") DriverRecordExample example);

    int updateByPrimaryKeySelective(DriverRecord record);

    int updateByPrimaryKey(DriverRecord record);
    
    int updateByPrimaryKey(DriverRecordPO driverRecord);

   	int updateByPrimaryKeySelective(DriverRecordPO driverRecord);
}