/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author ThyagoHenrique
 */
public class EstadoVenda {
     
     private Integer codigo;
     private String nome;
     private int ordem;
     
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

     public int getOrdem() {
          return ordem;
     }

     public void setOrdem(int ordem) {
          this.ordem = ordem;
     }

}
