/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author ThyagoHenrique
 */
public class Variacao {
     
     private Integer codigo;
     private String nome;
     private int    num_opcoes;
     
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

     public int getNum_opcoes() {
          return num_opcoes;
     }

     public void setNum_opcoes(int num_opcoes) {
          this.num_opcoes = num_opcoes;
     }

}
