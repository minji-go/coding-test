package 알고리즘정답노트.문자열;

//문제: https://www.acmicpc.net/problem/9093
//설명: 문장의 단어를 뒤집어서 출력하는 문제
//개념: 문자열, 구현

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9093_문자열_구현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                StringBuilder tmp = new StringBuilder(); //StringBuilder 혹은 StringBuffer의 reverse() 사용가능
                tmp.append(st.nextToken());              //StringBuffer는 멀티스레드 환경에서 안전하지만 StringBuilder보다 성능이 떨어짐
                tmp.reverse();
                sb.append(tmp).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
