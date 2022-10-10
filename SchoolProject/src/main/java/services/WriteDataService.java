package services;

import models.Teacher;
import repositories.IBaseRepository;

import java.util.List;

public class WriteDataService {



    public WriteDataService() {

    }

    public <T>  void writeData(List<T> object, IBaseRepository<T, String> repository) {
        for (Object student : object) {
            repository.save((T) student);
        }
    }

}
