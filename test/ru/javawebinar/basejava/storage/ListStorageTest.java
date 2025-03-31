package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListStorageTest {

    private final List<Resume> storage = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        storage.clear();

        storage.add(new Resume("uuid1"));
        storage.add(new Resume("uuid2"));
        storage.add(new Resume("uuid3"));
    }

    @Test
    void getSearchKey() {
        String expected = "12345";
        ListStorage storage = new ListStorage();
        Object actual = storage.getSearchKey(expected);
        assertNull(actual, "Должно вернуть null, если элемент не найден");
    }

    @Test
    void doUpdate() {
        Resume newResume = new Resume("UUID_NEW");
        final int searchKey = 1;
        storage.set(searchKey, newResume);
        Object actual = storage.set(1, newResume);
        assertEquals(actual, storage.get(searchKey), "Должно вернуть сохраненное резюме");
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
        Resume newResume = new Resume("uuid4", "Name4");
        storage.add(newResume);
        assertEquals(4, storage.size(), "Размер хранилища должен уменьшиться на 1 после удаления");
        System.out.println(storage.size());
    }

    @Test
    void doGet() {
        Resume newResume = new Resume("UUID_NEW");
        final int searchKey = 1;
        storage.set(searchKey, newResume);
        Resume result = storage.get(searchKey);
        assertEquals(result, newResume, "Должно вернуть сохраненное резюме");
        System.out.println(result);
    }

    @Test
    void doDelete() {
        Resume newResume = new Resume("uuid4", "Name4");
        storage.remove(newResume);
        assertEquals(3, storage.size(), "Размер хранилища должен уменьшиться на 1 после удаления");
        System.out.println(storage.size());
    }

    @Test
    void clear() {
        System.out.println(storage.size());
        storage.clear();
        assertEquals(0, storage.size(), "Размер хранилища должен составлять 0 (ноль) после очистки.");
        System.out.println(storage.size());
    }

    @Test
    void getAll() {
        storage.toArray(new Resume[0]);
        assertEquals(3, storage.size(), "Размер хранилища должен составлять 3 (три) резюме.");
        System.out.println(storage.size());
    }

    @Test
    void size() {
        storage.size();
        assertEquals(3, storage.size(), "Размер хранилища должен составлять 3 (три) резюме.");
        System.out.println(storage.size());
    }
}