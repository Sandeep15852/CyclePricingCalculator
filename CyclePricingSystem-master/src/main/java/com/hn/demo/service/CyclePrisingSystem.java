package com.hn.demo.service;


import lombok.Builder;
import org.apache.commons.collections4.ListUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * arguments to be passed set of all 5 values, ex - ADVANCE BASIC ADVANCE BASIC ADVANCE
 * returns total cost of each set of components.
 */
public class CyclePrisingSystem {

    public static void main(String[] args) {

        List<String> components = Arrays.asList(args);
        List<List<String>> partitionedTagList = ListUtils.partition(components, 5);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(() -> {
            partitionedTagList.forEach(list -> {
                System.out.println("totalCyclePrice = " + getCyclePrice(list));
            });
        });
    }

    private static String getCyclePrice(List<String> list) {
        int totalPrice = 0;
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0:
                    totalPrice += Frame.valueOf(list.get(i)).getPrice();
                    break;

                case 1:
                    totalPrice += Handle.valueOf(list.get(i)).getPrice();
                    break;

                case 2:
                    totalPrice += Seat.valueOf(list.get(i)).getPrice();
                    break;

                case 3:
                    totalPrice += Wheel.valueOf(list.get(i)).getPrice();
                    break;

                case 4:
                    totalPrice += Chain.valueOf(list.get(i)).getPrice();
                    break;
            }
        }
        return Integer.toString(totalPrice);
    }
}

@Builder
class Cycle {
    Frame frame;
    Handle handle;
    Seat seat;
    Wheel wheel;
    Chain chain;
}

enum Frame {

    BASIC(100),
    ADVANCE(150);

    private final int price;

    Frame(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

enum Handle {

    BASIC(100),
    ADVANCE(150);

    private final int price;

    Handle(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

enum Seat {

    BASIC(100),
    ADVANCE(150);

    private final int price;

    Seat(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

enum Wheel {

    BASIC(100),
    ADVANCE(150);

    private final int price;

    Wheel(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

enum Chain {

    BASIC(100),
    ADVANCE(150);

    private final int price;

    Chain(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}