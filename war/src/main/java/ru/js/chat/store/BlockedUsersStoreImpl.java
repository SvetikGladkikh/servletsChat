package ru.js.chat.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlockedUsersStoreImpl implements BlockedUsersStore{
    private final List<String> blockedUsers = Collections.synchronizedList(new ArrayList<String>());

    public List<String> getAll() {
        return new ArrayList<String>(blockedUsers);
    }

    public boolean containUser(String username) {
        return blockedUsers.contains(username);
    }

    public void blockUser(String username) {
        if (!blockedUsers.contains(username)){
            blockedUsers.add(username);
        }
    }

    public void unblockUser(String username) {
        if (blockedUsers.contains(username)){
            blockedUsers.remove(username);
        }
    }
}
