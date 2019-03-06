/**
 * Created by a.mogilevtsev on 3/6/2019.
 */
package ru.job4j.search;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    PhoneDictionary phones = new PhoneDictionary();
    @Before
    public void fillPhoneBook() {
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Ivan", "Petrov", "7486452", "Moscow"));
        phones.add(new Person("Alex", "Hunter", "0987543", "New-York"));
        phones.add(new Person("Andrew", "Alexeev", "32512", "Mink"));
    }
    @Test
    public void whenFindByName() {
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindByPhone() {
        List<Person> persons = phones.find("6452");
        assertThat(persons.iterator().next().getSurname(), is("Petrov"));
    }

    @Test
    public void whenFewFounded() {
        List<Person> founded = phones.find("Alex");
        Iterator<Person> iterator = founded.iterator();
        assertThat(iterator.next().getSurname(), is("Hunter"));
        assertThat(iterator.next().getSurname(), is("Alexeev"));
    }
}