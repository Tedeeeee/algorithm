package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 13300 - 방 배정
//  날짜 : 2025-11-12
// -------------------------------
public class Problem13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 최대 1000명 까지 들어가는 방
        int N = Integer.parseInt(st.nextToken());
        // 최대 1000명까지 참석 가능
        int maxCount = Integer.parseInt(st.nextToken());

        // 성별 : 여학생 0, 남학생 1
        // 학년 : 1학년에서 6학년까지 존대
        int[][] arr = new int[6][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            arr[grade - 1][gender]++;
        }

        int needRoom = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                int studentCount = arr[i][j];
                needRoom += studentCount / maxCount;

                if (studentCount % maxCount > 0) {
                    needRoom++;
                }
            }
        }

        System.out.println(needRoom);
    }
}
