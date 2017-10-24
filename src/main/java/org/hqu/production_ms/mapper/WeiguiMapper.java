package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.Weigui;
import org.hqu.production_ms.domain.WeiguiExample;
import org.hqu.production_ms.domain.po.WeiguiPO;

public interface WeiguiMapper {
	
	//扩展的mapper接口方法
		int deleteBatch(int[] ids);
		
		List<Weigui> find();
		
		List<Weigui> find1(String id);
		
		List<Weigui> searchWeiguiBydrivernum (String drivernum);

		List<Weigui> searchWeiguiBycarnum (int carnum);
		
		Weigui selectSingleWeigui(int driveCheckId);
		
		
    int countByExample(WeiguiExample example);

    int deleteByExample(WeiguiExample example);

    int deleteByPrimaryKey(Integer weiguiId);

    int insert(WeiguiPO record);

    int insertSelective(Weigui record);

    List<Weigui> selectByExample(WeiguiExample example);

    Weigui selectByPrimaryKey(Integer weiguiId);

    int updateByExampleSelective(@Param("record") Weigui record, @Param("example") WeiguiExample example);

    int updateByExample(@Param("record") Weigui record, @Param("example") WeiguiExample example);

    int updateByPrimaryKeySelective(Weigui record);

    int updateByPrimaryKey(Weigui record);
    
    int updateByPrimaryKey(WeiguiPO weigui);

   	int updateByPrimaryKeySelective(WeiguiPO weigui);
}