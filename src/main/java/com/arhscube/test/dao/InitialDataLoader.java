package com.arhscube.test.dao;

import com.arhscube.test.rest.model.User;
import com.arhscube.test.rest.service.UserStorageService;
import com.arhscube.test.utils.CsvUtils;
import com.arhscube.test.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class InitialDataLoader {

    @Value("${csvFileName}")
    private String fileName;

    @Autowired
    private UserStorageService userService;

    @PostConstruct
    private void loadUsersFromCsvFileToDb() throws IOException {
        System.out.println("loading data from csv file...");
        InputStream inputStream = FileUtils.read(fileName);
        List<User> users = CsvUtils.read(User.class, inputStream, "firstName", "lastName", "emailAddress");

        userService.addUsers(users);
    }

}