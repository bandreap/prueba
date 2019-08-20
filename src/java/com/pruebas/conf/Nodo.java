/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebas.conf;

/**
 *
 * @author ANDREA
 */
public class Nodo {
    public String dato;
    public Nodo NodoIzq;
    public Nodo NodoDer;

    public Nodo(String dato) {
        this.dato = dato;
        this.NodoIzq = null;
        this.NodoDer = null;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo getNodoIzq() {
        return NodoIzq;
    }

    public void setNodoIzq(Nodo NodoIzq) {
        this.NodoIzq = NodoIzq;
    }

    public Nodo getNodoDer() {
        return NodoDer;
    }

    public void setNodoDer(Nodo NodoDer) {
        this.NodoDer = NodoDer;
    }
    
}
