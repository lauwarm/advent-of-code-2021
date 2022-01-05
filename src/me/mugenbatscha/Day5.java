package me.mugenbatscha;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        int result = 0;

        String stringLines = Files.readString(Paths.get("input/input_day5.txt"));

        String[] splitted = Arrays.stream(stringLines.split("[,\\->\\n]"))
                .map(String::trim)
                .toArray(String[]::new);

        int[] coordinatesA = new int[2000];

        int b = 0;
        for(int a = 0; a < splitted.length; a++) {
            if (splitted[a] == "") { }
            else {
                coordinatesA[b] = Integer.parseInt(splitted[a]);
                b++;
            }
        }

        int d=0;
        for(int c = 0; c < coordinatesA.length-4; c+=4) {
            if((coordinatesA[c] == coordinatesA[c+2]) || (coordinatesA[c+1] == coordinatesA[c+3])) {
                d+=4;
            }
        }
        System.out.println("D: " +d);
        int[] coordinatesB = new int[d];

        int f = 0;
        for(int c = 0; c < coordinatesA.length-4; c+=4) {
            if((coordinatesA[c] == coordinatesA[c+2]) || (coordinatesA[c+1] == coordinatesA[c+3])) {
                coordinatesB[f] = coordinatesA[c];
                coordinatesB[f+1] = coordinatesA[c+1];
                coordinatesB[f+2] = coordinatesA[c+2];
                coordinatesB[f+3] = coordinatesA[c+3];
                f+=4;
            }
        }

        int max_x = 0, max_y = 0;
        for (int e=0; e<coordinatesB.length-4; e+=4) {
            if (coordinatesB[e] > max_x) {
                max_x = coordinatesB[e];
            }
            if (coordinatesB[e + 1] > max_y) {
                max_y = coordinatesB[e + 1];
            }
            if (coordinatesB[e + 2] > max_x) {
                max_x = coordinatesB[e + 2];
            }
            if (coordinatesB[e + 3] > max_y) {
                max_y = coordinatesB[e + 3];
            }
        }

        /*
        for(int i = 0; i < coordinatesB.length; i++) {
            System.out.println(coordinatesB[i]);
        }
        */

        System.out.println((max_x + " " + max_y));
        int[][] board = new int[max_x][max_y];

        for(int j = 0; j < coordinatesB.length-4; j+=4) {

        }

        return result;
    }

}