package com.pmareke;

import com.pmareke.models.About;
import com.pmareke.models.Careers;
import com.pmareke.models.DarkTheme;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppTest {
    @Test
    public void shouldAnswerWithContent() {
        DarkTheme darkTheme = new DarkTheme();

        About about = new About(darkTheme);
        Careers careers = new Careers(darkTheme);

        assertTrue(about.getContent().equals("About page in Dark Black"));
        careers.getContent().equals("Careers page in Dark Black");
    }
}
