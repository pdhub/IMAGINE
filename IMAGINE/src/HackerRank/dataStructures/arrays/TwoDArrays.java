package HackerRank.dataStructures.arrays;

import java.util.Scanner;

/**
 * Created by PDeb on 10/14/2017.
 */
public class TwoDArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }

        int maxiMumHourGlass = calculateMaximumHourGlass(arr);
        System.out.println(maxiMumHourGlass);
    }

    private static int calculateMaximumHourGlass(int[][] arr) {
        int maxHourGlass = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int tempHourGlassVal = calCulateTempHourGlass(i, j, arr);
                if(tempHourGlassVal > maxHourGlass)
                    maxHourGlass = tempHourGlassVal;
            }
        }
        return maxHourGlass;
    }

    private static int calCulateTempHourGlass(int i, int j, int[][] arr) {
        int sum = Integer.MIN_VALUE;
        for (int k = j, l = 0; l < 3; k++) {
            sum += arr[i][k];
            l++;
        }
        i++;
        j++;
        sum+= arr[i][j];
        i++;
        j--;
        for (int k = j, l=0; l < 3; k++) {
            sum+= arr[i][k];
            l++;
        }
        return sum;
    }
}
