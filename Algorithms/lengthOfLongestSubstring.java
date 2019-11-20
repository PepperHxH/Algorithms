/*
Runtime: 8 ms, faster than 65.98% of Java online submissions for Longest Substring Without Repeating Characters.
Memory Usage: 36.9 MB, less than 99.76% of Java online submissions for Longest Substring Without Repeating Characters.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() <= 1) return s.length();
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put(s.charAt(0), 0);
        int sum = 1;
        for(int i = 0, j = 1; j < s.length(); j++) {
            if(!map.containsKey(s.charAt(j)) || map.get(s.charAt(j)) < i) {
                sum = Math.max(j - i + 1, sum);
                map.put(s.charAt(j), j);
            } else {
                i = map.get(s.charAt(j)) + 1;
                map.put(s.charAt(j), j);
            }
        }
        return sum;
    }
}
