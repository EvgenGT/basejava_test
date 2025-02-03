package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void clear() {
    }

    public Resume[] getAll() {
        return new Resume[0];
    }

    public int size() {
        return 0;
    }
}
