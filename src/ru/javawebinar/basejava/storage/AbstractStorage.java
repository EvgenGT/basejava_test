package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void clear() {
    }

    public void update(Resume r) {
    }

    public void save(Resume r) {
    }

    public void delete(String uuid) {
    }

    public Resume[] getAll() {
        return new Resume[0];
    }

    public int size() {
        return 0;
    }

//
//    protected abstract void fillDeletedElement(int index);
//
//    protected abstract void insertElement(Resume r, int index);
//
//    protected abstract int getIndex(String uuid);

}
