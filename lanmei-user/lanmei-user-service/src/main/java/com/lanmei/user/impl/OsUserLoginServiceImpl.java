package com.lanmei.user.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.lanmei.common.baseservice.BaseService;
import com.lanmei.user.dao.mapper.OsUserLoginMapper;
import com.lanmei.user.dao.model.OsUserLogin;
import com.lanmei.user.service.OsUserLoginService;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class OsUserLoginServiceImpl extends BaseService implements OsUserLoginService {

	
	private final static Logger logger = LoggerFactory.getLogger("OsUserLoginServiceImpl.class");	
	{
		logger.debug("OsUserLoginServiceImpl create bean ......");
	}
	@Autowired
	private OsUserLoginMapper userLoginMapper;
	
	@Autowired
	private DruidDataSource dataSource; 
	@Autowired
	private SqlSessionFactoryBean sqlSessionFactory;
	
	
	@Override
	public Integer setLoginLog(Integer userId, OsUserLogin userLogin) {
		// TODO Auto-generated method stub
		
		Integer num = userLoginMapper.updateByUserId(userId,userLogin);
		logger.debug("num = " + num);
		return num;
	}


	@Override
	public Integer addLoginLog(Integer userId, OsUserLogin userLogin) {
		// TODO Auto-generated method stub
		
		Integer num = userLoginMapper.insertByUserId(userId,userLogin);
		logger.debug("num = " + num);
		return num;
	}
	
	

}
