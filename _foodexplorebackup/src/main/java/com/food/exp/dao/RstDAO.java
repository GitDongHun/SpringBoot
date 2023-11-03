package com.food.exp.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.exp.dto.LikesDTO;
import com.food.exp.dto.RstDTO;

@Repository("RstDAO")
public class RstDAO {

    private final SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public RstDAO(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public void insertOrUpdateRestaurant(RstDTO restaurant) {
        sqlSessionTemplate.insert("RstMapper.insertOrUpdateRestaurant", restaurant);
       
    }

    public RstDTO selectRestaurantById(String rst_id) {
        return sqlSessionTemplate.selectOne("RstMapper.selectRestaurantById", rst_id);
    }

	public List<RstDTO> getAllRestaurants() {
		return sqlSessionTemplate.selectList("RstMapper.getAllRestaurants");
	}
	
	public List<LikesDTO> getLikesTotal(String rst_id) {
		return sqlSessionTemplate.selectList("RstMapper.getLikesTotal",rst_id);
	}
}