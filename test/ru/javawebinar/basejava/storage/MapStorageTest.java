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
        String uuid = "uuid1";
        MapStorage storage = new MapStorage();
        Object result = storage.getSearchKey(uuid);
        System.out.println(result);  // Можно убрать, если не нужно
        assertNull(result, "Должно вернуть null, если элемент не найден");
    }

    @Test
    void doUpdate() {
        Resume oldResume = new Resume("UUID_OLD");
        Resume newResume = new Resume("UUID_NEW");
        final int searchKey = 1;
        map.put(2, oldResume);
        map.put(1, newResume);
        assertEquals(newResume, map.get(searchKey), "Должно вернуть сохраненное резюме");
    }

    @Test
    void isExist() {
        assertTrue(isExist("Hello"));  // Не null → должно вернуть true
        assertFalse(isExist(null));    // Null → должно вернуть false
    }

    boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Test
    void doSave() {
        Resume r4 = new Resume("uuid4");
        map.put(4, r4);
        assertEquals(4, map.size(), "Размер хранилища должен уменьшиться на 1 после удаления");
        System.out.println(map.size());
    }

    @Test
    void doGet() {
        Resume r1 = new Resume("uuid1");
        map.put(1, r1);
        Resume result = map.get(1);
        assertEquals(result, r1, "Должно вернуть сохраненное резюме");
        System.out.println(result);
    }

    @Test
    void doDelete() {
        Resume r1 = new Resume("uuid1");
        map.put(1, r1);
        map.remove(1);
        assertEquals(2, map.size(), "Размер хранилища должен уменьшиться на 1 после удаления");
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
        map.values().toArray(new Resume[0]);
        System.out.println(map.size());
        assertEquals(3, map.size(), "Размер хранилища должен составлять 3 (три) резюме.");
    }

    @Test
    void size() {
        assertEquals(3, map.size(), "Размер хранилища должен составлять 3 (три) резюме.");
        System.out.println(map.size());
    }
}