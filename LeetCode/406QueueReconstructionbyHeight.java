class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people.length == 0 || people == null || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, new Comparator<int[]>() {
           public int compare(int[] a, int[] b) {
                return (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
           } 
        });
        List<int[]> list = new LinkedList<>();
        for(int[] each : people) {
            list.add(each[1], each);
        }
        return list.toArray(new int[list.size()][]);
    }
}