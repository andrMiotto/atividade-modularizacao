package org.example.view;

import org.example.model.Emprestimos;
import org.example.model.Livro;
import org.example.repository.EmprestimoRepository;
import org.example.repository.LivroRepository;

import javax.xml.transform.Source;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BibliotecaView {
    static Scanner sc = new Scanner(System.in);

    public static void mostrarMenu() {

        System.out.println("1 - Cadastrar livro");
        System.out.println("2 - Cadastrar emprestimo");
        System.out.println("3 - Devolver livro");
        System.out.println("4 - Consultar livros");

        System.out.println("0 - Sair");

    }

    public static int capturarOpcao() {
        int opcao = sc.nextInt();

        return opcao;
    }


    public static void listarBiblioteca() throws SQLException {

        System.out.println("O que deseja listar?: ");
        System.out.println("1 - Livros");
        System.out.println("2 - Emprestimos");

        int opcaoListar = sc.nextInt();
        sc.nextLine();

        switch (opcaoListar) {
            case 1: {
                List<Livro> listaLivros = LivroRepository.listarLivros();

                for (Livro l : listaLivros) {
                    System.out.println("ID: " + l.getId() + "\n" + " Titulo: " + l.getTitulo() + "\n Autor: " + l.getAutor() + "\n" + " Ano: " + l.getAno());
                }

                break;
            }


            case 2: {
                List<Emprestimos> listaEmprestimos = EmprestimoRepository.listarEmprestimos();
                for (Emprestimos e : listaEmprestimos) {
                    System.out.println("ID: " + e.getId() + "\n" + " Data emprestimo: " + e.getData_emprestimo() + "\n Data devolucao: " + e.getData_devolucao());
                }
            }
        }
    }


}



