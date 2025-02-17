# 대출 심사 시스템 (Loan Screening System)

## 개요

본 프로젝트는 고객의 **이름과 주민등록번호**를 이용하여 **연소득, 신용정보**를 조회하고, 이를 바탕으로 **대출신용등급(CSS)** 을 산정하여 **대출 한도, 이자율, 대출 기간**을 결정하는 대출 심사 시스템입니다. 

### 📌 주요 기능
- 🏦 **고객 정보 조회**: 고객의 이름과 주민등록번호로 연소득 및 신용정보를 조회
- 📊 **신용 등급 산정**: 서울신용정보 데이터를 기반으로 내부 기준을 적용하여 대출 신용 등급(CSS) 산정
- 💰 **대출 조건 설정**: 산정된 신용 등급을 기준으로 대출 한도, 이자율, 대출 기간 결정
- 🔄 **결과 유효성 유지**: 산정된 대출 조건은 N일간(기본 7일) 동일한 결과를 반환

## 🛠 기술 스택 (TBU)

- **Backend**: Java 17, Spring Framework
- **Database**: 🗄 MySQL

## ⚙ 시스템 구성

1. 📂 **고객 정보 조회 API**: 이름과 주민번호로 서울신용정보 데이터 조회
2. 🎯 **신용 등급 산정 엔진**: 내부 기준을 기반으로 CSS 점수 계산
3. 💳 **대출 조건 산정 엔진**: 대출 한도, 이자율, 대출 기간 결정
4. 🏷 **결과 캐싱**: 7일간 동일한 결과 유지

## 📑 내부 기준 및 대출 조건

### 🔎 서울신용정보 데이터 항목

| 신용정보 명 | 코드명 | 타입     | 설명                  |
|-----------|-------|--------|---------------------|
| 이름 | name | string | 고객 이름               |
| 주민번호 | resident_number | string | 13자리 주민번호           |
| 대부업 대출 이용 횟수 | major_loan_usage_count | int    | 제3금융 또는 대부업 대출 횟수   |
| 신용등급 | credit_rating | int    | 1~9 등급              |
| 대출 연체 횟수 | loan_default_count | int    | 대출 연체 기록            |
| 연소득 | annual_income | bigint | 고객 연소득              |
| 정규직 여부 | is_regular_employee | boolean | 정규직 여부 (true/false) |
| 단기카드대출 이용횟수 | short_term_card_loan_usage_count | int    | 단기 카드 대출 횟수         |
| 대출 완납 횟수 | loan_clear_count | int    | 대출 완납 기록            |
| 신용카드 발행 회수 | credit_card_issue_count | int    | 신용카드 발급 횟수          |

### 📊 CSS 점수 산정 기준

| CSS 점수 범위 | CSS 등급 |
|--------------|---------|
| 0 ~ 300 | 9 |
| 301 ~ 400 | 8 |
| 401 ~ 500 | 7 |
| 501 ~ 600 | 6 |
| 601 ~ 700 | 5 |
| 701 ~ 800 | 4 |
| 801 ~ 900 | 3 |
| 901 ~ 1000 | 2 |
| 1001 이상 | 1 |

### 대출신용등급에 따른 한도, 이자율, 대출기간

| 대출신용등급(CSS) | 한도(만원) | 이자율(%) | 대출기간(개월) |
|---------|---------|--------|-------------|
| 1 | 6000 | 6% | 12 ~ 60 |
| 2 | 6000 | 7% | 12 ~ 60 |
| 3 | 5000 | 8% | 12 ~ 48 |
| 4 | 4000 | 9% | 12 ~ 48 |
| 5 | 3000 | 10% | 12 ~ 36 |
| 6 | 2000 | 11% | 12 ~ 36 |
| 7 | 1500 | 12% | 12 ~ 24 |
| 8 | 1000 | 13% | 12 ~ 24 |
| 9 | 500 | 14% | 12 ~ 24 |

## 🚀 설치 및 실행 방법

### 1️⃣ 프로젝트 클론
```sh
$ git clone https://github.com/your-repo/loan-screening.git
$ cd loan-screening
```

### 2️⃣ 환경 변수 설정
`.env` 파일을 생성하여 필요한 환경 변수 설정
```env
DATABASE_URL=postgresql://user:password@localhost:5432/loan_db
CACHE_URL=redis://localhost:6379
SECRET_KEY=your_secret_key
```

### 3️⃣ 가상 환경 설정 및 패키지 설치
```sh
$ python -m venv venv
$ source venv/bin/activate  # Mac/Linux
$ venv\Scripts\activate  # Windows
$ pip install -r requirements.txt
```

### 4️⃣ 데이터베이스 마이그레이션
```sh
$ python manage.py migrate  # Django
$ alembic upgrade head  # SQLAlchemy
```

### 5️⃣ 서버 실행
```sh
$ uvicorn main:app --host 0.0.0.0 --port 8000  # FastAPI
$ python manage.py runserver  # Django
```

## 🔗 API 엔드포인트 예시

### 📡 고객 정보 조회 API
```http
GET /api/customer?resident_number=930123*******
```
응답 예시:
```json
{
  "name": "홍길동",
  "resident_number": "930123*******",
  "credit_rating": 3,
  "annual_income": 50000000,
  "is_regular_employee": true
}
```

### 📊 대출 신용 등급 조회 API
```http
POST /api/loan-evaluation
```
요청 예시:
```json
{
  "resident_number": "930123*******"
}
```
응답 예시:
```json
{
  "credit_score": 750,
  "css_grade": 4,
  "loan_limit": 4000,
  "interest_rate": 8.5,
  "loan_period": "24 ~ 48개월"
}
```

## 🎯 향후 개선 사항
- 🤖 AI 기반 신용 평가 고도화
- 📡 실시간 데이터 반영 기능 추가
- 🔍 대출 한도 및 이자율 예측 기능 강화

---
본 프로젝트는 금융 기관에서 활용할 수 있도록 설계된 **대출 심사 자동화 시스템**입니다. 💼
