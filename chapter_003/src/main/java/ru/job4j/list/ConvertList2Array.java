package ru.job4j.list;

/**
 * Created by a.mogilevtsev on 3/16/2019.
 */
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells;
        cells = new Double(Math.ceil((double) list.size() / rows)).intValue();
        int[][] array = new int[rows][cells];
        int r = 0;
        int c = 0;
        for (int element : list) {
            array[r][c] = element;
            if (c == cells - 1) {
                c = 0;
                if (r < rows - 1) {
                    r++;
                }
            } else {
                c++;
            }
        }
        while (c < cells) {
            array[r][c] = 0;
            c++;
        }
        return array;
    }
}