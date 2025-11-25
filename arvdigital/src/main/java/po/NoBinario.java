package po;

public class NoBinario{
    private NoBinario esquerda;
    private NoBinario direita;
    private String valor;

    public NoBinario(){
        this.esquerda = null;
        this.direita = null;
        this.valor = null;
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
}
