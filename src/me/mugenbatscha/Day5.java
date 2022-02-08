package me.mugenbatscha;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Day5 {

    public static int solution1() throws IOException {

        Stream<String> stringLines = Files.lines(Paths.get("input/input_day5.txt"));

        String[] inputFile = stringLines.toArray(String[]::new);

        System.out.println(inputFile.length); //!

        int biggestX = 0, biggestY = 0;
        int cPosition = 0;
        int[] coordinates = new int[inputFile.length * 4];

        for (String s : inputFile) {
            for (int b = 0; b < 2; b++) {
                for (int c = 0; c < 2; c++) {
                    coordinates[cPosition] = Integer.parseInt(s.split(" -> ")[b].split(",")[c]);
                    cPosition++;
                }
            }
        }

        for (int a = 0; a < coordinates.length; a++) {
            if (a % 2 == 0) {
                if (coordinates[a] > biggestX) {
                    biggestX = coordinates[a];
                }
            } else {
                if (coordinates[a] > biggestY) {
                    biggestY = coordinates[a];
                }
            }
        }

        System.out.println(biggestX + " - " + biggestY); //!

        int switchCoordinate;
        for (int a = 0; a < coordinates.length; a += 4) {
            if (coordinates[a] > coordinates[a + 2]) {
                switchCoordinate = coordinates[a];
                coordinates[a] = coordinates[a + 2];
                coordinates[a + 2] = switchCoordinate;
            }
            if (coordinates[a + 1] > coordinates[a + 3]) {
                switchCoordinate = coordinates[a + 1];
                coordinates[a + 1] = coordinates[a + 3];
                coordinates[a + 3] = switchCoordinate;
            }
        }

        int[][] coordinateArr = new int[biggestX + 1][biggestY + 1];

        for (int a = 0; a < coordinates.length; a += 4) {
            if (coordinates[a] == coordinates[a + 2] || coordinates[a + 1] == coordinates[a + 3]) {
                for (int b = coordinates[a + 1]; b <= coordinates[a + 3]; b++) {
                    for (int c = coordinates[a]; c <= coordinates[a + 2]; c++) {
                        coordinateArr[b][c] += 1;
                    }
                }
            }
        }

        int result = 0;

        for (int[] ints : coordinateArr) {
            for (int e = 0; e < coordinateArr.length; e++) {
                System.out.print(ints[e]);
                if (ints[e] > 1) {
                    result++;
                }
            }
            System.out.println();
        }

        return result;
    }

    public static int solution2() { return 0; }

}