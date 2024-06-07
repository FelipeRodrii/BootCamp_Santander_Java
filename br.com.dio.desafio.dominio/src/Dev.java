import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Dev {
   private String nome;
   private Set<Conteudo> conteudoInscritos = new LinkedHashSet<>();
   private Set<Conteudo> conteudConcluidos = new LinkedHashSet<>();

   public void inscreverBootcamp(Bootcamp bootcamp){
      this.conteudoInscritos.addAll(bootcamp.getConteudos());
      bootcamp.getDevsInscritos().add(this); // Usando apenas o This, vai se referenciar a toda a instância DEV.
   }

   public void progredir(){
      Optional<Conteudo> conteudo = this.conteudoInscritos.stream().findFirst();
      if(conteudo.isPresent()){
         this.conteudConcluidos.add(conteudo.get());
         this.conteudoInscritos.remove(conteudo.get());
      }else{
         System.err.println("Você não está matriculado em nenhum conteudo!");
      }
   }

   public double calcularXp(){
      return this.conteudConcluidos
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

   public Set<Conteudo> getConteudoInscritos() {
      return conteudoInscritos;
   }

   public void setConteudoInscritos(Set<Conteudo> conteudoInscritos) {
      this.conteudoInscritos = conteudoInscritos;
   }

   public Set<Conteudo> getConteudConcluidos() {
      return conteudConcluidos;
   }

   public void setConteudConcluidos(Set<Conteudo> conteudConcluidos) {
      this.conteudConcluidos = conteudConcluidos;
   }
   //
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((nome == null) ? 0 : nome.hashCode());
      result = prime * result + ((conteudoInscritos == null) ? 0 : conteudoInscritos.hashCode());
      result = prime * result + ((conteudConcluidos == null) ? 0 : conteudConcluidos.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;  
      if (getClass() != obj.getClass())
         return false;
      Dev other = (Dev) obj;
      if (nome == null) {
         if (other.nome != null)
            return false;
      } else if (!nome.equals(other.nome))
         return false;
      if (conteudoInscritos == null) {
         if (other.conteudoInscritos != null)
            return false;
      } else if (!conteudoInscritos.equals(other.conteudoInscritos))
         return false;
      if (conteudConcluidos == null) {
         if (other.conteudConcluidos != null)
            return false;
      } else if (!conteudConcluidos.equals(other.conteudConcluidos))
         return false;
      return true;
   }
   
    
}
