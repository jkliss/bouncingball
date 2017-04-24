/**
 * Created by Julius on 08.02.2016.
 */
public class BouncingBall {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(750, 750);
        int N = 5;
        int Nb = 2;
        Ball balls[] = new Ball[N];
        Bar[] bar = new Bar[Nb];
        for(int i = 0; i < Nb; i++) {
            bar[i] = new Bar();
        }
        int score = 0;
        int pscore = 0;
        int time = 0;
        for (int i = 0; i < N; i++)
            balls[i] = new Ball();
        while(true) {
            time++;
            StdDraw.clear();
            int alive = 0;
            for (int i = 0; i < N; i++) {
                balls[i].move(bar);
                balls[i].draw();
                if(balls[i].alive()) alive++;
            }
            score+=alive;
            if(StdDraw.isKeyPressed(39)){
                bar[0].rmove();
            }
            else if(StdDraw.isKeyPressed(37)){
                bar[0].lmove();
            }
            if(StdDraw.isKeyPressed(65)){
                bar[1].lmove();
            }
            else if(StdDraw.isKeyPressed(68)) {
                bar[1].rmove();
            }
            for(int i = 0; i < Nb; i++) {
                bar[i].draw();
            }
            if(time%20==0)  pscore = score;
            StdDraw.text(0.95,0.95,Integer.toString(pscore));
            StdDraw.show(10);
        }
    }
}