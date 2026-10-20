package seminar1;


import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

        //Task 1
    public static int sum(int[] numbers) {
        int sum = 0;

        for(int number: numbers){
            sum += number;
        }

        return sum;
    }

        //Task 2
    public static void multiply(int[] numbers, int factor) {
        for(int i = 0 ; i < numbers.length ; i++){
            numbers[i] *= factor;
            System.out.print(numbers[i] + ", ");
        }
    }

        //Task 5
    public static int linearSearch(int[] numbers, int target){
        for(int i = 0; i < numbers.length ; i++)
        {
            if(numbers[i] == target) {
                return i;
            }
        }
        return -1;
    }

        //Task 6
    public static void reverseArray(int[] numbers){

        for(int i = 0 ; i < numbers.length / 2 ; i++)
        {
            int temp;

            temp = numbers[i];
            numbers[i] = numbers[numbers.length - i - 1];
            numbers[numbers.length - i - 1] = temp;
        }


    }

        //Task 7
    public static int countOccurences(int[] numbers, int n){
        int counter = 0;
        for(int i = 0 ; i < numbers.length ; i++){
            if(numbers[i] == n){
                counter++;
            }
        }
        return counter;
    }

        //Task 8
    public static int[] removeDuplicates(int[] arr){

        int[] temp = new int[arr.length];
        int uniqueCount = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;

            for (int j = 0; j < uniqueCount; j++) {
                if (arr[i] == temp[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                temp[uniqueCount] = temp[uniqueCount];
                temp[uniqueCount] = arr[i];
                uniqueCount++;
            }
        }

        int[] result = new int[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    public static void main(String[] args){
        int[] integers = {1, 2, 3, 4, 4, 5, 5, 6};

        System.out.println(Arrays.toString(removeDuplicates(integers)));


    }
}
