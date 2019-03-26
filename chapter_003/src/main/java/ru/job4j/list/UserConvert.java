package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

/**
 * Created by a.mogilevtsev on 3/20/2019.
 */
public class UserConvert {

    HashMap<Integer, User> usersMap = new HashMap<>();

    public HashMap<Integer, User> process(List<User> list) {
        for(User user : list) {
            usersMap.put(user.getId(), user);
        }
        return usersMap;
    }
}
