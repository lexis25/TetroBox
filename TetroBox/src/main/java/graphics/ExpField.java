package graphics;

import java.awt.*;

public class ExpField {

    public static Figure [] field = new Figure[35];
    private static int counter = 0;
    private final static int WIDTH = 320;
    private final static int HEIGHT = 448;



    public static void main(String[] args) {
        Figure f = new Figure();
        Figure a = new Figure();
        add(f);
        add(a);
        //read();

        for (int i = 0; i <= HEIGHT ; i+= 32) {
            System.out.print(i + " ");
        }
    }

    public static void add(Figure figure){
        field[counter] = figure;
        counter++;
    }

    public static void read(){
        for (int i = 0; i < field.length; i++) {
            if(field[i] != null && counter > 0){
                Point [] arr = field[i].getPoints();
                for (int j = 0; j < arr.length/4; j++) {
                    System.out.println(arr[j].getLocation());
                }
            }else{
                break;
            }
        }
    }

    public static void findFillLines(){
        int count = 0;
        int counterArray = 4;
        for (int i = 0; i < field.length; i++) {
            if(field[i] != null && counter > 0 ){
                Point [] array = field[i].getPoints();
                if(array.length > 4){
                    counterArray = array.length / 4;
                }
                for (int j = 0; j < counterArray ; j++) {// foobar
                    if (array[j].x == 288){
                        count++;
                    }
                }
            }
        }
    }
}
