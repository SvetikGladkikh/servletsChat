package ru.js.chat.store;

public class MessageStoreHolder {
    private static MessageStore messageStore;

    public static MessageStore get(){
        if(messageStore == null){
            messageStore = new MessagesStoreImpl();
        }

        return messageStore;
    }
}
