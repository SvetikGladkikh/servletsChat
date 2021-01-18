package ru.js.chat.store;

public class BlockedUsersStoreHolder {
    private static BlockedUsersStore blockedUsersStore;

    public static BlockedUsersStore get(){
        if(blockedUsersStore == null){
            blockedUsersStore = new BlockedUsersStoreImpl();
        }

        return blockedUsersStore;
    }
}
