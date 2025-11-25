package po;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Arquivo_Java {
    private String nomearquivo;
    private RandomAccessFile arquivo;

    public Arquivo_Java(String nomearquivo) {
        try {
            arquivo = new RandomAccessFile(nomearquivo, "rw");
        } catch (IOException e) {
            System.out.println("Erro ao abrir arquivo: " + e.getMessage());
        }
    }

    public void truncate(long pos) {
        try {
            arquivo.setLength(pos * Registro.length());
        } catch (IOException exc) { }
    }

    public boolean eof() {
        boolean retorno = false;
        try {
            if (arquivo.getFilePointer() == arquivo.length())
                retorno = true;
        } catch (IOException e) { }
        return (retorno);
    }

    public void inserirRegNoFinal(Registro reg) {
        seekArq(filesize()); // ultimo byte
        reg.gravaNoArq(arquivo);
    }

    public int filesize() {
        try {
            return (int) (arquivo.length() / Registro.length());
        } catch (IOException e) { return 0; }
    }

    public void seekArq(int pos) {
        try {
            arquivo.seek((long) pos * Registro.length());
        } catch (IOException e) { }
    }

    public void construirArvore(ArvoreBinariaPrefixo arvore) {
        Registro aux = new Registro();
        seekArq(0); // Garante o inicio

        while (!this.eof()) {
            aux.leDoArq(arquivo);

            arvore.inserir(aux.getChave(), aux.getBits());

            System.out.println("Inserido na árvore: " + aux.getChave() + " -> " + aux.getBits());
        }
    }
}