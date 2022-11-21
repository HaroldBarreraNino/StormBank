package com.usbbog.Proyecto.Sistemas.Distribuidos.controlador;

//Cifrado de cesar
public class SistemaCifrado {
    static String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890#$&*|° ";
    int n = letras.length();

    public SistemaCifrado() {
    }
    public String Cifrar(String texto) {
        String textoCodificado = "";
        char caracter;
        for (int i = 0; i < texto.length(); i++) {
            caracter = texto.charAt(i);
            int pos = letras.indexOf(caracter);
            if (pos == -1) {
                textoCodificado += caracter;
            } else {
                textoCodificado += letras.charAt((pos + 3) % n);
            }
        }
        return textoCodificado;
    }

    public String Descifrar(String texto) {
        String textoDescodificado = "";
        char caracter;
        for (int i = 0; i < texto.length(); i++) {
            caracter = texto.charAt(i);
            int pos = letras.indexOf(caracter);
            if (pos == -1) {
                textoDescodificado += caracter;
            } else {
                if (pos - 3 < 0) {
                    textoDescodificado += letras.charAt(n + (pos - 3));
                } else {
                    textoDescodificado += letras.charAt((pos - 3) % n);
                }
            }
        }
        return textoDescodificado;
    }
}
