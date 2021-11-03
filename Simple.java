package com.mgp;

import java.util.HashMap;

public class Simple {

    public static void main(String[] args) {

        /*
         * Tests for AboveBelow in addition the assumption is = is not a thing due to
         * input and output as well as the name
         * 
         * Error Handling will also assume a sort of user experience that is handle the
         * error and do not return the error
         */
        int[] test1 = { 1, 2, 3, 4, 5, 6 };
        int[] test2 = {};
        int[] test3 = { 1, 2, 2 };
        int[] test4 = { 4, 5, 5, 6 };
        int comp1 = 3;
        int comp2 = 10;
        int comp3 = -2;

        // values above to be used here
        System.out.println(aboveBelow(test1, comp1).get(ABOVE));
        System.out.println(aboveBelow(test1, comp1).get(BELOW));

        // sample use cases for the string manip stringRotation
        String sample1 = "MyString";
        int pos1 = 2;
        String sample2 = "test";
        int pos2 = 6;
        int pos22 = -1;

        System.out.println(stringRotation(sample2, pos2));
        System.out.println(stringRotation2(sample2, pos2));
    }

    public static HashMap<String, Integer> AboveBelowOutput = new HashMap<String, Integer>();
    private static final String ABOVE = "Above";
    private static final String BELOW = "Below";
    // private static final String OUTOFRANGE = "OutOfRange";
    public static final String ERROR_STRING_LEN = "Either the length of the string was shorter than position or position was negative";

    private static void initAboveBelowOutput() {
        AboveBelowOutput.put(ABOVE, 0);
        AboveBelowOutput.put(BELOW, 0);
        // AboveBelowOutput.put(OUTOFRANGE, 0); // not used but again you could do this
        // if needed
    }

    public static HashMap<String, Integer> aboveBelow(int[] listOfValue, int compare) {
        initAboveBelowOutput();
        int aboveValue = 0;
        int belowValue = 0;
        for (int temp : listOfValue) {
            if (temp < compare) {
                belowValue++;
            } else if (temp > compare) {
                aboveValue++;
            } else {
                // leaving this open for later in terms of error or a default in the hashmap or
                // something else like OUTOFRANGE
            }
        }
        AboveBelowOutput.put(ABOVE, aboveValue);
        AboveBelowOutput.put(BELOW, belowValue);
        return AboveBelowOutput;
    }

    // option 1 assumption is that you are not carrying
    public static String stringRotation(String originalString, int position) {
        String temp = null;
        int length = originalString.length();
        if (length >= position && position > 0) {
            position = length - position;
            temp = originalString.substring(position) + originalString.substring(0, position);
        } else {
            return ERROR_STRING_LEN;
        }
        return temp;
    }

    // option 2 assumption is that there is a carry over and the values will
    // continue is the shift
    // assumption is round up
    public static String stringRotation2(String originalString, int position) {
        int length = originalString.length() - 1;
        if (position > 0) {
            while (position > 0) {
                originalString = originalString.substring(length) + originalString.substring(0, length);
                position--;
            }
        } else {
            return ERROR_STRING_LEN; // notice with a while and a if
                                     // they are basically the same so this is where I would ask the question over
                                     // intent
        }

        return originalString;
    }

}
