package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractArrayStorageTest {
    private final Storage storage;

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    public void setUp() {
        storage.clear();

        Resume resume1 = new Resume("uuid1", "Name1");
        Resume resume2 = new Resume("uuid2", "Name2");
        Resume resume3 = new Resume("uuid3", "Name3");

        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);

    }

    @Test
    public void size() {
        assertEquals(3, storage.size(), "Размер хранилища должен составлять 3 (три) резюме.");
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size(), "Размер хранилища должен составлять 0 (ноль) после очистки.");
    }

    @Test
    public void update() {
        assertEquals(3, storage.size(), "Размер хранилища должен составлять 3 (три) резюме.");
    }

    @Test
    public void getAll() {
        assertEquals(3, storage.getAll().length, "Размер хранилища должен составлять 3 (три) резюме.");

    }

    @Test
    public void save() {

        Resume newResume = new Resume("uuid1", "Name1");
        storage.save(newResume);
        assertEquals(4, storage.size(), "Размер хранилища должен составлять 4 (четыре) после добавления нового резюме.");
    }

    @Test
    public void delete() {

        Resume resume4 = new Resume("uuid1", "Name1");
        storage.save(resume4);
        String uuidToDelete = resume4.getUuid();
        storage.delete(uuidToDelete);

        assertEquals(3, storage.size(), "Размер хранилища должен уменьшиться на 1 после удаления");

    }

    @Test
    public void get() {
        assertEquals(3, storage.size(), "Размер хранилища должен составлять 3 (три) резюме.");

    }

    @Test
    public void getNotExist() {
        assertThrows(NotExistStorageException.class, this::testGetStorage);
    }

    void testGetStorage() {
        storage.get("dummy");
    }

    @Test
    public void storageOverflow() {
        for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
            storage.save(new Resume("uuid1", "Name1"));
        }
        try {
            storage.save(new Resume("uuid1", "Name1"));
            fail("Ожидалось исключение StorageException, но оно не было брошено.");
        } catch (StorageException e) {
            assertEquals("Хранилище заполнено", e.getMessage());
        }
    }
}


