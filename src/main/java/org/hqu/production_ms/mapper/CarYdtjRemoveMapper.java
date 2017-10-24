package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarYdtjRemove;
import org.hqu.production_ms.domain.CarYdtjRemoveExample;
import org.hqu.production_ms.domain.po.CarYdtjRemovePO;

public interface CarYdtjRemoveMapper {
	//扩展的mapper接口方法
		int deleteBatch(int[] ids);
		
		List<CarYdtjRemove> find(String id);
		
		List<CarYdtjRemove> find1();
		
		List<CarYdtjRemove> findByNature(String string);
		List<CarYdtjRemove> get();
		
		List<CarYdtjRemove> searchCarYdtjRemoveByCarYdtj1(String brand);

		List<CarYdtjRemove> searchCarYdtjRemoveByCarYdtj2(String carXH,String st);
		
		List<CarYdtjRemove> searchCarYdtjRemoveByCarYdtj3(String carXH);
		
		List<CarYdtjRemove> searchCarYdtjRemoveByCarYdtj4(String brand,String st);

		List<CarYdtjRemove> searchCarYdtjRemoveByCarYdtj5(String carXH,String st,String str);
		
		CarYdtjRemove selectSingleCarYdtj(int carId);
		//逆向工程生成的mapper接口
	    int countByExample(CarYdtjRemoveExample example);

	    int deleteByExample(CarYdtjRemoveExample example);

	    int deleteByPrimaryKey(Integer carId);

	    int insert(CarYdtjRemovePO record);

	    int insertSelective(CarYdtjRemove record);

	    List<CarYdtjRemove> selectByExample(CarYdtjRemoveExample example);

	    CarYdtjRemove selectByPrimaryKey(Integer carId);

	    int updateByExampleSelective(@Param("record") CarYdtjRemove record, @Param("example") CarYdtjRemoveExample example);

	    int updateByExample(@Param("record") CarYdtjRemove record, @Param("example") CarYdtjRemoveExample example);

	    int updateByPrimaryKeySelective(CarYdtjRemovePO record);

	    int updateByPrimaryKey(CarYdtjRemovePO record);
}
