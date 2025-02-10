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
        return null;
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

    @Override
    protected void fillDeletedElement(int index) {
        int count = 0;
        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            if (count == index) {
                String keyToRemove = entry.getKey();
                map.remove(keyToRemove);
                break;
            }
            count++;
        }
    }

    @Override
    protected void insertElement(Resume r, int index) {
        if (index < 0 || index > map.size()) {
            throw new IndexOutOfBoundsException("Некорректный индекс: " + index);
        }
        // Шаг 1: Получаем список всех записей (ключ-значение)
        List<Map.Entry<String, Resume>> entries = new ArrayList<>(map.entrySet());

        // Шаг 2: Вставляем новый элемент в нужную позицию в список
        entries.add(index, new AbstractMap.SimpleEntry<>(r.getUuid(), r));

        // Шаг 3: Создаём новый LinkedHashMap и заполняем его отсортированными парами
        map.clear(); // Очищаем старый storage
        for (Map.Entry<String, Resume> entry : entries) {
            map.put(entry.getKey(), entry.getValue()); // Добавляем в новый LinkedHashMap
        }
    }

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }
}
