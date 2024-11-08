package com.result.repsoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.result.entity.Result;

public interface ResultRepository   extends JpaRepository<Result,Integer>{

   @Query(value="select max(percentage) from Stud_result",nativeQuery=true)
public int topper();


}
