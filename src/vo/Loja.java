/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author ThyagoHenrique
 */
public class Loja {
     
     private Integer codigo;
     private String site;
     private String linkftp;
     private String login;
     private String senha;

     public Integer getCodigo() {
          return codigo;
     }

     public void setCodigo(Integer codigo) {
          this.codigo = codigo;
     }

     public String getSite() {
          return site;
     }

     public void setSite(String site) {
          this.site = site;
     }

     public String getLinkftp() {
          return linkftp;
     }

     public void setLinkftp(String linkftp) {
          this.linkftp = linkftp;
     }

     public String getLogin() {
          return login;
     }

     public void setLogin(String login) {
          this.login = login;
     }

     public String getSenha() {
          return senha;
     }

     public void setSenha(String senha) {
          this.senha = senha;
     }
     
}
