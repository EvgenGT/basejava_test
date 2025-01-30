package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListStorageTest {

    private final Collection<Resume> collection = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        collection.clear();

        String uuid1 = "uuid1";
        Resume resume1 = new Resume(uuid1);
        String uuid2 = "uuid2";
        Resume resume2 = new Resume(uuid2);
        String uuid3 = "uuid1";
        Resume resume3 = new Resume(uuid3);

        collection.add(resume1);
        collection.add(resume2);
        collection.add(resume3);

    }

    @Test
    public void clear() {
    }

    @Test
    public void update() {
    }

    @Test
    public void save() {
    }

    @Test
    public void get() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void size() {
        assertEquals(3, collection.size(), "Размер хранилища должен составлять 3 (три) резюме.");
    }
}