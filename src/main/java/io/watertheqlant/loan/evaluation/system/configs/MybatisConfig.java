package io.watertheqlant.loan.evaluation.system.configs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("io.watertheqlant.loan.evaluation.system.domain.dao")
public class MybatisConfig {

}
