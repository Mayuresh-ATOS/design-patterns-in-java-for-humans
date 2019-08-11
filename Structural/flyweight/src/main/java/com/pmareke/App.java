package com.pmareke;

import com.pmareke.models.TeaMaker;
import com.pmareke.models.TeaShop;

public class App {
    public static void main(String[] args) {
        TeaMaker teaMaker = new TeaMaker();
        TeaShop shop = new TeaShop(teaMaker);

        shop.takeOrder("less sugar", 1);
        shop.takeOrder("more milk", 2);
        shop.takeOrder("without sugar", 5);

        shop.serve();
        // Serving tea to table# 1
        // Serving tea to table# 2
        // Serving tea to table# 5
    }
}
