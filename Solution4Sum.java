package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution4Sum {
    //Create class Pair for HashSet<Pair> to use
    static class Pair {
        Integer x;
        Integer y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode(){
            return this.x.hashCode() + this.y.hashCode();
        }

        @Override
        public boolean equals(Object d) {
            if (!(d instanceof Pair)) {
                return false;
            }
            Pair p = (Pair)d;
            return (this.x == p.x) && (this.y == p.y);
        }
    }

    public static ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length < 4) {
            return rst;
        }
        Arrays.sort(numbers);
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (map.containsKey(target - sum)) {
                    for (Pair p : map.get(target - sum)) {
                        ArrayList<Integer> list = new  ArrayList<Integer>();
                        list.add(p.x);
                        list.add(p.y);
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        if (!rst.contains(list)) {
                            rst.add(list);
                        }
                    }
                }
            }
            //Add all pairs up to i
            for (int j = 0; j < i; j++) {
                int sum = numbers[i] + numbers[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<Pair>());
                }
                map.get(sum).add(new Pair(numbers[j], numbers[i]));
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] a = {1, 0, -1, 0, -2, 2};
        int target = 0;

        fourSum(a,target);
    }

}
