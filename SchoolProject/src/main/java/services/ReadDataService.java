package services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadDataService {
    public ReadDataService() {}

    /**
     * Read data from a JSON file and return a list of class specified by the type parameter
     * @param fileName
     * @return List<T>
     */
    public <T> List<T> readDataFromJson(String fileName,Class<T[]> c){
        List<T> list = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(fileName))) {
            Gson gson = new Gson();
            T[] arr = gson.fromJson(reader, c);
            Collections.addAll(list, arr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
