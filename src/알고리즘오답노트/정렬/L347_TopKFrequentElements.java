package 알고리즘오답노트.정렬;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 문제 링크: https://leetcode.com/problems/top-k-frequent-elements/
 * 문제 설명: 배열에서 가장 자주 등장하는 k개의 요소를 반환 (순서 무관)
 * 핵심 개념: Bucket Sort – 빈도수를 인덱스로 하는 버킷 배열에 요소를 저장하고, 뒤에서부터 k개 추출
 * 시간 복잡도: O(n) – Map으로 빈도 계산 + 버킷 채우기 + 결과 수집
 * 공간 복잡도: O(n) – Map과 버킷 배열에 최대 n개의 요소 저장
 * 오답 노트:
 * - Max Heap을 사용한 풀이도 가능하지만, Bucket Sort가 시간 복잡도 O(n)으로 더 효율적임
 * - Max Heap은 삽입 시 정렬이 이루어지므로 처리 비용이 크고, 변경된 빈도수를 반영하기 위해서는 정렬을 다시 수행해야 함
 */
public class L347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : map.keySet()) {
            int count = map.get(num);
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }

        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
