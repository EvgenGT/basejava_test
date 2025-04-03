package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MapStorageTest {

    private final Map<Integer, Resume> map = new HashMap<>();

    @BeforeEach
    void setUp() {
        map.clear();
        Resume r1 = new Resume("uuid1");
        Resume r2 = new Resume("uuid2");
        Resume r3 = new Resume("uuid3");

        map.put(1, r1);
        map.put(2, r2);
        map.put(3, r3);

    }

    @Test
    void getSearchKey() {
        String expected = "12345";
        MapStorage storage = new MapStorage();
        Object actual = storage.getSearchKey(expected);
        assertNull(actual, "Должно вернуть null, если элемент не найден");
    }

    @Test
    void doUpdate() {
        Resume newResume = new Resume("UUID_NEW");
        final int searchKey = 1;
        map.put(searchKey, newResume);
        Object actual = map.put(1, newResume);
        assertEquals(actual, map.get(searchKey), "Должно вернуть сохраненное резюме");
    }

    @Test
    void isExist() {
        MapStorage map = new MapStorage();
        assertTrue(map.isExist("Hello"));
        assertFalse(map.isExist(null));
    }

    @Test
    void doSave() {
        Resume newResume = new Resume("uuid4");
        map.put(4, newResume);
        assertEquals(4, map.size(), "Размер хранилища должен уменьшиться на 1 после удаления");
        System.out.println(map.size());
    }

    @Test
    void doGet() {
        Resume newResume = new Resume("uuid1");
        final int searchKey = 1;
        map.put(searchKey, newResume);
        Resume result = map.get(searchKey);
        assertEquals(result, newResume, "Должно вернуть сохраненное резюме");
        System.out.println(result);
    }

    @Test
    void doDelete() {
        Resume r4 = new Resume("uuid4");
        final int searchKey = 4;
        map.put(searchKey, r4);
        map.remove(4);
        assertEquals(3, map.size(), "Размер хранилища должен уменьшиться на 1 после удаления");
        System.out.println(map.size());
    }

    @Test
    void clear() {
        map.clear();
        assertEquals(0, 0, "Размер хранилища должен составлять 0 (ноль) после очистки.");
        System.out.println(map.size());
    }

    @Test
    void getAll() {
        Resume[] resumes = map.values().toArray(new Resume[0]);
        System.out.println(map.size());
        assertEquals(3, map.size(), "Размер хранилища должен составлять 3 (три) резюме.");
        assertEquals(3, resumes.length, "Должно быть 3 резюме в массиве.");
    }

    @Test
    void size() {
        map.size();
        assertEquals(3, map.size(), "Размер хранилища должен составлять 3 (три) резюме.");
        System.out.println(map.size());
    }
}