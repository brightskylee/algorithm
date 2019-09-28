package org.test.ht;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PickupDelivery {

    public List<List<String>> pickupDelivery(int n) {
        List<List<String>> paths = Collections.singletonList(Arrays.asList("P1", "D1"));

        for (int i = 2; i <= n; i++) {
            List<List<String>> newPaths = new ArrayList<>();
            for (int j = 0; j <= 2 * (i - 1); j++) {
                for (int k = 0; k <= 2 * (i - 1) - j; k++) {
                    for (List<String> path : paths) {
                        newPaths.add(insert(i, path, j, k));
                    }
                }
            }
            paths = newPaths;
        }

        return paths;
    }

    private List<String> insert(int newIndex, List<String> path, int leftCount, int middleCount) {
        List<String> tmp = new ArrayList<>(path.subList(0, leftCount));
        tmp.add("P" + newIndex);
        tmp.addAll(path.subList(leftCount, leftCount + middleCount));
        tmp.add("D" + newIndex);
        tmp.addAll(path.subList(leftCount + middleCount, 2 * (newIndex - 1)));
        return tmp;
    }

    public static void main(String[] args) {
        PickupDelivery pickupDelivery = new PickupDelivery();
        System.out.println(pickupDelivery.pickupDelivery(2));
    }
}
