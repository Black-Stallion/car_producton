package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarUsing;

import org.hqu.production_ms.domain.CarUsingExample;
import org.hqu.production_ms.domain.po.CarUsingPO;

public interface CarUsingMapper {
	//扩展的mapper接口方法
		int deleteBatch(int[] ids);
		
		List<CarUsing> find();
		
		List<CarUsing> find1(String id);
		
		List<CarUsing> searchCarUsingByUsingyear (int year);
		
		List<CarUsing> searchCarUsingBy1 (String year);
		List<CarUsing> searchCarUsingBy2 (String year);
		List<CarUsing> searchCarUsingBy1s (String id,String year);
		List<CarUsing> searchCarUsingBy2s (String id,String year);

		List<CarUsing> searchCarUsingByCarUsingCarId (int carnumber);
		
		CarUsing selectSingleCarUsing(int usingId);
	
	
	
	//逆向工程生成的mapper接口
    int countByExample(CarUsingExample example);

    int deleteByExample(CarUsingExample example);

    int deleteByPrimaryKey(Integer usingId);

    int insert(CarUsingPO record);

    int insertSelective(CarUsing record);

    List<CarUsing> selectByExample(CarUsingExample example);

    CarUsing selectByPrimaryKey(Integer usingId);

    int updateByExampleSelective(@Param("record") CarUsing record, @Param("example") CarUsingExample example);

    int updateByExample(@Param("record") CarUsing record, @Param("example") CarUsingExample example);

    int updateByPrimaryKeySelective(CarUsing record);

    int updateByPrimaryKey(CarUsing record);
    
    int updateByPrimaryKey(CarUsingPO carUsing);

	int updateByPrimaryKeySelective(CarUsingPO carUsing);
}