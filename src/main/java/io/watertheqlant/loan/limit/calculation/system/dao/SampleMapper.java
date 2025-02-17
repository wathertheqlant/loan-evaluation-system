package io.watertheqlant.loan.limit.calculation.system.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface SampleMapper {

    // 읽기
    Map<String,Object> read();

}
