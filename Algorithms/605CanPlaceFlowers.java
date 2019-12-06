class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for(int i = 0; i < len; i++) {
            if(flowerbed[i] == 1) continue;
            int pre = (i == 0) ? 0 : flowerbed[i-1];
            int next = (i == len-1) ? 0 : flowerbed[i+1];
            if(pre == 0 && next == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return (n <= 0);
    }
}
