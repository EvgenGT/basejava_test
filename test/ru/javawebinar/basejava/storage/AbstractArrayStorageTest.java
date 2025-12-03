package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }
    @Test
    void saveOverflow() throws Exception {
        for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
            storage.save(new Resume("uuid4", "Name4"));
        }
        try {
            storage.save(new Resume("uuid5", "Name5"));
            fail("Ожидалось исключение StorageException, но оно не было брошено.");
        } catch (StorageException e) {
            assertEquals("Storage overflow", e.getMessage());
        }
    }
}

