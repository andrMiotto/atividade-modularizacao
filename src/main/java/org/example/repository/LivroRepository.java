package org.example.repository;

import org.example.model.Livro;
import org.example.infraestrutura.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroRepository {


    public static Livro inserirLivro(Livro livro) throws SQLException {
        String query = "INSERT INTO livros (titulo,autor,ano,disponivel) VALUES (?,?,?,?)";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno());
            stmt.setBoolean(4, true);

            stmt.executeUpdate();


        }
        return livro;
    }


    public static List<Livro> listarLivros() throws SQLException {
        String query = "SELECT id,titulo, autor,ano,disponivel FROM livros WHERE disponivel = TRUE";

        List<Livro> livros = new ArrayList<>();

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int ano = rs.getInt("ano");
                boolean disponivel = rs.getBoolean("disponivel");

                var livro = new Livro(id, titulo, autor, ano, disponivel);
                livros.add(livro);


            }

        }
        return livros;
    }

    public void atualizarStatus (int id)throws SQLException{
        String query="UPDATE livro SET disponivel = TRUE where ID = ?";

        try(Connection connection = Conexao.conectar();
        PreparedStatement stmt = connection.prepareStatement(query)){

            stmt.setInt(1,id);
            stmt.executeUpdate();

        }


    }


}
