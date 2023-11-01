package com.food.exp.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.exp.dto.MainDTO;

@Repository("/mainDAO")
public class MainDAO {

	@Autowired
	SqlSessionTemplate session;
	
	public List<MainDTO> top10Rst() {
		return session.selectList("MainMapper.top10Rst");
	}
	
}
