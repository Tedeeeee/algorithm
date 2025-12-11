# 🧠 알고리즘 풀이 기록 

### 🔵 배열 (Array) / 리스트 (List)

- <img src="https://static.solved.ac/tier_small/4.svg" width="13px" />&nbsp;
  [BOJ 13300 - 방 배정](https://www.acmicpc.net/problem/13300)
- <img src="https://static.solved.ac/tier_small/8.svg" width="13px" />&nbsp;
  [BOJ 3272 - 두 수의 합](https://www.acmicpc.net/problem/3272)
- <img src="https://static.solved.ac/tier_small/4.svg" width="13px" />&nbsp;
  [BOJ 2577 - 숫자의 개수](https://www.acmicpc.net/problem/2577)
- <img src="https://static.solved.ac/tier_small/6.svg" width="13px" />&nbsp;
  [BOJ 1475 - 방 번호](https://www.acmicpc.net/problem/1475)

#### 🔵 브루트포스
> 브루트포스(Brute Force)는  
> **가능한 모든 경우를 전부 탐색해서 해결하는 방식**이다.
> ##### Brute Force의 핵심 특징
> - 빠른 알고리즘이 아니라 **정확한 알고리즘**이다.
> - 경우의 수가 많지 않을 때 사용할 수 있다.
> - 가장 단순하고, 가장 구현하기 쉬운 방식이다.
>
> ##### 언제 사용하는가?
> - 문제에서 <u>**모든 조합을 확인해야 한다**</u>는 뉘앙스가 있을 때
> - 탐색 대상의 크기가 작아서 **전체 탐색해도 시간 초과가 나지 않을 때**
> - 최적화보다 정답을 찾는 게 중요할 때

- <img src="https://static.solved.ac/tier_small/4.svg" width="13px" />&nbsp;
  [BOJ 2798 - 블랙잭](https://www.acmicpc.net/problem/2798)
- <img src="https://static.solved.ac/tier_small/5.svg" width="13px" />&nbsp;
  [BOJ 2309 - 일곱 난쟁이](https://www.acmicpc.net/problem/2309)

---
### 🔵 스택
> 스택(Stack)은 **LIFO(Last-In First-Out)** 방식의 자료구조이다.  
> 데이터를 위에서만 넣고(pop) 뺄 수 있으며,  
> **괄호 검사, 되돌리기(Undo), DFS, 수식 계산** 등의 기본 원리로 사용된다.

- <img src="https://static.solved.ac/tier_small/9.svg" width="13px" />&nbsp;
  [BOJ 1874 - 스택 수열](https://www.acmicpc.net/problem/1874)
- <img src="https://static.solved.ac/tier_small/8.svg" width="13px" />&nbsp;
  [BOJ 1935 - 후위 표현식2](https://www.acmicpc.net/problem/1935)
- <img src="https://static.solved.ac/tier_small/9.svg" width="13px" />&nbsp;
  [BOJ 10799 - 쇠막대기](https://www.acmicpc.net/problem/10799)
- <img src="https://static.solved.ac/tier_small/11.svg" width="13px" />&nbsp;
  [BOJ 2504 - 괄호의 값](https://www.acmicpc.net/problem/2504)
- <img src="https://static.solved.ac/tier_small/11.svg" width="13px" />&nbsp;
  [BOJ 2493 - 탑](https://www.acmicpc.net/problem/2493) **(추가 설명 있음)**
- <img src="https://static.solved.ac/tier_small/7.svg" width="13px" />&nbsp;
  [BOJ 4949 - 균형잡힌 세상](https://www.acmicpc.net/problem/4949)
- <img src="https://static.solved.ac/tier_small/12.svg" width="13px" />&nbsp;
  [BOJ 22942 - 데이터 체커](https://www.acmicpc.net/problem/22942) **(추가 설명 있음 : 다시 풀어도 좋을 문제)**

---
### 🔵 큐
> 큐(Queue)는 FIFO(First-In First-Out) 구조로  
> 앞에서 꺼내고 뒤에 넣는 방식의 자료구조다.  
> 덱(Deque)은 앞뒤 양쪽에서 삽입/삭제가 가능한 확장 구조로,  
> 원형 이동(circular rotation) 같은 문제에 자주 활용된다.

- <img src="https://static.solved.ac/tier_small/6.svg" width="13px" />&nbsp;
  [BOJ 2346 - 풍선 터뜨리기](https://www.acmicpc.net/problem/2346) ( deque & 원형 리스트 구현 )
- <img src="https://static.solved.ac/tier_small/8.svg" width="13px" />&nbsp;
  [BOJ 1966 - 프린터 큐](https://www.acmicpc.net/problem/1966)
- <img src="https://static.solved.ac/tier_small/8.svg" width="13px" />&nbsp;
  [BOJ 18115 - 카드 놓기](https://www.acmicpc.net/problem/18115)
- <img src="https://static.solved.ac/tier_small/8.svg" width="13px" />&nbsp;
  [BOJ 1021 - 회전하는 큐](https://www.acmicpc.net/problem/1021) (Deque 사용)
---
### 🔵 맵 ( HashMap )
> Key–Value 구조로 데이터를 저장하는 자료구조  
> 특정 값의 존재 여부 확인이나 빈도(count) 관리에 매우 많이 사용된다.

- <img src="https://static.solved.ac/tier_small/7.svg" width="13px" />&nbsp;
  [BOJ 10816 - 숫자 카드2](https://www.acmicpc.net/problem/10816)

---
### 🔵 셋 ( Set / HashSet )
> **중복을 허용하지 않는 자료구조**  
> 데이터의 **존재 여부 관리**에 최적화되어 있으며, 삽입·삭제·조회가 매우 빠르다.

- <img src="https://static.solved.ac/tier_small/6.svg" width="13px" />&nbsp;
  [BOJ 7785 - 회사에 있는 사람](https://www.acmicpc.net/problem/7785)

---

### 🔵 집합 (Set)

---
### 🔵 정렬 (Sorting)

> 정렬은 데이터를 특정 기준에 따라 재배치하는 알고리즘이다.  
> 대표적으로 버블 정렬, 삽입 정렬, 선택 정렬, 퀵 정렬, 병합 정렬 등이 있다.  
> 대부분의 코테에서는 내장 정렬 함수 (Arrays.sort, Collections.sort) 를 사용해도 충분하다.

- <img src="https://static.solved.ac/tier_small/4.svg" width="13px" />&nbsp;
  [BOJ 2750 - 수 정렬하기](https://www.acmicpc.net/problem/2750)
- <img src="https://static.solved.ac/tier_small/6.svg" width="13px" />&nbsp;
  [BOJ 2822 - 점수 계산](https://www.acmicpc.net/problem/2822)
- <img src="https://static.solved.ac/tier_small/6.svg" width="13px" />&nbsp;
  [BOJ 16435 - 스네이크 버드](https://www.acmicpc.net/problem/16435)
- <img src="https://static.solved.ac/tier_small/8.svg" width="13px" />&nbsp;
  [BOJ 1431 - 시리얼 번호](https://www.acmicpc.net/problem/1431) ( 추가 설명 있음 )
- <img src="https://static.solved.ac/tier_small/7.svg" width="13px" />&nbsp;
  [BOJ 11652 - 카드](https://www.acmicpc.net/problem/11652) ( 추가 설명 있음 )
- <img src="https://static.solved.ac/tier_small/6.svg" width="13px" />&nbsp;
  [BOJ 10814 - 나이순 정렬](https://www.acmicpc.net/problem/10814) ( 객체 사용 )

---
### 🔵 이진 탐색

---
### 🔵 투 포인터 / 슬라이딩 윈도우
> 투 포인터(Two Pointers)는
> 두 개의 인덱스를 양쪽 또는 같은 방향으로 이동시키며 최적값을 찾는 알고리즘 기법이다.
> 
> 대표적으로
> 
> - 구간의 최대/최소 찾기
> - 합이 특정 값을 만족하는 쌍 찾기
> - 배열/문자열에서 부분구간 탐색
> 등에 활용된다.
> 
> 슬라이딩 윈도우(Sliding Window)는 투 포인터 기법의 확장으로,  
> 연속된 구간을 유지하며 창(window)을 움직여 문제를 해결한다.

- [leetCode 11 - Container With Most Water](https://leetcode.com/problems/container-with-most-water/)

---
### 🔵 그리디

---
### 🔵 그래프 탐색 (DFS)
> 한 방향으로 갈 수 있을 때까지 깊게 내려간 뒤,  
> 더 이상 갈 수 없으면 이전 분기로 되돌아오는 탐색 방식이다.  
>   
> 주로 재귀 또는 스택으로 구현되며, 트리·그래프의 구조를 파악하거나  
> **경로 존재 여부, 거리 누적, 백트래킹 문제**에 자주 사용된다.

---
### 🔵 그래프 탐색 (BFS)
> 현재 노드에서 가까운 노드부터 차례대로 탐색하는 방식이다.
> 
> 큐(Queue)를 사용하여 구현하며, **최단 거리 탐색이나 레벨 개념이 중요한 문제**에서 주로 활용된다.

- <img src="https://static.solved.ac/tier_small/10.svg" width="13px" />&nbsp;
  [BOJ 1926 - 그림](https://www.acmicpc.net/problem/1926)
- <img src="https://static.solved.ac/tier_small/10.svg" width="13px" />&nbsp;
  [BOJ 2178 - 미로 탐색](https://www.acmicpc.net/problem/2178)
- <img src="https://static.solved.ac/tier_small/10.svg" width="13px" />&nbsp;
  [BOJ 7576 - 토마토](https://www.acmicpc.net/problem/7576)
- <img src="https://static.solved.ac/tier_small/9.svg" width="13px" />&nbsp;
  [BOJ 1012 - 유기농 배추](https://www.acmicpc.net/problem/1012) (DFS로도 풀 수 있음)
- <img src="https://static.solved.ac/tier_small/10.svg" width="13px" />&nbsp;
  [BOJ 1697 - 숨바꼭질](https://www.acmicpc.net/problem/1697)
- <img src="https://static.solved.ac/tier_small/10.svg" width="13px" />&nbsp;
  [BOJ 7562 - 나이트의 이동](https://www.acmicpc.net/problem/7562)
- <img src="https://static.solved.ac/tier_small/13.svg" width="13px" />&nbsp;
  [BOJ 4179 - 불!](https://www.acmicpc.net/problem/4179) (2개의 BFS가 필요했던 문제)
- <img src="https://static.solved.ac/tier_small/11.svg" width="13px" />&nbsp;
  [BOJ 10026 - 적록색약](https://www.acmicpc.net/problem/10026) (2개의 BFS가 필요했던 문제)
- <img src="https://static.solved.ac/tier_small/10.svg" width="13px" />&nbsp;
  [BOJ 2468 - 안전 영역](https://www.acmicpc.net/problem/2468) (2개의 BFS가 필요했던 문제)
- <img src="https://static.solved.ac/tier_small/11.svg" width="13px" />&nbsp;
  [BOJ 6593 - 상범 빌딩](https://www.acmicpc.net/problem/6593) (3차원 배열을 사용한 풀이)
- <img src="https://static.solved.ac/tier_small/10.svg" width="13px" />&nbsp;
  [BOJ 2667 - 단지번호 붙이기](https://www.acmicpc.net/problem/2667)
- <img src="https://static.solved.ac/tier_small/10.svg" width="13px" />&nbsp;
  [BOJ 5014 - 스타트링크](https://www.acmicpc.net/problem/5014)

---
### 🟠 백트래킹

---
### 🔵 트리
> 트리(Tree)는 사이클이 없는 연결 그래프로,  
> N개의 노드가 있을 때 항상 N-1개의 간선을 갖는다.  
> 루트(Root)를 기준으로 하면 모든 노드는 유일한 부모 하나를 가지며,  
> 부모–자식 관계를 통해 계층적인 구조를 이룬다.
> 
> 트리 문제의 핵심은
> 
> - 루트 기준 구조를 만드는 것
> - DFS / BFS로 부모, 깊이, 서브트리 관계를 구하는 것이며,  
> 인접 리스트로 연결 정보를 저장한 뒤 탐색을 통해 트리 구조를 “만들어내는” 과정이 중요하다.

- <img src="https://static.solved.ac/tier_small/9.svg" width="13px" />&nbsp;
  [BOJ 11725 - 트리의 부모 찾기](https://www.acmicpc.net/problem/11725)
- <img src="https://static.solved.ac/tier_small/7.svg" width="13px" />&nbsp;
  [BOJ 9372 - 상근이의 여행](https://www.acmicpc.net/problem/9372) ( 트리의 성격을 묻는 문제 )
- <img src="https://static.solved.ac/tier_small/10.svg" width="13px" />&nbsp;
  [BOJ 20364 - 부동산 다툼](https://www.acmicpc.net/problem/20364) ( 추가 설명 있음 )
- <img src="https://static.solved.ac/tier_small/10.svg" width="13px" />&nbsp;
  [BOJ 1991 - 트리 순회](https://www.acmicpc.net/problem/1991)
- <img src="https://static.solved.ac/tier_small/11.svg" width="13px" />&nbsp;
  [BOJ 1240 - 노드사이의 거리](https://www.acmicpc.net/problem/1240)
- <img src="https://static.solved.ac/tier_small/12.svg" width="13px" />&nbsp;
  [BOJ 22856 - 트리 순회](https://www.acmicpc.net/problem/22856) ( 추가 설명 있음 )
- <img src="https://static.solved.ac/tier_small/11.svg" width="13px" />&nbsp;
  [BOJ 1068 - 트리](https://www.acmicpc.net/problem/1068) ( 다시 풀어봤으면 좋겠음 )
- <img src="https://static.solved.ac/tier_small/12.svg" width="13px" />&nbsp;
  [BOJ 20955 - 민서의 응급 수술](https://www.acmicpc.net/problem/20955) ( 다시 풀어봤으면 좋겠음 )
- <img src="https://static.solved.ac/tier_small/12.svg" width="13px" />&nbsp;
  [BOJ 4803 - 트리](https://www.acmicpc.net/problem/4803) ( 20955 와 흡사하지만 다름 )

---
### 🟠 힙 / 우선순위 큐


---
### 🟢 시뮬레이션 (Simulation)

- <img src="https://static.solved.ac/tier_small/2.svg" width="13px" />&nbsp;
  [BOJ 2480 - 주사위 세 개](https://www.acmicpc.net/problem/2480)
- <img src="https://static.solved.ac/tier_small/3.svg" width="13px" />&nbsp;
  [BOJ 15953 - 상금 헌터](https://www.acmicpc.net/problem/15953)
- <img src="https://static.solved.ac/tier_small/4.svg" width="13px" />&nbsp;
  [BOJ 15969 - 행복](https://www.acmicpc.net/problem/15969) **(코드에 추가 설명있음)**
- <img src="https://static.solved.ac/tier_small/4.svg" width="13px" />&nbsp;
  [BOJ 17389 - 보너스 점수](https://www.acmicpc.net/problem/17389)
- <img src="https://static.solved.ac/tier_small/4.svg" width="13px" />&nbsp;
  [BOJ 2920 - 음계](https://www.acmicpc.net/problem/2920)
- <img src="https://static.solved.ac/tier_small/2.svg" width="13px" />&nbsp;
  [BOJ 10808 - 알파벳 갯수](https://www.acmicpc.net/problem/10808)
- <img src="https://static.solved.ac/tier_small/5.svg" width="13px" />&nbsp;
  [BOJ 3035 - 스캐너](https://www.acmicpc.net/problem/3035)
- <img src="https://static.solved.ac/tier_small/4.svg" width="13px" />&nbsp;
  [BOJ 2979 - 트럭 주차](https://www.acmicpc.net/problem/2979)
- <img src="https://static.solved.ac/tier_small/6.svg" width="13px" />&nbsp;
  [BOJ 17269 - 이름궁합 테스트](https://www.acmicpc.net/problem/17269)
- <img src="https://static.solved.ac/tier_small/6.svg" width="13px" />&nbsp;
  [BOJ 17269 - 이름궁합 테스트](https://www.acmicpc.net/problem/17269)
- <img src="https://static.solved.ac/tier_small/3.svg" width="13px" />&nbsp;
  [BOJ 2953 - 나는 요리사다](https://www.acmicpc.net/problem/2953)
- <img src="https://static.solved.ac/tier_small/3.svg" width="13px" />&nbsp;
  [BOJ 1547 - 공](https://www.acmicpc.net/problem/1547)
- <img src="https://static.solved.ac/tier_small/3.svg" width="13px" />&nbsp;
  [BOJ 5597 - 과제 안 내신 분..?](https://www.acmicpc.net/problem/5597)
- <img src="https://static.solved.ac/tier_small/6.svg" width="13px" />&nbsp;
  [BOJ 1652 - 누울 자리를 찾아라](https://www.acmicpc.net/problem/1652)
- <img src="https://static.solved.ac/tier_small/5.svg" width="13px" />&nbsp;
  [BOJ 1110 - 더하기 사이클](https://www.acmicpc.net/problem/1110)
- <img src="https://static.solved.ac/tier_small/5.svg" width="13px" />&nbsp;
  [BOJ 2816 - 디지털 티비](https://www.acmicpc.net/problem/2816)

---
### 🟣 다이나믹 프로그래밍 (DP)
> DP(Dynamic Programming)는  
> **이미 계산한 값을 다시 계산하지 않도록 저장해두는 방식이다.**
>
> - 큰 문제를 **작은 부분 문제**로 나누고,
> - 계산한 값을 저장해서 **중복 계산을 줄인다.**

- <img src="https://static.solved.ac/tier_small/4.svg" width="13px" />&nbsp;
  [BOJ 2747 - 피보나치 수](https://www.acmicpc.net/problem/2747)

---
### 🟣 최단 경로 알고리즘
