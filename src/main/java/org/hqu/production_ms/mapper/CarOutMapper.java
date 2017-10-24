package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarOut;
import org.hqu.production_ms.domain.CarOutExample;
import org.hqu.production_ms.domain.po.CarOutPO;

public interface CarOutMapper {
	//扩展的mapper接口方法
			int deleteBatch(int[] ids);
			
			List<CarOut> find();
			
			List<CarOut> findCount();
			
			List<CarOut> find1(String id);
			
			List<CarOut> searchCarOutByCarOutDriverfrom(String brand);

			List<CarOut> searchCarOutByCarOutAA(String checkNums);
			List<CarOut> searchCarOutByCarOutDriverfrom1(String id,String brand);

			List<CarOut> searchCarOutByCarOutAA1(String id,String checkNums);

			List<CarOut> searchCarOutByCarOutName(String carXH);
			
			CarOut selectSingleCarOut(int carRemoveId);
				//逆向工程生成的mapper接口
    int countByExample(CarOutExample example);

    int deleteByExample(CarOutExample example);

    int deleteByPrimaryKey(Integer outId);

    int insert(CarOutPO record);

    int insertSelective(CarOut record);

    List<CarOut> selectByExample(CarOutExample example);

    CarOut selectByPrimaryKey(Integer outId);

    int updateByExampleSelective(@Param("record") CarOut record, @Param("example") CarOutExample example);

    int updateByExample(@Param("record") CarOut record, @Param("example") CarOutExample example);

    int updateByPrimaryKeySelective(CarOutPO record);

    int updateByPrimaryKey(CarOutPO record);
}