package org.example.view;

import java.util.Scanner;

public class BibliotecaView {
    static Scanner sc = new Scanner(System.in);

    public static void mostrarMenu() {

        System.out.println("1 - Cadastrar livro");
        System.out.println("2 - Cadastrar emprestimo");
        System.out.println("3 - Devolver livro");
        System.out.println("4 - Consultar livros");
        capturarOpcao();


    }

    public static int capturarOpcao() {
        int opcao = sc.nextInt();

        return opcao;
    }

}
