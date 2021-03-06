package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarRemove;
import org.hqu.production_ms.domain.CarRemoveExample;
import org.hqu.production_ms.domain.po.CarRemovePO;

public interface CarRemoveMapper {
	//扩展的mapper接口方法
		int deleteBatch(int[] ids);
		
		List<CarRemove> find();
		
		List<CarRemove> findCount();
		
		List<CarRemove> find1(String id);
		
		List<CarRemove> searchCarRemoveByCarRemoveDriverfrom(String brand);

		List<CarRemove> searchCarRemoveByCarRemoveAA(String checkNums);
		
		List<CarRemove> searchCarRemoveByCarRemoveDriverfrom1(String id,String brand);

		List<CarRemove> searchCarRemoveByCarRemoveAA1(String id,String checkNums);

		List<CarRemove> searchCarRemoveByCarRemoveName(String carXH);
		
		CarRemove selectSingleCarRemove(int carRemoveId);
			//逆向工程生成的mapper接口
    int countByExample(CarRemoveExample example);

    int deleteByExample(CarRemoveExample example);

    int deleteByPrimaryKey(Integer removeId);

    int insert(CarRemovePO record);

    int insertSelective(CarRemove record);

    List<CarRemove> selectByExample(CarRemoveExample example);

    CarRemove selectByPrimaryKey(Integer removeId);

    int updateByExampleSelective(@Param("record") CarRemove record, @Param("example") CarRemoveExample example);

    int updateByExample(@Param("record") CarRemove record, @Param("example") CarRemoveExample example);

    int updateByPrimaryKeySelective(CarRemovePO record);

    int updateByPrimaryKey(CarRemovePO record);
}