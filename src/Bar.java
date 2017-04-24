/**
 * Created by Julius on 10.02.2016.
 */
public class Bar {
    private double rx;
    private double vx;
    private double width;
    private double height;
    private double speed;
    public Bar() {
        rx = 0.5;
        vx = 0.015;
        width = 0.08;
        height = 0.01;
        speed = 0.02;
    }
    public void rmove() {
        if(rx<1)    rx+=speed;
    }
    public void lmove() {
        if(rx>0)   rx-=speed;
    }
    public void draw() {
        StdDraw.filledRectangle(rx, vx, width, height);
    }
    public double BarPosition(){return rx;}
    public double size(){return width;}
    public double hsize(){return height;}
    public double vBarPosition(){return vx;}
}
