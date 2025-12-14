# 🧪 Simulation (시뮬레이션)

시뮬레이션(Simulation)은  
**문제에서 주어진 상황을 그대로 코드로 옮겨 실행하는 방식**이다.

코딩테스트에서 시뮬레이션은  
👉 알고리즘을 “선택”하는 문제가 아니라  
👉 **문제를 정확히 읽고 실수 없이 구현하는 문제**다.

---

## 언제 시뮬레이션을 떠올려야 하나?
문제에서 아래 신호가 보이면 시뮬레이션을 의심한다.

- 문제 설명이 길다
- 규칙이 많다
- 그대로 따라 하면 될 것 같다
- 시간 흐름이 있다
- 상태가 계속 바뀐다
- 구현만 잘하면 된다

📌 핵심 신호
> **“이거… 그냥 시키는 대로 하면 되는데?”**

---

## 시뮬레이션의 핵심 사고
시뮬레이션의 본질은  
**“사람이 하는 행동을 컴퓨터가 똑같이 하게 만든다”**는 것이다.

그래서 가장 중요한 질문은 이거다.

> “이 문제에서  
> 계속 변하는 상태는 무엇인가?”

이걸 못 잡으면  
👉 구현하다가 반드시 꼬인다.

---

## 시뮬레이션 사고 흐름 (공식처럼)

1. **상태 정의**
    - 위치
    - 방향
    - 점수
    - 시간
2. **초기 상태 설정**
3. **상태 변화 규칙 정리**
4. **시간 / 턴 / 이벤트 단위로 반복**
5. **종료 조건 명확히 설정**

📌 시뮬레이션은  
👉 상태 관리 싸움이다.

---

## 시뮬레이션의 대표 패턴

### 1️⃣ 단순 규칙 반복
- 주사위
- 점수 계산
- 문자열 변화

📌 반복문 + 조건문

---

### 2️⃣ 격자 시뮬레이션
- 2차원 배열
- 상하좌우 이동
- 회전

📌 방향 배열(dx, dy)이 핵심

---

### 3️⃣ 시간 단위 시뮬레이션
- 초 / 분 / 턴 단위
- 이벤트 발생

📌 “한 번에 처리” ❌  
📌 “한 단계씩 처리” ⭕

---

## 시뮬레이션 문제에서 반드시 점검할 것들
문제 풀기 전에 이걸 체크해라.

- 상태를 모두 변수로 표현했는가?
- 조건 분기가 빠짐없이 구현됐는가?
- 순서가 중요한가?
- 경계 조건을 처리했는가?
- 테스트 케이스를 손으로 따라가 봤는가?

---

## 시뮬레이션에서 자주 하는 실수
(실전에서 진짜 많이 터진다)

- 문제를 대충 읽음
- 상태 누락
- 순서 착각
- 조건 하나 빠뜨림
- 중간 상태 덮어씀

📌 시뮬레이션은  
👉 **알고리즘보다 독해력이 더 중요**하다.

---

## 시뮬레이션 vs 다른 알고리즘
이 차이를 구분해야 한다.

- 규칙 그대로 실행 → 시뮬레이션
- 최단 거리 → BFS
- 경우의 수 → 브루트포스
- 최적 선택 → 그리디

📌 시뮬레이션은  
👉 “생각보다 쉬워 보일 때” 의심해야 한다.

---

## 문제 기록
(※ **직접 푼 문제만 작성**)

### <img src="https://static.solved.ac/tier_small/2.svg" width="13px" />&nbsp;[BOJ 2480 - 주사위 세 개](https://www.acmicpc.net/problem/2480)
### <img src="https://static.solved.ac/tier_small/3.svg" width="13px" />&nbsp;[BOJ 15953 - 상금 헌터](https://www.acmicpc.net/problem/15953)
### <img src="https://static.solved.ac/tier_small/4.svg" width="13px" />&nbsp;[BOJ 15969 - 행복](https://www.acmicpc.net/problem/15969) **(코드에 추가 설명있음)**
### <img src="https://static.solved.ac/tier_small/4.svg" width="13px" />&nbsp;[BOJ 17389 - 보너스 점수](https://www.acmicpc.net/problem/17389)
### <img src="https://static.solved.ac/tier_small/4.svg" width="13px" />&nbsp;[BOJ 2920 - 음계](https://www.acmicpc.net/problem/2920)
### <img src="https://static.solved.ac/tier_small/2.svg" width="13px" />&nbsp;[BOJ 10808 - 알파벳 갯수](https://www.acmicpc.net/problem/10808)
### <img src="https://static.solved.ac/tier_small/5.svg" width="13px" />&nbsp;[BOJ 3035 - 스캐너](https://www.acmicpc.net/problem/3035)
### <img src="https://static.solved.ac/tier_small/4.svg" width="13px" />&nbsp;[BOJ 2979 - 트럭 주차](https://www.acmicpc.net/problem/2979)
### <img src="https://static.solved.ac/tier_small/6.svg" width="13px" />&nbsp;[BOJ 17269 - 이름궁합 테스트](https://www.acmicpc.net/problem/17269)
### <img src="https://static.solved.ac/tier_small/3.svg" width="13px" />&nbsp;[BOJ 2953 - 나는 요리사다](https://www.acmicpc.net/problem/2953)
### <img src="https://static.solved.ac/tier_small/3.svg" width="13px" />&nbsp;[BOJ 1547 - 공](https://www.acmicpc.net/problem/1547)
### <img src="https://static.solved.ac/tier_small/3.svg" width="13px" />&nbsp;[BOJ 5597 - 과제 안 내신 분..?](https://www.acmicpc.net/problem/5597)
### <img src="https://static.solved.ac/tier_small/6.svg" width="13px" />&nbsp;[BOJ 1652 - 누울 자리를 찾아라](https://www.acmicpc.net/problem/1652)
### <img src="https://static.solved.ac/tier_small/5.svg" width="13px" />&nbsp;[BOJ 1110 - 더하기 사이클](https://www.acmicpc.net/problem/1110)
### <img src="https://static.solved.ac/tier_small/5.svg" width="13px" />&nbsp;[BOJ 2816 - 디지털 티비](https://www.acmicpc.net/problem/2816)

- 어떤 상태를 관리했는지
- 구현에서 가장 헷갈렸던 규칙
- 실수 포인트 1개

---

## 한 줄 요약
> **“시뮬레이션은  
> 문제를 코드로 번역하는 능력을 본다.”**
