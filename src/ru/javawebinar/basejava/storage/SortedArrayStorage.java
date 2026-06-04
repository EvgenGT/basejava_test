package ru.javawebinar.basejava.storage;

import java.util.Comparator;
import ru.javawebinar.basejava.model.Resume;

public class SortedArrayStorage extends AbstractArrayStorage {

  private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

  @Override
  protected void fillDeletedElement(int index) {
    int numMoved = size - index - 1;
    if (numMoved > 0) {
      System.arraycopy(storage, index + 1, storage, index, numMoved);
    }
  }

  @Override
  protected void insertElement(Resume r, int index) {
    int insertIdx = -index - 1;
    System.arraycopy(storage, insertIdx, storage, insertIdx + 1, size - insertIdx);
    storage[insertIdx] = r;
  }

  @Override
  protected Integer getSearchKey(String uuid) {
    for (int i = 0; i < size; i++) {
      int cmp = storage[i].getUuid().compareTo(uuid);
      if (cmp == 0) {
        return i;
      }
      if (cmp > 0) {
        return -i - 1;
      }
    }
    return -size - 1;
  }
}
