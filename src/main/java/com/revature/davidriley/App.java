package com.revature.davidriley;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class App {

    public static int sortDigits(int numberToSort, String sortingOption) {
        String stringifyInt = Integer.toString(numberToSort);
        List<Integer> toIntList = new ArrayList<Integer>();
        int placeValue = 1;


        // Put each digit into a list<int>.
        for(int j = 0; j < stringifyInt.length(); j++) {
            // Converts each digit into an integer.
            toIntList.add(parseInt(Character.toString(stringifyInt.charAt(j))));
        }

        if (sortingOption.equals("asc"))
            Collections.sort(toIntList);
        else
            Collections.sort(toIntList, Collections.reverseOrder());

        // Resetting the value so this method can add to the product of each digit by the placeValue.
        numberToSort = 0;

        for (int k = 0; k < toIntList.size(); k++) {
            placeValue = toIntList.size() - (k + 1);
            numberToSort += toIntList.get(k) * Math.pow(10, placeValue);
        }
        return numberToSort;
    }

    public static int[] reorderDigits(int[] arrayOfNumbers, String sortingOption) {
        int arrayElementContents = 0;
        int newNumber = 0;

        for (int i = 0; i < arrayOfNumbers.length; i++) {
            arrayElementContents = arrayOfNumbers[i];
            if (arrayElementContents < 10)
                arrayOfNumbers[i] = arrayElementContents;
            else
                arrayOfNumbers[i] = sortDigits(arrayElementContents, sortingOption);
        }

        return arrayOfNumbers;
    }

    public static boolean canPartition(int[] arrayToMult) {
        int elementProduct = 1;
        boolean productEqualsElement = false;

        // These will go through each element in the array, and multiply each number to see if it is equal to the sum of the other elements.
        for (int m = 0; m < arrayToMult.length; m++) {
            elementProduct = 1;
            for (int n = 0; n < arrayToMult.length; n++) {
                if (n != m) {
                    elementProduct *= arrayToMult[n];
                }
            }
            if (elementProduct == arrayToMult[m])
                productEqualsElement = true;
        }
        return productEqualsElement;
    }

    public static void main(String args[]) {
        int[] numToPrint = reorderDigits(new int[]{515,341,98,44,211},   "desc");

        for (int l = 0; l < numToPrint.length; l++) {
            System.out.println(numToPrint[l]);
        }

        System.out.println(canPartition(new int[]{-1, -20, 5, -1, -2, 2}));
    }
}