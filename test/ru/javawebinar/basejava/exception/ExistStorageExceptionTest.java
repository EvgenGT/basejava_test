package ru.javawebinar.basejava.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for ExistStorageException class.
 * Tests cover constructor, inheritance, and exception message formatting.
 */
@DisplayName("ExistStorageException Unit Tests")
class ExistStorageExceptionTest {

    private static final String TEST_UUID = "550e8400-e29b-41d4-a716-446655440000";
    
    private ExistStorageException exception;

    @BeforeEach
    void setUp() {
        // Arrange: Create an ExistStorageException instance
        exception = new ExistStorageException(TEST_UUID);
    }

    @Test
    @DisplayName("Constructor should create exception with formatted message and UUID")
    void testConstructor() {
        // Act & Assert
        assertEquals(TEST_UUID, exception.getUuid());
        assertNotNull(exception.getMessage());
        assertTrue(exception.getMessage().contains(TEST_UUID));
        assertTrue(exception.getMessage().contains("already exist"));
    }

    @Test
    @DisplayName("getUuid should return the UUID passed to constructor")
    void testGetUuid() {
        // Act
        String uuid = exception.getUuid();

        // Assert
        assertEquals(TEST_UUID, uuid);
    }

    @Test
    @DisplayName("Exception should extend StorageException")
    void testIsStorageException() {
        // Act & Assert
        assertInstanceOf(StorageException.class, exception);
    }

    @Test
    @DisplayName("Exception should extend RuntimeException")
    void testIsRuntimeException() {
        // Act & Assert
        assertInstanceOf(RuntimeException.class, exception);
    }

    @Test
    @DisplayName("getMessage should contain UUID")
    void testGetMessage() {
        // Act
        String message = exception.getMessage();

        // Assert
        assertNotNull(message);
        assertTrue(message.contains(TEST_UUID));
    }

    @Test
    @DisplayName("Different UUIDs should create different error messages")
    void testDifferentUuids() {
        // Arrange
        String uuid1 = "uuid-001";
        String uuid2 = "uuid-002";
        
        ExistStorageException exception1 = new ExistStorageException(uuid1);
        ExistStorageException exception2 = new ExistStorageException(uuid2);

        // Act & Assert
        assertNotEquals(exception1.getMessage(), exception2.getMessage());
        assertTrue(exception1.getMessage().contains(uuid1));
        assertTrue(exception2.getMessage().contains(uuid2));
    }

    @Test
    @DisplayName("Exception can be thrown and caught")
    void testThrowAndCatch() {
        // Act & Assert
        assertThrows(ExistStorageException.class, () -> {
            throw new ExistStorageException(TEST_UUID);
        });
    }

    @Test
    @DisplayName("Exception can be caught as StorageException")
    void testCatchAsStorageException() {
        // Act & Assert
        assertDoesNotThrow(() -> {
            try {
                throw new ExistStorageException(TEST_UUID);
            } catch (StorageException e) {
                assertEquals(TEST_UUID, e.getUuid());
            }
        });
    }

    @Test
    @DisplayName("Exception can be caught as RuntimeException")
    void testCatchAsRuntimeException() {
        // Act & Assert
        assertDoesNotThrow(() -> {
            try {
                throw new ExistStorageException(TEST_UUID);
            } catch (RuntimeException e) {
                assertInstanceOf(ExistStorageException.class, e);
            }
        });
    }

    @Test
    @DisplayName("Message format should be consistent")
    void testMessageFormat() {
        // Arrange
        String expectedUUID = "test-uuid-123";
        
        // Act
        ExistStorageException ex = new ExistStorageException(expectedUUID);

        // Assert
        String message = ex.getMessage();
        assertTrue(message.contains("Resume"));
        assertTrue(message.contains(expectedUUID));
        assertTrue(message.contains("already exist"));
    }

    @Test
    @DisplayName("Exception should be throwable as Throwable")
    void testThrowableHierarchy() {
        // Act & Assert
        assertDoesNotThrow(() -> {
            try {
                throw new ExistStorageException(TEST_UUID);
            } catch (Throwable t) {
                assertInstanceOf(ExistStorageException.class, t);
            }
        });
    }
}
