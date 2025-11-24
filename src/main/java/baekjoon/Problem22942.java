package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 22942 - 데이터 체커
//  날짜 : 2025-11-24
//  추가 설명 : 가장 중요한 점은 원이 서로 겹쳐 있거나 맞닿아 있는지 확인하는 것이다
//             1. stack을 사용해서 각 원의 점의 위치를 넣어놓는다
//             2. 맞닿은 점 : 같은 위치의 점이 있다면 바로 실패
//             3. 겹친 점 : stack에서 값을 뺐을때 그 다음 빠질 stack의 값이 같은 원의 점이여야 한다
// -------------------------------
public class Problem22942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 몇 개의 원
        int n = Integer.parseInt(br.readLine());

        // 각 원을 배열에 넣어주기
        // 배열의 크기는 원의 양끝이기에 X2 해줘야 한다
        ArrayList<Pointer> circleArr = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int circleNum = i + 1;
            circleArr.add(new Pointer('L', x - r, circleNum));
            circleArr.add(new Pointer('R', x + r, circleNum));
        }

        // 원들의 좌표가 정렬되어야 알 수 있다
        Collections.sort(circleArr);

        // 먼저 맞닿아 있으면 먼저 실패
        for (int i = 0; i < circleArr.size() - 1; i++) {
            Pointer pointer = circleArr.get(i);
            Pointer nextPointer = circleArr.get(i + 1);

            if (pointer.point == nextPointer.point) {
                System.out.println("NO");
                return;
            }
        }

        // 맞닿아 있지 않지만 겹쳐 있는 원이 있으면 실패
        Stack<Pointer> stack = new Stack<>();
        for (Pointer pointer : circleArr) {
            if (pointer.arrow == 'L') {
                stack.push(pointer);
            } else {
                Pointer pop = stack.pop();
                if (pointer.circleNum != pop.circleNum) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
    }

    // 원에서 사용되는 점
    static class Pointer implements Comparable<Pointer> {
        // L 인지 R 인지
        char arrow;
        // 좌표 번호가 어디인지
        int point;
        // 원 이름
        int circleNum;

        public Pointer(char arrow, int point, int circleNum) {
            this.arrow = arrow;
            this.point = point;
            this.circleNum = circleNum;
        }

        @Override
        public int compareTo(Pointer o) {
            if (this.point != o.point) {
                return Integer.compare(this.point, o.point);
            }
            return Character.compare(this.arrow, o.arrow);
        }
    }
}
