package 문제모음.프로그래머스;

import java.util.*;

public class 광고삽입 {

    public static String solution(String play_time, String adv_time, String[] logs) {

        HashMap<Integer, Integer> accumPeople = new HashMap<>();

        accumPeople.put(0, 0);
        for (String log : logs) {
            String[] beginTime = log.split("-")[0].split(":");
            String[] endTime = log.split("-")[1].split(":");

            int beginTs = Integer.parseInt(beginTime[0])*3600 + Integer.parseInt(beginTime[1])*60 + Integer.parseInt(beginTime[2]);
            int endTs = Integer.parseInt(endTime[0])*3600 + Integer.parseInt(endTime[1])*60 + Integer.parseInt(endTime[2]);

            accumPeople.put(beginTs, accumPeople.getOrDefault(beginTs, 0) + 1);
            accumPeople.put(endTs, accumPeople.getOrDefault(endTs, 0) - 1);
        }

        //시간순으로 정렬
        List<Integer> times = new ArrayList<>(accumPeople.keySet());
        Collections.sort(times);

        //시간순 인원수 및 누적시간 계산
        HashMap<Integer, Integer> accumTime = new HashMap<>();
        int prevTime = 0;
        int prevAccumPeople = 0;
        int prevAccumTime = 0;

        for (int time : times) {
            prevTime = time;
            int thisAccumPeople = accumPeople.get(time);
            accumPeople.put(time, prevAccumPeople + thisAccumPeople);
            prevAccumPeople = prevAccumPeople + thisAccumPeople;

            accumTime.put(time, prevAccumTime + prevAccumPeople * (time-prevTime));
        }


        //마지막 광고시작 가능 시간 계산
        String[] tmp = play_time.split(":");
        int playTime = Integer.parseInt(tmp[0])*3600 + Integer.parseInt(tmp[1])*60 + Integer.parseInt(tmp[2]);
        tmp = adv_time.split(":");
        int advTime = Integer.parseInt(tmp[0])*3600 + Integer.parseInt(tmp[1])*60 + Integer.parseInt(tmp[2]);
        accumPeople.put(playTime, 0);

        int lastStartTime = playTime - advTime;

        int maxStartTime = 0;
        int maxAccumTime = 0;
        int tmpAccumTime = 0;

        for (int i=0; i<times.size(); i++) {
            int startTime = times.get(i);
            if(startTime > lastStartTime) break;



            if (tmpAccumTime > maxAccumTime) {
                maxAccumTime = tmpAccumTime;
                maxStartTime = startTime;
            }

            tmpAccumTime = 0;
        }

        for (int i=0; i<times.size(); i++) {
            int endTime = times.get(i);
            if(endTime - advTime < 0) continue;

            for (int j=i; j>=0; j--) {

                if (times.get(j) <= endTime - advTime || j==0) {
                    tmpAccumTime -= accumPeople.get(times.get(j)) * ((endTime - advTime) - times.get(j));
                    break;
                }
                tmpAccumTime += accumPeople.get(times.get(j-1)) * (times.get(j) - times.get(j-1));
            }

            if (tmpAccumTime > maxAccumTime) {
                maxAccumTime = tmpAccumTime;
                maxStartTime = endTime =advTime;
            }

            tmpAccumTime = 0;
        }



        String answer = String.format("%02d", maxStartTime / 3600) + ":"
                + String.format("%02d", (maxStartTime%3600-maxStartTime % 60)/60) + ":"
                + String.format("%02d", maxStartTime % 60);

        return answer;
    }

    public static void main(String[] args) {
        /*
            1. 로그를 계산하여 시작시간을 변동되는 시점을 기준으로 누적인원수를 map에 업데이트한다.
            2. 로그를 돌면서 누적시간을 계산하여 accumulated에 업데이트
            3. 누적시간이 더 크면 교체한다.
            4. 광고재생시간을 광고끝구간에서 빼서 가능한 광고 시작시간 중 가장 느린 시간을 알아내어 그것과 같거나 뒤로가면 멈춘다.
        */


        System.out.println(solution(	"99:59:59", "25:00:00", new String[]{"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"}));

        /*
        00:25:50 1
        00:40:31 2
        00:48:29 1

        01:00:00 0
        01:20:15 1
        01:30:59 2
        01:37:44 3
        01:45:14 2
        01:53:29 1
        02:02:30 0

        */
    }
}
