package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarApprove;
import org.hqu.production_ms.domain.CarApproveExample;
import org.hqu.production_ms.domain.po.CarApprovePO;

public interface CarApproveMapper {
	//扩展的mapper接口方法
			int deleteBatch(int[] ids);
			
			List<CarApprove> find(String string);
			
			List<CarApprove> find1(String name,String id);
			List<CarApprove> find2(String name,String id,String id2);
			
			List<CarApprove> findByDepartment();
			
			List<CarApprove> getXX();
			
			List<CarApprove> searchCarApproveByCarApproveDriverfrom(String brand);

			List<CarApprove> searchCarApproveByCarApproveAA(String checkNums);

			List<CarApprove> searchCarApproveByCarApproveName(String carXH);
			
			CarApprove selectSingleCarApprove(int applyId);
			//逆向工程生成的mapper接口
	    int countByExample(CarApproveExample example);

	    int deleteByExample(CarApproveExample example);

	    int deleteByPrimaryKey(Integer applyId);

	    int insert(CarApprovePO record);

	    int insertSelective(CarApprove record);

	    List<CarApprove> selectByExample(CarApproveExample example);

	    CarApprove selectByPrimaryKey(Integer applyId);

	    int updateByExampleSelective(@Param("record") CarApprove record, @Param("example") CarApproveExample example);

	    int updateByExample(@Param("record") CarApprove record, @Param("example") CarApproveExample example);

	    int updateByPrimaryKeySelective(CarApprovePO record);

	    int updateByPrimaryKey(CarApprovePO record);
	    int updateById(CarApprovePO record);
}
