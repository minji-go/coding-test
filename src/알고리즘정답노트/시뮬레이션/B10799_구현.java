package 알고리즘정답노트.시뮬레이션;

//문제: https://www.acmicpc.net/problem/10799
//설명: 인접하지 않은 괄호를 쇠막대기, 인접한 괄호쌍을 레이저라고 할때 잘려진 조각의 총 개수를 구하는 문제
//개념: 자료구조, 스택, 구현

import java.util.Scanner;

public class B10799_구현 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String parens = sc.nextLine();

        int answer = 0;
        int count = 0;
        for(int i=0; i<parens.length(); i++){
            if(parens.charAt(i) == ')' && parens.charAt(i-1) == '('){
                count--;
                answer += count;
            } else if (parens.charAt(i) == ')') {
                count--;
                answer++;
            } else if (parens.charAt(i) == '(') {
                count++;
            }
        }
        System.out.println(answer);
    }
}
