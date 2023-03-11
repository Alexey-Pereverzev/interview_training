package org.example.lesson_08;

public class SortSquare {
    public static void main(String[] args) {
        int[] input = new int[] {-5, -3, 0, 1, 2, 6};
        int pointer1 = 0;
        int pointer2 = input.length - 1;

        int[] result = new int[input.length];

        int index = input.length - 1;

        if (input.length == 1) {
            result[0] = input[0]*input[0];
        }

        while (pointer1 < pointer2) {
            if (input[pointer1]*input[pointer1] > input[pointer2]*input[pointer2]) {
                result[index] = input[pointer1]*input[pointer1];
                pointer1++;
                index--;
            } else {
                result[index] = input[pointer2]*input[pointer2];
                index--;
                pointer2--;
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
