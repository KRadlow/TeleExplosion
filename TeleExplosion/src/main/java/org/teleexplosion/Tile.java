package org.teleexplosion;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

public class Tile extends ImageView {
    private final String level;

    public Tile (String level) {
        this.level = level;
    }

    public ImageView getTile(int content){
        ImageView image = new ImageView();
        if(content==1){
            // floor
            Image img = new Image(new File("maps/"+level+"/floor.png").toURI().toString());
            image.setImage(img);
        }
        else if(content==2) {
            // wall
            Image img = new Image(new File("maps/"+level+"/wall.png").toURI().toString());
            image.setImage(img);
        }
        else if(content==3){
            // box
            Image img = new Image(new File("maps/"+level+"/box.png").toURI().toString());
            image.setImage(img);
        }
        else if(content==8){
            // bomb
            Image img = new Image(new File("maps/"+level+"/bomb.png").toURI().toString());
            image.setImage(img);
        }
        else if(content==9){
            // boom/explosion
            Image img = new Image(new File("maps/"+level+"/boom.png").toURI().toString());
            image.setImage(img);
        }
        return image;
    }
}
