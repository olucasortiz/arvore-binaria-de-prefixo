package po;

public class Main {
    public static void main(String[] args) {

        Arquivo_Java arq = new Arquivo_Java("dados_prova.dat");

        ArvoreBinariaPrefixo arvore = new ArvoreBinariaPrefixo();
        System.out.println("--- Lendo arquivo e construindo árvore ---");
        arq.construirArvore(arvore);

        arvore.imprimir();
    }
}