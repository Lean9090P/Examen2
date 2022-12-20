package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Terremoto {
    private Integer id;
    private Double magnitud;
    private String ciudad;
    private LocalDateTime fechaHora;

    public Integer getId() {
        return id;
    }

    public Double getMagnitud() {
        return magnitud;
    }

    public String getCiudad() {
        return ciudad;
    }


    public LocalDateTime getFecha() {
        return fechaHora;
    }

    public Terremoto(Integer id, Double magnitud, String ciudad, LocalDateTime fecha) {
        this.id = id;
        this.magnitud = magnitud;
        this.ciudad = ciudad;
        this.fechaHora = fecha;
    }
    public Terremoto(Integer id, Double magnitud, String ciudad, LocalDate fecha, LocalTime hora) {
        this.id = id;
        this.magnitud = magnitud;
        this.ciudad = ciudad;
        this.fechaHora = LocalDateTime.of(fecha,hora);
    }

    @Override
    public String toString() {
        return  id + ","+ magnitud+","+ ciudad+","+ fechaHora.toLocalDate()+","+ fechaHora.toLocalTime();
    }

}



