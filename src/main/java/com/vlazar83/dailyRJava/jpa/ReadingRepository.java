package com.vlazar83.dailyRJava.jpa;

import com.vlazar83.dailyRJava.entities.Reading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingRepository extends JpaRepository<Reading, Long> {
}
