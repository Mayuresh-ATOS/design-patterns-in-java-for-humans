package com.pmareke.models;

import com.pmareke.interfaces.Theme;
import com.pmareke.interfaces.WebPage;

public class About implements WebPage {
    protected Theme theme;

    public About(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String getContent() {
        return "About page in " + this.theme.color();
    }
}
