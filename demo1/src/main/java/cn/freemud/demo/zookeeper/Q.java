package cn.freemud.demo.zookeeper;

/**
 * Created by chenwenshun on 2017/7/9.
 */
public class Q {

    private volatile int n;

    public Q(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
