package me.mugenbatscha;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
     *
     * 0,9 -> 5,9 => richtige reihenfolge, x1<x2 und y1=y2; first number inner loop, second number outer loop
     * 9,4 -> 3,4 => falsche reihenfolge, x1>x2;
     * 2,2 -> 2,1 => falsche reihenfolge, y1>y2;
     * 7,0 -> 7,4 => richtige reihenfolge, y1<y2;
     * 0,9 -> 2,9 => richtige reihenfolge, x1<x2;
     * 3,4 -> 1,4 => falsche reihenfolge, x1>x2;
     */
    public static int solution1() throws IOException {

        Stream<String> stringLines = Files.lines(Paths.get("input/input_day5_example.txt"));

        String[] inputFile = stringLines.toArray(String[]::new);

        System.out.println(inputFile.length);

        int x1=0, x2=0, y1=0, y2=0;
        int biggestX=0, biggestY=0;
        int cPosition = 0;
        int[] coordinates = new int[inputFile.length*4];

        for (String s : inputFile) {
            for (int b = 0; b < 2; b++) {
                for (int c = 0; c < 2; c++) {
                    coordinates[cPosition] = Integer.parseInt(s.split(" -> ")[b].split(",")[c]);
                    cPosition++;
                }
            }
        }

        for (int coordinate : coordinates) {
            System.out.println(coordinate);
        }
/*
        for(int a = 0; a < inputFile.length; a++) {
            System.out.println(inputFile[a]);
        }

        int[][] test = new int[10][10];

        for(int b=9; b <= 9; b++) { //0,9 5,9
            for(int c=0; c <= 5; c++) {
                test[b][c] += 1;
            }
        }

        for(int b=4; b <= 4; b++) { //9,4 3,4
            for(int c=3; c <= 9; c++) {
                test[b][c] += 1;
            }
        }

        for(int b=1; b <= 2; b++) { //2,2 2,1
            for(int c=2; c <= 2; c++) {
                test[b][c] += 1;
            }
        }

        for(int b=0; b <= 4; b++) { //7,0 7,4
            for(int c=7; c <= 7; c++) {
                test[b][c] += 1;
            }
        }

        for(int b=9; b <= 9; b++) { //0,9 2,9
            for(int c=0; c <= 2; c++) {
                test[b][c] += 1;
            }
        }

        for(int b=4; b <= 4; b++) { //3,4 1,4
            for(int c=1; c <= 3; c++) {
                test[b][c] += 1;
            }
        }

        int tmp_result = 0;

        for(int d=0; d < test.length; d++) {
            for (int e = 0; e < test.length; e++) {
                System.out.print(test[d][e]);
                if (test[d][e] > 1) {
                    tmp_result ++;
                }
            }
            System.out.println();
        }

        System.out.println(tmp_result);
*/
        return 0;
    }

}