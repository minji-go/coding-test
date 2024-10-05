package 알고리즘정답노트.스택;

// 문제 링크 : https://www.acmicpc.net/problem/1874
// 문제 설명 : N까지 오름차순으로 스택에 push/pop 할 때, 주어진 수열을 만들기 위한 스택 연산을 구하는 문제
//			 (push 연산은 +, pop 연산은 -)
// 핵심 개념 : 스택, 자료구조

import java.util.*;
import java.io.*;

public class B1874_스택 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];
		for(int i=0; i<N; i++) seq[i] = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int idx = 0;
		for(int i=1; i<=N; i++){ //1부터 N까지 스택에 순차적으로 push 연산을 한다.
			stack.push(i);
			sb.append("+\n");
			if(seq[idx]>i) continue; //i보다 작거나 같으면 스택에 있으므로, pop 연산을 한다.
			
			boolean flag = false;
			while(!stack.isEmpty() && seq[idx]<=i){ //push 연산이 필요하기 전까지 pop 연산을 한다.
				if(seq[idx] == stack.pop()){ 		//pop 연산으로 나온게 수열이랑 일치하지 않으면, 불가능한 경우다.
					idx++;		// 수열의 다음 숫자를 탐색하기 위해 인덱스를 증가시킨다.
					sb.append("-\n");
				} else {
					flag=true;
					break;
				}
			}
			if(flag) break;
		}
		
		if(idx==N) System.out.println(sb);	//인덱스가 N일 경우, 가능한 수열이므로 연산을 출력한다.
		else System.out.println("NO");
		
	}
}