package task.punch.in.time.card;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PunchCardManagerTest {
    private static final String TEST_FILE_NAME = "test_clock_in_out.txt";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
    private PunchCardManager punchCardManager;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        punchCardManager = new PunchCardManager();
        punchCardManager.setFileName();

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testClockIn() throws Exception {
        punchCardManager.clockIn();

        String expectedDateTime = LocalDateTime.now().format(DATE_FORMAT);
        String expectedOutput = "You have clocked in at " + expectedDateTime;

        // check if the file contains the expected clock-in entry
        String fileContent = Files.readString(Path.of(TEST_FILE_NAME));
        String expectedEntry = "Clock In: " + expectedDateTime;
        assertTrue(fileContent.contains(expectedEntry));

        // check if the output matches the expected output
        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Test
    public void testClockOut() throws Exception {
        punchCardManager.clockIn();
        Thread.sleep(1000); // waiting for 1 sec to register
        punchCardManager.clockOut();

        String expectedDateTime = LocalDateTime.now().format(DATE_FORMAT);
        String expectedOutput = "You have clocked out at " + expectedDateTime;

        // check if the file contains the expected clock-out entry
        String fileContent = Files.readString(Path.of(TEST_FILE_NAME));
        String expectedEntry = "Clock Out: " + expectedDateTime;
        assertTrue(fileContent.contains(expectedEntry));

        // check if the output matches the expected output
        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    private void assertTrue(boolean condition) {
        Assertions.assertTrue(condition);
    }
}

