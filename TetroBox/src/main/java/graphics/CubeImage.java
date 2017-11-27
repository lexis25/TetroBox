package graphics;

import java.awt.image.BufferedImage;

public class CubeImage {

    private BufferedImage image;

    public CubeImage(String imageName){
        image = Loader.loadImage(imageName);
    }

    public BufferedImage cut(int x, int y, int w, int h){
        return image.getSubimage(x,y,w,h);
    }
}