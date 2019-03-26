package ru.job4j.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by a.mogilevtsev on 3/20/2019.
 */
public class UserConvertTest {

    @Test
    public void whenConvertListThenMapReturned () {
        UserConvert converter = new UserConvert();
        List<User>  usersList = new ArrayList<>();
        usersList.add(new User(1, "Ivan", "Minsk"));
        usersList.add(new User(2, "Andrew", "Moscow"));
        usersList.add(new User(3, "Petr", "Gomel"));
        Map<Integer, User> usersMapExpected = new HashMap<>();
        usersMapExpected.put(1, new User(1, "Ivan", "Minsk"));
        usersMapExpected.put(2, new User(2, "Andrew", "Moscow"));
        usersMapExpected.put(3, new User(3, "Petr", "Gomel"));
        Assert.assertThat(converter.process(usersList), is(usersMapExpected));
        Assert.assertThat(converter.process(usersList).equals(usersMapExpected), is(true));
    }
}
