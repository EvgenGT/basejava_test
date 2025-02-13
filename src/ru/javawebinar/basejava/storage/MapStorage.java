package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {

    protected final LinkedHashMap<String, Resume> map = new LinkedHashMap<>();

    public void clear() {
        map.clear();
    }

    public void update(Resume r) {
        if (!map.containsKey(r.getUuid())) {
            throw new NotExistStorageException("Резюме с ключом '" + r.getUuid() + "' не найдено.");
        }
        map.put(r.getUuid(), r);
    }

    public void save(Resume r) {
        if (map.containsKey(r.getUuid())) {
            throw new ExistStorageException(r.getUuid());
        }
        map.put(r.getUuid(), r);
    }

    public Resume get(String uuid) {
        if (map.containsKey(uuid)) {
            return map.get(uuid);
        } else {
            System.out.println("Элемент с uuid " + uuid + " не найден в хранилище.");
            return null;
        }
    }

    public void delete(String uuid) {
        if (!map.containsKey(uuid)) {
            throw new NotExistStorageException("Элемент с ключом '" + uuid + "' не найден.");
        }
        map.remove(uuid);
    }

    public Resume[] getAll() {
        return map.values().toArray(new Resume[0]);
    }

    public int size() {
        return map.size();
    }
}
