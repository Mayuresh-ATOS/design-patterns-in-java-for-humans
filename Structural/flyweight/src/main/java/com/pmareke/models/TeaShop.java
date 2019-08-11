package com.pmareke.models;

import java.util.HashMap;
import java.util.Map;

public class TeaShop {
    protected Map<Integer, KarakTea> orders = new HashMap<Integer, KarakTea>();

    protected TeaMaker teaMaker;

    public TeaShop(TeaMaker teaMaker) {
        this.teaMaker = teaMaker;
    }

    public void takeOrder(String teaType, int table) {
        this.orders.put(table, this.teaMaker.Make(teaType));
    }

    public void serve() {
        for (Integer table : orders.keySet()) {
            System.out.println("Serving tea to table# " + table);
        }
    }
}
