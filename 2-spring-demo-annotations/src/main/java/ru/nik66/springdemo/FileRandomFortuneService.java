package ru.nik66.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;

@Component
public class FileRandomFortuneService extends RandomFortuneService {

    private File file;

    @PostConstruct
    public void initMethod() {
        if (this.file != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                this.services = new ArrayList<>();
                while ((line = reader.readLine()) != null) {
                    if (!line.trim().isEmpty()) {
                        this.services.add(line.trim());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public FileRandomFortuneService(@Value("FileFortuneService.txt") String fileName) {
        try {
            this.file = ResourceUtils.getFile("classpath:" + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
