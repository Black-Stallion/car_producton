package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.CarMoney;
import org.hqu.production_ms.domain.CarMoneyExample;

public interface CarMoneyMapper {
	List<CarMoney> find();
	List<CarMoney> findtj(String id,String id2);
	List<CarMoney> findfx(String id);
	
    int countByExample(CarMoneyExample example);

    int deleteByExample(CarMoneyExample example);

    int deleteByPrimaryKey(Integer moneyId);

    int insert(CarMoney record);

    int insertSelective(CarMoney record);

    List<CarMoney> selectByExample(CarMoneyExample example);

    CarMoney selectByPrimaryKey(Integer moneyId);

    int updateByExampleSelective(@Param("record") CarMoney record, @Param("example") CarMoneyExample example);

    int updateByExample(@Param("record") CarMoney record, @Param("example") CarMoneyExample example);

    int updateByPrimaryKeySelective(CarMoney record);

    int updateByPrimaryKey(CarMoney record);
}