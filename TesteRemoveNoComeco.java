/**
 * TesteRemoveNoComeco
 */
public class TesteRemoveNoComeco {

    public static void main(String[] args){
        ListaLigada lista = new ListaLigada();

        lista.adicionaNoComeco("Gabriel");
        lista.adicionaNoComeco("Rodrigo");

        // System.out.println(lista);

        lista.removeNoComeco();
    }
    
}