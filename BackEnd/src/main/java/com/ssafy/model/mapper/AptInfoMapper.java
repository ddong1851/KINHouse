package com.ssafy.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.AptSearchIsLoginVo;
import com.ssafy.model.dto.AptSearchVo;
import com.ssafy.model.dto.AptSearchBybCodeIsLoginVo;
import com.ssafy.model.dto.AptSearchBybCodeVo;


@Mapper
public interface AptInfoMapper {
	List<AptSearchVo> searchApt(Map<String, Object> map) throws SQLException;
	List<AptSearchIsLoginVo> searchAptIsLogin(Map<String, Object> param) throws SQLException;
	int getTotalCount(Map<String,String> map) throws SQLException;
	int getAptCount(Map<String, String> map);
	int getDongCount(Map<String, String> map);
	List<AptSearchBybCodeVo> findByAddress(Map<String, Object> param);
	int getTotalCountBybcode(double bcode);
	List<AptSearchBybCodeIsLoginVo> findByAddressIsLogin(Map<String, Object> param);
}
