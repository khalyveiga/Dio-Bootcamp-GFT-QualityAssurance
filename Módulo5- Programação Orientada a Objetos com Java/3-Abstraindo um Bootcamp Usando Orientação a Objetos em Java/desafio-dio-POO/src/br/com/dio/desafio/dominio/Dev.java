package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public Dev() {
    }

    /* Foi criado um local na memória para poder guardar os conteudos, com o LinkedHashSet()

       E pq o LinkedHashSet() e não um Array[]?
       Pela funcionalidade atribuida a cursos.
       Pois a medida que um aluno se inscreve em 1 curso ele não pode se inscrever novamente no mesmo.
       E a Array iria permitir duplicidade de conteudo. Já com o LinkedHashSet() só pode add elementos unicos.

       Conceito Herança
       private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
       Se não tivesse criado a classe mãe Conteudo (pode ser usada tanto para curso quando para mentoria),
       teria que criar um set de cursosInscritos e um set de cursosConcluidos,
       um set de mentoriaInscrito e um set de MentoriaConcluida.
       Não teria como agrupar tudo em um set só, por isso foi utilizado da Herança.

       Conceito Polimorfismo
       private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
       Porque estou instanciando o LinkedHashSet<>() através da Classe mãe Set<Conteudo>.
       Outra forma que poderia ser utilizada( Não tão comum!)
       private LinkedHashSet<Conteudo> conteudosInscritos = new LinkedHashSet<>();
       O uso Padrão é com Set<Conteudo>, como foi utilizada. Para evitar aclopamentos.
     */


    /* public void inscreverBootcamp(Bootcamp bootcamp){}
        Quer dizer que quando chamar inscreverBootcamp e passar um (Bootcamp bootcamp)eu vou me inscrever neste bootcamp.
        E implementar a lógica {}
     */
    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDesvsInscritos().add(this);
    }


    /*  public void progredir(){}
        Quer dizer que a medida que eu for progredindo dentro do Bootcamp, vai ter uma lógica {}
     */
    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }


    /*  public void calcularTotalXp(){}
        Quando chamar o calcularTotalXp(), quer saber quantos xp o dev conseguiu
       de acordo com o progresso dele dentro do Bootcamp.
    */
    public double calcularTotalXp(){
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(conteudo -> conteudo.calcularXp())
                .sum();
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    // Porque está trabalhando com LinkedHashSet serão implementados os equals and hashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
