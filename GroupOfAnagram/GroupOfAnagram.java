package GroupOfAnagram;

import java.util.*;

public class GroupOfAnagram {
    public static void main(String args[]) {
        System.out.println("Enter the number for which you need to find sqaure root");
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            int[] count = new int[26];
            for (int j = 0; j < chars.length; j++) {
                count[chars[j] - 'a']++;
            }
            String countString = Arrays.toString(count);
            List<String> exisitingAnagram = map.get(countString);
            if (exisitingAnagram != null && exisitingAnagram.size() > 0){
                exisitingAnagram.add(str);
                map.put(countString, exisitingAnagram);
            }else{
                map.put(countString, new ArrayList<>(Arrays.asList(str)));
            }
        }
        return new ArrayList<>(map.values());
    }
}

