package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    protected final List<Resume> collection = new ArrayList<>();

    public void clear() {
        collection.clear();
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException("Резюме с UUID '" + r.getUuid() + "' не найдено.");
        } else {
            collection.set(index, r);
        }
    }

    public void save(Resume r) {
        if (collection.contains(r)) {
            throw new ExistStorageException(r.getUuid());
        }
        collection.add(r);
    }

    public Resume get(String uuid) {
        for (Resume r : collection) {
            if (r.getUuid().equals(uuid)) {
                return r;
            }
        }
        throw new NotExistStorageException(uuid);
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        collection.remove(index);
    }

    public Resume[] getAll() {
        return collection.toArray(new Resume[size()]);
    }

    public int size() {
        return collection.size();
    }

    @Override
    protected void fillDeletedElement(int index) {
        while (index < collection.size()) {
            collection.remove(index);
        }
    }

    @Override
    protected void insertElement(Resume r, int index) {
        collection.add(r);
    }

    @Override
    protected int getIndex(String uuid) {
        int index = 0;
        for (Resume resume : collection) {
            if (uuid.equals(resume.getUuid())) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
