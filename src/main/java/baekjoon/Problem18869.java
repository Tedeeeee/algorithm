package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 18869 - 멀티버스 2
//  핵심 아이디어
//  1. 각 우주의 행성 배열을 "rank 배열(좌표 압축)"로 변환한다.
//  2. 같은 rank 배열을 가진 우주들을 Map으로 묶는다.
//  3. 같은 패턴이 c개 있으면 가능한 쌍의 개수는 c*(c-1)/2
// -------------------------------
public class Problem18869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 우주의 개수
        // M: 각 우주에 존재하는 행성의 개수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // arr[i] = i번째 우주의 행성 배열
        int[][] arr = new int[N][M];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // -------------------------------
        // 1️⃣ 각 우주별 좌표 압축 (rank 배열 만들기)
        // -------------------------------
        for (int i = 0; i < N; i++) {

            // 원본 배열을 복사 (정렬용)
            int[] clone = arr[i].clone();

            // 값의 대소 관계를 알기 위해 정렬
            Arrays.sort(clone);

            // 값 -> rank 매핑
            // 같은 값은 같은 rank를 가져야 함
            Map<Integer, Integer> rankMap = new HashMap<>();
            for (int j = 0; j < clone.length; j++) {
                // 처음 등장한 값만 rank 부여
                if (!rankMap.containsKey(clone[j])) {
                    rankMap.put(clone[j], j);
                }
            }

            // 원본 배열을 rank 배열로 변환
            for (int j = 0; j < M; j++) {
                arr[i][j] = rankMap.get(arr[i][j]);
            }
        }

        // -------------------------------
        // 2️⃣ 같은 rank 배열끼리 묶기
        // -------------------------------
        // key   : rank 배열을 문자열로 변환한 값
        // value : 해당 패턴을 가진 우주의 개수
        Map<String, Integer> patternCount = new HashMap<>();

        for (int[] space : arr) {
            // 배열은 Map의 key가 될 수 없으므로 문자열로 변환
            String key = Arrays.toString(space);
            patternCount.put(key, patternCount.getOrDefault(key, 0) + 1);
        }

        // -------------------------------
        // 3️⃣ 조합 공식으로 쌍의 개수 계산
        // -------------------------------
        long answer = 0;
        for (int count : patternCount.values()) {
            // 같은 패턴이 count개 있으면
            // 가능한 쌍의 개수 = countC2 = count*(count-1)/2
            answer += (long) count * (count - 1) / 2;
        }

        System.out.println(answer);
    }
}
