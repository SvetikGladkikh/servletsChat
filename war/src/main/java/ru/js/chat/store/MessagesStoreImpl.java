package ru.js.chat.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessagesStoreImpl implements MessageStore {
    private final List<Message> messages = Collections.synchronizedList(new ArrayList<Message>());

    public List<Message> getAll() {
        return new ArrayList<Message>(messages);
    }

    public void addMessage(Message newMessage) {
        messages.add(newMessage);
    }
}
