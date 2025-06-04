package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {

    private final Map<String, Resume> map = new HashMap<>();

    @Override
    protected Resume getSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        map.put((String) searchKey, r);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return map.containsKey(String.valueOf(searchKey));
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        map.put(String.valueOf(searchKey), r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return map.get(String.valueOf(searchKey));
    }

    @Override
    protected void doDelete(Object searchKey) {
        map.remove(String.valueOf(searchKey));
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        return map.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return map.size();
    }
}
