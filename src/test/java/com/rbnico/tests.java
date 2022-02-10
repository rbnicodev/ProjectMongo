package com.rbnico;

import com.rbnico.models.TeacherModel;
import com.rbnico.repositories.TeacherRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class tests {

    TeacherModel teacher = new TeacherModel(1L, "Test", "Test");
    TeacherRepository repository = new TeacherRepository();

    @Test
    void insertOneTest() {
        assertTrue(repository.insertOne(teacher));
    }

    @Test
    void updateTest() {
        teacher.setLastName("Jacinto");
        assertTrue(repository.update(teacher));
    }
}
