import java.io.*;

public class Celula {
    private Celula proxima;
    private Object elemento;
    private Celula anterior;

    public Celula(Object elemento){
        this.elemento = elemento;
    }

    public Celula(Celula proxima, Object elemento){
        this.proxima = proxima;
        this.elemento = elemento;
    }

    public void setProxima(Celula proxima){
        this.proxima = proxima;
    }

    public Celula getProxima(){
        return this.proxima;
    }

    public Object getElemento(){
        return elemento;
    }

    public void setAnterior(){
        this.anterior = anterior;
    }

    public Celula getAnterior(){
        return anterior;
    }
    
}