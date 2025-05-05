package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorageName extends AbstractStorage {

    private final Map<String, Resume> map = new HashMap<>();

    @Override
    protected Object getSearchKey(String email) {
        return email;
    }

    @Override
    protected void doUpdate(Resume r, Object email) {
        map.put((String) email, r);
    }

    @Override
    protected boolean isExist(Object email) {
        return map.containsKey(String.valueOf(email));
    }

    @Override
    protected void doSave(Resume r, Object email) {
        map.put(String.valueOf(email), r);
    }

    @Override
    protected Resume doGet(Object email) {
        return map.get(String.valueOf(email));
    }

    @Override
    protected void doDelete(Object email) {
        map.remove(String.valueOf(email));
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
