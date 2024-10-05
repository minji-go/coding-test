package 알고리즘정답노트.백트래킹;

// 문제 링크 : https://www.acmicpc.net/problem/1759
// 문제 설명 : 사용 가능한 문자들이 주어질때, 최소 한 개의 모음과 두 개의 자음을 포함하며, 알파벳 순으로 구성된 가능한 모든 암호를 구하는 문제
// 핵심 개념 : 백트래킹, 브루트포스, 조합론

import java.util.*;
import java.io.*;

public class B1759_백트래킹_브루트포스_조합 {
	public static int L, C;		//L은 암호의 길이, C는 사용 가능한 문자의 개수
	public static char[] clist;	//사용 가능한 문자를 담는 배열
	public static char[] pw;	//사용 가능한 암호의 각 문자를 담는 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		clist = br.readLine().replace(" ", "").toCharArray(); //사용 가능한 문자가 공백을 두고 주어진다.
		pw = new char[L];

		//알파벳 암호가 증가하는 순서로 정렬
		Arrays.sort(clist);

		//사용 가능한 모든 암호 구하기
		dfs(0, 0, 0);

		System.out.println(sb);
	}

	public static StringBuilder sb = new StringBuilder();
	public static List<Character> vowel = List.of('a', 'e', 'i', 'o', 'u'); //모음 배열

	public static void dfs(int cidx, int pidx, int vnum){ //cidx는 clist의 인덱스, pidx는 pw의 인덱스, vnum은 모음의 개수
		if(vnum>L-2) return;			//모음의 개수가 L-2개 이상이어서 자음 2개이상을 포함할 수 없는 경우
		if(pidx==L && vnum==0) return;	//암호의 길이가 충족되었는데, 모음의 개수가 1개도 포함되지 않은 경우
		if(pidx==L) {					//제대로된 암호일 경우
			for(int i=0; i<L; i++) sb.append(pw[i]);
			sb.append("\n");
			return;
		}
		if(cidx>=C) return;				//clist의 배열의 최대 인덱스보다 커진 경우

		pw[pidx]=clist[cidx];
		dfs(cidx+1, pidx+1, vowel.contains(pw[pidx])?vnum+1:vnum); //clist의 cidx번째 문자를 암호에 포함하는 경우
		dfs(cidx+1, pidx, vnum);	//clist의 cidx번째 문자를 암호에 포함하지 않는 경우
	}
}