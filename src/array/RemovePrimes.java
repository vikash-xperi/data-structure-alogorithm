package array;

import java.util.ArrayList;
import java.util.Scanner;

public class RemovePrimes {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            al.add(scn.nextInt());
        }
        solution(al);
        System.out.println(al);
    }

    private static void solution(ArrayList<Integer> al) {
        for (int i = 0; i < al.size();) {
            if (isPrime(al.get(i))) {
                al.remove(i);
            } else {
                i++;
            }
        }
    }

    private static boolean isPrime(Integer el) {
        if (el == 1) {
            return true;
        }
        for (int i = 2; i <= Math.pow(el, 0.5); i++) {
            if (el % i == 0) {
                return false;
            }
        }
        return true;
    }
}
