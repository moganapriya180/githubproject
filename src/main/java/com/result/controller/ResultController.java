package com.result.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.result.entity.Result;
import com.result.pojo.StudentMs;
import com.result.service.ResultService;

@RestController

public class ResultController {
	

@Autowired
ResultService rs;
@Autowired
RestTemplate rest;
@PostMapping(value="/totalmarksandpercentage")
public String totalwithpercentage(@RequestBody List<Result> total2)
{
return rs.totalwithpercentage(total2);
}
@GetMapping(value="/getall")
public List<Result> getAll()
{
	System.out.println("Hello");
return rs.getAll();
}



@GetMapping(value="/topper")
public int topper()
{
return rs.topper();
}
@GetMapping(value="/topthree")
public List<Result> topthree()
{
return rs.topthree();
}
@GetMapping(value="/rangeof")
public List<Result> rangeofmarks()
{
return rs.rangeofmarks();
}
}
