/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.evento;
import java.time.LocalDateTime;
/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {

        ArbolBinarioEventos arbol = new ArbolBinarioEventos();

        // 1. INSERTAR
        arbol.insertar(new Evento(50, "Conferencia de Java", LocalDateTime.of(2026, 10, 5, 9, 0), "Auditorio principal"));
        arbol.insertar(new Evento(30, "Taller de Git", LocalDateTime.of(2026, 10, 7, 14, 0), "Traer portátil"));
        arbol.insertar(new Evento(70, "Hackathon", LocalDateTime.of(2026, 10, 20, 8, 0), "Equipos de 4"));
        arbol.insertar(new Evento(20, "Charla de IA", LocalDateTime.of(2026, 10, 3, 16, 30), "Entrada libre"));
        arbol.insertar(new Evento(40, "Feria de empleo", LocalDateTime.of(2026, 10, 12, 10, 0), "Llevar hoja de vida"));
        arbol.insertar(new Evento(60, "Torneo de ajedrez", LocalDateTime.of(2026, 10, 15, 15, 0), "Inscripción previa"));
        arbol.insertar(new Evento(80, "Cierre del semestre", LocalDateTime.of(2026, 11, 30, 18, 0), "Evento de gala"));

        // 2. RECORRIDOS
        System.out.println("=== Inorden (ordenado por id) ===");
        arbol.inorden();

        System.out.println("\n=== Preorden ===");
        arbol.preorden();

        System.out.println("\n=== Postorden ===");
        arbol.postorden();

        // 3. BUSCAR
        System.out.println("\n=== Buscar ===");
        System.out.println("Buscar id 40: " + arbol.buscar(40));
        System.out.println("Buscar id 99: " + arbol.buscar(99));

        // 4. DATOS DEL ÁRBOL
        System.out.println("\n=== Datos del árbol ===");
        System.out.println("Total de eventos: " + arbol.contar());
        System.out.println("Altura: " + arbol.altura());
        System.out.println("Menor id: " + arbol.minimo().getId());
        System.out.println("Mayor id: " + arbol.maximo().getId());

        // 5. ID REPETIDO
        boolean insertado = arbol.insertar(new Evento(50, "Repetido", LocalDateTime.now(), "No debe entrar"));
        System.out.println("\nInsertar id 50 repetido: " + insertado);

        // 6. ELIMINAR
        System.out.println("\n=== Eliminar id 30 ===");
        arbol.eliminar(30);
        arbol.inorden();
        System.out.println("Total de eventos: " + arbol.contar());
    }
    
    
}
