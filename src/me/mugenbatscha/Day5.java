package me.mugenbatscha;

import java.io.IOException;

public class Day5 {

    /*
     * use 2d array?get the biggest values and init array with that?
     * 0,9 9,4 would be the biggest values... so an array of int[9][9]
     * 0 0 0 0 0 0 0 0 0 0
     * 1 1 1 1 1 1 1 1 1 1
     * 2 2 2 2 2 2 2 2 2 2
     * 3 3 3 3 3 3 3 3 3 3
     * 4 4 4 4 4 4 4 4 4 4
     * 5 5 5 5 5 5 5 5 5 5
     * 6 6 6 6 6 6 6 6 6 6
     * 7 7 7 7 7 7 7 7 7 7
     * 8 8 8 8 8 8 8 8 8 8
     * 9 9 9 9 9 9 9 9 9 9
     * then I need a mapping from one end to the other...
     * 0 0 0 0 0 0 0 1 0 0
     * 0 0 1 0 0 0 0 1 0 0
     * 0 0 1 0 0 0 0 1 0 0
     * 0 0 0 0 0 0 0 1 0 0
     * 0 1 1 2 1 1 1 2 1 1
     * 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0
     * 2 2 2 1 1 1 0 0 0 0
     *
     * 0,9 -> 5,9 OK y1=y2
     * 8,0 -> 0,8 x1!=x2,y1!=y2
     * 9,4 -> 3,4 OK y1=y2
     * 2,2 -> 2,1 OK x1=x2
     * 7,0 -> 7,4 OK x1=x2
     * 6,4 -> 2,0 !=
     * 0,9 -> 2,9 OK y1=y2
     * 3,4 -> 1,4 OK y1=y2
     * 0,0 -> 8,8 !=
     * 5,5 -> 8,2 !=
     * i need an 2d array for the input data...
     * have it as x1 y1 x2 y2
     */
    public static int solution1() throws IOException {

        return 0;
    }

}