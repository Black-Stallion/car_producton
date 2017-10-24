package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarCompany;
import org.hqu.production_ms.domain.CarCompanyExample;
import org.hqu.production_ms.domain.po.CarCompanyPO;

public interface CarCompanyMapper {
	int deleteBatch(int[] ids);
	
	List<CarCompany> find();
	
	List<CarCompany> find1(String id);
	
	List<CarCompany> get();
	
	List<CarCompany> get1(String id);
	
	CarCompany selectSingleCarCompany(int carTypeId);
	
    int countByExample(CarCompanyExample example);

    int deleteByExample(CarCompanyExample example);

    int deleteByPrimaryKey(Integer companyId);

    int insert(CarCompanyPO record);

    int insertSelective(CarCompany record);

    List<CarCompany> selectByExample(CarCompanyExample example);

    CarCompany selectByPrimaryKey(Integer companyId);

    int updateByExampleSelective(@Param("record") CarCompany record, @Param("example") CarCompanyExample example);

    int updateByExample(@Param("record") CarCompany record, @Param("example") CarCompanyExample example);

    int updateByPrimaryKeySelective(CarCompanyPO record);

    int updateByPrimaryKey(CarCompanyPO record);
}