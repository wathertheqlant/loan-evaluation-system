package io.watertheqlant.loan.evaluation.system.entity;

import io.watertheqlant.loan.evaluation.system.type.OperatorType;
import io.watertheqlant.loan.evaluation.system.vo.InternalEvaluationPolicyResult;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InternalEvaluationPolicyTest {

  @Test
  void singleOperatorEvaluation() {
    InternalEvaluationPolicy internalEvaluationPolicy = InternalEvaluationPolicy.builder()
      .operator1(OperatorType.EQUALS)
      .value1(BigDecimal.valueOf(100))
      .build();

    InternalEvaluationPolicyResult expectedPass = internalEvaluationPolicy.evaluate(BigDecimal.valueOf(100));
    InternalEvaluationPolicyResult expectedFail = internalEvaluationPolicy.evaluate(BigDecimal.valueOf(100).negate());

    assertTrue(expectedPass.isPass());
    assertFalse(expectedFail.isPass());
  }

  @Test
  void doubleOperatorEvaluation() {
    InternalEvaluationPolicy internalEvaluationPolicy = InternalEvaluationPolicy.builder()
      .operator1(OperatorType.GREATER_THAN)
      .operator2(OperatorType.LESS_THAN)
      .value1(BigDecimal.valueOf(100))
      .value2(BigDecimal.valueOf(200))
      .build();

    InternalEvaluationPolicyResult expectedPass = internalEvaluationPolicy.evaluate(BigDecimal.valueOf(150));
    InternalEvaluationPolicyResult expectedFailEdge1 = internalEvaluationPolicy.evaluate(BigDecimal.valueOf(99));
    InternalEvaluationPolicyResult expectedFailEdge2 = internalEvaluationPolicy.evaluate(BigDecimal.valueOf(201));

    assertTrue(expectedPass.isPass());
    assertFalse(expectedFailEdge1.isPass());
    assertFalse(expectedFailEdge2.isPass());
  }

}
