package com.paravar.interview;

public class ArrayQ {
    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5};

        duplicates(arr);
        nonDuplicates(arr);
        unique(arr);

    }

    public static void duplicates(int... arr) {

        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            boolean isDuplicate = false;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    isDuplicate = true;
                }
            }
            if (isDuplicate)
                System.out.println("Duplicate: " + arr[i]);

        }

    }

    public static void nonDuplicates(int... arr) {

        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            boolean isDuplicate = false;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    isDuplicate = true;
                }
            }
            if (!isDuplicate)
                System.out.println("Non Duplicate: " + arr[i]);

        }

    }

    public static void unique(int... arr) {

        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                }
            }
            System.out.println("Unique: " + arr[i]);

        }

    }

}
