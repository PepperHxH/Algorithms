class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for(char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if(index == -1) {
                return false;
            }
        }
        return true;
    }
}

/*
class Solution {
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, new ArrayList<Integer>());
            } 
            map.get(c).add(i);
        }
        int index = -1;
        for(char c : s.toCharArray()) {
            List<Integer> list = map.get(c);
            if(list == null) {
                return false;
            } else {
                int lo = 0, hi = list.size()-1;
                while(lo <= hi) {
                    int mid = (lo+hi)/2;
                    if(list.get(mid) < index) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
                if(lo == list.size()) {
                    return false;
                }
                index = list.get(lo)+1;
            }
        }
        return true;
    }
}
*/