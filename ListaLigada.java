public class ListaLigada {

    private Celula primeira;
    private Celula ultima;
    private int totalDeElementos;

    public void adiciona(){
        if(this.totalDeElementos == 0){
            this.adicionaNoComeco(elemento);
        }else{
            Celula nova  = new Celula(elemento);
            this.ultima.setProxima(nova);
            this.ultima = nova;
            this.totalDeElementos++;
        }
    }
    public void remove(){

    }

    public void adicionaNoComeco(Object elemento){
        Celula nova  = new Celula(this.primeira, elemento);
        this.primeira = nova;

        if(this.totalDeElementos == 0){
            // caso lista vazia
            this.ultima = this.primeira;
        }

        this.totalDeElementos++;
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
    }

    private boolean posicaoOcupada(int posicao){
        return posicao >= 0 && posicao < this.totalDeElementos;
    }

}