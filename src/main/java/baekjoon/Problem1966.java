package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 1966 - 프린터 큐
//  날짜 : 2025-11-22
// -------------------------------
public class Problem1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int page = Integer.parseInt(st.nextToken());
            int targetIndex = Integer.parseInt(st.nextToken());

            Integer[] maxImplArr = new Integer[page];
            Queue<Pointer> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < page; j++) {
                int pageImp = Integer.parseInt(st.nextToken());
                maxImplArr[j] = pageImp;
                queue.add(new Pointer(j, pageImp));
            }

            int calc = calc(maxImplArr, queue, targetIndex);
            sb.append(calc).append("\n");
        }

        System.out.println(sb);
    }

    static int calc(Integer[] maxImplArr, Queue<Pointer> queue, int targetIndex) {
        Arrays.sort(maxImplArr, Collections.reverseOrder());

        int maxImplIdx = 0;
        int maxImpl = maxImplArr[maxImplIdx];
        int result = 0;
        while (!queue.isEmpty()) {
            Pointer p = queue.poll();

            if (p.imp == maxImpl) {
                result++;
                if (p.index == targetIndex) {
                    break;
                }
                maxImpl = maxImplArr[++maxImplIdx];
            } else {
                queue.offer(p);
            }
        }

        return result;
    }

    static class Pointer {
        int index;
        int imp;

        public Pointer(int index, int imp) {
            this.index = index;
            this.imp = imp;
        }
    }
}