package 문제모음.프로그래머스;

import java.util.*;

/*
    fees    [180, 5000, 10, 600]
    records ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]
    result  [14600, 34400, 5000]

    fees    [120, 0, 60, 591]
    records ["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"]
    result  [0, 591]

    fees    [1, 461, 1, 10]
    records ["00:00 1234 IN"]
    result  [14841]
*/
public class 주차요금계산 {

    public static int[] solution(int[] fees, String[] records) {

        HashMap<Integer, Integer> inTimeMap = new HashMap<>();
        HashMap<Integer, Integer> timeMap = new HashMap<>();

        for (String record : records) {
            String[] tmp = record.split(" ");

            Integer carNum = Integer.parseInt(tmp[1]);
            Integer time = Integer.parseInt(tmp[0].split(":")[0]) * 60 + Integer.parseInt(tmp[0].split(":")[1]);

            if (tmp[2].equals("IN")) {
                inTimeMap.put(carNum, time);
            } else {
                timeMap.put(carNum, timeMap.getOrDefault(carNum, 0) + time - inTimeMap.remove(carNum));
            }
        }

        for (Integer key : inTimeMap.keySet()) {
            int time = (23 * 60 + 59) - inTimeMap.get(key);

            timeMap.put(key, timeMap.getOrDefault(key, 0) + time);
        }


        Object[] keys = timeMap.keySet().toArray();
        Arrays.sort(keys);

        int[] answer = new int[keys.length];

        for (int i = 0; i < keys.length; i++) {
            int time = timeMap.get(keys[i]) - fees[0];

            if (time <= 0) {
                answer[i] = fees[1];
            } else {
                int fee = fees[1] + (time / fees[2]) * fees[3];
                if (time % fees[2] != 0) fee += fees[3];
                answer[i] = fee;
            }
        }

        return answer;


    }

    public static void main(String[] args) {

        int[] fees ={1, 10, 1, 11};
        String[] records = {"00:00 1234 IN", "00:02 1234 OUT"};

        int[] answer = solution(fees, records);

    }
}
