CREATE TABLE customers
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '고객 ID',
    customer_name  VARCHAR(255) NOT NULL COMMENT '고객이름',
    customer_jumin VARCHAR(50)  NOT NULL UNIQUE COMMENT '고객 주민등록번호'
) COMMENT ='고객정보';

CREATE TABLE internal_evaluation_policies
(
    id                        BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '내부 기준 ID',
    credit_info_dictionary_id LONG           NOT NULL COMMENT '신용 정보 종류',
    description               VARCHAR(255)   NOT NULL COMMENT '기준 설명 (예: 대부업 대출 이용 횟수)',
    operator1                 VARCHAR(45) COMMENT '연산방법1',
    operator2                 VARCHAR(45) COMMENT '연산방법2',
    value1                    DECIMAL(32, 9) NOT NULL COMMENT '연산대상1',
    value2                    DECIMAL(32, 9) NULL COMMENT '연산대상2',
    evaluation_score          INT            NOT NULL COMMENT '평가점수',
    expired_at                DATETIME       NOT NULL COMMENT '만료시점',
    INDEX idx_expired_at (expired_at)
) COMMENT ='내부 평가 정책';

CREATE TABLE internal_css_grade_policies
(
    id                   BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '내부 기준 산정 스코어별 신용등급 ID',
    css_grade            INT            NOT NULL COMMENT 'CSS 등급',
    min_evaluation_score INT            NOT NULL COMMENT '최소 평가 점수',
    max_evaluation_score INT            NOT NULL COMMENT '최대 평가 점수',
    min_loan_amount      INT            NOT NULL COMMENT '최소 대출 금액',
    max_loan_amount      INT            NOT NULL COMMENT '최대 대출 금액',
    interest_rate        DECIMAL(12, 5) NOT NULL COMMENT '이자율',
    min_loan_term        INT            NOT NULL COMMENT '최소 대출 기간(개월)',
    max_loan_term        INT            NOT NULL COMMENT '최대 대출 기간(개월)',
    expired_at           DATETIME       NOT NULL COMMENT '만료 시점',
    INDEX idx_credit_score_range (max_evaluation_score, min_evaluation_score),
    INDEX idx_expired_at (expired_at)
) COMMENT ='내부 CSS 등급 정책';

CREATE TABLE internal_css_evaluation_scores
(
    id                           BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '고객 CSS ID',
    customer_id                  BIGINT   NOT NULL COMMENT '고객_ID',
    internal_css_grade_policy_id BIGINT   NOT NULL COMMENT '내부 CSS 등급 정책 ID',
    css_grade                    INT      NOT NULL COMMENT 'CSS 등급',
    scb_credit_info_id           BIGINT   NOT NULL COMMENT '서울신용정보 ID',
    expired_at                   DATETIME NOT NULL COMMENT '만료시점',
    evaluated_at                 DATETIME NOT NULL COMMENT '평가시점',
    INDEX idx_customer_id (customer_id),
    INDEX idx_expired_at (expired_at),
    INDEX idx_scb_id (scb_credit_info_id),
    INDEX idx_evaluated_at (evaluated_at)
) COMMENT ='내부 CSS 평가 점수';

CREATE TABLE internal_css_evaluation_score_items
(
    id                               BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '내부 기준 평가 점수 ID',
    customer_id                      BIGINT         NOT NULL COMMENT '고객ID',
    internal_css_evaluation_score_id BIGINT         NOT NULL COMMENT '고객 CSS ID',
    internal_evaluation_policy_id    BIGINT         NOT NULL COMMENT '내부 평가 정책 ID',
    evaluation_result_type           VARCHAR(45)    NOT NULL COMMENT '평가 결과 타입',
    evaluated_value                  DECIMAL(32, 9) NOT NULL COMMENT '평가된 값',
    score                            INT            NOT NULL COMMENT '점수',
    INDEX idx_customer_id (customer_id),
    INDEX idx_internal_evaluation_policy_id (internal_evaluation_policy_id)
) COMMENT ='내부 CSS 평가 점수 항목';


CREATE TABLE scb_credit_info
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '서울신용정보 등급정보 ID',
    customer_id  BIGINT NOT NULL COMMENT '고객_ID',
    request_date DATE   NOT NULL COMMENT '조회 날짜',
    INDEX idx_customer_id (customer_id),
    INDEX idx_request_date (request_date)
) COMMENT ='서울신용정보 조회 정보';

CREATE TABLE scb_credit_info_details
(
    id                        BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '서울신용정보 등급정보 ID',
    scb_credit_info_id        BIGINT       NOT NULL COMMENT '서울신용정보 조회 정보',
    credit_info_dictionary_id BIGINT       NOT NULL COMMENT '신용 정보 종류',
    type_name                 VARCHAR(100) NOT NULL COMMENT '이름',
    description               VARCHAR(255) NULL COMMENT '설명',
    value                     VARCHAR(255) NULL COMMENT '값',
    INDEX idx_scb_credit_info_id (scb_credit_info_id)
) COMMENT ='서울신용정보 조회 세부 정보';

CREATE TABLE credit_info_dictionary
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '신용 등급 ID',
    type_name          VARCHAR(100) NOT NULL COMMENT '이름',
    credit_bureau_name VARCHAR(45)  NOT NULL COMMENT 'CB사 이름',
    type               VARCHAR(45)  NULL COMMENT '타입(e.g. ORIGIN, CALCULATED)',
    description        VARCHAR(255) NULL COMMENT '설명',
    example            VARCHAR(255) NULL COMMENT '예시'
) COMMENT ='신용 정보 사전';

CREATE TABLE sequences
(
    name  VARCHAR(255) PRIMARY KEY COMMENT '시퀀스 이름',
    value BIGINT NOT NULL COMMENT '다음 값'
) COMMENT ='시퀀스';
