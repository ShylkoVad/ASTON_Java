package ru.aston.utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;


import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class ValueWriter<T>{
    private final Object writerObject;

    public ValueWriter(Object object ){
        this.writerObject =object;
    }

    public void writer() throws IOException {
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("src/main/java/resources/findResults.txt"), CREATE, APPEND)){
            Field[] fields = writerObject.getClass().getDeclaredFields();
            for(Field field:fields){
                field.setAccessible(true);
            }
            try{
                for (int i = 0; i < fields.length; i++) {
                    if (i <= fields.length - 2){
                        String appendedString = fields[i].get(writerObject).toString() + ", ";
                        bufferedWriter.append(appendedString);
                    }
                    if(i == fields.length-1){
                        String appendedString = fields[i].get(writerObject).toString() + "\n";
                        bufferedWriter.append(appendedString);
                    }
                }
            }
            catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
