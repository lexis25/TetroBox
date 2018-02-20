package util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Loader {

    private static final String PATH = "/res";

    public static BufferedImage loadImage(String fileName){
        BufferedImage image = null;
        try{
            image = ImageIO.read(new File(PATH + fileName));
        }catch (IOException e){
            e.printStackTrace();
        }
        return image;
    }

}
