package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo{
    // extends, para dizer que Classe Mentoria é filha de Classe Conteudo, conceito de Herança.
    // Tudo que tem na Classe Conteudo também terá na classe Mentoria.
    // Mas nem tudo que tem na Classe Mentoria terá na Classe Conteudo.

    private LocalDate data;

    @Override
    public double calcularXp() {
        return xp_PADRAO + 20d;
    }

    public Mentoria() {
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", data=" + data +
                '}';

        // foi usado geTitulo() e getDescricao() pq está chamando da Classe Conteudo e a declaração delas é Private.
    }


}
