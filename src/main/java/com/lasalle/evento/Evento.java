/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.evento;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Usuario
 */
public class Evento {
    private long id;
    private String nombreEvento;
    private LocalDateTime fecha;
    String observaciones;
    
    public Evento( long id, String nombreEvento, LocalDateTime fecha, String observaciones){
        this.id=id;
        this.nombreEvento=nombreEvento;
        this.fecha=fecha;
        this.observaciones=observaciones;
    }
     public long getId() { 
         return id; 
     }  
     public void setId(long id) { 
        this.id = id; 
     }
     
     public String getNombreEvento() {
         return nombreEvento;
    } 
     public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }
    
     public LocalDateTime getFecha() {
        return fecha;
    }
     public void setFecha(LocalDateTime fecha) {
         this.fecha=fecha;
    }
     
     public String getObservaciones() { 
         return observaciones;
     }
     public void setObservaciones(String observaciones) {
         this.observaciones = observaciones; 
     }
     
     @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Evento{id=" + id + ", nombre='" + nombreEvento + "', fecha=" + fecha.format(f)
                + ", observaciones='" + observaciones + "'}";
    }
}
