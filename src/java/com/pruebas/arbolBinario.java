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
    
    @GET
    public String crearArbol(@QueryParam("nodo1") int n1, @QueryParam("nodo2") int n2){
        String imprimirArbol = "";
        
        Nodo raiz = new Nodo("67");
        Nodo nodo2 = new Nodo("39");
        Nodo nodo3 = new Nodo("76");

        raiz.setNodoIzq(nodo2);
        Nodo nodo4 = new Nodo("28");
        nodo2.setNodoIzq(nodo4);
        nodo2.setNodoDer(new Nodo("44"));
        nodo4.setNodoDer(new Nodo("29"));
        
        raiz.setNodoDer(nodo3);
        Nodo nodo5 = new Nodo("85");
        nodo3.setNodoIzq(new Nodo("74"));
        nodo3.setNodoDer(nodo5);
        nodo5.setNodoIzq(new Nodo("83"));
        nodo5.setNodoDer(new Nodo("87"));
        
        Nodo nodoAnt = lca(raiz, n1, n2);
        
        imprimirArbol = preOrden(raiz) + "\t" + inOrden(raiz) + "\n" + postOrden(raiz)
                + "El nodo Antecesor en comun de " + n1 + " y " + n2 + " es " + nodoAnt.getDato();
        
        
        
        
        return String.valueOf(imprimirArbol);
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
