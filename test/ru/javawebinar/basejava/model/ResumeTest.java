package ru.javawebinar.basejava.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Resume class.
 * Tests cover constructors, getters, toString, compareTo, and custom comparators.
 */
@DisplayName("Resume Unit Tests")
class ResumeTest {

    private Resume resume1;
    private Resume resume2;
    private String testUuid;

    @BeforeEach
    void setUp() {
        // Arrange: Create test data with known UUIDs for deterministic testing
        testUuid = "550e8400-e29b-41d4-a716-446655440000";
        resume1 = new Resume(testUuid, "John Doe");
        resume2 = new Resume("550e8400-e29b-41d4-a716-446655440001", "Jane Smith");
    }

    @Test
    @DisplayName("Constructor with fullName should generate UUID")
    void testConstructorWithFullName() {
        // Act
        Resume resume = new Resume("Alice Johnson");

        // Assert
        assertNotNull(resume.getUuid(), "UUID should be generated");
        assertNotNull(resume.getFullName(), "Full name should be set");
        assertEquals("Alice Johnson", resume.getFullName());
        // UUID should match UUID format (36 characters with hyphens)
        assertEquals(36, resume.getUuid().length());
    }

    @Test
    @DisplayName("Constructor with UUID and fullName should set both fields")
    void testConstructorWithUuidAndFullName() {
        // Act & Assert
        assertEquals(testUuid, resume1.getUuid());
        assertEquals("John Doe", resume1.getFullName());
    }

    @Test
    @DisplayName("Constructor with null UUID should throw NullPointerException")
    void testConstructorWithNullUuid() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            new Resume(null, "John Doe");
        });
    }

    @Test
    @DisplayName("Constructor with null fullName should throw NullPointerException")
    void testConstructorWithNullFullName() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            new Resume(testUuid, null);
        });
    }

    @Test
    @DisplayName("toString should return UUID")
    void testToString() {
        // Act
        String result = resume1.toString();

        // Assert
        assertEquals(testUuid, result);
    }

    @Test
    @DisplayName("compareTo should compare by UUID")
    void testCompareTo() {
        // Arrange
        Resume resume3 = new Resume("550e8400-e29b-41d4-a716-446655440002", "Bob Wilson");

        // Act & Assert
        assertTrue(resume1.compareTo(resume2) < 0, "resume1 should come before resume2");
        assertTrue(resume2.compareTo(resume3) < 0, "resume2 should come before resume3");
        assertTrue(resume3.compareTo(resume1) > 0, "resume3 should come after resume1");
        assertEquals(0, resume1.compareTo(new Resume(testUuid, "Different Name")), 
                    "Same UUID should return 0");
    }

    @Test
    @DisplayName("FULLNAME_UUID_COMPARATOR should compare by fullName first, then UUID")
    void testFullnameUuidComparator() {
        // Arrange
        Resume resumeA = new Resume("aaa", "Alice");
        Resume resumeB = new Resume("bbb", "Alice");
        Resume resumeC = new Resume("ccc", "Bob");
        List<Resume> resumes = Arrays.asList(resumeC, resumeA, resumeB);

        // Act
        resumes.sort(Resume.FULLNAME_UUID_COMPARATOR);

        // Assert
        assertEquals("Alice", resumes.get(0).getFullName());
        assertEquals("aaa", resumes.get(0).getUuid());
        assertEquals("Alice", resumes.get(1).getFullName());
        assertEquals("bbb", resumes.get(1).getUuid());
        assertEquals("Bob", resumes.get(2).getFullName());
    }

    @Test
    @DisplayName("FULLNAME_UUID_COMPARATOR should be a Comparator instance")
    void testFullnameUuidComparatorExists() {
        // Assert
        assertNotNull(Resume.FULLNAME_UUID_COMPARATOR);
        assertTrue(Resume.FULLNAME_UUID_COMPARATOR instanceof Comparator);
    }

    @Test
    @DisplayName("Different Resume instances with same UUID should be comparable")
    void testComparableInterface() {
        // Arrange
        Resume sameUuidDifferentName = new Resume(testUuid, "Different Name");

        // Act & Assert
        assertInstanceOf(Comparable.class, resume1);
        assertEquals(0, resume1.compareTo(sameUuidDifferentName));
    }

    @Test
    @DisplayName("getUuid should return the UUID set in constructor")
    void testGetUuid() {
        // Act & Assert
        assertEquals(testUuid, resume1.getUuid());
    }

    @Test
    @DisplayName("getFullName should return the full name set in constructor")
    void testGetFullName() {
        // Act & Assert
        assertEquals("John Doe", resume1.getFullName());
    }
}
