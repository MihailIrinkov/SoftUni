package bg.softuni.SpringJSONProcessing.services;

import bg.softuni.SpringJSONProcessing.dto.StudentDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl {

    private Gson gson;

    public StudentServiceImpl(Gson gson) {
        this.gson = gson;
    }

    public void create(String createGson) {
        StudentDTO studentDTO =
                gson.fromJson(createGson, StudentDTO.class);

        System.out.println("Created -> " + studentDTO);
    }

    public String getAllAsJson() {

        return null;
    }
}
