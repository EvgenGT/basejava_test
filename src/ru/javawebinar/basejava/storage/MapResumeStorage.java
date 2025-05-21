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
    protected void doUpdate(Resume r, Object Resume) {
        map.put((String) Resume, r);
    }

    @Override
    protected boolean isExist(Object Resume) {
        return map.containsKey(String.valueOf(Resume));
    }

    @Override
    protected void doSave(Resume r, Object Resume) {
        map.put(String.valueOf(Resume), r);
    }

    @Override
    protected Resume doGet(Object Resume) {
        return map.get(String.valueOf(Resume));
    }

    @Override
    protected void doDelete(Object Resume) {
        map.remove(String.valueOf(Resume));
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
