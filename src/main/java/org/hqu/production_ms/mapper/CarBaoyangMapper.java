package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarBaoyang;
import org.hqu.production_ms.domain.CarBaoyangExample;
import org.hqu.production_ms.domain.po.CarBaoyangPO;

public interface CarBaoyangMapper {
	//扩展的mapper接口方法
		int deleteBatch(int[] ids);
		
		List<CarBaoyang> find();
		
		List<CarBaoyang> find1(String id);
		CarBaoyang find2(Integer id);
		
		List<CarBaoyang> searchCarBaoyangByCheckyear (int year);

		List<CarBaoyang> searchCarBaoyangByCarBaoyangCarId (String carnumber);
		
		CarBaoyang selectSingleCarBaoyang(int checkId);
		
		 int updateById(CarBaoyangPO record);
		
    int countByExample(CarBaoyangExample example);

    int deleteByExample(CarBaoyangExample example);

    int deleteByPrimaryKey(Integer baoyangId);

    int insert(CarBaoyangPO record);

    int insertSelective(CarBaoyang record);

    List<CarBaoyang> selectByExample(CarBaoyangExample example);

    CarBaoyang selectByPrimaryKey(Integer baoyangId);

    int updateByExampleSelective(@Param("record") CarBaoyang record, @Param("example") CarBaoyangExample example);

    int updateByExample(@Param("record") CarBaoyang record, @Param("example") CarBaoyangExample example);

    int updateByPrimaryKeySelective(CarBaoyangPO record);

    int updateByPrimaryKey(CarBaoyangPO record);
}