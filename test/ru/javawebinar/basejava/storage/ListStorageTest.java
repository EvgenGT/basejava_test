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
        String uuid3 = "uuid3";
        Resume resume3 = new Resume(uuid3);

        collection.add(resume1);
        collection.add(resume2);
        collection.add(resume3);

    }

    @Test
    public void clear() {
        collection.clear();
        assertEquals(0, collection.size(), "Размер хранилища должен составлять 0 (ноль) после очистки.");
    }

    @Test
    public void update() {
        assertEquals(3, collection.size(), "Размер хранилища должен составлять 3 (три) резюме.");
    }

    @Test
    public void save() {
        String uuid4 = "uuid4";
        Resume resume4 = new Resume(uuid4);
        collection.add(resume4);

        assertEquals(4, collection.size(), "Размер хранилища должен составлять 4 (четыре) после добавления нового резюме.");
    }

    @Test
    public void get() {
        assertEquals(3, collection.size(), "Размер хранилища должен составлять 3 (три) резюме.");

    }

    @Test
    public void delete() {
        String uuid4 = "uuid4";
        Resume resume4 = new Resume(uuid4);
        collection.remove(resume4);

        assertEquals(3, collection.size(), "Размер хранилища должен составлять 4 (четыре) после добавления нового резюме.");
    }

    @Test
    public void getAll() {
        assertEquals(3, collection.size(), "Размер хранилища должен составлять 3 (три) резюме.");
    }

    @Test
    public void size() {
        assertEquals(3, collection.size(), "Размер хранилища должен составлять 3 (три) резюме.");
    }
}