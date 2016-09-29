package by.sem3.lab8;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int size;
    public static int typeOfSort;
    public static Integer[] array;
    static Sort sort;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        sort = new Sort();
        Thread sortThread = new Thread(sort);
        System.out.print("Enter size of array: ");
        try {
            size = scan.nextInt();
            array = fillArray(size);
            printArray(array);
            System.out.print("\n\tTypes of sort:\n1. Ascending values.\n2. Descending values.\n3. Ascending length." +
                    "\n4. Descending length.\nChoose type of sort: №");
            typeOfSort = scan.nextInt();
            if (typeOfSort > 4 || typeOfSort <= 0) {
                throw new InputMismatchException("Incorrect input! Number is not in interval from 1 to 4!");
            }
            sortThread.start();
            sortThread.join();
            printArray(array);
        } catch (InputMismatchException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    private static Integer[] fillArray(int length) {
        Random rand = new Random();
        Integer[] arr = new Integer[length];
        for (int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(1001);
        }
        return arr;
    }

    private static void printArray(Integer[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
