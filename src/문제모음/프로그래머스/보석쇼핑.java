package 문제모음.프로그래머스;

import java.util.HashMap;

/*
    ["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]	[3, 7]
    ["AA", "AB", "AC", "AA", "AC"]	                                    [1, 3]
    ["XYZ", "XYZ", "XYZ"]	                                            [1, 1]
    ["ZZZ", "YYY", "NNNN", "YYY", "BBB"]	                            [1, 5]
*/
public class 보석쇼핑 {

    public static int[] solution(String[] gems) {

        HashMap<String, Integer> map = new HashMap<>();
        for(String gem : gems) map.put(gem, 0);

        int[] answer = {0, gems.length};

        HashMap<String, Integer> gemMap = new HashMap<>();
        int start = 0;
        int end = 0;

        gemMap.put(gems[start], 1);

        while (true) {
            if(start == gems.length -1) break;

            if (gemMap.size() == map.size()) {
                int answerSize = answer[1] - answer[0];
                if (answerSize > end - start) {
                    answer[0] = start;
                    answer[1] = end;
                }

                if (start == end) {
                    end++;
                    if (gemMap.get(gems[end]) == null) {
                        gemMap.put(gems[end], 1);
                    } else {
                        gemMap.put(gems[end], gemMap.get(gems[end]) + 1);
                    }
                } else {
                    if (gemMap.get(gems[start]) == 1) {
                        gemMap.remove(gems[start]);
                    } else {
                        gemMap.put(gems[start], gemMap.get(gems[start]) - 1);
                    }
                    start++;
                }
            } else {
                if(end == gems.length - 1) break;
                end++;
                if (gemMap.get(gems[end]) == null) {
                    gemMap.put(gems[end], 1);
                } else {
                    gemMap.put(gems[end], gemMap.get(gems[end]) + 1);
                }
            }

        }

        answer[0]++;
        answer[1]++;

        return answer;
    }


    public static void main(String[] args) {

        //총 보석의 개수를 구한다.
        //0번방부터 탐색하며 보석의 개수와 일치하면 첫방과 끝방을 기록한다.
        //그다음 1번방부터 탐색하며 보석의 개수와 일치하면 이전에 기록된 길이와 비교하여 그 길이보다 작으면 바꾼다.
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        int[] answer = solution(gems);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}