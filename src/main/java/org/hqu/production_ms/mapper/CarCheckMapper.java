package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarCheck;
import org.hqu.production_ms.domain.CarCheckExample;
import org.hqu.production_ms.domain.po.CarCheckPO;

public interface CarCheckMapper {
	//扩展的mapper接口方法
	int deleteBatch(int[] ids);
	
	List<CarCheck> find();
	List<CarCheck> find1(String id);
	
	List<CarCheck> searchCarCheckByCheckyear (int year);
	List<CarCheck> searchCarCheckBy1 (String year);
	List<CarCheck> searchCarCheckBy2 (String year);
	List<CarCheck> searchCarCheckBy1s (String year,String id);
	List<CarCheck> searchCarCheckBy2s (String year,String id);

	List<CarCheck> searchCarCheckByCarCheckCarId (int carnumber);
	
	CarCheck selectSingleCarCheck(int checkId);
		
		
		//逆向工程生成的mapper接口
    int countByExample(CarCheckExample example);

    int deleteByExample(CarCheckExample example);

    int deleteByPrimaryKey(Integer checkId);

    int insert(CarCheckPO record);

    int insertSelective(CarCheck record);

    List<CarCheck> selectByExample(CarCheckExample example);

    CarCheck selectByPrimaryKey(Integer checkId);

    int updateByExampleSelective(@Param("record") CarCheck record, @Param("example") CarCheckExample example);

    int updateByExample(@Param("record") CarCheck record, @Param("example") CarCheckExample example);

    int updateByPrimaryKeySelective(CarCheck record);

    int updateByPrimaryKey(CarCheck record);
    
    int updateByPrimaryKey(CarCheckPO carCheck);

   	int updateByPrimaryKeySelective(CarCheckPO carCheck);
}