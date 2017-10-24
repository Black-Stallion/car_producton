package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarPublic;
import org.hqu.production_ms.domain.CarRegister;
import org.hqu.production_ms.domain.CarRegisterExample;
import org.hqu.production_ms.domain.po.CarRegisterPO;

public interface CarRegisterMapper {
	//扩展的mapper接口方法
	int deleteBatch(int[] ids);
	
	List<CarRegister> find();
	
	List<CarRegister> find1(String id);
	
	List<CarPublic> findP();
	
	List<CarRegister> findP11();
	List<CarPublic> finddep();
	List<CarPublic> findType();
	List<CarPublic> findUsenature();
	
	List<CarRegister> findP2(String id);
	
	List<CarPublic> findP1(String id);
	
	List<CarRegister> findByNature(String string);
	
	List<CarRegister> findByNature1(String string,String id);
	
	List<CarRegister> get();
	List<CarRegister> get1(String id);
	
	
	List<CarRegister> searchCarRegisterByCarRegisterDriverfrom(String brand);

	List<CarRegister> searchCarRegisterByCarRegisterAA(String checkNums);

	List<CarRegister> searchCarRegisterByCarRegisterName(String carXH);
	CarRegister findByCarNumber(String id);
	
	CarRegister findByCarCJH(String id);
	
	CarRegister selectSingleCarRegister(int carId);
	//逆向工程生成的mapper接口
    int countByExample(CarRegisterExample example);

    int deleteByExample(CarRegisterExample example);

    int deleteByPrimaryKey(Integer carId);
    
    int updateDepById(String id,Integer ids);
    int updateDepByIds(String id,String ids);

    int insert(CarRegisterPO record);

    int insertSelective(CarRegister record);

    List<CarRegister> selectByExample(CarRegisterExample example);

    CarRegister selectByPrimaryKey(Integer carId);

    int updateByExampleSelective(@Param("record") CarRegister record, @Param("example") CarRegisterExample example);

    int updateByExample(@Param("record") CarRegister record, @Param("example") CarRegisterExample example);

    int updateByPrimaryKeySelective(CarRegisterPO record);

    int updateByPrimaryKey(CarRegisterPO record);
}