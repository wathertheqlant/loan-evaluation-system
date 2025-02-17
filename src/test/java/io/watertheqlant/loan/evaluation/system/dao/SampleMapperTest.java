package io.watertheqlant.loan.evaluation.system.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SampleMapperTest {

	@Autowired
	private SampleMapper sampleMapper;

	@Test
	void read() {
		var result = sampleMapper.read();

		assertNotNull(result);
	}

}
