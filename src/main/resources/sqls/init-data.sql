INSERT INTO `loan-evaluation-system`.sequences (name, value) VALUES ('credit_info_dictionary', 0);
INSERT INTO `loan-evaluation-system`.sequences (name, value) VALUES ('customer_css', 0);
INSERT INTO `loan-evaluation-system`.sequences (name, value) VALUES ('customers', 0);
INSERT INTO `loan-evaluation-system`.sequences (name, value) VALUES ('internal_css_evaluated_scores', 0);
INSERT INTO `loan-evaluation-system`.sequences (name, value) VALUES ('internal_css_grade_policies', 0);
INSERT INTO `loan-evaluation-system`.sequences (name, value) VALUES ('internal_policies', 0);
INSERT INTO `loan-evaluation-system`.sequences (name, value) VALUES ('scb_credit_info', 0);
INSERT INTO `loan-evaluation-system`.sequences (name, value) VALUES ('scb_credit_info_details', 0);
INSERT INTO `loan-evaluation-system`.sequences (name, value) VALUES ('test', 2);

INSERT INTO `loan-evaluation-system`.credit_info_dictionary (id, type_name, credit_bureau_name, type, description, example) VALUES (1, 'approved_income', 'SCB', 'CALCULATED', '인정소득', ' ');
INSERT INTO `loan-evaluation-system`.credit_info_dictionary (id, type_name, credit_bureau_name, type, description, example) VALUES (2, 'major_loan_usage_count', 'SCB', 'ORIGIN', '대부업 대출 이용 횟수', ' ');
INSERT INTO `loan-evaluation-system`.credit_info_dictionary (id, type_name, credit_bureau_name, type, description, example) VALUES (3, 'credit_rating', 'SCB', 'ORIGIN', '신용등급', ' ');
INSERT INTO `loan-evaluation-system`.credit_info_dictionary (id, type_name, credit_bureau_name, type, description, example) VALUES (4, 'loan_default_count', 'SCB', 'ORIGIN', '대출 연체 횟수', ' ');
INSERT INTO `loan-evaluation-system`.credit_info_dictionary (id, type_name, credit_bureau_name, type, description, example) VALUES (5, 'annual_income', 'SCB', 'ORIGIN', '연소득', ' ');
INSERT INTO `loan-evaluation-system`.credit_info_dictionary (id, type_name, credit_bureau_name, type, description, example) VALUES (6, 'is_regular_employee', 'SCB', 'ORIGIN', '정규직 여부', ' ');
INSERT INTO `loan-evaluation-system`.credit_info_dictionary (id, type_name, credit_bureau_name, type, description, example) VALUES (7, 'short_term_card_loan_usage_count', 'SCB', 'ORIGIN', '단기카드대출 이용횟수', ' ');
INSERT INTO `loan-evaluation-system`.credit_info_dictionary (id, type_name, credit_bureau_name, type, description, example) VALUES (8, 'loan_clear_count', 'SCB', 'ORIGIN', '대출 완납 횟수', ' ');
INSERT INTO `loan-evaluation-system`.credit_info_dictionary (id, type_name, credit_bureau_name, type, description, example) VALUES (9, 'credit_card_issue_count', 'SCB', 'ORIGIN', '신용카드 발행 회수', ' ');
