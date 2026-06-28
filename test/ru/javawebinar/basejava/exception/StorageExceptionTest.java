package ru.javawebinar.basejava.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for StorageException class.
 * Tests cover constructor, getters, and exception behavior.
 */
@DisplayName("StorageException Unit Tests")
class StorageExceptionTest {

    private static final String TEST_MESSAGE = "Test error message";
    private static final String TEST_UUID = "550e8400-e29b-41d4-a716-446655440000";
    
    private StorageException exception;

    @BeforeEach
    void setUp() {
        // Arrange: Create a StorageException instance with test data
        exception = new StorageException(TEST_MESSAGE, TEST_UUID);
    }

    @Test
    @DisplayName("Constructor should set message and UUID")
    void testConstructor() {
        // Act & Assert
        assertEquals(TEST_MESSAGE, exception.getMessage());
        assertEquals(TEST_UUID, exception.getUuid());
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
    @DisplayName("Exception should extend RuntimeException")
    void testIsRuntimeException() {
        // Act & Assert
        assertInstanceOf(RuntimeException.class, exception);
    }

    @Test
    @DisplayName("getMessage should return the message passed to constructor")
    void testGetMessage() {
        // Act
        String message = exception.getMessage();

        // Assert
        assertEquals(TEST_MESSAGE, message);
    }

    @Test
    @DisplayName("Constructor with null message should be allowed")
    void testConstructorWithNullMessage() {
        // Act
        StorageException nullMessageException = new StorageException(null, TEST_UUID);

        // Assert
        assertNull(nullMessageException.getMessage());
        assertEquals(TEST_UUID, nullMessageException.getUuid());
    }

    @Test
    @DisplayName("Constructor with null UUID should be allowed")
    void testConstructorWithNullUuid() {
        // Act
        StorageException nullUuidException = new StorageException(TEST_MESSAGE, null);

        // Assert
        assertEquals(TEST_MESSAGE, nullUuidException.getMessage());
        assertNull(nullUuidException.getUuid());
    }

    @Test
    @DisplayName("Different exceptions with same message and UUID should be equal in terms of content")
    void testMultipleInstances() {
        // Act
        StorageException exception2 = new StorageException(TEST_MESSAGE, TEST_UUID);

        // Assert
        assertEquals(exception.getMessage(), exception2.getMessage());
        assertEquals(exception.getUuid(), exception2.getUuid());
    }

    @Test
    @DisplayName("Exception can be caught as RuntimeException")
    void testCatchAsRuntimeException() {
        // Act & Assert
        assertDoesNotThrow(() -> {
            try {
                throw new StorageException(TEST_MESSAGE, TEST_UUID);
            } catch (RuntimeException e) {
                assertEquals(TEST_MESSAGE, e.getMessage());
            }
        });
    }

    @Test
    @DisplayName("Exception can be caught as Exception")
    void testCatchAsException() {
        // Act & Assert
        assertDoesNotThrow(() -> {
            try {
                throw new StorageException(TEST_MESSAGE, TEST_UUID);
            } catch (Exception e) {
                assertEquals(TEST_MESSAGE, e.getMessage());
            }
        });
    }

    @Test
    @DisplayName("Exception should be throwable")
    void testThrowableException() {
        // Act & Assert
        assertThrows(StorageException.class, () -> {
            throw new StorageException(TEST_MESSAGE, TEST_UUID);
        });
    }
}
