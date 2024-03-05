package com.vlazar83.dailyRJava.controller;

import com.vlazar83.dailyRJava.ReadingNotFoundException;
import com.vlazar83.dailyRJava.entities.Reading;
import com.vlazar83.dailyRJava.jpa.ReadingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readings")
public class ReadingController {
    private static final Logger logger = LoggerFactory.getLogger(ReadingController.class);

    @Autowired
    private ReadingRepository readingRepository;

    ReadingController(ReadingRepository repository) {
        this.readingRepository = repository;
    }

    @GetMapping
    public List<Reading> getAllReadings() {
        logger.info(String.valueOf(readingRepository.findAll().get(0).getReadingYear()));
        return readingRepository.findAll();
    }

    @GetMapping("/{id}")
    Reading getReadingById(@PathVariable Long id) {

        return readingRepository.findById(id)
                .orElseThrow(() -> new ReadingNotFoundException(id));
    }

    @PostMapping
    public Reading createReading(@RequestBody Reading reading) {
        return readingRepository.save(reading);
    }

    // other CRUD endpoints
}