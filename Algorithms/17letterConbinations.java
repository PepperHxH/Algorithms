class Solution {
    public List<String> letterCombinations(String digits) {
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> res = new LinkedList<>();
        if(digits.length() == 0) return res;
        res.add("");
        for(int i = 0; i < digits.length(); i++) {
            int j = digits.charAt(i) - '0';
            while(res.peek().length() == i) {
                String s = res.remove();
                for(char x : mapping[j].toCharArray()) {
                    res.add(s+x);
                }
            }
        }
        return res;
    }
}

