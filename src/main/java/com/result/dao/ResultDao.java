package com.result.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.result.entity.Result;
import com.result.repsoitory.ResultRepository;

@Repository
public class ResultDao {
	@Autowired
	ResultRepository rr;
	@Autowired
	RestTemplate rest;
	public String totalwithpercentage(List<Result> total2)
	{
	rr.saveAll(total2);
	return "posted successfully";
	}
	public List<Result> getAll()
	{
		System.out.println("");
	return rr.findAll();
	}
	public int topper()
	{
	return rr.topper();
	}
	public List<Result> findAll() {
	return rr.findAll();
	}
	public List<Result> rangeofmarks()
	{
	return rr.findAll();
	}
	}


