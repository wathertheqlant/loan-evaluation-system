서울신용정보에서 제공하는 신용정보의 종류는 아래와 같습니다.

| 신용정보 명       | 신용정보 코드명                         | 데이터 타입     | 설명                                   |
|--------------|----------------------------------|------------|--------------------------------------|
| 이름           | name                             | string     |                                      |
| 주민번호         | resident_number                  | string(13) |                                      |
| 대부업 대출 이용 횟수 | major_loan_usage_count           | int        | 제3금융 혹은 대부업체에서 대출한 회수                |
| 신용등급         | credit_rating                    | int        |                                      |
| 대출 연체 횟수     | loan_default_count               | int        |                                      |
| 연소득          | annual_income                    | bigint     |                                      |
| 정규직 여부       | is_regular_employee              | boolean    | false인 경우 프리랜서로 판단<br>- 연소득 차감 계산 필요 |
| 단기카드대출 이용횟수  | short_term_card_loan_usage_count | int        |                                      |
| 대출 완납 횟수     | loan_clear_count                 | int        |                                      |
| 신용카드 발행 회수   | credit_card_issue_count          | int        |                                      |
