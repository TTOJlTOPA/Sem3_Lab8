package by.sem3.lab8;

import java.util.Arrays;
import java.util.Comparator;

import static by.sem3.lab8.Main.array;
import static by.sem3.lab8.Main.typeOfSort;

public class Sort implements Runnable {
    @Override
    public void run() {
        switch (typeOfSort) {
            case 1:
                Arrays.sort(array, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1.compareTo(o2);
                    }
                });
                break;
            case 2:
                Arrays.sort(array, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo(o1);
                    }
                });
                break;
            case 3:
                Arrays.sort(array, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return lengthOfNumber(o1).compareTo(lengthOfNumber(o2));
                    }
                });
                break;
            case 4:
                Arrays.sort(array, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return lengthOfNumber(o2).compareTo(lengthOfNumber(o1));
                    }
                });
                break;
            default:
                return;
        }
    }

    private Integer lengthOfNumber(Integer number) {
        Integer counter = 0;
        while (number.compareTo(0) != 0) {
            number /= 10;
            counter++;
        }
        return counter;
    }
}
