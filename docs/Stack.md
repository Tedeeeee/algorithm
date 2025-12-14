# 🧱 Stack (스택)

스택(Stack)은  
**마지막에 넣은 것을 가장 먼저 꺼내는(LIFO) 자료구조**다.

코딩테스트에서 스택은  
👉 “자료구조 하나”라기보다는  
👉 **순서·되돌리기·짝 맞추기·상태 관리**를 표현하는 도구다.

---

## 언제 스택을 떠올려야 하나?
문제에서 아래 신호가 보이면 스택을 의심한다.

- 가장 최근 상태로 되돌아가야 한다
- 이전 선택을 취소한다 (undo)
- 짝을 맞춘다
- 순서가 뒤집힌다
- 중첩 구조가 있다

📌 핵심 신호
> **“지금 이 상태를 나중에 다시 써야 한다”**

---

## 스택의 핵심 사고
스택 문제의 본질은  
**“지금 정보를 쌓아두고, 나중에 꺼내 쓴다”**는 사고다.

그래서 스택 문제를 풀 때 항상 이 질문을 던진다.

> “이 정보를  
> 언제 다시 꺼내 써야 하지?”

---

## 스택 사고 흐름 (공식처럼 외우기)

1. **스택에 무엇을 저장할지 결정**
    - 값?
    - 인덱스?
    - 상태?
2. **언제 push 하는지**
3. **언제 pop 하는지**
4. **pop 조건이 명확한지**

📌 스택 문제는  
👉 **push / pop 타이밍 싸움**이다.

---

## 스택의 대표 사용 패턴

### 1️⃣ 괄호 / 짝 맞추기
- 열림 → push
- 닫힘 → pop

📌 주의
- 스택 비었는데 pop 하면 ❌
- 마지막에 스택이 비어 있어야 정답

---

### 2️⃣ 이전 상태 추적
- 수식 계산
- undo
- 되돌리기

📌 스택에는  
👉 **“돌아갈 지점”**을 넣는다.

---

### 3️⃣ 단조 스택 (Monotonic Stack)
- 스택 내부가 항상 증가 / 감소
- 비교 대상 제거하며 유지

📌 대표 문제
- 탑
- 오큰수
- 히스토그램

---

## 스택 문제에서 반드시 점검할 것들
문제 풀기 전에 이걸 체크해라.

- 스택에 값 vs 인덱스 중 무엇을 넣는가?
- pop 조건이 정확한가?
- pop 후 처리를 했는가?
- 남은 스택을 어떻게 처리할 것인가?

---

## 스택에서 자주 하는 실수
(실전에서 진짜 많이 나온다)

- 스택이 비었는데 pop
- pop 조건을 반대로 작성
- 마지막 스택 정리 누락
- 값과 인덱스를 혼동
- 중첩 구조 처리 누락

📌 스택 문제는  
👉 **조건 하나 틀리면 전부 틀린다.**

---

## 스택 vs 다른 자료구조
이 구분이 되면 스택이 보인다.

- “가장 최근 것” → 스택
- “가장 먼저” → 큐
- “정렬된 순서 유지” → 힙
- “모든 경우” → DFS / 백트래킹

---

## 문제 기록
(※ **직접 푼 문제만 작성**)


### <img src="https://static.solved.ac/tier_small/9.svg" width="13px" />&nbsp;[BOJ 1874 - 스택 수열](https://www.acmicpc.net/problem/1874)
### <img src="https://static.solved.ac/tier_small/8.svg" width="13px" />&nbsp;[BOJ 1935 - 후위 표현식2](https://www.acmicpc.net/problem/1935)
### <img src="https://static.solved.ac/tier_small/9.svg" width="13px" />&nbsp;[BOJ 10799 - 쇠막대기](https://www.acmicpc.net/problem/10799)
### <img src="https://static.solved.ac/tier_small/11.svg" width="13px" />&nbsp;[BOJ 2504 - 괄호의 값](https://www.acmicpc.net/problem/2504)
### <img src="https://static.solved.ac/tier_small/11.svg" width="13px" />&nbsp;[BOJ 2493 - 탑](https://www.acmicpc.net/problem/2493) **(추가 설명 있음)**
### <img src="https://static.solved.ac/tier_small/7.svg" width="13px" />&nbsp;[BOJ 4949 - 균형잡힌 세상](https://www.acmicpc.net/problem/4949)
### <img src="https://static.solved.ac/tier_small/12.svg" width="13px" />&nbsp;[BOJ 22942 - 데이터 체커](https://www.acmicpc.net/problem/22942) **(추가 설명 있음 : 다시 풀어도 좋을 문제)**
- 왜 스택을 썼는지
- 시간복잡도
- 실수 포인트 1개

---

## 한 줄 요약
> **“스택은  
> 가장 최근 상태를 관리하기 위한 도구다.”**
