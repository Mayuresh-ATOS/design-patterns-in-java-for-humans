package com.pmareke;

import com.pmareke.models.Editor;
import com.pmareke.models.EditorMemento;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppTest {
    @Test
    public void shouldAnswerWithTrue() {
        Editor editor = new Editor();

        editor.type("This is the first sentence.");
        editor.type("This is second.");

        EditorMemento saved = editor.save();

        editor.type("And this is third.");
        assertTrue(editor.getContent().equals(" This is the first sentence. This is second. And this is third."));

        editor.restore(saved);
        assertTrue(editor.getContent().equals(" This is the first sentence. This is second."));
    }
}
