package com.pmareke.models;

import com.pmareke.interfaces.Theme;
import com.pmareke.interfaces.WebPage;

public class Careers implements WebPage {
    protected Theme theme;

    public Careers(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String getContent() {
        return "Careers page in " + this.theme.color();
    }
}