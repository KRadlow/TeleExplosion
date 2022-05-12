package org.teleexplosion.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


class MapTest {
    TestMap mapTest = new TestMap();
    @Test
    void getCell() {

        Assertions.assertEquals(1, mapTest.getCell(1,1));
    }

    @Test
    void setCell() {
        mapTest.setCell(1,1,3);
        Assertions.assertEquals(3, mapTest.getCell(1,1));
    }

    public static class TestMap {
        // map table
        private final int[][] map = new int[13][15];

        public TestMap() {
            // reading map from map.txt file
            try {
                FileReader fileReader = new FileReader("map.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                for(int j = 0; j < 13; j++){
                    String textLine = bufferedReader.readLine();
                    String[] line = textLine.split(" {3}");
                    for (int i = 0; i < 15; i++){
                        map[j][i] = Integer.parseInt(line[i]);
                    }
                }
                bufferedReader.close();
            } catch (IOException ignored) {}
        }

        public Integer getCell(int x, int y){
            return map[y][x];
        }
        public void setCell(int x, int y, int value){
            map[y][x] = value;
        }
    }

}