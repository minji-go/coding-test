package 알고리즘정답노트.시뮬레이션;

// 문제 링크: https://www.acmicpc.net/problem/20436
// 문제 설명: 한글 자음 키보드는 왼손, 모음 키보드는 오른손으로 누를 때 문자열을 입력하는데 걸리는 최소 시간을 구하는 문제
//			(키를 누르는데 1의 시간, 키로 이동하는데 |X1-X2|+|Y1-Y2|의 시간이 걸린다.)
// 핵심 개념: 시뮬레이션, 구현, 문자열(String > char)

import java.util.*;
import java.io.*; 

public class B20436_시뮬레이션_구현 {
	public static class Alphabet {
		public char c; 	 //알파벳 문자
		public int x, y; //알파벳 위치 (배열의 인덱스)
		public boolean isVowel;

		Alphabet(char c, int x, int y, boolean v){
			this.c=c; this.x=x; this.y=y; this.isVowel=v; //지역변수와 인스턴스 변수의 이름이 같을 때는 this를 안붙이면 객체의 값이 초기화되지 않는다.
		}
	}

	public static void main(String[] args) throws IOException {

		//키보드를 한글 자음과 모음으로 구별한 배열을 만들고, 이때 중요한건 키간 거리이므로, '-'를 사용하여 인덱스를 조정해준다.
		char[][] consonant = {{'q','w','e','r','t','-'},{'a','s','d','f','g','-'},{'z','x','c','v','-','-'}}; 	//한글자음 키보드의 알파벳
		char[][] vowel = {{'-','y','u','i','o','p'},{'-','h','j','k','l','-'},{'b','n','m','-','-','-'}};		//한글모음 키보드의 알파벳

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char sL = st.nextToken().charAt(0); //String을 char로 변환할 때 charAt()을 사용한다. 혹은 Character.toString()를 사용한다.
 		char sR = st.nextToken().charAt(0);
		String str = br.readLine();

		//키보드의 알파벳의 위치를 한번에 찾을 수 있도록, 알파벳을 키로 Alphabet객체를 밸류로 하는 맵으로 변환한다.
		Map<Character, Alphabet> map = new HashMap<>();
		for(int i=0; i<3; i++){
			for(int j=0; j<6; j++){	//자음과 모음을 모두 3행, 6열의 배열로 만들어뒀다.
				// '-'은 위치를 조정하기 위한 값이므로 넘어간다.
				if(consonant[i][j]!='-') map.put(consonant[i][j], new Alphabet(consonant[i][j], i, j, false)); 	//맵에 자음 정보를 넣는다.
				if(vowel[i][j]!='-') map.put(vowel[i][j], new Alphabet(vowel[i][j], i, j, true));				//맵에 모음 정보를 넣는다.
			}
		}

		int answer = 0;
		for(int i=0; i<str.length(); i++){
			Alphabet next = map.get(str.charAt(i));	//알파벳을 하나씩 누른다고 가정할떄, 눌러야하는 알파벳에 대한 정보를 맵에서 가져온다.
			if(sL==next.c || sR==next.c) {	//이미 왼손 혹은 오른손이 눌러야 하는 위치에 있다면 누르기만 하면 된다.
				answer++;					//누르는 동작은 1의 시간이 걸린다.
			} else if(next.isVowel){		//알파벳이 한글 모음 키에 속한다면, 오른손을 움직여야한다.
				Alphabet cur = map.get(sR); //현재 오른손의 위치 정보를 맵에서 가져온다.
				sR=next.c;					//오른손을 알파벳 위로 이동한다.
				answer+=(Math.abs(next.x-cur.x)+Math.abs(next.y-cur.y)+1); //현재 손의 위치와 옮겨야 할 위치의 절대값을 더하고, 누르는 시간 1을 더한다.
			} else {						//알파벳이 한글 자음 키에 속한다면, 왼손을 움직여야한다.
				Alphabet cur = map.get(sL);	//현재 왼손의 위치 정보를 맵에서 가져온다.
				sL=next.c;					//왼손을 알파벳 위로 이동한다.
				answer+=(Math.abs(next.x-cur.x)+Math.abs(next.y-cur.y)+1);
			}
		}

		System.out.println(answer);

	}
}