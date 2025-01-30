package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.Collection;

public class ListStorage implements Storage {

    protected final Collection<Resume> collection = new ArrayList<>();
    protected int size = 0;

    public void clear() {
        collection.clear();
    }

    public void update(Resume r) {
        collection.remove(r);
        collection.add(r);
    }

    public void save(Resume r) {
        collection.add(r);
    }

    public Resume get(String uuid) {
        for (Resume r : collection) {
            if (r.getUuid().equals(uuid)) {
                return r;
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (Resume r : collection) {
            if (r.getUuid().equals(uuid)) {
                collection.remove(r);
                return;
            }
        }
    }

    public Resume[] getAll() {
        return collection.toArray(new Resume[0]);
    }

    public int size() {
        return collection.size();
    }
}
