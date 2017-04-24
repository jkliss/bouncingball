/**
 * Created by Julius on 08.02.2016.
 */
public class Ball {
    private double rx, ry;
    private double vx, vy;
    private double radius;
    public Ball() {
        rx = ry = 0.5;
        vx = 0.004 - Math.random()/400;
        vy = 0.003 - Math.random()/400;
        radius = 0.005 + Math.random() * 0.001;
    }
    public void move() {
        if ((rx + vx > 1.0) || (rx + vx < 0.0)) vx = -vx;
        if ((ry + vy > 1.0) || (ry + vy < 0.0)) vy = -vy;
        rx = rx + vx;
        ry = ry + vy;
    }
    public void move(Bar bar) {
        double bp = bar.BarPosition();
        double vp = bar.vBarPosition();
        double bsize = bar.size();
        double hsize = bar.hsize();
        if(((ry+vy)>hsize-vp) && (ry+vy)<hsize+vp && (rx+vx)<bp+bsize && (rx+vx)>bp-bsize) vy = -vy;
        if ((ry + vy > 1.0)) vy = -vy;
        if ((rx + vx > 1.0) || (rx + vx < 0.0)) vx = -vx;
        rx = rx + vx;
        ry = ry + vy;
    }
    public boolean alive(){
        if (ry + vy < 0.0) return false;
        else return true;
    }
    public void move(Bar[] bar) {
        for(int i = 0; i < bar.length; i++){
            double bp = bar[i].BarPosition();
            double vp = bar[i].vBarPosition();
            double bsize = bar[i].size();
            double hsize = bar[i].hsize();
            if(((ry+vy)>hsize-vp) && (ry+vy)<hsize+vp && (rx+vx)<bp+bsize && (rx+vx)>bp-bsize){
                vy = -vy;
                i = bar.length;
            }
            if ((ry + vy > 1.0)) {
                vy = -vy;
                i = bar.length;
            }
            if ((rx + vx > 1.0) || (rx + vx < 0.0)) {
                vx = -vx;
                i = bar.length;
            }
            rx = rx + vx;
            ry = ry + vy;
        }
    }
    public void draw() {
        StdDraw.filledCircle(rx, ry, radius);
    }
}
