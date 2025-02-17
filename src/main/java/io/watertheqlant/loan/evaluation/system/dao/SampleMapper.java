package io.watertheqlant.loan.evaluation.system.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface SampleMapper {

    // 읽기
    Map<String,Object> read();

}
