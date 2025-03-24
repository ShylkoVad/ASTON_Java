package ru.aston.utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class ListWriter<T>{
    private final List<T> listWriter;

    public ListWriter(List<T> list){
        this.listWriter = list;
    }

    public  void fileWriter() throws IOException {
        try(BufferedWriter outputStream = Files.newBufferedWriter(Paths.get("src/main/java/resources/sortingResults.txt"), CREATE,APPEND)){
            for(T object: listWriter){
                Field[] fields = object.getClass().getDeclaredFields();
                for(Field field:fields){
                    field.setAccessible(true);
                }
                try{
                    for (int i = 0; i < fields.length; i++) {
                        if (i <= fields.length - 2){
                            String appendedString = fields[i].get(object).toString() + ", ";
                            outputStream.append(appendedString);
                        }
                        if(i == fields.length-1){
                            String appendedString = fields[i].get(object).toString() + "\n";
                            outputStream.append(appendedString);
                        }
                    }
                }
                catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
