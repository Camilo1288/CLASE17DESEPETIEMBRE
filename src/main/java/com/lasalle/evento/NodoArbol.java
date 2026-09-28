/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.evento;

/**
 *
 * @author Usuario
 */
public class NodoArbol {
    Evento dato;          
    NodoArbol izquierdo;  
    NodoArbol derecho;    
    
    public NodoArbol(Evento dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}
