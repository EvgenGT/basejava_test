package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.Collection;

public abstract class ListStorage implements Storage {

    protected final Collection<Resume> storage = new ArrayList<>();

    public void clear() {
        storage.clear();
    }

    public void update(Resume r) {
        storage.remove(r);
        storage.add(r);
    }

    public void save(Resume r) {
        storage.add(r);
    }

    public Resume get(String uuid) {
        for (Resume r : storage) {
            if (r.getUuid().equals(uuid)) {
                return r;
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (Resume r : storage) {
            if (r.getUuid().equals(uuid)) {
                storage.remove(r);
                break;
            }
        }
    }

    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    public int size() {
        return storage.size();
    }

}
