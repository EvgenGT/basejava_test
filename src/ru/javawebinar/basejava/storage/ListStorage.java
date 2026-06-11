package ru.javawebinar.basejava.storage;

import java.util.ArrayList;
import java.util.List;
import ru.javawebinar.basejava.model.Resume;

public class ListStorage extends AbstractStorage {

  private final List<Resume> storage = new ArrayList<>();

  @Override
  protected Object getSearchKey(String uuid) {
    for (int i = 0; i < storage.size(); i++) {
      if (storage.get(i).getUuid().equals(uuid)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  protected void doUpdate(Resume r, Object searchKey) {
    storage.set((Integer) searchKey, r);
  }

  @Override
  protected boolean isExist(Object searchKey) {
    return searchKey != null;
  }

  @Override
  protected void doSave(Resume r, Object searchKey) {
    storage.add(r);
  }

  @Override
  protected Resume doGet(Object searchKey) {
    return storage.get((Integer) searchKey);
  }

  @Override
  protected void doDelete(Object searchKey) {
    storage.remove(((Integer) searchKey).intValue());
  }

  @Override
  public void clear() {
    storage.clear();
  }

  @Override
  public List<Resume> getAllSorted() {
    List<Resume> list = new ArrayList<>(storage);
    list.sort(Resume.FULLNAME_UUID_COMPARATOR);
    return list;
  }

  @Override
  public int size() {
    return storage.size();
  }
}
