/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.evento;

/**
 *
 * @author Usuario
 */
public class ArbolBinarioEventos {
     private NodoArbol raiz;

    public ArbolBinarioEventos() {
        raiz = null;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    // ---------- INSERTAR ----------
    // Devuelve false si ya existe un evento con ese id
    public boolean insertar(Evento evento) {
        if (buscar(evento.getId()) != null) {
            return false;
        }
        raiz = insertarRec(raiz, evento);
        return true;
    }

    private NodoArbol insertarRec(NodoArbol actual, Evento evento) {
        if (actual == null) {
            return new NodoArbol(evento);
        }
        if (evento.getId() < actual.dato.getId()) {
            actual.izquierdo = insertarRec(actual.izquierdo, evento);
        } else {
            actual.derecho = insertarRec(actual.derecho, evento);
        }
        return actual;
    }

    // ---------- BUSCAR ----------
    // Devuelve el Evento, o null si no existe
    public Evento buscar(long id) {
        NodoArbol actual = raiz;
        while (actual != null) {
            if (id == actual.dato.getId()) {
                return actual.dato;
            } else if (id < actual.dato.getId()) {
                actual = actual.izquierdo;
            } else {
                actual = actual.derecho;
            }
        }
        return null;
    }

    // ---------- RECORRIDOS ----------
    public void inorden() {
        inordenRec(raiz);
    }

    private void inordenRec(NodoArbol nodo) {
        if (nodo != null) {
            inordenRec(nodo.izquierdo);
            System.out.println(nodo.dato);
            inordenRec(nodo.derecho);
        }
    }

    public void preorden() {
        preordenRec(raiz);
    }

    private void preordenRec(NodoArbol nodo) {
        if (nodo != null) {
            System.out.println(nodo.dato);
            preordenRec(nodo.izquierdo);
            preordenRec(nodo.derecho);
        }
    }

    public void postorden() {
        postordenRec(raiz);
    }

    private void postordenRec(NodoArbol nodo) {
        if (nodo != null) {
            postordenRec(nodo.izquierdo);
            postordenRec(nodo.derecho);
            System.out.println(nodo.dato);
        }
    }

    // ---------- CONTAR Y ALTURA ----------
    public int contar() {
        return contarRec(raiz);
    }

    private int contarRec(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + contarRec(nodo.izquierdo) + contarRec(nodo.derecho);
    }

    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + Math.max(alturaRec(nodo.izquierdo), alturaRec(nodo.derecho));
    }

    // ---------- MINIMO Y MAXIMO ----------
    public Evento minimo() {
        if (raiz == null) {
            return null;
        }
        return minimoNodo(raiz).dato;
    }

    private NodoArbol minimoNodo(NodoArbol nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }

    public Evento maximo() {
        if (raiz == null) {
            return null;
        }
        NodoArbol actual = raiz;
        while (actual.derecho != null) {
            actual = actual.derecho;
        }
        return actual.dato;
    }

    // ---------- ELIMINAR ----------
    public boolean eliminar(long id) {
        if (buscar(id) == null) {
            return false;
        }
        raiz = eliminarRec(raiz, id);
        return true;
    }

    private NodoArbol eliminarRec(NodoArbol actual, long id) {
        if (actual == null) {
            return null;
        }
        if (id < actual.dato.getId()) {
            actual.izquierdo = eliminarRec(actual.izquierdo, id);
        } else if (id > actual.dato.getId()) {
            actual.derecho = eliminarRec(actual.derecho, id);
        } else {
            // Caso 1: sin hijos
            if (actual.izquierdo == null && actual.derecho == null) {
                return null;
            }
            // Caso 2: un solo hijo
            if (actual.izquierdo == null) {
                return actual.derecho;
            }
            if (actual.derecho == null) {
                return actual.izquierdo;
            }
            // Caso 3: dos hijos -> se reemplaza por el menor del lado derecho
            NodoArbol sucesor = minimoNodo(actual.derecho);
            actual.dato = sucesor.dato;
            actual.derecho = eliminarRec(actual.derecho, sucesor.dato.getId());
        }
        return actual;
    }
}
