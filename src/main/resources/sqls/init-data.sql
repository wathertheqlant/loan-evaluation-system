INSERT INTO `loan-evaluation-system`.sequences (name, value) VALUES ('credit_info_dictionary', 100);
INSERT INTO `loan-evaluation-system`.sequences (name, value) VALUES ('customers', 100);
INSERT INTO `loan-evaluation-system`.sequences (name, value) VALUES ('internal_css_evaluation_score_items', 100);
INSERT INTO `loan-evaluation-system`.sequences (name, value) VALUES ('internal_css_evaluation_scores', 100);
INSERT INTO `loan-evaluation-system`.sequences (name, value) VALUES ('internal_css_grade_policies', 100);
INSERT INTO `loan-evaluation-system`.sequences (name, value) VALUES ('internal_evaluation_policies', 100);
INSERT INTO `loan-evaluation-system`.sequences (name, value) VALUES ('scb_credit_info', 100);
INSERT INTO `loan-evaluation-system`.sequences (name, value) VALUES ('scb_credit_info_details', 100);
INSERT INTO `loan-evaluation-system`.sequences (name, value) VALUES ('test', 100);

INSERT INTO `loan-evaluation-system`.credit_info_dictionary (id, type_name, credit_bureau_name, type, description, example) VALUES (1, 'approved_income', 'SCB', 'CALCULATED', '인정소득', ' ');
INSERT INTO `loan-evaluation-system`.credit_info_dictionary (id, type_name, credit_bureau_name, type, description, example) VALUES (2, 'major_loan_usage_count', 'SCB', 'ORIGIN', '대부업 대출 이용 횟수', ' ');
INSERT INTO `loan-evaluation-system`.credit_info_dictionary (id, type_name, credit_bureau_name, type, description, example) VALUES (3, 'credit_rating', 'SCB', 'ORIGIN', '신용등급', ' ');
INSERT INTO `loan-evaluation-system`.credit_info_dictionary (id, type_name, credit_bureau_name, type, description, example) VALUES (4, 'loan_default_count', 'SCB', 'ORIGIN', '대출 연체 횟수', ' ');
INSERT INTO `loan-evaluation-system`.credit_info_dictionary (id, type_name, credit_bureau_name, type, description, example) VALUES (5, 'annual_income', 'SCB', 'ORIGIN', '연소득', ' ');
INSERT INTO `loan-evaluation-system`.credit_info_dictionary (id, type_name, credit_bureau_name, type, description, example) VALUES (6, 'is_regular_employee', 'SCB', 'ORIGIN', '정규직 여부', ' ');
INSERT INTO `loan-evaluation-system`.credit_info_dictionary (id, type_name, credit_bureau_name, type, description, example) VALUES (7, 'short_term_card_loan_usage_count', 'SCB', 'ORIGIN', '단기카드대출 이용횟수', ' ');
INSERT INTO `loan-evaluation-system`.credit_info_dictionary (id, type_name, credit_bureau_name, type, description, example) VALUES (8, 'loan_clear_count', 'SCB', 'ORIGIN', '대출 완납 횟수', ' ');
INSERT INTO `loan-evaluation-system`.credit_info_dictionary (id, type_name, credit_bureau_name, type, description, example) VALUES (9, 'credit_card_issue_count', 'SCB', 'ORIGIN', '신용카드 발행 회수', ' ');

INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (1, '7', '단기카드대출 이용횟수', 'EQUALS', null, 0.000000000, null, 100, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (2, '7', '단기카드대출 이용횟수', 'GREATER_THAN_OR_EQUALS', 'LESS_THAN', 1.000000000, 3.000000000, 50, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (3, '7', '단기카드대출 이용횟수', 'GREATER_THAN_OR_EQUALS', null, 3.000000000, null, 0, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (4, '8', '대출 완납 횟수', 'EQUALS', null, 0.000000000, null, 0, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (5, '8', '대출 완납 횟수', 'GREATER_THAN_OR_EQUALS', 'LESS_THAN', 1.000000000, 3.000000000, 100, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (6, '8', '대출 완납 횟수', 'GREATER_THAN_OR_EQUALS', null, 3.000000000, null, 200, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (7, '9', '신용카드 발행 회수', 'EQUALS', null, 0.000000000, null, 0, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (8, '9', '신용카드 발행 회수', 'GREATER_THAN_OR_EQUALS', null, 1.000000000, null, 100, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (9, '1', '인정소득', 'LESS_THAN', null, 30000000.000000000, 0.000000000, 100, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (10, '1', '인정소득', 'GREATER_THAN_OR_EQUALS', 'LESS_THAN', 30000000.000000000, 40000000.000000000, 200, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (11, '1', '인정소득', 'GREATER_THAN_OR_EQUALS', 'LESS_THAN', 40000000.000000000, 50000000.000000000, 250, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (12, '1', '인정소득', 'GREATER_THAN_OR_EQUALS', 'LESS_THAN', 50000000.000000000, 60000000.000000000, 300, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (13, '1', '인정소득', 'GREATER_THAN_OR_EQUALS', 'LESS_THAN', 60000000.000000000, 70000000.000000000, 350, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (14, '1', '인정소득', 'GREATER_THAN_OR_EQUALS', null, 70000000.000000000, null, 400, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (15, '2', '대부업 대출 이용 횟수', 'EQUALS', null, 0.000000000, null, 100, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (16, '2', '대부업 대출 이용 횟수', 'GREATER_THAN_OR_EQUALS', 'LESS_THAN', 1.000000000, 3.000000000, 50, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (17, '2', '대부업 대출 이용 횟수', 'GREATER_THAN_OR_EQUALS', null, 3.000000000, null, 0, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (18, '3', '신용등급', 'EQUALS', null, 1.000000000, null, 500, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (19, '3', '신용등급', 'EQUALS', null, 2.000000000, null, 450, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (20, '3', '신용등급', 'EQUALS', null, 3.000000000, null, 400, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (21, '3', '신용등급', 'EQUALS', null, 4.000000000, null, 350, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (22, '3', '신용등급', 'EQUALS', null, 5.000000000, null, 300, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (23, '3', '신용등급', 'EQUALS', null, 6.000000000, null, 250, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (24, '3', '신용등급', 'EQUALS', null, 7.000000000, null, 200, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (25, '3', '신용등급', 'EQUALS', null, 8.000000000, null, 150, '9999-12-31 23:59:59');
INSERT INTO `loan-evaluation-system`.internal_evaluation_policies (id, credit_info_dictionary_id, description, operator1, operator2, value1, value2, evaluation_score, expired_at) VALUES (26, '3', '신용등급', 'EQUALS', null, 9.000000000, null, 100, '9999-12-31 23:59:59');

INSERT INTO `loan-evaluation-system`.internal_css_grade_policies (css_grade, min_evaluation_score, max_evaluation_score,
                                                                  min_loan_amount, max_loan_amount, interest_rate,
                                                                  min_loan_term, max_loan_term, expired_at)
VALUES (9, 0, 300, 2000, 3000, 9, 12, 12, '9999-12-31 23:59:59');

INSERT INTO `loan-evaluation-system`.internal_css_grade_policies (css_grade, min_evaluation_score, max_evaluation_score,
                                                                  min_loan_amount, max_loan_amount, interest_rate,
                                                                  min_loan_term, max_loan_term, expired_at)
VALUES (8, 301, 400, 2000, 3000, 8, 12, 12, '9999-12-31 23:59:59');

INSERT INTO `loan-evaluation-system`.internal_css_grade_policies (css_grade, min_evaluation_score, max_evaluation_score,
                                                                  min_loan_amount, max_loan_amount, interest_rate,
                                                                  min_loan_term, max_loan_term, expired_at)
VALUES (7, 401, 500, 2000, 3000, 7, 12, 12, '9999-12-31 23:59:59');

INSERT INTO `loan-evaluation-system`.internal_css_grade_policies (css_grade, min_evaluation_score, max_evaluation_score,
                                                                  min_loan_amount, max_loan_amount, interest_rate,
                                                                  min_loan_term, max_loan_term, expired_at)
VALUES (6, 501, 600, 2000, 3000, 6, 12, 12, '9999-12-31 23:59:59');

INSERT INTO `loan-evaluation-system`.internal_css_grade_policies (css_grade, min_evaluation_score, max_evaluation_score,
                                                                  min_loan_amount, max_loan_amount, interest_rate,
                                                                  min_loan_term, max_loan_term, expired_at)
VALUES (5, 601, 700, 3000, 4000, 5, 12, 24, '9999-12-31 23:59:59');

INSERT INTO `loan-evaluation-system`.internal_css_grade_policies (css_grade, min_evaluation_score, max_evaluation_score,
                                                                  min_loan_amount, max_loan_amount, interest_rate,
                                                                  min_loan_term, max_loan_term, expired_at)
VALUES (4, 701, 800, 3000, 4000, 4, 12, 24, '9999-12-31 23:59:59');

INSERT INTO `loan-evaluation-system`.internal_css_grade_policies (css_grade, min_evaluation_score, max_evaluation_score,
                                                                  min_loan_amount, max_loan_amount, interest_rate,
                                                                  min_loan_term, max_loan_term, expired_at)
VALUES (3, 801, 900, 3000, 5000, 3, 12, 24, '9999-12-31 23:59:59');

INSERT INTO `loan-evaluation-system`.internal_css_grade_policies (css_grade, min_evaluation_score, max_evaluation_score,
                                                                  min_loan_amount, max_loan_amount, interest_rate,
                                                                  min_loan_term, max_loan_term, expired_at)
VALUES (2, 901, 1000, 3000, 5000, 2, 12, 60, '9999-12-31 23:59:59');

INSERT INTO `loan-evaluation-system`.internal_css_grade_policies (css_grade, min_evaluation_score, max_evaluation_score,
                                                                  min_loan_amount, max_loan_amount, interest_rate,
                                                                  min_loan_term, max_loan_term, expired_at)
VALUES (1, 1001, 9999, 3000, 8000, 1, 12, 60, '9999-12-31 23:59:59');

