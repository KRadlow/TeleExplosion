package org.teleexplosion;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Player implements Runnable{
    // player avatar
    Circle circle = new Circle();

    // player position
    Position position;

    // player status
    private boolean playing;
    public boolean isPlaying() {
        return playing;
    }
    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    // map
    Map map;

    public Player(String avatar, AnchorPane mapPane, Map map, boolean playing){
        this.map = map;
        this.playing = playing;

        // starting position and color
        switch (avatar) {
            case "RED" -> {
                circle.setFill(Color.RED);
                this.position = new Position(map, circle, 1, 1, 60, 60);
            }
            case "GREEN" -> {
                circle.setFill(Color.GREEN);
                this.position = new Position(map, circle, 13, 1, 540, 60);
            }
            case "BLUE" -> {
                circle.setFill(Color.BLUE);
                this.position = new Position(map, circle, 1, 11, 60, 460);
            }
            case "ORANGE" -> {
                circle.setFill(Color.ORANGE);
                this.position = new Position(map, circle, 13, 11, 540, 460);
            }
        }

        // adding player avatar
        mapPane.getChildren().add(circle);
    }

    // player moving
    public void move(KeyCode code) {
        position.movement(code);
    }

    // death detection
    @Override
    public void run() {
        while (playing || circle.getRadius() != 0){
            try {
                if(!playing){
                    this.circle.setRadius(0);
                }
                else if (map.getCell(position.getX(), position.getY()) == 9) {
                    this.playing = false;
                    this.circle.setRadius(0);
                }
                Thread.sleep(200);
            }
            catch (InterruptedException ignored) {}
        }
    }
}
