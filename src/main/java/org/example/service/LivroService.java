package org.example.service;

import org.example.model.Livro;
import org.example.repository.LivroRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class LivroService {
    static Scanner sc = new Scanner(System.in);

    public static void cadastrarLivro() throws SQLException {
        System.out.println("Digite o titulo do livro: ");
        String titulo = sc.nextLine();

        System.out.println("Digite o autor do livro: ");
        String autor = sc.nextLine();

        System.out.println("Digite o ano do livro: ");
        int ano = sc.nextInt();

        Livro livro =  new Livro(titulo,autor,ano);


        LivroRepository.inserirLivro(livro);

    }


    public static void listarLivros() throws SQLException {


    }

    public static void registrarEmprestimos() throws SQLException {


    }

    public static void devolverLivro() throws SQLException {


    }


}
