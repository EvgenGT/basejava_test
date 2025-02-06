package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.Collection;
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

    }

    public Resume get(String uuid) {
        return null;
    }

    public void delete(String uuid) {

    }

    public Resume[] getAll() {
        return collection.toArray(new Resume[size()]);
    }

    public int size() {
        return collection.size();
    }


    @Override
    protected void fillDeletedElement(int index) {
        for (int i = 0; i < collection.size(); i++) {
            if (i >= index) {
                collection.remove(i);
                return;
            }
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
