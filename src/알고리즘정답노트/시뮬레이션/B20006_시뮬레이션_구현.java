package 알고리즘정답노트.시뮬레이션;

// 문제 링크 : https://www.acmicpc.net/problem/20006
// 문제 설명 : 최초 방을 개설한 플레이어의 레벨과 10차이가 나지 않는 플레이어들을 방 순서대로 매칭해주는 문제
//			- 방의 정원은 M명이고, 방 정원이 모두 차면 "Started!", 대기중이면 "Waiting!"을 출력한다.
//			- 출력 순서는 방 번호, 플레이어의 닉네임 순으로 출력한다.
// 핵심 개념 : 시뮬레이션, 구현

import java.util.*;
import java.io.*;

public class B20006_시뮬레이션_구현 {
	public static class Player {
		public int level;
		public String name;
		Player(int l, String n){
			level= l;
			name = n;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Queue<List<Player>> queue = new LinkedList<>();	//방이 들어있는 큐
		
		//플레이어 방 배정
		for(int i=0; i<p; i++){
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken());
				String n = st.nextToken();

				int num = -1;
				int size = queue.size();
				for(int j=0; j<size; j++){ //방 순서대로 배정될 수 있는지 판단한다.
					List<Player> room = queue.poll();
					queue.offer(room);		//큐에서 방 순서를 유지하기 위해 배정될 방을 찾더라도 break 하지 않는다.
					if(num > -1 || room.size()==m) continue;//이미 배정되었거나 방의 정원이 찬 경우 continue
					if(Math.abs(room.get(0).level-l)<=10){	//room.get(0)은 방을 개설한 플레이어
						num=j;								//배정된 방의 번호를 기록한다.
						room.add(new Player(l, n));
					}
				}
				if(num==-1){ //방에 배정되지 못한 경우, 새로운 방을 만든다.
					List<Player> room = new ArrayList<>();
					room.add(new Player(l, n));
					queue.offer(room);
				}
		}		


		//출력
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()){
			List<Player> room = queue.poll();
			if(room.size()==m) sb.append("Started!\n"); //방의 정원이 찬 경우 플레이를 시작한다.
			else sb.append("Waiting!\n");

			room.sort((o1, o2) -> (o1.name).compareTo(o2.name)); //플레이어 출력시 닉네임 순으로 한다.
			for(Player player : room){
				sb.append(player.level).append(" ");
				sb.append(player.name).append("\n");
			}
		}
		System.out.println(sb);
	}
}