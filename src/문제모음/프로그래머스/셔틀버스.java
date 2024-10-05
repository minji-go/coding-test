package 문제모음.프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 셔틀버스 {

    public static String solution(int n, int t, int m, String[] timetable) {

//      1. timetable을 min기준으로 변환
        List<Integer> timeList = new ArrayList<>();

        for (String time : timetable) {
            int hour = Integer.parseInt(time.split(":")[0]);
            int min = Integer.parseInt(time.split(":")[1]);

            timeList.add(hour * 60 + min);
        }
        Collections.sort(timeList);


//        마지막 운행시간 09:00 + (n-1)*t 분
//        마지막-1 운행시간 09:00 + (n-2)*t 분
        int lastBusTime =  540 + t * (n - 1);
        int lastSeatTime = -1;

        int busTime = 540;
        int busSeat = m;

        for (int i = 0; i<timeList.size(); i++) {

            if (timeList.get(i) <= busTime) {
                busSeat--;
            } else {
                busTime = 540 + (int) Math.ceil((timeList.get(i) - 540.0) / t) * t;
                busSeat = m-1;

                if (busTime > lastBusTime) { //busTime이 lastTime보다 큰 경우엔, 이전버스에 빈자리가 있는 경우
                    lastSeatTime = lastBusTime;
                    break;
                }
            }

            if (busSeat == 0) {
                busTime = busTime + t;
                busSeat = m;
            }

            if (busTime > lastBusTime) {
                lastSeatTime = timeList.get(i) - 1;
                break;
            }

            if (i == timetable.length - 1) {
                lastSeatTime = lastBusTime;
                break;
            }
        }

        if (lastSeatTime == lastBusTime) {
            return String.format("%02d", lastBusTime / 60) + ":" + String.format("%02d", lastBusTime % 60);
        } else {
            return String.format("%02d", lastSeatTime / 60) + ":" + String.format("%02d", lastSeatTime % 60);
        }

    }

    public static void main(String[] args) {
        System.out.println(
                solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"})
        );
    }
}
