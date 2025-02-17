package io.watertheqlant.loan.limit.calculation.system.configs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("io.watertheqlant.loan.limit.calculation.system.dao")
public class MybatisConfig {

}