package org.example.repository;

import com.sun.source.tree.TryTree;
import org.example.infraestrutura.Conexao;
import org.example.model.Emprestimos;
import org.example.model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoRepository {

    public static void inserirEmprestimo(Emprestimos emprestimos) throws SQLException {
        String query = "INSERT INTO emprestimos (livro_id,usuario_id,data_devolucao) VALUES (?,?,?)";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, emprestimos.getLivro_id());
            stmt.setInt(2, emprestimos.getId_usuario());
            stmt.setDate(3, null);

            stmt.executeUpdate();
        }


    }


    public static void devolverLivros(Date data, int id) throws SQLException {
        String query = "UPDATE emprestimos SET data_devolucao = ? WHERE id = ?";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {


            stmt.setDate(1, data);
            stmt.setInt(2, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public static List<Emprestimos> listarEmprestimos() throws SQLException {

        String query = "SELECT id,data_emprestimo,data_devolucao FROM emprestimos";

        List<Emprestimos> emprestimos = new ArrayList<>();


        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                Date data_emprestimo = rs.getDate("data_emprestimo");
                Date data_devolucao = rs.getDate("data_devolucao");

                var emprestimo = new Emprestimos(id, data_emprestimo, data_devolucao);
                emprestimos.add(emprestimo);

            }

        }

        return emprestimos;
    }


}
