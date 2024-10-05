package 알고리즘오답노트.수학;
// 문제 링크 : https://www.acmicpc.net/problem/6588
// 문제 설명 : 4보다 큰 모든 짝수를 두 홀수 소수의 합으로 나태내는 문제
// 핵심 개념 : 수학, 정수론, 소수 판정, 에라토스테네스의 체
// 오답 이유 : String.format으로 인한 시간 초과
//          - https://stackoverflow.com/questions/513600/should-i-use-javas-string-format-if-performance-is-important

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B6588_수학_에라토스테네스의체 {
    static boolean[] multiple;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        findPrime(1_000_000);
        String input = null;
        while (!(input = br.readLine()).equals("0")) {
            int n = Integer.parseInt(input);
            bw.write(solution(n));
        }
        bw.close();
    }

    private static void findPrime(int n) {
        multiple = new boolean[n+1];
        multiple[0] = multiple[1] = true;

        for(int i=2; i<=Math.sqrt(n); i++){
            if(!multiple[i]) {
                for (int j=i*i; j<=n; j+=i) {
                    multiple[j] = true;         //i가 아닌 j임에 주의!!!
                }
            }
        }
    }

    public static String solution(int n) throws Exception {
        for (int i = 3; i <= n / 2; i+=2) {
            if(!multiple[i] && !multiple[n-i]) return n + " = " + i + " + " + (n-i) + "\n";
        }
        return "Goldbach's conjecture is wrong.\n";
    }
}
