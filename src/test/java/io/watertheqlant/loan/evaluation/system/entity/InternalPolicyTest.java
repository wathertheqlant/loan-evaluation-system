package io.watertheqlant.loan.evaluation.system.entity;

import io.watertheqlant.loan.evaluation.system.InternalPolicyEvaluationResult;
import io.watertheqlant.loan.evaluation.system.type.OperatorType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InternalPolicyTest {

  @Test
  void singleOperatorEvaluation() {
    InternalPolicy internalPolicy = InternalPolicy.builder()
      .operator1(OperatorType.EQUALS)
      .value1(BigDecimal.valueOf(100))
      .build();

    InternalPolicyEvaluationResult expectedPass = internalPolicy.evaluate(BigDecimal.valueOf(100));
    InternalPolicyEvaluationResult expectedFail = internalPolicy.evaluate(BigDecimal.valueOf(100).negate());

    assertTrue(expectedPass.isPass());
    assertFalse(expectedFail.isPass());
  }

  @Test
  void doubleOperatorEvaluation() {
    InternalPolicy internalPolicy = InternalPolicy.builder()
      .operator1(OperatorType.GREATER_THAN)
      .operator2(OperatorType.LESS_THAN)
      .value1(BigDecimal.valueOf(100))
      .value2(BigDecimal.valueOf(200))
      .build();

    InternalPolicyEvaluationResult expectedPass = internalPolicy.evaluate(BigDecimal.valueOf(150));
    InternalPolicyEvaluationResult expectedFailEdge1 = internalPolicy.evaluate(BigDecimal.valueOf(99));
    InternalPolicyEvaluationResult expectedFailEdge2 = internalPolicy.evaluate(BigDecimal.valueOf(201));

    assertTrue(expectedPass.isPass());
    assertFalse(expectedFailEdge1.isPass());
    assertFalse(expectedFailEdge2.isPass());
  }

}
