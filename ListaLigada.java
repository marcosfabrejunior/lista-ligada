
/**
ListaLigada * Aula de estrutura de dados - 28/05/2019  - Rodrigo Louback Adame
 */
public class ListaLigada {

    private Celula primeira;
    private Celula ultima;
    private int totalDeElementos;

    public void adiciona(int posicao, Object elemento){
        
    }

    public void adiciona(){
        if(this.totalDeElementos == 0){
            this.adicionaNoComeco(elemento);
        }else{
            Celula nova  = new Celula(elemento);
            this.ultima.setProxima(nova);
            this.ultima = nova;
            this.totalDeElementos++;
        }

        System.out.println("============================================ ");
        System.out.println("Lista Primeiro - "+ primeira.getElemento());
        System.out.println("Lista Ultimo - "+ ultima.getElemento());
        System.out.println("Total "+ totalDeElementos);
    }
    public void removeNoFim(){
        if(!this.posicaoOcupada(0)){
            throw new IllegalArgumentException("Posição Inválida");
        }

        if(this.totalDeElementos == 1){
            this.removeNoComeco();
        }else{
            Celula penultima = this.ultima.getAnterior();
            penultima.setProxima(null);
            this.ultima = penultima;
            this.totalDeElementos--;
        }

        System.out.println("============================================ ");
        System.out.println("Lista Primeiro - "+ primeira.getElemento());
        System.out.println("Lista Ultimo - "+ ultima.getElemento());
        System.out.println("Total "+ totalDeElementos);
    }

    public void adicionaNoComeco(Object elemento){
        Celula nova  = new Celula(this.primeira, elemento);
        this.primeira = nova;

        if(this.totalDeElementos == 0){
            // caso lista vazia
            this.ultima = this.primeira;
        }

        this.totalDeElementos++;

        System.out.println("Lista Primeiro - "+ primeira.getElemento());
        System.out.println("Lista Ultimo - "+ ultima.getElemento());
        System.out.println("Total "+ totalDeElementos);
    }

    public void removeNoComeco(){
        if(!this.posicaoOcupada(0)){
            throw new IllegalArgumentException("Posição Inválida");
        }
        this.primeira = this.primeira.getProxima();
        this.totalDeElementos--;

        if(this.totalDeElementos == 0){
            this.ultima = null;
        }

        System.out.println("============================================ ");
        System.out.println("Lista Primeiro - "+ primeira.getElemento());
        System.out.println("Lista Ultimo - "+ ultima.getElemento());
        System.out.println("Total "+ totalDeElementos);
    }

    private boolean posicaoOcupada(int posicao){
        return posicao >= 0 && posicao < this.totalDeElementos;
    }

}