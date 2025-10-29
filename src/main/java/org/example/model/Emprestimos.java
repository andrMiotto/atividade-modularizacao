package org.example.model;

import java.util.Date;

public class Emprestimos {

    private int id;
    private int livro_id;
    private int id_usuario;
    private Date data_emprestimo;
    private Date data_devolucao;


    public Emprestimos(int id, int livro_id, int id_usuario, Date data_emprestimo, Date data_devolucao) {
        this.id = id;
        this.livro_id = livro_id;
        this.id_usuario = id_usuario;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    public Emprestimos(int livro_id, int id_usuario, Date data_emprestimo, Date data_devolucao) {
        this.livro_id = livro_id;
        this.id_usuario = id_usuario;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    public Emprestimos(int idLivro, int idUsuario, Date dataDevolucao) {
        this.livro_id = idLivro;
        this.id_usuario = idUsuario;
        this.data_devolucao = dataDevolucao;
    }

    public Emprestimos(int id, java.sql.Date dataEmprestimo, java.sql.Date dataDevolucao) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(int livro_id) {
        this.livro_id = livro_id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Date getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(Date data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    @Override
    public String toString() {
        return "Emprestimos{" +
                "id=" + id +
                ", livro_id=" + livro_id +
                ", id_usuario=" + id_usuario +
                ", data_emprestimo=" + data_emprestimo +
                ", data_devolucao=" + data_devolucao +
                '}';
    }
}
