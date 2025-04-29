package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorageName extends AbstractStorage {

    private final Map<String, Resume> map = new HashMap<>();

    @Override
    protected Object getSearchKey(String fullName) {
        return fullName;
    }

    @Override
    protected void doUpdate(Resume r, Object fullName) {
        map.put((String) fullName, r);
    }

    @Override
    protected boolean isExist(Object fullName) {
        return map.containsKey(String.valueOf(fullName));
    }

    @Override
    protected void doSave(Resume r, Object fullName) {
        map.put(String.valueOf(fullName), r);
    }

    @Override
    protected Resume doGet(Object fullName) {
        return map.get(String.valueOf(fullName));
    }

    @Override
    protected void doDelete(Object fullName) {
        map.remove(String.valueOf(fullName));
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
