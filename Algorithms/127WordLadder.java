class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Stack<String> stack = new Stack<>();
        HashSet<String> set = new HashSet<>();
        stack.push(beginWord);
        int res = 0;
        while(stack.size() != 0) {
            int size = stack.size();
            res++;
            while(size-- > 0) {
                String s = stack.pop();
                set.add(s);
                if(s.equals(endWord)) return res;
                for(int i = 0; i < wordList.size(); i++) {
                    if(set.contains(wordList.get(i))) continue;
                    if(compare(s, wordList.get(i))) {
                        stack.push(wordList.get(i));
                    }
                }
            }  
        }
        return 0;
    }

    public boolean compare(String s1, String s2) {
        int cnt = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(i)) {
                cnt++;
            }
        }
        return (s1.length() - cnt) == 1;
    }
}