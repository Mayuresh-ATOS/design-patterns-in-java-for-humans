package com.pmareke;

import com.pmareke.models.DefaultText;
import com.pmareke.models.LowerCase;
import com.pmareke.models.TextEditor;
import com.pmareke.models.UpperCase;

public class App {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(new DefaultText());

        System.out.println(editor.type("First line"));

        editor.setState(new UpperCase());

        System.out.println(editor.type("Second line"));
        System.out.println(editor.type("Third line"));

        editor.setState(new LowerCase());

        System.out.println(editor.type("Fourth line"));
        System.out.println(editor.type("Fifth line"));

        // Output:
        // First line
        // SECOND LINE
        // THIRD LINE
        // fourth line
        // fifth line
    }
}
