# 🌳 Tree

트리(Tree)는 **사이클이 없는 연결 그래프**이다.  
노드가 N개일 때 항상 **간선은 N-1개**이며,  
루트(Root)를 기준으로 **부모–자식 관계**가 명확하다.

코딩테스트에서 트리는  
👉 **그래프 + DFS/BFS 사고를 그대로 사용**한다.

---

## 언제 이걸 떠올려야 하나?
다음 특징이 보이면 트리 문제일 가능성이 높다.

- 노드 개수 N, 간선 N-1
- 사이클이 없다고 명시됨
- “부모”, “자식”, “루트”라는 표현
- 한 노드에서 다른 노드까지의 거리
- 서브트리, 깊이, 레벨

---

## 트리 문제의 핵심 사고
트리 문제의 본질은 **구조를 직접 만들어내는 것**이다.

1. 인접 리스트로 연결 정보 저장
2. 루트를 하나 정한다
3. DFS / BFS로 트리 구조를 만든다
4. 부모, 깊이, 거리, 서브트리 정보를 계산한다

📌 대부분의 트리 문제는  
**“그래프 → 트리로 변환 → 탐색”** 과정이다.

---

## 기본 구현 패턴

### 1️⃣ 인접 리스트
- 양방향 그래프처럼 저장
- 방문 배열로 부모–자식 방향을 고정

### 2️⃣ DFS / BFS
- DFS: 서브트리, 깊이, 재귀 구조에 유리
- BFS: 레벨, 거리 계산에 유리

---

## 자주 하는 실수
- 부모로 다시 되돌아가는 걸 막지 않음
- 루트를 정하지 않고 탐색 시작
- 방문 배열 없이 DFS 수행
- 트리인데 그래프처럼 사이클 처리함
- 노드 번호를 인덱스로 바로 쓰지 못함

---

## 문제 기록

### <img src="https://static.solved.ac/tier_small/9.svg" width="13px" />&nbsp;[BOJ 11725 - 트리의 부모 찾기](https://www.acmicpc.net/problem/11725)
### <img src="https://static.solved.ac/tier_small/7.svg" width="13px" />&nbsp;[BOJ 9372 - 상근이의 여행](https://www.acmicpc.net/problem/9372) ( 트리의 성격을 묻는 문제 )
### <img src="https://static.solved.ac/tier_small/10.svg" width="13px" />&nbsp;[BOJ 20364 - 부동산 다툼](https://www.acmicpc.net/problem/20364) ( 추가 설명 있음 )
### <img src="https://static.solved.ac/tier_small/10.svg" width="13px" />&nbsp;[BOJ 1991 - 트리 순회](https://www.acmicpc.net/problem/1991)
### <img src="https://static.solved.ac/tier_small/11.svg" width="13px" />&nbsp;[BOJ 1240 - 노드사이의 거리](https://www.acmicpc.net/problem/1240)
### <img src="https://static.solved.ac/tier_small/12.svg" width="13px" />&nbsp;[BOJ 22856 - 트리 순회](https://www.acmicpc.net/problem/22856) ( 추가 설명 있음 )
### <img src="https://static.solved.ac/tier_small/11.svg" width="13px" />&nbsp;[BOJ 1068 - 트리](https://www.acmicpc.net/problem/1068) ( 다시 풀어봤으면 좋겠음 )
### <img src="https://static.solved.ac/tier_small/12.svg" width="13px" />&nbsp;[BOJ 20955 - 민서의 응급 수술](https://www.acmicpc.net/problem/20955) ( 다시 풀어봤으면 좋겠음 )
### <img src="https://static.solved.ac/tier_small/12.svg" width="13px" />&nbsp;[BOJ 4803 - 트리](https://www.acmicpc.net/problem/4803) ( 20955 와 흡사하지만 다름 )


---

## 한 줄 요약
> **“트리는 그래프다.  
> 다만 사이클이 없고, 루트 기준으로 구조를 만든다.”**
