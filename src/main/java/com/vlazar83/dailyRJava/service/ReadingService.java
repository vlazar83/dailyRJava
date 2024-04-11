package com.vlazar83.dailyRJava.service;
import com.vlazar83.dailyRJava.entities.Reading;
import com.vlazar83.dailyRJava.jpa.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadingService {

    private final ReadingRepository readingRepository;

    @Autowired
    public ReadingService(ReadingRepository readingRepository) {
        this.readingRepository = readingRepository;
    }

    public List<Reading> getAllReadings() {
        return readingRepository.findAll();
    }

    // Other methods such as saveReading(), updateReading(), deleteReading(), etc. can be added here
}
