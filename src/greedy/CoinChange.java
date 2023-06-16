package greedy;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {
    public static void main(String[] args) {
        int[] denominations = {1, 2, 5, 10, 20, 50, 100};  // 100p = 1 pound
        int[] numberOfCoinsAvailable = {10, 3, 1, 0, 1, 19, 16};
        int spareChange = 30;
        returnChange(denominations, numberOfCoinsAvailable, spareChange);
    }

    private static void returnChange(int[] denominations, int[] numberOfCoinsAvailable, int spareChange) {
        List<Integer> list = new ArrayList<>();
        boolean flag = false;
        for (int i = denominations.length - 1; i >= 0; --i) {
            if (spareChange == denominations[i] && numberOfCoinsAvailable[i] > 0) {
                list.add(denominations[i]);
                numberOfCoinsAvailable[i] = numberOfCoinsAvailable[i] - 1;
                flag = true;
                break;
            }
            if (spareChange < denominations[i] || numberOfCoinsAvailable[i] == 0) {
                continue;
            }
            if (numberOfCoinsAvailable[i] > 0) {
                list.add(denominations[i]);
                spareChange -= denominations[i];
                numberOfCoinsAvailable[i] = numberOfCoinsAvailable[i] - 1;
                ++i;
            }
        }
        if (flag) {
            System.out.println(list);
        } else {
            System.out.println("Not possible");
        }
    }

}
