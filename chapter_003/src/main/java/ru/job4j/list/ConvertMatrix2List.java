package ru.job4j.list;

/**
 * Created by a.mogilevtsev on 3/16/2019.
 */
import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for(int[] row : array){
            for(int element : row){
                list.add(element);
            }
        }
        return list;
    }
}