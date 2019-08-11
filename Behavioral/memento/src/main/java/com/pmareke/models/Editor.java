package com.pmareke.models;

public class Editor {
    protected String content = "";

    public void type(String words) {
        this.content = this.content + " " + words;
    }

    public String getContent() {
        return content;
    }

    public EditorMemento save() {
        return new EditorMemento(this.content);
    }

    public String restore(EditorMemento memento) {
        return this.content = memento.getContent();
    }
}
