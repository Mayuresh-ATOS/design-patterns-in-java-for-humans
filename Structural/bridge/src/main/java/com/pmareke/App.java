package com.pmareke;

import com.pmareke.models.About;
import com.pmareke.models.Careers;
import com.pmareke.models.DarkTheme;

public class App {
    public static void main(String[] args) {
        DarkTheme darkTheme = new DarkTheme();

        About about = new About(darkTheme);
        Careers careers = new Careers(darkTheme);

        System.out.println(about.getContent()); // "About page in Dark Black";
        System.out.println(careers.getContent()); // "Careers page in Dark Black";
    }
}
