CREATE TABLE customers (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '고객 ID',
                           customer_name VARCHAR(255) NOT NULL COMMENT '고객이름',
                           customer_jumin VARCHAR(50) NOT NULL UNIQUE COMMENT '고객 주민등록번호',
                           customer_annual_income BIGINT NOT NULL COMMENT '고객 연소득',
                           customer_credit_id BIGINT NOT NULL COMMENT '고객 신용정보 ID',
                           INDEX idx_customer_credit_id (customer_credit_id) COMMENT '고객 신용정보 조회 최적화'
) COMMENT='고객정보';

CREATE TABLE internal_policies (
                                   id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '내부 기준 ID',
                                   target_field_name VARCHAR(255) NOT NULL COMMENT '대상 필드명 (예: major_loan_usage_count)',
                                   description VARCHAR(255) NOT NULL COMMENT '기준 설명 (예: 대부업 대출 이용 횟수)',
                                   operator1 VARCHAR(10) COMMENT '연산방법1',
                                   operator2 VARCHAR(10) COMMENT '연산방법2',
                                   value1 DECIMAL(32, 9) NOT NULL COMMENT '연산대상1',
                                   value2 DECIMAL(32, 9) NOT NULL COMMENT '연산대상2',
                                   evaluation_score INT NOT NULL COMMENT '평가점수',
                                   expired_at DATETIME NOT NULL COMMENT '만료시점',
                                   INDEX idx_expired_at (expired_at) COMMENT '기준 만료일 조회 최적화'
) COMMENT='내부기준 종류';

CREATE TABLE internal_css_grade_policies (
                                             id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '내부 기준 산정 스코어별 신용등급 ID',
                                             credit_grade INT NOT NULL COMMENT '신용등급',
                                             credit_max_score INT NOT NULL COMMENT '산정범위 최대 점수',
                                             credit_min_score INT NOT NULL COMMENT '산정범위 최소 점수',
                                             grade_valid_at DATETIME NOT NULL COMMENT '적용유효시점',
                                             INDEX idx_credit_score_range (credit_max_score, credit_min_score) COMMENT '신용 점수 범위 조회 최적화',
                                             INDEX idx_grade_valid_at (grade_valid_at) COMMENT '신용등급 유효기간 조회 최적화'
) COMMENT='내부기준 산정 스코어 별 대출신용등급 CSS';

CREATE TABLE internal_css_evaluated_scores (
                                               id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '내부 기준 평가 점수 ID',
                                               customer_id BIGINT NOT NULL COMMENT '고객ID',
                                               customer_css_id BIGINT NOT NULL COMMENT '고객 CSS ID',
                                               internal_css_grade_policy_id BIGINT NOT NULL COMMENT '내부기준ID',
                                               evaluated_score INT NOT NULL COMMENT '평가된 점수 (예: 2, 300, ...)',
                                               standard_score INT NOT NULL COMMENT '내부기준 평가점수',
                                               evaluated_at DATETIME NOT NULL COMMENT '평가시점',
                                               INDEX idx_customer_id (customer_id) COMMENT '고객별 평가 조회 최적화',
                                               INDEX idx_internal_css_grade_policy_id (internal_css_grade_policy_id) COMMENT '내부기준별 평가 조회 최적화',
                                               INDEX idx_evaluated_at (evaluated_at) COMMENT '평가 날짜 조회 최적화'
) COMMENT='내부기준 평가 점수';

CREATE TABLE customer_css (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '고객 CSS ID',
                              customer_id BIGINT NOT NULL COMMENT '고객_ID',
                              css_grade INT NOT NULL COMMENT 'CSS 신용등급',
                              css_valid_date DATETIME NOT NULL COMMENT 'CSS 적용유효기간',
                              scb_id BIGINT NOT NULL COMMENT '서울신용정보_ID',
                              INDEX idx_customer_id (customer_id) COMMENT '고객별 CSS 조회 최적화',
                              INDEX idx_css_valid_date (css_valid_date) COMMENT 'CSS 유효기간 조회 최적화',
                              INDEX idx_scb_id (scb_id) COMMENT '서울신용정보 ID 조회 최적화'
) COMMENT='고객 CSS';

CREATE TABLE scb_credit_grade_info (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '서울신용정보 등급정보 ID',
                                       customer_id BIGINT NOT NULL COMMENT '고객_ID',
                                       major_loan_usage_count INT NOT NULL DEFAULT 0 COMMENT '대부업 대출이용 횟수',
                                       credit_rating INT NOT NULL COMMENT '신용등급',
                                       loan_default_count INT NOT NULL DEFAULT 0 COMMENT '대출 연체 횟수',
                                       annual_income BIGINT NOT NULL COMMENT '연소득',
                                       approved_income BIGINT NOT NULL COMMENT '인정소득 (Y: 연소득 / N : 연소득*0.7)',
                                       is_regular_employee INT NOT NULL DEFAULT 0 COMMENT '정규직 여부',
                                       short_term_card_loan_usage_count BOOLEAN NOT NULL DEFAULT FALSE COMMENT '단기카드대출 이용횟수',
                                       loan_clear_count INT NOT NULL DEFAULT 0 COMMENT '대출 완납 횟수',
                                       credit_card_issue_count INT NOT NULL DEFAULT 0 COMMENT '신용카드 발행 횟수',
                                       request_date DATETIME NOT NULL COMMENT '조회 날짜',
                                       INDEX idx_customer_id (customer_id) COMMENT '고객 ID 조회 최적화',
                                       INDEX idx_request_date (request_date) COMMENT '조회 날짜 조회 최적화',
                                       INDEX idx_credit_rating (credit_rating) COMMENT '신용등급 조회 최적화'
) COMMENT='서울신용정보에서 받아온 등급정보';