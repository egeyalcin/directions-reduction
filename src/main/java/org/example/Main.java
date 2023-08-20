package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] strings = dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"});
        System.out.println(Arrays.toString(strings));
    }

    public static String[] dirReduc(String[] arr) {
        List<String> collect = Arrays.stream(arr).collect(Collectors.toList());
        final String north = "NORTH";
        final String south = "SOUTH";
        final String east = "EAST";
        final String west = "WEST";
        int size = collect.size();
        int changeSize = collect.size();;
        String s1 = "";
        for (int i = 0; i < collect.size(); i++) {
            if(size != changeSize) {
                i = 0;
            }
            size = changeSize;
            String s = collect.get(i);
            if(i + 1 < collect.size()) {
                s1 = collect.get(i + 1);
            }
            else {
                break;
            }
            switch(s) {
                case north :
                    if(s1.equals(south)) {
                        collect.remove(i + 1);
                        collect.remove(i);
                        changeSize = collect.size();
                        i = 0;
                    }
                    break;
                case south :
                    if(s1.equals(north)) {
                        collect.remove(i + 1);
                        collect.remove(i);
                        changeSize = collect.size();
                        i = 0;
                    }
                    break;
                case east :
                    if(s1.equals(west)) {
                        collect.remove(i + 1);
                        collect.remove(i);
                        changeSize = collect.size();
                        i = 0;
                    }
                    break;
                case west :
                    if(s1.equals(east)) {
                        collect.remove(i + 1);
                        collect.remove(i);
                        changeSize = collect.size();
                        i = 0;
                    }
                    break;
            }
        }
        return collect.toArray(new String[0]);
    }
}