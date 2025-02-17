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
                                   credit_info_dictionary_id LONG NOT NULL COMMENT '신용 정보 종류',
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
                                               internal_css_grade_policy_id BIGINT NOT NULL COMMENT '내부기준 산정 스코어 별 대출신용등급 CSS ID',
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
                              scb_credit_info_id BIGINT NOT NULL COMMENT '서울신용정보_ID',
                              INDEX idx_customer_id (customer_id) COMMENT '고객별 CSS 조회 최적화',
                              INDEX idx_css_valid_date (css_valid_date) COMMENT 'CSS 유효기간 조회 최적화',
                              INDEX idx_scb_id (scb_credit_info_id) COMMENT '서울신용정보 ID 조회 최적화'
) COMMENT='고객 CSS';

CREATE TABLE scb_credit_info (
                                 id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '서울신용정보 등급정보 ID',
                                 customer_id BIGINT NOT NULL COMMENT '고객_ID',
                                 request_date DATE NOT NULL COMMENT '조회 날짜',
                                 INDEX idx_customer_id (customer_id) COMMENT '고객 ID 조회 최적화',
                                 INDEX idx_request_date (request_date) COMMENT '조회 날짜 조회 최적화'
) COMMENT='서울신용정보 조회 정보';

CREATE TABLE scb_credit_info_details (
                                 id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '서울신용정보 등급정보 ID',
                                 scb_credit_info_id BIGINT NOT NULL COMMENT '서울신용정보 조회 정보',
                                 credit_info_dictionary_id BIGINT NOT NULL COMMENT '신용 정보 종류',
                                 type_name VARCHAR(100) NOT NULL COMMENT '이름',
                                 description VARCHAR(255) NOT NULL COMMENT '설명',
                                 value VARCHAR(255) NOT NULL COMMENT '값',
                                 INDEX idx_scb_credit_info_id (scb_credit_info_id) COMMENT '고객 ID 조회 최적화'
) COMMENT='서울신용정보 조회 세부 정보';

CREATE TABLE credit_info_dictionary (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '신용 등급 ID',
                                       type_name VARCHAR(100) NOT NULL COMMENT '이름',
                                       credit_bureau_name VARCHAR(45) NOT NULL COMMENT 'CB사 이름',
                                       type VARCHAR(45) NOT NULL COMMENT '타입(e.g. ORIGIN, CALCULATED)',
                                       description VARCHAR(255) NOT NULL DEFAULT 0 COMMENT '설명',
                                       example VARCHAR(255) NOT NULL COMMENT '예시'
) COMMENT='신용 정보 사전';

CREATE TABLE sequences (
                         name VARCHAR(255) PRIMARY KEY COMMENT '시퀀스 이름',
                         value BIGINT NOT NULL COMMENT '다음 값'
) COMMENT='시퀀스';
