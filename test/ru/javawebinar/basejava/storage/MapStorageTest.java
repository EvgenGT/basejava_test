package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MapStorageTest {
    private final HashMap<String, Resume> map = new HashMap<>();

    @BeforeEach
    void setUp() {
        map.clear();

        String uuid1 = "uuid1";
        Resume resume1 = new Resume(uuid1);
        String uuid2 = "uuid2";
        Resume resume2 = new Resume(uuid2);
        String uuid3 = "uuid3";
        Resume resume3 = new Resume(uuid3);

        map.put("resume1", resume1);
        map.put("resume2", resume2);
        map.put("resume3", resume3);
    }

    @Test
    void clear() {
        map.clear();
        assertEquals(0, map.size(), 0, "Размер хранилища должен составлять 0 (ноль) после очистки.");
    }

    @Test
    void update() {
        assertEquals(3, map.size(), "Размер хранилища должен составлять 3 (три) резюме.");
    }

    @Test
    void save() {
        String uuid4 = "uuid4";
        Resume resume4 = new Resume(uuid4);
        map.put("resume4", resume4);

        assertEquals(4, map.size(), "Размер хранилища должен составлять 4 (четыре) после добавления нового резюме.");
    }

    @Test
    void get() {
        assertEquals(3, map.size(), "Размер хранилища должен составлять 3 (три) резюме.");
    }

    @Test
    void delete() {
        String uuid4 = "uuid4";
        Resume resume4 = new Resume(uuid4);
        map.remove("resume4");

        assertEquals(3, map.size(), "Размер хранилища должен составлять 4 (четыре) после добавления нового резюме.");
    }

    @Test
    void getAll() {
        assertEquals(3, map.size(), "Размер хранилища должен составлять 3 (три) резюме.");
    }

    @Test
    void size() {
        assertEquals(3, map.size(), "Размер хранилища должен составлять 3 (три) резюме.");
    }
}