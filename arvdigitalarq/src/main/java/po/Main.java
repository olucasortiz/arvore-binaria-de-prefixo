package po;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Limpeza para teste
        new File("dados_prova.dat").delete();

        // 1. Prepara dados (Simulando o arquivo que o professor daria)
        Arquivo_Java arq = new Arquivo_Java("dados_prova.dat");
        arq.inserirRegNoFinal(new Registro("s1", "0"));
        arq.inserirRegNoFinal(new Registro("s2", "1000"));
        arq.inserirRegNoFinal(new Registro("s3", "10010"));
        arq.inserirRegNoFinal(new Registro("s4", "11100"));
        arq.inserirRegNoFinal(new Registro("s5", "11101"));

        // 2. ITEM B: Construir a Árvore Binária de Prefixo
        ArvoreBinariaPrefixo arvore = new ArvoreBinariaPrefixo();
        System.out.println("--- Construindo Arvore (Item B) ---");
        arq.construirArvore(arvore);
        arvore.imprimir();

        System.out.println("\n--- Compactando Arvore em Patricia(Item C) ---");
        arvore.compactar();
        arvore.imprimir();
    }
}