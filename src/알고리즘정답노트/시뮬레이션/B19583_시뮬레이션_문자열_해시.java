package 알고리즘정답노트.시뮬레이션;

import java.util.*;
import java.io.*;

// 문제 링크 : https://www.acmicpc.net/problem/19583
// 문제 설명 : 출석이 확인된 학회원의 인원 수를 구하는 문제
// 핵심 개념 : 구현, 문자열, 해시맵

public class B19583_시뮬레이션_문자열_해시 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = convertToMinute(st.nextToken());
		int E = convertToMinute(st.nextToken());
		int Q = convertToMinute(st.nextToken());

		Map<String, Boolean> attendance = new HashMap<>();
		String str = null;
		while((str = br.readLine()) != null && !str.isEmpty()){
			st = new StringTokenizer(str);
			int time = convertToMinute(st.nextToken());
			String name = st.nextToken();

			//time이 S~E사이면 put(name, false)
			//time이 E~Q사이이고 get(name)!=null이면 put(name, true)
			if(time<=S) attendance.put(name, false);
			else if(time>=E && time<=Q && attendance.get(name)!=null) attendance.put(name, true);
		}

		//map의 value가 true인 개수를 출력
		int count = 0;
		for(String name : attendance.keySet()){
			if(attendance.get(name)) count++;
		}
		System.out.println(count);

	}

	public static int convertToMinute(String time){ //HH:MM은 compareTo()로 비교 가능
		int hour = Integer.parseInt(time.split(":")[0])*60;
		int min = Integer.parseInt(time.split(":")[1]);
		return hour+min;
	}
}