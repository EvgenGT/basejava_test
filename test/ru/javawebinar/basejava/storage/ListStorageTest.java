package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListStorageTest {

    public List<Resume> storage = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        storage.clear();

        storage.add(new Resume("uuid1"));
        storage.add(new Resume("uuid2"));
        storage.add(new Resume("uuid3"));
    }

    @Test
    public void getSearchKey() {

    }

    @Test
    public void doUpdate() {
    }

    @Test
    public void isExist() {
    }

    @Test
    public void doSave() {

        Resume newResume = new Resume("uuid4", "Name4");
        storage.add(newResume);
        assertEquals(4, storage.size(), "Размер хранилища должен составлять 4 (четыре) после добавления нового резюме.");
    }

    @Test
    public void doGet() {
    }

    @Test
    public void doDelete() {
        Resume newResume = new Resume("uuid4", "Name4");
        storage.remove(newResume);
        assertEquals(3, storage.size(), "Размер хранилища должен уменьшиться на 1 после удаления");
    }

    @Test
    public void clear() {
        System.out.println(storage.size());
        storage.clear();
        assertEquals(0, storage.size(), "Размер хранилища должен составлять 0 (ноль) после очистки.");
        System.out.println(storage.size());
    }

    @Test
    public void getAll() {
    }

    @Test
    public void size() {
        assertEquals(3, storage.size(), "Размер хранилища должен составлять 3 (три) резюме.");
        System.out.println(storage.size());
    }
}