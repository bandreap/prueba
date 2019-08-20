/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebas;

import com.pruebas.conf.Nodo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author ANDREA
 */
@Path("arbolBinario")
public class arbolBinario {
    private String resPreOrden = "PreOrden ->";
    private String resInOrden = "InOrden ->";
    private String resPostOrden = "PostOrden ->";
    private Nodo raiz;
    
    public arbolBinario(){
        raiz = null;
    }
        
    @GET
    public String crearArbol(@QueryParam("arbol") String arbol, @QueryParam("nodo1") int n1, @QueryParam("nodo2") int n2){
        String imprimirArbol = "";
        
        //String arbol = "67-39-76-28";
        String datos [] = arbol.split("-");
        
        for (String i : datos) {
            agregarNodo(i);
        }
        
        Nodo nodoAnt = lca(raiz, n1, n2);
        
        imprimirArbol = preOrden(raiz) + "\t" + inOrden(raiz) + "\n" + postOrden(raiz)
                + "El nodo Antecesor en comun de " + n1 + " y " + n2 + " es " + nodoAnt.getDato();
        
        return String.valueOf(imprimirArbol);
    }
    
    public void agregarNodo(String dato){
        Nodo nuevo = new Nodo(dato);
        if(raiz == null){
            raiz = nuevo;
        } else {
            Nodo auxiliar=raiz;
            Nodo padre;
            while(true){
                padre=auxiliar;
                if(Integer.parseInt(dato) < Integer.parseInt(auxiliar.getDato())){
                    auxiliar=auxiliar.NodoIzq;
                    if(auxiliar==null){
                        padre.setNodoIzq(nuevo);
                        return;
                    }
                }else{
                    auxiliar=auxiliar.NodoDer;
                    if(auxiliar==null){
                        padre.setNodoDer(nuevo);
                        return;
                    }
                }
            }
        }
    }
    
    public String preOrden(Nodo raiz) {
        if (raiz != null) {
            resPreOrden = resPreOrden.concat(raiz.getDato() + "-");
            preOrden(raiz.getNodoIzq());
            preOrden(raiz.getNodoDer());
            
        }
        return resPreOrden;
    }
    
    public String inOrden(Nodo raiz) {
        if (raiz != null) {
            inOrden(raiz.getNodoIzq());
            resInOrden = resInOrden.concat(raiz.getDato() + "-");
            inOrden(raiz.getNodoDer());
        }
        return resInOrden;
    }
    
    public String postOrden(Nodo raiz) {
        if (raiz != null) {
            postOrden(raiz.getNodoIzq());
            postOrden(raiz.getNodoDer());
            resPostOrden = resPostOrden.concat(raiz.getDato() + "-");
        }
        return resPostOrden;
    }
    
    public Nodo lca(Nodo nodoC, int n1, int n2) {
        if (nodoC == null)
            return null;
        
        if (Integer.parseInt(nodoC.getDato()) > n1 && Integer.parseInt(nodoC.getDato()) > n2)
            return lca(nodoC.getNodoIzq(), n1, n2);
        
        if (Integer.parseInt(nodoC.getDato()) < n1 && Integer.parseInt(nodoC.getDato()) < n2)
            return lca(nodoC.getNodoDer(), n1, n2);
        
        return nodoC;
    }
}
