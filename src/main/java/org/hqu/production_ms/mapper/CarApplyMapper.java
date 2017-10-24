package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarApply;
import org.hqu.production_ms.domain.CarApplyExample;
import org.hqu.production_ms.domain.po.CarApplyPO;

public interface CarApplyMapper {
	//扩展的mapper接口方法
		int deleteBatch(int[] ids);
		List<CarApply> find(String id2);
		List<CarApply> finds(String id,String id2);
		List<CarApply> find4();
		List<CarApply> find2s(String id,String id2);
		List<CarApply> findb();
		List<CarApply> find2(String id);
		
		List<CarApply> findByDepartment();
		
		CarApply findByBian(String string);
		
		List<CarApply> getXX();
		
		List<CarApply> searchCarApplyByCarApplyDriverfrom(String brand);

		List<CarApply> searchCarApplyByCarApplyAA(String checkNums);

		List<CarApply> searchCarApplyByCarApplyName(String carXH);
		
		List<CarApply> searchCarApplyByCarApplyDriverfrom1(String id,String brand);

		List<CarApply> searchCarApplyByCarApplyAA1(String id,String checkNums);

		List<CarApply> searchCarApplyByCarApplyName1(String id,String carXH);
		
		CarApply selectSingleCarApply(int applyId);
		//逆向工程生成的mapper接口
    int countByExample(CarApplyExample example);

    int deleteByExample(CarApplyExample example);

    int deleteByPrimaryKey(Integer applyId);

    int insert(CarApplyPO record);

    int insertSelective(CarApply record);

    List<CarApply> selectByExample(CarApplyExample example);

    CarApply selectByPrimaryKey(Integer applyId);

    int updateByExampleSelective(@Param("record") CarApply record, @Param("example") CarApplyExample example);

    int updateByExample(@Param("record") CarApply record, @Param("example") CarApplyExample example);

    int updateByPrimaryKeySelective(CarApplyPO record);

    int updateByPrimaryKey(CarApplyPO record);
}