package org.cn.dsa;

public class Buyer {

    int favColor;
    boolean tShirtBought;
    int purchPrice;

    public Buyer(int favColor, boolean tShirtBought, int purchPrice) {
        this.favColor = favColor;
        this.tShirtBought = tShirtBought;
        this.purchPrice = purchPrice;
    }

    @Override
    public String toString() {
        return "\n"+"Buyer{" +
                "favColor=" + favColor +
                ", tShirtBought=" + tShirtBought +
                ", purchPrice=" + purchPrice +
                '}';
    }
}
