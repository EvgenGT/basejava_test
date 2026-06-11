package ru.javawebinar.basejava.model;

import java.util.Objects;
import java.util.UUID;
import java.util.Comparator;

/** ru.javawebinar.basejava.model.Resume class */
public class Resume implements Comparable<Resume> {
  // Unique identifier
  private final String uuid;

  private String fullName;

  public Resume(String fullName) {
    this(UUID.randomUUID().toString(), fullName);
  }

  public Resume(String uuid, String fullName) {
    Objects.requireNonNull(uuid, "uuid must not be null");
    Objects.requireNonNull(fullName, "fullName must not be null");
    this.uuid = uuid;
    this.fullName = fullName;
  }

  public String getUuid() {
    return uuid;
  }

  public String getFullName() {
    return fullName;
  }

  @Override
  public String toString() {
    return uuid;
  }

  @Override
  public int compareTo(Resume o) {
    return uuid.compareTo(o.uuid);
  }

  public static final Comparator<Resume> FULLNAME_UUID_COMPARATOR =
      Comparator.comparing((Resume r) -> r.getFullName()).thenComparing(Resume::getUuid);
}
