package br.ufrn.eaj.tads.meuslivros;

import com.orm.SugarRecord;

/**
 * Created by Aluno on 06/09/2017.
 */

public class Livro  extends SugarRecord{
    private long id;
    private String titulo;
    private String autor;
    private int ano;
    private double nota;

    public Livro() {
    }

    public Livro(String titulo, String autor, int ano, double nota) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.nota = nota;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    public double getNota() {
        return nota;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ano=" + ano +
                ", nota=" + nota +
                '}';
    }
}
