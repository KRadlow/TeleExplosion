package org.teleexplosion;

import javafx.scene.input.KeyCode;
import javafx.scene.shape.Circle;

public class Position {
    Map map;
    private final Circle circle;

    // image position
    private float imgX;
    private float imgY;

    // position on map
    private int x;
    private int y;

    // position getters
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    // moving speed
    int speed = 10;

    public Position(Map map, Circle circle, int x, int y, int startingX, int startingY) {
        this.map = map;
        this.x = x;
        this.y = y;

        // creating avatar
        this.circle = circle;
        this.imgX = startingX;
        this.imgY = startingY;
        circle.setCenterX(startingX);
        circle.setCenterY(startingY);
        circle.setRadius(15);
    }

    // player move
    public void movement(KeyCode code){

        if(code == KeyCode.UP || code == KeyCode.W || code == KeyCode.I || code == KeyCode.NUMPAD8){
            // move UP
            if ((imgX - 20) % 40 == 0) {
                if ((imgY - 20) % 40 == 0) {
                    // center
                    if (map.getCell(x, y - 1) == 1 || map.getCell(x, y - 1) >= 10) {
                        circle.setCenterY(imgY - speed);
                        imgY -= speed;
                    }
                } else if (imgY % 40 == 0) {
                    // border
                    circle.setCenterY(imgY - speed);
                    imgY -= speed;
                    y = (int) (imgY / 40);
                } else {
                    // other
                    circle.setCenterY(imgY - speed);
                    imgY -= speed;
                }
            }
        }
        else if(code == KeyCode.DOWN || code == KeyCode.S || code == KeyCode.K || code == KeyCode.NUMPAD5){
            // move DOWN
            if ((imgX - 20) % 40 == 0) {
                if ((imgY - 20) % 40 == 0) {
                    // center
                    if (map.getCell(x, y + 1) == 1 || map.getCell(x, y - 1) >= 10) {
                        circle.setCenterY(imgY + speed);
                        imgY += speed;
                    }
                } else if (imgY % 40 == 0) {
                    // border
                    circle.setCenterY(imgY + speed);
                    imgY += speed;
                    y = (int) (imgY / 40);
                } else {
                    // other
                    circle.setCenterY(imgY + speed);
                    imgY += speed;
                }
            }
        }
        else if(code == KeyCode.LEFT || code == KeyCode.A || code == KeyCode.J || code == KeyCode.NUMPAD4){
            // move LEFT
            if((imgY-20)%40 == 0) {
                if ((imgX - 20) % 40 == 0) {
                    // center
                    if (map.getCell(x - 1, y) == 1 || map.getCell(x - 1, y) >= 10) {
                        circle.setCenterX(imgX - speed);
                        imgX -= speed;
                    }
                } else if (imgX % 40 == 0) {
                    // border
                    circle.setCenterX(imgX - speed);
                    imgX -= speed;
                    x = (int) (imgX / 40);
                } else {
                    // other
                    circle.setCenterX(imgX - speed);
                    imgX -= speed;
                }
            }
        }
        else if(code == KeyCode.RIGHT || code == KeyCode.D || code == KeyCode.L || code == KeyCode.NUMPAD6) {
            // move RIGHT
            if ((imgY - 20) % 40 == 0) {
                if ((imgX - 20) % 40 == 0) {
                    // center
                    if (map.getCell(x + 1, y) == 1 || map.getCell(x + 1, y) >= 10) {
                        circle.setCenterX(imgX + speed);
                        imgX += speed;
                    }
                } else if (imgX % 40 == 0) {
                    // border
                    circle.setCenterX(imgX + speed);
                    imgX += speed;
                    x = (int) (imgX / 40);
                } else {
                    // other
                    circle.setCenterX(imgX + speed);
                    imgX += speed;
                }
            }
        }
        else if(code == KeyCode.CONTROL || code == KeyCode.Q || code == KeyCode.U || code == KeyCode.NUMPAD7){
            // place BOMB
            Bomb b = new Bomb(x,y,map,3,2);
            Thread bomb = new Thread(b);
            bomb.start();
        }
    }
}
