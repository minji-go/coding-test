package 알고리즘정답노트.해시테이블;

import java.util.HashMap;
import java.util.Map;

/* 문제 링크: https://leetcode.com/problems/two-sum/
 * 문제 설명: 정수 배열 nums와 정수 target이 주어질 때, 합이 target이 되는 서로 다른 두 원소의 인덱스를 반환 (정답은 오직 하나 존재)
 * 핵심 개념: HashMap을 이용한 보완 탐색 (target - 현재값)
 * 시간 복잡도: O(n) – 한 번의 for문으로 해결
 * 공간 복잡도: O(n) – HashMap에 최대 n개의 값 저장
 */
public class L1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
