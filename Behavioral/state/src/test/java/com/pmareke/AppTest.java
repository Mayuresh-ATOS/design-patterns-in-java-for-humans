package com.pmareke;

import com.pmareke.models.DefaultText;
import com.pmareke.models.LowerCase;
import com.pmareke.models.TextEditor;
import com.pmareke.models.UpperCase;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppTest {
    @Test
    public void shouldAnswerWithTrue() {
        TextEditor editor = new TextEditor(new DefaultText());

        assertTrue(editor.type("First line").equals("First line"));

        editor.setState(new UpperCase());

        assertTrue(editor.type("Second line").equals("SECOND LINE"));
        assertTrue(editor.type("Third line").equals("THIRD LINE"));

        editor.setState(new LowerCase());

        assertTrue(editor.type("Fourth line").equals("fourth line"));
        assertTrue(editor.type("Fifth line").equals("fifth line"));
    }
}
