package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarKeepApprove;
import org.hqu.production_ms.domain.CarKeepApproveExample;
import org.hqu.production_ms.domain.po.CarKeepApprovePO;

public interface CarKeepApproveMapper {
	//扩展的mapper接口方法
			int deleteBatch(int[] ids);
			
			List<CarKeepApprove> find(String approve);
			List<CarKeepApprove> find5();
			
			List<CarKeepApprove> find1(String id,String approve);
			
			List<CarKeepApprove> findByDepartment();
			
			CarKeepApprove findByBian(String string);
			
			List<CarKeepApprove> getXX();
			
			List<CarKeepApprove> searchCarKeepApproveByCarKeepApproveDriverfrom(String brand);

			List<CarKeepApprove> searchCarKeepApproveByCarKeepApproveAA(String checkNums);

			List<CarKeepApprove> searchCarKeepApproveByCarKeepApproveName(String carXH);
			
			CarKeepApprove selectSingleCarKeepApprove(int applyId);
			//逆向工程生成的mapper接口
    int countByExample(CarKeepApproveExample example);

    int deleteByExample(CarKeepApproveExample example);

    int deleteByPrimaryKey(Integer applyId);

    int insert(CarKeepApprovePO record);

    int insertSelective(CarKeepApprove record);

    List<CarKeepApprove> selectByExample(CarKeepApproveExample example);

    CarKeepApprove selectByPrimaryKey(Integer applyId);

    int updateByExampleSelective(@Param("record") CarKeepApprove record, @Param("example") CarKeepApproveExample example);

    int updateByExample(@Param("record") CarKeepApprove record, @Param("example") CarKeepApproveExample example);

    int updateByPrimaryKeySelective(CarKeepApprovePO record);

    int updateByPrimaryKey(CarKeepApprovePO record);
}