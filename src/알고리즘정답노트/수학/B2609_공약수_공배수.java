package 알고리즘정답노트.수학;
// 문제 링크: https://www.acmicpc.net/problem/2609
// 문제 설명: 두 수의 최대 공약수와 최소 공배수를 구하는 문제
// 핵심 개념: 수학, 정수론, 유클리드 호제법

import java.util.*;
import java.io.*;

public class B2609_공약수_공배수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int min=1;
        for(int i=2; i<=a && i<=b ;i++){
            if(a%i==0 && b%i==0){
                min=i;
            }
        }
        bw.write(min+"\n");
        bw.write((a*b/min)+"\n");
        bw.close();

    }
}
