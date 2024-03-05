"to generate the DB table:
CREATE TABLE readings (
    id SERIAL PRIMARY KEY,
    reading_year VARCHAR,
    reading_month VARCHAR,
    reading_day VARCHAR,
    firstreading VARCHAR NOT NULL,
    firstreading_short VARCHAR NOT NULL,
    firstreading_link VARCHAR NOT NULL,
    secondreading VARCHAR NOT NULL,
    secondreading_short VARCHAR NOT NULL,
    secondreading_link VARCHAR NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR,
    status VARCHAR DEFAULT 'saved' CHECK (status IN ('saved', 'ongoing', 'checked'))
);