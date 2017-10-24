package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.Shigu;
import org.hqu.production_ms.domain.ShiguExample;
import org.hqu.production_ms.domain.po.ShiguPO;

public interface ShiguMapper {
	
	
	//扩展的mapper接口方法
		int deleteBatch(int[] ids);
		
		List<Shigu> find();
		
		List<Shigu> find1(String id);
		
		List<Shigu> searchShiguBycode (int code);

		List<Shigu> searchShiguBycarnum (String carnum);
		
		Shigu selectSingleShigu(int driveCheckId);
		
		
    int countByExample(ShiguExample example);

    int deleteByExample(ShiguExample example);

    int deleteByPrimaryKey(Integer shiguId);

    int insert(ShiguPO record);

    int insertSelective(Shigu record);

    List<Shigu> selectByExample(ShiguExample example);

    Shigu selectByPrimaryKey(Integer shiguId);

    int updateByExampleSelective(@Param("record") Shigu record, @Param("example") ShiguExample example);

    int updateByExample(@Param("record") Shigu record, @Param("example") ShiguExample example);

    int updateByPrimaryKeySelective(Shigu record);

    int updateByPrimaryKey(Shigu record);
    
    int updateByPrimaryKey(ShiguPO shigu);

   	int updateByPrimaryKeySelective(ShiguPO shigu);
}