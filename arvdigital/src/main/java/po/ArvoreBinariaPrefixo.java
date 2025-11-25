package po;

public class ArvoreBinariaPrefixo {
    private NoBinario raiz;
    public ArvoreBinariaPrefixo() {
        this.raiz = new NoBinario();
    }

    public void inserir(String chave, String bits) {
        NoBinario atual = raiz;
        int i = 0;
        int totalBits = bits.length();
        boolean fim = false;

        while (i < totalBits) {
            char bit = bits.charAt(i);

            // se for bit 0 vai para a esquerda
            if (bit == '0') {
                if (atual.getEsquerda() == null) {
                    atual.setEsquerda(new NoBinario());
                }
                atual = atual.getEsquerda();
            }
            else {
                if (atual.getDireita() == null) {
                    atual.setDireita(new NoBinario());
                }
                atual = atual.getDireita();
            }
            i = i + 1;
        }

        atual.setValor(chave);
    }

    public void imprimir() {
        System.out.println("--- Árvore Binária ---");
        imprimirRec(raiz, "");
    }

    private void imprimirRec(NoBinario no, String prefixo) {
        if (no != null) {
            String mostraValor = (no.getValor() != null) ? " [" + no.getValor() + "]" : "";
            System.out.println(prefixo + "." + mostraValor);

            imprimirRec(no.getEsquerda(), prefixo + "(0)--");
            imprimirRec(no.getDireita(), prefixo + "(1)--");
        }
    }
}
