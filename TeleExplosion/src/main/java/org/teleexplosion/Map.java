package org.teleexplosion;

import javafx.scene.layout.GridPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Map {
    // map table
    private final int[][] map = new int[13][15];
    // current map on screen
    private final int[][] currentMap = new int[13][15];

    public GridPane mapPane;
    Tile tile;

    public Map(GridPane mapPane, String level) {
        this.mapPane = mapPane;
        this.tile = new Tile(level);

        // reading map from map.txt file
        try {
            FileReader fileReader = new FileReader("maps/"+level+"/map.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for(int j = 0; j < 13; j++){
                String textLine = bufferedReader.readLine();
                String[] line = textLine.split(" {3}");
                for (int i = 0; i < 15; i++){
                    map[j][i] = Integer.parseInt(line[i]);
                }
            }
            loadMap();
            bufferedReader.close();
        } catch (IOException ignored) {}
    }

    // loading tiles to map
    public void loadMap(){
        // map loading
        for(int j = 0; j < 13; j++){
            for(int i = 0; i < 15; i++){
                // tile loading
                if (mapPane != null) {
                    // minimizing the number of processes
                    if(map[j][i] != currentMap[j][i]){
                        currentMap[j][i] = map[j][i];
                        mapPane.add(tile.getTile(map[j][i]),i,j);
                    }
                }
            }
        }
    }

    public Integer getCell(int x, int y){
        return map[y][x];
    }

    public void setCell(int x, int y, int value){
        map[y][x] = value;
    }
}
