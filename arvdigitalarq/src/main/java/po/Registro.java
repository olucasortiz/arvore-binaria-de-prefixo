package po;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Registro {
    public final int tf = 20;

    private int tlChave;
    private char[] chave = new char[tf]; // ex: "s1"

    private int tlBits;
    private char[] bits = new char[tf];  // ex: "10010"

    public Registro() {
    }

    public Registro(String chaveStr, String bitsStr) {
        this.tlChave = chaveStr.length();
        for (int i = 0; i < chaveStr.length(); i++) {
            this.chave[i] = chaveStr.charAt(i);
        }

        this.tlBits = bitsStr.length();
        for (int i = 0; i < bitsStr.length(); i++) {
            this.bits[i] = bitsStr.charAt(i);
        }
    }

    public String getChave() {
        return new String(chave, 0, tlChave);
    }

    public String getBits() {
        return new String(bits, 0, tlBits);
    }

    public void gravaNoArq(RandomAccessFile arquivo) {
        try {
            arquivo.writeInt(tlChave); // Grava o tamanho
            for (int i = 0; i < tf; i++) {
                arquivo.writeChar(chave[i]); // Grava letra por letra
            }

            arquivo.writeInt(tlBits);
            for (int i = 0; i < tf; i++) {
                arquivo.writeChar(bits[i]);
            }
        } catch (IOException e) {
            System.out.println("Erro ao gravar: " + e.getMessage());
        }
    }

    public void leDoArq(RandomAccessFile arquivo) {
        try {
            this.tlChave = arquivo.readInt();
            for (int i = 0; i < this.tf; i++) {
                this.chave[i] = arquivo.readChar();
            }
            this.tlBits = arquivo.readInt();
            for (int i = 0; i < this.tf; i++) {
                this.bits[i] = arquivo.readChar();
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler: " + e.getMessage());
        }
    }

    // Calcula o tamanho em bytes do registro para o seek
    static int length() {
        // int (4 bytes) + 20 chars (40 bytes) = 44 bytes por campo
        // Temos 2 campos (chave e bits) = 88 bytes total
        return (44 + 44);
    }

    public void exibirReg() {
        System.out.println("Chave: " + getChave() + " | Bits: " + getBits());
    }
}