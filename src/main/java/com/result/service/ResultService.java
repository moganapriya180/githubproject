package com.result.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.result.dao.ResultDao;
import com.result.entity.Result;
import com.result.pojo.StudentMs;
import com.result.pojo.Studentdetails;

@Service
public class ResultService {
	@Autowired
	ResultDao rd;
	@Autowired
	RestTemplate rest;


	public String totalwithpercentage(List<Result> total2) {
	String url1 = "http://localhost:8081/getall";
	String url2 = "http://localhost:8082/getAll";

	ResponseEntity<List<Result>> total1 = rest.exchange(url1, HttpMethod.GET, null,
	new ParameterizedTypeReference<List<Result>>() {
	},url2,HttpMethod.GET,null,new ParameterizedTypeReference<List<Result>>() {});
	List<Result> total21 = total1.getBody();



	ResponseEntity<List<Studentdetails>> attend = rest.exchange(url1, HttpMethod.GET, null,
	new ParameterizedTypeReference<List<Studentdetails>>() {
	});

	ResponseEntity<List<StudentMs>> percent= rest.exchange(url2, HttpMethod.GET, null,
	new ParameterizedTypeReference<List<StudentMs>>() {
	});


	List<Studentdetails> attend1=attend.getBody();
	List<StudentMs> per=percent.getBody();
	for(int i=0;i<total21.size();i++)
	{
	Result r=total21.get(i);
	StudentMs m=per.get(i);


	int totalMarks = m.getSem1Total()+m.getSem2Total();
	r.setTotal_marks(totalMarks);

	Studentdetails s=attend1.get(i);

	if (s.getAttendance() >= 90 && r.getTotal_marks() < 100)
	{
	int percentage = (r.getTotal_marks()/2)+5;
	r.setPercentage(percentage);
	}
	else
	{
	int percentage =(r.getTotal_marks()/2);
	r.setPercentage(percentage);
	}
	}
	return rd.totalwithpercentage(total21);
	}

	public List<Result> getAll()
	{
	return rd.getAll();
	}

	public int topper()
	{
	return rd.topper();
	}
	public List<Result> topthree()
	{
	List<Result> r=rd.findAll();
	return r.stream().sorted(Comparator.comparing(Result::getPercentage).reversed()).distinct().limit(3).collect(Collectors.toList());
	}
	public List<Result> rangeofmarks()
	{
	List<Result> s=rd.findAll();
	return s.stream().filter(x->x.getTotal_marks()>70 && x.getTotal_marks()<90).collect(Collectors.toList());
	}

	
	
}
