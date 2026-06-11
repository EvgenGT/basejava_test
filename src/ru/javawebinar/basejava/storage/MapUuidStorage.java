package ru.javawebinar.basejava.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import ru.javawebinar.basejava.model.Resume;

public class MapUuidStorage extends AbstractStorage {

  private final Map<String, Resume> map = new HashMap<>();

  @Override
  protected Object getSearchKey(String uuid) {
    return uuid;
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
  public List<Resume> getAllSorted() {
    List<Resume> list = new ArrayList<>(map.values());
    list.sort(Resume.FULLNAME_UUID_COMPARATOR);
    return list;
  }

  @Override
  public int size() {
    return map.size();
  }
}
