/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author ThyagoHenrique
 */
public class Pagina {
     
     private Integer codigo;
     private String titulo;
     private String metatitulo;
     private String palavrachave;
     private String conteudo;

     public Integer getCodigo() {
          return codigo;
     }

     public void setCodigo(Integer codigo) {
          this.codigo = codigo;
     }

     public String getTitulo() {
          return titulo;
     }

     public void setTitulo(String titulo) {
          this.titulo = titulo;
     }

     public String getMetatitulo() {
          return metatitulo;
     }

     public void setMetatitulo(String metatitulo) {
          this.metatitulo = metatitulo;
     }

     public String getPalavrachave() {
          return palavrachave;
     }

     public void setPalavrachave(String palavrachave) {
          this.palavrachave = palavrachave;
     }

     public String getConteudo() {
          return conteudo;
     }

     public void setConteudo(String conteudo) {
          this.conteudo = conteudo;
     }
     
}
