package com.pmareke;

import com.pmareke.models.Hunter;
import com.pmareke.models.WildDog;
import com.pmareke.models.WildDogAdapter;

public class App {
    public static void main(String[] args) {
        WildDog wildDog = new WildDog();
        WildDogAdapter wildDogAdapter = new WildDogAdapter(wildDog);

        Hunter hunter = new Hunter();
        System.out.println(hunter.hunt(wildDogAdapter));
    }
}
