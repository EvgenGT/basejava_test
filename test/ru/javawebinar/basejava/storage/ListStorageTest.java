package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        String uuid = "12345";
        ListStorage storage = new ListStorage();
        Object result = storage.getSearchKey(uuid);
        System.out.println(result);  // Можно убрать, если не нужно
        assertNull(result, "Должно вернуть null, если элемент не найден");
    }

    @Test
    void doUpdate() {
        System.out.println(storage.size());
    }

    @Test
    void isExist() {
        System.out.println(storage.size());
    }

    @Test
    void doSave() {

        Resume newResume = new Resume("uuid4", "Name4");
        storage.add(newResume);
        assertEquals(4, storage.size(), "Размер хранилища должен составлять 4 (четыре) после добавления нового резюме.");
        System.out.println(storage.size());
    }

    @Test
    void doGet() {
    }

    @Test
    void doDelete() {
        Resume newResume = new Resume("uuid4", "Name4");
        storage.remove(newResume);
        assertEquals(3, storage.size(), "Размер хранилища должен уменьшиться на 1 после удаления");
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
    }

    @Test
    void size() {
        storage.size();
        assertEquals(3, storage.size(), "Размер хранилища должен составлять 3 (три) резюме.");
        System.out.println(storage.size());
    }
}