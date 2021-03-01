/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author ThyagoHenrique
 */
public class CategoriaProduto {
     
     private Integer codigo;
     private String nome;
     private CategoriaProduto mestre;
     
     public Integer getCodigo() {
          return codigo;
     }

     public void setCodigo(Integer codigo) {
          this.codigo = codigo;
     }

     public String getNome() {
          return nome;
     }

     public void setNome(String nome) {
          this.nome = nome;
     }

     public CategoriaProduto getMestre() {
          return mestre;
     }

     public void setMestre(CategoriaProduto mestre) {
          this.mestre = mestre;
     }
     
}
