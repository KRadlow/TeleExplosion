package org.teleexplosion;

import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Game implements Runnable{
    Map map;
    private boolean end = false;

    // players
    private static Player p1;
    private static Player p2;
    private static Player p3;
    private static Player p4;
    static ArrayList<Boolean> players = new ArrayList<>();

    // constructor
    public Game(AnchorPane mapPane, GridPane mapGrid, String level, ArrayList<Boolean> players) {
        this.map = new Map(mapGrid,level);

        Game.players = players;

        // creating players
        if(players.get(0)) {
            p1 = new Player("RED", mapPane, map, true);
            Thread thread = new Thread(p1);
            thread.start();
        }
        if (players.get(1)) {
            p2 = new Player("GREEN", mapPane, map, true);
            Thread thread = new Thread(p2);
            thread.start();
        }
        if (players.get(2))
        {
            p3 = new Player("ORANGE", mapPane, map, true);
            Thread thread = new Thread(p3);
            thread.start();
        }
        if (players.get(3))
        {
            p4 = new Player("BLUE", mapPane, map, true);
            Thread thread = new Thread(p4);
            thread.start();
        }
    }

    public static void playersMove(KeyCode code) {
        // moving players
        if (players.get(0) && (code == KeyCode.W || code == KeyCode.A || code == KeyCode.S || code == KeyCode.D || code == KeyCode.Q))
            p1.move(code);
        if (players.get(1) && (code == KeyCode.I || code == KeyCode.J || code == KeyCode.K || code == KeyCode.L || code == KeyCode.U))
            p2.move(code);
        if (players.get(2)  && (code == KeyCode.KP_UP || code == KeyCode.KP_LEFT || code == KeyCode.KP_DOWN || code == KeyCode.KP_RIGHT || code == KeyCode.CONTROL))
            p3.move(code);
        if (players.get(3)  && (code == KeyCode.NUMPAD8 || code == KeyCode.NUMPAD4 || code == KeyCode.NUMPAD5 || code == KeyCode.NUMPAD6 || code == KeyCode.NUMPAD7))
            p4.move(code);
    }

    @Override
    public void run() {
        while(!end) {
            try {
                Thread thread = new Thread(task);
                thread.setDaemon(true);
                thread.start();
                Thread.sleep(200);
                checkEndGame();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    Runnable task = () -> Platform.runLater(()-> map.loadMap());

    // checking game status
    private void checkEndGame(){
        int numOfPlayers = 0;
        if(players.get(0)) {
            players.set(0,p1.isPlaying());
            numOfPlayers+=1;
        }
        if (players.get(1)) {
            players.set(1,p2.isPlaying());
            numOfPlayers+=1;
        }
        if (players.get(2)) {
            players.set(2,p3.isPlaying());
            numOfPlayers+=1;
        }
        if (players.get(3)) {
            players.set(3,p4.isPlaying());
            numOfPlayers+=1;
        }

        // end game
        if(numOfPlayers == 1 || end){
            // somebody win
            if(players.get(0)) {
                System.out.println("GORDON WIN");
                p1.setPlaying(false);
            }
            if (players.get(1)) {
                System.out.println("LUCAS WIN");
                p2.setPlaying(false);
            }
            if (players.get(2)) {
                System.out.println("PENNY WIN");
                p3.setPlaying(false);
            }
            if (players.get(3)) {
                System.out.println("LOLA WIN");
                p4.setPlaying(false);
            }
            endGame();
        }
        else if(numOfPlayers == 0) {
            // draw
            System.out.println("DRAW");
            endGame();
        }
    }

    // thread ending
    public void endGame(){
        this.end = true;
    }
}
