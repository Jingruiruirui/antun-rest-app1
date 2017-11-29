package com.zdjy.bigdata.antun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdjy.bigdata.antun.domain.User;
import com.zdjy.bigdata.antun.domain.UserExample;
import com.zdjy.bigdata.antun.domain.UserExample.Criteria;
import com.zdjy.bigdata.antun.mapper.UserMapper;
import com.zdjy.bigdata.antun.util.TransferUtil;
import com.zdjy.bigdata.antun.web.model.UserAdd;
import com.zdjy.bigdata.antun.web.model.UserUpdate;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		
	return	userMapper.selectByExample(null);
		
	}

	@Override
	public int addUser(UserAdd userAdd) {
		// TODO Auto-generated method stub
		User transfer = TransferUtil.transfer(userAdd, User.class);
		
		return userMapper.insertSelective(transfer);
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateUser(Long id,UserUpdate userUpdate) {
		// TODO Auto-generated method stub
		User user = TransferUtil.transfer(userUpdate, User.class);
		
		user.setId(id);
		
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public User findByPhone(String phone) {	
		UserExample userExample = new UserExample();
		
		Criteria createCriteria = userExample.createCriteria();
		
		createCriteria.andPhoneEqualTo(phone);
		
		List<User> selectByExample = userMapper.selectByExample(userExample);
		
		if(selectByExample.isEmpty())
			return null;
		return selectByExample.get(0);
	}

	@Override
	public int deleteUser(Long id) {
		// TODO Auto-generated method stub
		
		
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> findByStatus(int i) {

		UserExample userExample = new UserExample();
		 Criteria createCriteria = userExample.createCriteria();
		
		 createCriteria.andStutusEqualTo(i);
		 
		
		return userMapper.selectByExample(userExample);
	}
	
	
	
}
