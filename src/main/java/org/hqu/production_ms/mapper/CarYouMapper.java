package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarYou;
import org.hqu.production_ms.domain.CarYouExample;
import org.hqu.production_ms.domain.po.CarYouPO;

public interface CarYouMapper {
	//扩展的mapper接口方法
			int deleteBatch(int[] ids);
			
			List<CarYou> find();
			
			List<CarYou> find1(String id);
			
			List<CarYou> find3();
			
			List<CarYou> find4(String id);
			
			List<CarYou> find5();
			
			List<CarYou> find6(String id);
			
			List<CarYou> searchCarYouByCarYouDriverfrom(String brand);
			List<CarYou> searchCarYouByCarYouDriverfrom1(String id,String brand);

			CarYou selectSingleCarYou(int applyId);
			CarYou selectSingleCarYou1(String applyId);
			
	int updateByYouId(CarYou record);
			
    int countByExample(CarYouExample example);

    int deleteByExample(CarYouExample example);

    int deleteByPrimaryKey(Integer youId);

    int insert(CarYouPO record);

    int insertSelective(CarYou record);

    List<CarYou> selectByExample(CarYouExample example);

    CarYou selectByPrimaryKey(Integer youId);

    int updateByExampleSelective(@Param("record") CarYou record, @Param("example") CarYouExample example);

    int updateByExample(@Param("record") CarYou record, @Param("example") CarYouExample example);

    int updateByPrimaryKeySelective(CarYouPO record);

    int updateByPrimaryKey(CarYouPO record);

	int updateById(CarYouPO carYou);
}