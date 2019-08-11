package com.pmareke.models;

import java.util.HashMap;
import java.util.Map;

public class TeaMaker {
    protected Map<String, KarakTea> availableTea = new HashMap<String, KarakTea>();

    public KarakTea Make(String preference) {
        if (!this.availableTea.containsKey(preference)) {
            this.availableTea.put(preference, new KarakTea());
        }

        return this.availableTea.get(preference);
    }
}
