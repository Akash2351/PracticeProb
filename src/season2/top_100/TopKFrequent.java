package season2.top_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        List<Integer>[] count = new List[nums.length + 1];

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (count[entry.getValue()] == null) {
                List<Integer> list = new ArrayList<>();
                list.add(entry.getKey());
                count[entry.getValue()] = list;
            } else {
                count[entry.getValue()].add(entry.getKey());
            }
        }

        int index = nums.length;
        List<Integer> fin = new ArrayList<>();
        while (k > 0) {
            if (count[index] != null) {
                fin.addAll(count[index]);
                k -= count[index].size();
            }
            index--;
        }
        return fin;

    }
}
