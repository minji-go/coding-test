package 문제모음.프로그래머스;

import java.util.*;

public class 불량사용자 {

    private static List<List<String>> idLists;
    private static Set<Set<String>> idSets;
    private static Set<String> idSet;

    public static int solution(String[] user_id, String[] banned_id) {

        idLists = new ArrayList<>();
        idSets = new HashSet<>();

        //1. banned_id에 해당하는 아이디목록을 구한다
        for (String bannedId : banned_id) {
            List<String> idList = new ArrayList<>();

            String bannedIdCopy = new String(bannedId).replace("*", "[a-z0-9]");

            for (String userId : user_id) {
                if(userId.matches(bannedIdCopy)) idList.add(userId);
            }

            idLists.add(idList);
        }


        //2. banned_id에 해당하는 아이디의 가능한 조합을 모두 set에 넣는다.
        idSet = new HashSet<>();
        selectId(0);

        //3. set의 개수를 구한다.
        return idSets.size();
    }


    public static void selectId(int idListIndex) {

        if(idListIndex == idLists.size()) {
            idSets.add(new HashSet<>(idSet));
            return;
        }

        List<String> idList = idLists.get(idListIndex);

        for (String id : idList) {

            int idSetSize = idSet.size();
            idSet.add(id);
            if(idSetSize + 1 != idSet.size()) continue;

            selectId(idListIndex + 1);
            idSet.remove(id);
        }
    }

    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
        System.out.println(solution(user_id, banned_id));
    }
}
