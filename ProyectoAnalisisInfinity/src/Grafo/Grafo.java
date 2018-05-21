
package Grafo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class Grafo
{
    /*
    private List<Arista> aristas;
    private List<Object> nodos;

    public Grafo()
    {
        this.aristas = new ArrayList<>();
        this.nodos = new ArrayList<>();
    }
    
    public void agregarArista()
    {
        
    }
    
    public void agregarNodo()
    {
        
    }
   */ 
}


//RIOS


/*

public class grafo {
    public int matAdy[][];
    public int etiquetas[];
    public LinkedList<escudo> list;
    


    public grafo(int tam,LinkedList<Integer> etiquetas,LinkedList<escudo> list) {
       this.matAdy=new int [tam][tam];
       this.etiquetas=new int [tam];
       this.list=list;
       int cont=0;
        for (int i : etiquetas) {
            
            this.etiquetas[cont]=i;
            cont++;
        }
    
    }
     
  
 
    
    public void addArista(int origen,int destino,int costo)
    {
    this.matAdy[origen][destino]=costo;
    this.matAdy[destino][origen]=costo;
     }
    
    
 
    public LinkedList<nodo> listAristas(int origen){
        LinkedList<nodo> salida=new LinkedList<>();
        
       
        for (int i = 0; i < this.matAdy.length; i++) {
            if(this.matAdy[origen][i]!=0){
                nodo n=new nodo(this.etiquetas[i], this.matAdy[origen][i]);
                //System.out.println("origen"+this.etiquetas[origen]);
                salida.add(n);
            
            }
            
        }
    
        return salida;
    
    
    
    
    }
   
    
    
    
    

*/