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
    public abstract void update(Resume r);

    public abstract Resume get(String uuid);

    public abstract void delete(String uuid);

    public abstract void save(Resume r);
}
