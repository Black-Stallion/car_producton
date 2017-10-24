package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarDriver;
import org.hqu.production_ms.domain.CarDriverExample;
import org.hqu.production_ms.domain.po.CarDriverPO;

public interface CarDriverMapper {
	//扩展的mapper接口方法
		int deleteBatch(int[] ids);
		
		List<CarDriver> find();
		List<CarDriver> find1(String id);
		
		List<CarDriver> searchCarDriverByCarDriverDriverfrom(String brand);

		List<CarDriver> searchCarDriverByCarDriverAA(String checkNums);
		List<CarDriver> searchCarDriverByCarDriverDriverfrom1(String id,String brand);

		List<CarDriver> searchCarDriverByCarDriverAA1(String id,String checkNums);

		List<CarDriver> get();
		List<CarDriver> get1(String id);
		
		CarDriver searchCarDriverByCarDepName(String driverNum);
		
		CarDriver selectSingleCarDriver(int Id);
			//逆向工程生成的mapper接口
    int countByExample(CarDriverExample example);

    int deleteByExample(CarDriverExample example);

    int deleteByPrimaryKey(Integer driverId);

    int insert(CarDriverPO record);

    int insertSelective(CarDriver record);

    List<CarDriver> selectByExample(CarDriverExample example);

    CarDriver selectByPrimaryKey(Integer driverId);

    int updateByExampleSelective(@Param("record") CarDriver record, @Param("example") CarDriverExample example);

    int updateByExample(@Param("record") CarDriver record, @Param("example") CarDriverExample example);

    int updateByPrimaryKeySelective(CarDriverPO record);

    int updateByPrimaryKey(CarDriverPO record);
}