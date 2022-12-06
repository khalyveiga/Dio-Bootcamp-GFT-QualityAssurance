import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
   public static void  main(String[]args){
       Curso curso1 = new Curso();
       curso1.setTitulo("Curso Java");
       curso1.setDescricao("Descricao curso Java");
       curso1.setCargaHoraria(8);

       Curso curso2 = new Curso();
       curso2.setTitulo("Curso Js");
       curso2.setDescricao("Descricao curso Js");
       curso2.setCargaHoraria(4);

       /* Exemplo que não dá para criar um conteudo porque a Classe é abstract.
        ele traz o método abstrato, que não dá pra ser utilizado.( abaixo).

       (Exemplo inválido)

       Conteudo conteudo = new Conteudo() {
           @Override
           public double calcularXp() {
               return 0;
           }
       }
       ( Exemplo válido 1)
        No conceito Polimorfismo.

        Conteudo conteudo = new Curso();

        Foi instanciado um Curso() apartir da Classe Conteudo.
        Sendo assim tudo que tem em Conteudo em tem Curso().
        Mas nem tudo que tem em Curso tem em Conteudo.

         ( Exemplo válido 1)
        No conceito Polimorfismo.

        Conteudo conteudo1 = new Mentoria();
        */

       Mentoria mentoria = new Mentoria();
       mentoria.setTitulo("Mentoria de Java");
       mentoria.setDescricao("Descrição mentoria de Java");
       mentoria.setData(LocalDate.now());

       //System.out.println(curso1);
       // System.out.println(curso2);
       // System.out.println(mentoria);

       Bootcamp bootcamp = new Bootcamp();
       bootcamp.setNome("Bootcamp Java Developer");
       bootcamp.setDescricao("Descrição Bootcamp Java Developer");
       bootcamp.getConteudos().add(curso1);
       bootcamp.getConteudos().add(curso2);
       bootcamp.getConteudos().add(mentoria);

       Dev devKhaly = new Dev();
       devKhaly.setNome("Khaly");
       devKhaly.inscreverBootcamp(bootcamp);
       System.out.println("Conteúdos Inscritos" + devKhaly.getConteudosInscritos());

       devKhaly.progredir();
       devKhaly.progredir();
       System.out.println("-");
       System.out.println("Conteúdos Inscritos" + devKhaly.getConteudosInscritos());
       System.out.println("Conteúdos Concluídos"+ devKhaly.getConteudosConcluidos());
       System.out.println("XP:" + devKhaly.calcularTotalXp());

       System.out.println("---------------------------");

       Dev devCamila = new Dev();
       devCamila.setNome("Camila");
       devCamila.inscreverBootcamp(bootcamp);
       System.out.println("Conteúdos Inscritos" + devCamila.getConteudosInscritos());

       devCamila.progredir();
       devCamila.progredir();
       devCamila.progredir();
       System.out.println("-");
       System.out.println("Conteúdos Inscritos" + devCamila.getConteudosInscritos());
       System.out.println("Conteúdos Concluídos"+devCamila.getConteudosConcluidos());
       System.out.println("XP:" + devCamila.calcularTotalXp());


   }
}