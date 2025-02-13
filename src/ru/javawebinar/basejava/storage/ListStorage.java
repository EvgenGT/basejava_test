package ru.javawebinar.basejava.storage;

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
        int index = collection.indexOf(r);
        if (index != -1) {
            collection.set(index, r);
            System.out.println("Резюме успешно обновлено.");
        } else {
            System.out.println("Резюме не найдено.");
        }
    }

    public void save(Resume r) {
        if (collection.contains(r)) {
            System.out.println("Резюме уже существует. Сохранение не выполнено.");
            return;
        }
        collection.add(r);
        System.out.println("Резюме успешно сохранено.");
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
        Resume resumeToRemove = new Resume(uuid, "");
        if (collection.contains(resumeToRemove)) {
            collection.remove(resumeToRemove);
            System.out.println("Элемент с UUID " + uuid + " удален.");
        } else {
            System.out.println("Элемент с UUID " + uuid + " не найден.");
        }
    }

    public Resume[] getAll() {
        return collection.toArray(new Resume[size()]);
    }

    public int size() {
        return collection.size();
    }
}

