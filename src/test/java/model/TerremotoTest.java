package model;

import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class TerremotoTest {
    Terremoto terremoto;
    @BeforeEach void setUp() {
        terremoto = new Terremoto(1,5.5,"Tijuana", LocalDateTime.now());
    }

    @org.junit.jupiter.api.Test
    void getId() {
        assertEquals(1, terremoto.getId());
    }

    @org.junit.jupiter.api.Test
    void getMagnitud() {
        assertEquals(5.5, terremoto.getMagnitud());
    }

    @org.junit.jupiter.api.Test
    void getCiudad() {
        assertEquals("Tijuana", terremoto.getCiudad());
    }

    @org.junit.jupiter.api.Test
    void getFecha() {
        assertEquals(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES),terremoto.getFecha().truncatedTo(ChronoUnit.MINUTES));
    }
}