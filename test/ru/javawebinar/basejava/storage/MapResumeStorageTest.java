package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapResumeStorageTest {
    private final Map<String, Resume> map = new HashMap<>();

    @BeforeEach
    void setUp() {
        map.clear();

        map.put("1", new Resume("uuid1"));
        map.put("2", new Resume("uuid2"));
        map.put("3", new Resume("uuid3"));
    }

    @Test
    void getSearchKey() {
        Resume newResume1 = new Resume("uuid4");
        MapResumeStorage map = new MapResumeStorage();
        map.doSave(newResume1, "uuid4");
        Object result = map.getSearchKey("uuid4");
        assertEquals(newResume1, result, "Должно вернуть сохраненное резюме");
    }

    @Test
    void doUpdate() {
        Resume newResume = new Resume("UUID_NEW");
        map.put("1", newResume);
        Object actual = map.put("1", newResume);
        assertEquals(actual, map.get("1"), "Должно вернуть сохраненное резюме");
    }

    @Test
    void isExist() {
        assertTrue(map.containsKey("1"));
        assertFalse(map.containsKey("4"));
    }

    @Test
    void doSave() {
        Resume newResume = new Resume("uuid4");
        map.put("4", newResume);
        assertEquals(4, map.size(), "Размер хранилища должен уменьшиться на 1 после удаления");
    }

    @Test
    void doGet() {
        Resume newResume = new Resume("uuid1");
        map.put("1", newResume);
        Resume result = map.get("1");
        assertEquals(result, newResume, "Должно вернуть сохраненное резюме");
    }

    @Test
    void doDelete() {
        map.remove("3");
        assertEquals(2, map.size(), "Размер хранилища должен уменьшиться на 1 после удаления");
    }

    @Test
    void clear() {
        map.clear();
        assertEquals(0, 0, "Размер хранилища должен составлять 0 (ноль) после очистки.");
    }

    @Test
    void getAll() {
        Resume[] resumes = map.values().toArray(new Resume[0]);
        assertEquals(3, map.size(), "Размер хранилища должен составлять 3 (три) резюме.");
        assertEquals(3, resumes.length, "Должно быть 3 резюме в массиве.");
    }

    @Test
    void size() {
        map.size();
        assertEquals(3, map.size(), "Размер хранилища должен составлять 3 (три) резюме.");
    }
}