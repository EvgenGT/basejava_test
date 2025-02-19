package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract void doUpdate(Resume r, Object searchKey);

    protected abstract void doSave(Resume r, Object searchKey);

    protected abstract void doDelete(Object searchKey);

    protected abstract boolean ifExist(Object searchKey);

    public void update(Resume r) {
        Object searchKey = getExistedSearchKey(r.getUuid());
        doUpdate(r, searchKey);
    }
}

private Object getSearchKey(String uuid) {
    return null;
}

public void save(Resume r) {
    Object searchKey = getNotExistedSearchKey(r.getUuid());
    doSave(r, searchKey);
}


public void delete(String uuid) {
    Object searchKey = getExistedSearchKey(uuid);
    doDelete(searchKey);
}


private Object getExistedSearchKey(String uuid) {
    Object searchKey = getSearchKey(uuid);
    {
        if (!ifExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }
}

private Object getNotExistedKey(String uuid) {
    Object searchKey = getSearchKey(uuid);
    {
        if (ifExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
}



