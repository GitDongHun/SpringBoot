package com.food.exp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//@Repository
//public class RegionDAO {
//	
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public String getRegionForRestaurant(String rst_id) {
//        String sql = "SELECT rst_region FROM restaurant WHERE rst_id = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{rst_id}, String.class);
//    }
//}
