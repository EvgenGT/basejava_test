package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

class MapStorageTest {

    private final Map<Integer, Resume> map = new HashMap<>();

    @BeforeEach
    void setUp() {
        map.clear();

    }

    @Test
    void getSearchKey() {
    }

    @Test
    void doUpdate() {
        System.out.println(map.size());
    }

    @Test
    void isExist() {
    }

    @Test
    void doSave() {
    }

    @Test
    void doGet() {
    }

    @Test
    void doDelete() {
    }

    @Test
    void clear() {
    }

    @Test
    void getAll() {
    }

    @Test
    void size() {
    }
}