package 알고리즘정답노트.그리디;

// 문제 링크 : https://www.acmicpc.net/problem/12933
// 문제 설명 : 녹음된 오리들의 연속된 울음소리(quack)가 섞여 있을 때, 오리의 최소 개수를 구하는 문제
// 핵심 개념 : 스택, 자료구조

import java.io.*;

public class B12933_구현_그리디_문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] record = br.readLine().toCharArray();
		char[] quack = {'q','u','a','c','k'};
		
		int duck = -1;
		boolean flag = true;
		while(flag){
			duck++;
			flag=false;
			int idx=0;

			//오리 한마리가 연속적으로 울음소리를 낼 경우, 제거할 수 있는 최대 문자열의 개수를 구한다.
			for(int i=0; i<record.length; i++){
				if(record[i]==quack[idx]){
					flag=true;
					idx=(idx+1)%5; //quack 배열의 순서대로 녹음 문자열을 탐색한다.
					record[i]='x'; //탐색한 녹음 문자열은 x로 변환하여, 다음번 탐색에서 제외한다.
				}
			}
			
			if(idx!=0) { //quack이 완성되지 않은 경우로, 올바르지 않은 녹음이다.
				duck=-1; //올바르지 않은 경우 -1을 출력하기 위해, duck=-1을 한다.
				break;
			}
		}

		//탐색한 오리들의 울음소리를 x로 표시했을 때, x가 아닌 문자열이 있으면 올바르지 않은 녹음이다.
		for(int i=0; i<record.length; i++){
			if(record[i]!='x'){
				duck=-1;
				break;
			}
		}
		System.out.println(duck);
	}
}