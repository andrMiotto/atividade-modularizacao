package org.example;

import org.example.view.BibliotecaView;

import java.sql.SQLException;
import java.util.Scanner;

import static org.example.service.LivroService.*;
import static org.example.service.EmprestimoService.*;
import static org.example.view.BibliotecaView.listarBiblioteca;


public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        inicio();

    }


    public static void inicio() throws SQLException {

        boolean sair = false;

        var bilbiotecadView = new BibliotecaView();
        bilbiotecadView.mostrarMenu();

        int opcao = bilbiotecadView.capturarOpcao();

        switch (opcao) {
            case 1: {
                cadastrarLivro();
                break;
            }
            case 2: {
                cadastrarEmprestimo();
                break;
            }
            case 3: {
                realizarDevolucao();
                break;
            }
            case 4: {
                listarBiblioteca();
                break;
            }

            case 0: {
                sair = true;
            }
        }

        if (!sair) {
            inicio();
        }

    }


}
