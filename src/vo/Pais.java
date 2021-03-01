/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author ThyagoHenrique
 */
public class Pais {
     private Integer codigo;
     private String nome;
     private String sigla;
     private Regiao regiao;
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

     public String getSigla() {
          return sigla;
     }

     public void setSigla(String sigla) {
          this.sigla = sigla;
     }

     public Regiao getRegiao() {
          return regiao;
     }

     public void setRegiao(Regiao regiao) {
          this.regiao = regiao;
     }
}
