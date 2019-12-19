package edu.mum.cs.helloworldboot.component;

public interface MessageDisplay {
    void display();
    void setMessageSource(MessageOrigin source);
    MessageOrigin getMessageSource();
}
