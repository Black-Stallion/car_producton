package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarMaintenance;
import org.hqu.production_ms.domain.CarMaintenanceExample;
import org.hqu.production_ms.domain.po.CarMaintenancePO;

public interface CarMaintenanceMapper {
	//扩展的mapper接口方法
			int deleteBatch(int[] ids);
			
			List<CarMaintenance> find();
			List<CarMaintenance> find1(Integer str);
			List<CarMaintenance> find2(double str,Integer id);
			List<CarMaintenance> find3(double str,Integer id);
			
			List<CarMaintenance> searchCarMaintenanceByCarMaintenanceDriverfrom(String brand);

			List<CarMaintenance> searchCarMaintenanceByCarMaintenanceName(String carXH);
			
			CarMaintenance selectSingleCarMaintenance(int carMaintenanceId);
			//逆向工程生成的mapper接口
	    int countByExample(CarMaintenanceExample example);

	    int deleteByExample(CarMaintenanceExample example);

	    int deleteByPrimaryKey(Integer maintenanceId);

	    int insert(CarMaintenancePO record);

	    int insertSelective(CarMaintenance record);

	    List<CarMaintenance> selectByExample(CarMaintenanceExample example);

	    CarMaintenance selectByPrimaryKey(Integer maintenanceId);

	    int updateByExampleSelective(@Param("record") CarMaintenance record, @Param("example") CarMaintenanceExample example);

	    int updateByExample(@Param("record") CarMaintenance record, @Param("example") CarMaintenanceExample example);

	    int updateByPrimaryKeySelective(CarMaintenancePO record);

	    int updateByPrimaryKey(CarMaintenancePO record);
}