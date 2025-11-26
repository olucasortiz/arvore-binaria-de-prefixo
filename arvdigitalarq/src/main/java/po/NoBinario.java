package po;

public class NoBinario{
    private NoBinario esquerda;
    private NoBinario direita;
    private String valor;
    private int indiceBit; // Necessário para a Árvore Patricia (Item C)

    public NoBinario(){
        this.esquerda = null;
        this.direita = null;
        this.valor = null;
        this.indiceBit = -1;
    }

    public NoBinario getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoBinario esquerda) {
        this.esquerda = esquerda;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public NoBinario getDireita() {
        return direita;
    }

    public void setDireita(NoBinario direita) {
        this.direita = direita;
    }

    public int getIndiceBit() { return indiceBit; }
    public void setIndiceBit(int indiceBit) { this.indiceBit = indiceBit; }
}
