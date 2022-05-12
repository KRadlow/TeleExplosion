package org.teleexplosion;

public class Bomb implements Runnable {
    // bomb position
    private final int x;
    private final int y;
    // time to explode in ms
    private final long countdown;
    // radius of explosion
    private final int radius;

    Map map;

    public Bomb(int x, int y, Map map, long countdown, int radius) {
        this.x = x;
        this.y = y;
        this.map = map;
        this.countdown = countdown * 1000;
        this.radius = radius;
    }

    @Override
    public void run() {
        boolean up = false;
        boolean down = false;
        boolean left = false;
        boolean right = false;
            try {
                //placing bomb on map
                map.setCell(x, y, 8);
                Thread.sleep(countdown);
                //explosion instead of bomb
                map.setCell(x, y, 9);
                //explosion in radius if no wall
                for(int i=1; i<=radius; i++){
                    if(!right) {
                        if (map.getCell(x + i, y) == 3) {
                            map.setCell(x + i, y, 9);
                            right = true;
                        }
                        else if (map.getCell(x + i, y) != 2) {
                            map.setCell(x + i, y, 9);
                        }else {
                            right = true;
                        }
                    }
                    if(!left) {
                        if (map.getCell(x - i, y) == 3) {
                            map.setCell(x - i, y, 9);
                            left = true;
                        }
                        else if (map.getCell(x - i, y) != 2) {
                            map.setCell(x - i, y, 9);
                        }else {
                            left = true;
                        }
                    }
                    if(!up) {
                        if (map.getCell(x, y + i) == 3) {
                            map.setCell(x , y + i, 9);
                            up = true;
                        }
                        else if (map.getCell(x, y + i) != 2) {
                            map.setCell(x, y + i, 9);
                        }else {
                            up = true;
                        }
                    }
                    if(!down) {
                        if (map.getCell(x, y - i) == 3) {
                            map.setCell(x, y - i, 9);
                            down = true;
                        }
                        else if (map.getCell(x, y - i) != 2) {
                            map.setCell(x, y - i, 9);
                        }else {
                            down = true;
                        }
                    }
                }
                Thread.sleep(500);
                up = false;
                down = false;
                left = false;
                right = false;
                for(int i=1; i<=radius; i++){
                    //going back to floor
                    if(!right) {
                        if (map.getCell(x + i, y) == 3) {
                            map.setCell(x + i, y, 1);
                            right = true;
                        }
                        else if (map.getCell(x + i, y) != 2) {
                            map.setCell(x + i, y, 1);
                        }else {
                            right = true;
                        }
                    }
                    if(!left) {
                        if (map.getCell(x - i, y) == 3) {
                            map.setCell(x - i, y, 1);
                            left = true;
                        }
                        else if (map.getCell(x - i, y) != 2) {
                            map.setCell(x - i, y, 1);
                        }else {
                            left = true;
                        }
                    }
                    if(!up) {
                        if (map.getCell(x, y + i) == 3) {
                            map.setCell(x , y + i, 1);
                            up = true;
                        }
                        else if (map.getCell(x, y + i) != 2) {
                            map.setCell(x, y + i, 1);
                        }else {
                            up = true;
                        }
                    }
                    if(!down) {
                        if (map.getCell(x, y - i) == 3) {
                            map.setCell(x, y - i, 1);
                            down = true;
                        }
                        else if (map.getCell(x, y - i) != 2) {
                            map.setCell(x, y - i, 1);
                        }else {
                            down = true;
                        }
                    }
                }
                map.setCell(x, y, 1);
            }
            catch (InterruptedException ignored) {}
    }
}
