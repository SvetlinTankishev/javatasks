/**
 package my.punch.card;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class PunchCardManagerTest {

    @Test
    void calculateTotalTimeWorkedTest() throws IOException {
        // Create a mock of the FileManager dependency
        FileManager fileManagerMock = Mockito.mock(FileManager.class);

        // Stub the behavior of the mock to return a specific clock-in timestamp
        LocalDateTime mockClockInTimestamp = LocalDateTime.of(2023, 6, 28, 9, 0);
        when(fileManagerMock.readLastClockInTimestamp()).thenReturn(mockClockInTimestamp);

        // Create an instance of the my.punch.card.PunchCardManager with the mock FileManager
        PunchCardManager punchCardManager = new PunchCardManager(fileManagerMock);

        // Call the method under test
        Duration totalTimeWorked = punchCardManager.calculateTotalTimeWorked();

        // Verify the expected behavior
        assertEquals(Duration.ZERO, totalTimeWorked);
    }
}
*/