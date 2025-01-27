package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.model.Resume;

import java.util.Collection;

public class ListStorageTest {
    private final Storage storage;

    protected ListStorageTest(Collection<Resume> storage) {
        this.storage = new ListStorage(storage);
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
    public void clear() {
    }

    @Test
    public void update() {
    }

    @Test
    public void save() {
    }

    @Test
    public void get() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void size() {
    }
}