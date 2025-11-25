package po;

import po.ArvoreBinariaPrefixo;

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaPrefixo arvore = new ArvoreBinariaPrefixo();

        arvore.inserir("s1", "0");
        arvore.inserir("s2", "1000");
        arvore.inserir("s3", "10010");
        arvore.inserir("s4", "11100");
        arvore.inserir("s5", "11101");
        arvore.imprimir();
    }
}