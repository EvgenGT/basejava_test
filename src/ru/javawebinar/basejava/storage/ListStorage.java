package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public class ListStorage extends AbstractStorage{
    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }

}
