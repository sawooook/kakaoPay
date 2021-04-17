# 카카오페이 사전과제 3 - 지자체 협약 지원 API 개발
## 목차
- [개발 환경](#개발-환경)
- [빌드 및 실행하기](#빌드-및-실행하기)
- [기능 요구사항](#기능-요구사항)
- [개발 제약사항](#개발-제약사항)

---
## 기능 요구사항
### 필수사항
- 데이터 파일(`.csv`)에서 각 레코드를 데이터베이스에 저장하는 API 개발
- 주택금융 공급 금융기관(은행) 목록을 출력하는 API 개발
- 년도별 각 금융기관의 지원금액 합계를 출력하는 API 개발
    - 아래는 출력 예시

```
{
    “name”:”주택금융 공급현황”,
    [
        {   “year”: "2004년”,
            “total_amount”: 14145,
            “detail_amount”: {“주택도시기금”: 2143,”국민은행”: 4356,”우리은행”: 5342,...,”기타은행”: 1324},
        }
        {   “year”: "2005년”,
            “total_amount”: 23145,
            “detail_amount”: {“주택도시기금”: 1243,”국민은행”: 5336,”우리은행”: 4849,...,”기타은행”: 1093},
        }

        ...

        {   “year”: "2017년”,
            “total_amount”: 33145,
            “detail_amount”: {“주택도시기금”: 2240,”국민은행”: 4338,”우리은행”: 5131,...,”기타은행”: 1392}
        }
    ]
}
```

- 각 년도별 각 기관의 전체 지원 금액 중에서 가장 큰 금액의 기관명을 출력하는 API 개발
    - 예를들어, 2005년 ~ 2017년 중에 2010년 국민은행의 전체 지원금액(1월 ~ 12월 지원 합계)이 가장 높았다면 `{ “year": “2010” , "bank": “국민은행”}`을 결과로 출력한다.
    - 아래는 출력 예시

```
{
    “year": 2010 ,
    "bank": “국민은행”
}
```

- 전체 년도(2005 ~ 2016)에서 외환은행의 지원금액 평균 중에서 가장 작은 금액과 큰 금액을 출력하는 API 개발
    - 예를들어, 2005년 ~ 2016년 외환은행의 평균 지원금액(매년 12달의 지원금액 평균값)을 계산하여 가장 작은 값과 큰 값을 출력한다. 소수점 이하는 반올림해서 계산한다.
    - 아래는 출력 예시

```
{
    “bank”:”외환은행”,
    "support_amount”:
    [
        { ”year”: 2008 , ”amount”: 78},
        { ”year”: 2015 , ”amount”: 1702}
    ]
}
```

### 선택사항
#### 특정 은행의 특정 달에 대해서 2018년도 해당 달에 금융지원 금액을 예측하는 API 개발
- 단, 예측 알고리즘을 무엇을 써야하는지에 대한 제약은 없지만, 가장 근사치에 가까울 수록 높은 점수 부여.
- 입/출력 샘플 예제

알고리즘에 따라서 다를 수 있지만, 근사치를 제시한 것이다. 데이터는 2005년부터 2017년까지의 데이터로 2018년 금융지원 금약을 예측하면 된다.

입력

```
{
    “bank”:”국민은행”,
    “month”: 2
}
```

출력

```
{
    “bank”:”bnk3726”,
    “year”: 2018,
    “month”: 2,
    "amount”: 4850
}
```

국민은행의 기관코드가 “bnk3726”라는 가정으로, 국민은행이 2018년도 2월달에 4850억을 지원할것이라는 예측 결과이다.


## 개발 제약사항
### 필수사항
- API 기능명세에서 기술된 API 를 모두 개발한다.
- 데이터 영속성 관리 및 매핑을 위한 ORM(Object Relational Mapping)을 사용하여 각 엔티티를 정의하고 레퍼지토리를 개발한다.
    - 단, 엔티티 디자인은 지원자의 문제해결 방법에 따라 자유롭게 한다.
    - 단, 주택금융 공급기관은 독립 엔티티(기관명과 기관코드)로 디자인한다. `{“institute_name”, “institute_code”}`
- 단위 테스트 (Unit Test) 코드를 개발하여 각 기능을 검증한다.
- 모든 입/출력은 JSON 형태로 주고 받는다.
- 단, 각 API 에 HTTP Method 들(GET|POST|PUT|DEL)은 자유롭게 선택한다.

### 선택사항
- API 인증을 위해 JWT(Json Web Token)를 이용해서 Token 기반 API 인증 기능을 개발하고 각 API 호출 시에 HTTP Header 에 발급받은 토큰을 가지고 호출한다.
    - **signup 계정생성 API**: 입력으로 ID, PW 받아 내부 DB 에 계정 저장하고 토큰 생성하여 출력
        - 단, 패스워드는 인코딩하여 저장한다.
        - 단, 토큰은 특정 secret 으로 서명하여 생성한다.
    - **signin 로그인 API**: 입력으로 생성된 계정 (ID, PW)으로 로그인 요청하면 토큰을 발급한다.
    - **refresh 토큰 재발급 API**: 기존에 발급받은 토큰을 Authorization 헤더에 “Bearer Token”으로 입력 요청을 하면 토큰을 재발급한다.
