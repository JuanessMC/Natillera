package com.natillera.demo.adapters.driving.http.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class AddMultaRequest {
    Integer idMulta;
    String nombre;
    Float valorMulta;
    String descripcion;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate fecha;
    boolean estado;
    long cedula;
}
