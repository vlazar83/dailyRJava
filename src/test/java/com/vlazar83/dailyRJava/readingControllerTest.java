package com.vlazar83.dailyRJava;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import com.vlazar83.dailyRJava.controller.ReadingController;
import com.vlazar83.dailyRJava.entities.Reading;
import com.vlazar83.dailyRJava.jpa.ReadingRepository;
import com.vlazar83.dailyRJava.service.ReadingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class readingControllerTest {

    @Mock
    private ReadingService readingService;

    @Mock
    private ReadingRepository readingRepository;

    @InjectMocks
    private ReadingController readingController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllReading() throws Exception {
        // Mock data
        Reading reading1 = new Reading();
        reading1.setReadingYear("2024");
        reading1.setReadingMonth("April");
        // Set other properties as needed

        Reading reading2 = new Reading();
        reading2.setReadingYear("2024");
        reading2.setReadingMonth("May");
        List<Reading> readings = Arrays.asList(reading1, reading2);

        // Mock service method
        when(readingService.getAllReadings()).thenReturn(readings);
        when(readingRepository.findAll()).thenReturn(readings);

        // Call the controller method
        List<Reading> responseEntity = readingController.getAllReadings();

        // Verify the response
        assertTrue(responseEntity.size()==2);

    }

}
