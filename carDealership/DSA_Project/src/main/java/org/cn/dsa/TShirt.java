package org.cn.dsa;

public class TShirt {
    int price;
    int frontColor;
    int backColor;
    boolean isSoldOut=false;

    public TShirt(int price, int frontColor, int backColor) {
        this.price = price;
        this.frontColor = frontColor;
        this.backColor = backColor;
    }

    @Override
    public String toString() {
        return "\n"+"TShirt{" +
                "price=" + price +
                ", frontColor=" + frontColor +
                ", backColor=" + backColor +
                ", isSoldOut=" + isSoldOut +
                '}';
    }
}