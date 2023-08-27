package leetcode75;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; ++i) {
            if (flowerbed[i] != 1) {
                if (i - 1 >= 0 && i + 1 < flowerbed.length) {
                    if (flowerbed[i -1] != 1 && flowerbed[i + 1] != 1) {
                        flowerbed[i] = 1;
                        n--;
                    }
                }
            }
            if (n == 0) {
                return true;
            }
        }
        return false;
    }
}
