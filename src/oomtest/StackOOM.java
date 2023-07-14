package oomtest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: joe
 * @dateTime: 2023/3/1 19:14
 * @description: TODO
 * @version: 1.0
 */
public class StackOOM {
    static class Person {
    }
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        while (true) {
            personList.add(new Person());
        }
    }
}
