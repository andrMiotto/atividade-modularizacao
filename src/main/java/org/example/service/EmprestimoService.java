package org.example.service;

import org.example.model.Emprestimos;
import org.example.model.Livro;
import org.example.repository.EmprestimoRepository;
import org.example.repository.LivroRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmprestimoService {
    static Scanner sc = new Scanner(System.in);

    public static void cadastrarEmprestimo() throws SQLException {

        List<Livro> listaLivros = LivroRepository.listarLivros();

        for (Livro l : listaLivros) {
            System.out.println("ID: " + l.getId() + "\n" + " Titulo: " + l.getTitulo() + "\n Autor: " + l.getAutor() + "\n" + " Ano: " + l.getAno());
        }

        System.out.println("Escolha o livro: ");
        int id_livro = sc.nextInt();

        System.out.println("Digite o id do cliente que realizara o emprestimo");
        int id_usuario = sc.nextInt();

        var emprestimo = new Emprestimos(id_livro, id_usuario, null);
        EmprestimoRepository.inserirEmprestimo(emprestimo);

        System.out.println("Emprestimo cadastrado");


    }


    public static void realizarDevolucao() throws SQLException {

        List<Emprestimos> listaEmprestimos = EmprestimoRepository.listarEmprestimos();
        for (Emprestimos e : listaEmprestimos) {
            System.out.println("ID: " + e.getId() + "\n" + " Data emprestimo: " + e.getData_emprestimo() + "\n Data devolucao: " + e.getData_devolucao());
        }


        System.out.println("Selecione o id emprestimo: ");
        int idSelecionado = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite a data de devolucao");
        Date data = Date.valueOf(sc.nextLine());



        var emprestimo = new Emprestimos(idSelecionado, data);

        EmprestimoRepository.devolverLivros(emprestimo);


    }


}
