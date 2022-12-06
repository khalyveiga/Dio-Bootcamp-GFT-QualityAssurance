package br.com.dio.desafio.dominio;

// Todo Bootcamp terão conteúdos.
//  Mentoria e Curso são conteúdos.
// Objetivo da Classe Conteudo é para poder iniciar os atributos titulo e descrição e criar método calcular xp().
// Para que as Classes filhas (Mentoria e Curso) utilizem esses atributos. Com isso podemos simplificar e evitar repetição de código.
public abstract class Conteudo {
   // foi usado abstract no método calcularXp(). Assim a Classe também tem que ser abstrata.

   protected static final double xp_PADRAO = 10d;

   // todo conteudo será criado com o xp_padrão, será uma constante.
   // final quer dizer que &eacute; uma constante.
   // static quer dizer que pode acessar fora da classe conteúdo.
   //protect somente as classes filhas podem acessar a constante.

   private String titulo;
   private String descricao;

   public abstract double calcularXp();
   // As classes filhas, que estenderem de Conteudo serão obrigadas a implementar uma lógica no método xp().
   // abstract, ela não consegue instanciar um conteudo na Classe Main.
   // Porque será usado somente nas classes filhas, conceito de Herança.


   public String getTitulo() {
      return titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   public String getDescricao() {
      return descricao;
   }

   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }
}
