package com.ohmp.study.dynamic.service.impl;

import com.ohmp.study.dynamic.entity.User;
import com.ohmp.study.dynamic.mapper.UserMapper;
import com.ohmp.study.dynamic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

	@Autowired private UserMapper userMapper;
	
	@Override
	public User get(String targetSource) {
		return userMapper.selectByPrimaryKey(1);
	}

}
