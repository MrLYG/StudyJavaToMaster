package lagou.phase1.base;

import java.util.Arrays;
import java.util.Random;

public class Work01 {
    /**
     * 1. 编程题 实现双色球抽奖游戏中奖号码的生成，中奖号码由 6 个红球号码和 1 个蓝球号码组成。
     * 其中红球号码要求随机生成 6 个 1~33 之间不重复的随机号码。 其中蓝球号码要求随机生成 1 个 1~16 之间的随机号码。
     */
    private int[] redBalls = new int[6]; //存红球的数组
    private int blueBall;  //存蓝色球

    public int getBlueBall() {
        return blueBall;
    }

    public void setBlueBall(int blueBall) {
        this.blueBall = blueBall;
    }

    public int[] getRedBalls() {
        return redBalls;
    }

    public void setRedBalls(int[] redBalls) {
        this.redBalls = redBalls;
    }

    /**
     * 判断生成的红色球是否已经存在于红色球数组中，存在返回true
     * @param redBall
     * @return
     */
    public Boolean isRedBallRepeat(int redBall){
        for(int i = 0; i < redBalls.length; i++){
            if(redBalls[i] == redBall){
                return true;
            }
        }
        return false;
    }

    /**
     * 生成红色球序列
     */
    public void createRedBalls(){
        int i = 0;
        while(i<redBalls.length){
            int redball = (int) (Math.random()*33+1);
            while(isRedBallRepeat(redball)){
                redball = (int) (Math.random()*33+1);
            }
            redBalls[i++] =redball;
        }
    }

    /**
     * 生成蓝色球
     */
    public void createBlueBall(){
        blueBall = (int) (Math.random()*16+1);
    }

    public static void main(String[] args) {
        Work01 w = new Work01();
        w.createRedBalls();  //调用红色球生成方法
        w.createBlueBall();  //调用蓝色球生成方法
        System.out.println("redBalls:"+Arrays.toString(w.getRedBalls()));
        System.out.println("blueBall:"+w.getBlueBall());
    }
}
