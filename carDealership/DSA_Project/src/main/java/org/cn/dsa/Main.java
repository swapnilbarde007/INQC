package org.cn.dsa;

import java.util.*;

public class Main {

    static ArrayList<TShirt> tShirtList;
    public static void main(String[] args) {
//        Timebased tb=new Timebased();
//        tb.setKey("Swapnil","Java",1);
//        tb.setKey("Swapnil","Spring",2);
//        tb.setKey("Swapnil","React",3);
//
//        System.out.println(tb.getValue("Swapnil",4));

        tShirtList=new ArrayList<>();
        tShirtList.add(new TShirt(201,1,1));
        tShirtList.add(new TShirt(202,1,2));
        tShirtList.add(new TShirt(301,1,3));
        tShirtList.add(new TShirt(302,2,1));
        tShirtList.add(new TShirt(401,2,2));
        tShirtList.add(new TShirt(402,2,3));
        tShirtList.add(new TShirt(501,3,1));
        tShirtList.add(new TShirt(502,3,2));
        tShirtList.add(new TShirt(502,3,3));


        Deque<Buyer> buyerQueue=new ArrayDeque<>();
        buyerQueue.addLast(new Buyer(1,false,0));
        buyerQueue.addLast(new Buyer(1,false,0));
        buyerQueue.addLast(new Buyer(1,false,0));
        buyerQueue.addLast(new Buyer(1,false,0));
        buyerQueue.addLast(new Buyer(2,false,0));
        buyerQueue.addLast(new Buyer(3,false,0));
        buyerQueue.addLast(new Buyer(2,false,0));
        buyerQueue.addLast(new Buyer(2,false,0));
        buyerQueue.addLast(new Buyer(3,false,0));
        buyerQueue.addLast(new Buyer(3,false,0));

        Iterator<Buyer> itBr=buyerQueue.iterator();
        while(itBr.hasNext()){
            //System.out.println(itBr.next());
            buyTShirt(itBr.next());
        }


        System.out.println("Buyers after purchase: "+buyerQueue);
        System.out.println("Tshirts after purchase: "+tShirtList);
//        System.out.println("TShirt after purchase: "+tShirtList);
    }

    public static void buyTShirt(Buyer b1){
        //Check if favourite color is available
        TShirt minTshirt= tShirtList.stream().filter(tshirt->tshirt.backColor== b1.favColor || tshirt.frontColor==b1.favColor)
                .filter(tShirt -> tShirt.isSoldOut==false)
                .min(Comparator.comparing(tshirt->tshirt.price))
                .orElse(null);

        if(minTshirt!=null){
            minTshirt.isSoldOut=true;
            b1.tShirtBought=true;
            b1.purchPrice=minTshirt.price;
        }
                //.ifPresent(System.out::println);
        //Check if available colors are greater than 1

        // choice based on price


    }
}