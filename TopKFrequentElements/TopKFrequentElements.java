package TopKFrequentElements;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] number = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : number) {
            Integer value = map.get(j);
            if (value != null)
                map.put(j, ++value);
            else
                map.put(j, 1);
        }
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int kFrequent[] = new int[k];
        for(int i =0;i < k && i < list.size(); i++){
           kFrequent[i] = list.get(i).getKey();
        }
    }
    public static void OptimalSolution (int[] number,int k) {}

}
