package com.zdjy.bigdata.antun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdjy.bigdata.antun.domain.Area;
import com.zdjy.bigdata.antun.domain.AreaExample;
import com.zdjy.bigdata.antun.domain.AreaExample.Criteria;
import com.zdjy.bigdata.antun.mapper.AreaMapper;
@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaMapper areaMapper;
	
	@Override
	public Area findById(Long town) {
		// TODO Auto-generated method stub
		return areaMapper.selectByPrimaryKey(town);
	}

	@Override
	public List<Area> findByParentId(Long parentId) {
		// TODO Auto-generated method stub
		AreaExample areaExample = new AreaExample();
		
		Criteria createCriteria = areaExample.createCriteria();
		
		createCriteria.andParentIdEqualTo(parentId);
		return areaMapper.selectByExample(areaExample);
	}

}
