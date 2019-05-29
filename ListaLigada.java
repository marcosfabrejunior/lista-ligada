
/**
ListaLigada * Aula de estrutura de dados - 28/05/2019  - Rodrigo Louback Adame
 */
public class ListaLigada {

    private Celula primeira;
    private Celula ultima;
    private int totalDeElementos;

    public void adicionaNaPosicao(int posicao, Object elemento){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição Inválida");
        }
        if(posicao == 0){ //no começo
            this.adicionaNoComeco(elemento);
        }else if(posicao == this.totalDeElementos){ //no final
            this.adiciona(elemento);
        }else{ //no meio
            Celula anterior = this.pega(posicao - 1);
            Celula nova = new Celula(anterior.getProxima(), elemento);
            anterior.setProxima(nova);
        }
    }

    public void removeNaPosicao(int posicao, Object elemento){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição Inválida");
        }

        if(posicao == 0){
            this.removeNoComeco();
        }else if(posicao == this.totalDeElementos - 1){
            this.removeNoFim();
        }else{
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula atual = anterior.getProxima();
            Celula proxima = atual.getProxima();

            this.totalDeElementos++;
        }
    }

    private pegaCelula(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição Inválida");
        }
        Celula atual = primeira;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProxima();
        }

        return atual;
    }

    public Object pega(int posicao){
        return this.pegaCelula(posicao).getElemento();
    }

    public void adiciona(Object elemento){
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