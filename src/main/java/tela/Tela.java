package tela;

import entities.MaterialBibliografico;
import swing.LivroPainel;
import entities.Livro;
import entities.Revista;
import java.util.List;

public class Tela {
  private MaterialBibliografico materialBibliografico;
  
  public Tela(MaterialBibliografico MB){
    this.materialBibliografico = MB;
    new LivroPainel(this);
  }

  public void addLivro(String titulo, String autor,int ano){
    try {
      if(titulo.length()==0||autor.length()==0){
        throw new Exception("Titulo or autor is null");
      }
      this.materialBibliografico.addLivro(titulo, autor, ano);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void addRevista(String titulo,String org,int vol,int nro,int ano){
    try {
      if(titulo.length()==0||org.length()==0){
        throw new Exception("Titulo or org is null");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    this.materialBibliografico.addRevista(titulo, org, vol, nro, ano);
  }

  public List<Livro> getLivros(){
    return this.materialBibliografico.getLivros();
  }

  public List<Revista> getRevistas(){
    return this.materialBibliografico.getRevistas();
  }
}
