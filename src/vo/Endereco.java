/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author ThyagoHenrique
 */
public class Endereco {
     
     private Integer codigo;
     private Pessoa pessoa;
     private Estado estado;
     private String endereco;
     private String cep;
     private String cidade;
     private String bairro;
     
     public Integer getCodigo() {
          return codigo;
     }

     public void setCodigo(Integer codigo) {
          this.codigo = codigo;
     }

     public Pessoa getPessoa() {
          return pessoa;
     }

     public void setPessoa(Pessoa pessoa) {
          this.pessoa = pessoa;
     }

     public Estado getEstado() {
          return estado;
     }

     public void setEstado(Estado estado) {
          this.estado = estado;
     }

     public String getEndereco() {
          return endereco;
     }

     public void setEndereco(String endereco) {
          this.endereco = endereco;
     }

     public String getCep() {
          return cep;
     }

     public void setCep(String cep) {
          this.cep = cep;
     }

     public String getCidade() {
          return cidade;
     }

     public void setCidade(String cidade) {
          this.cidade = cidade;
     }

     public String getBairro() {
          return bairro;
     }

     public void setBairro(String bairro) {
          this.bairro = bairro;
     }
     
}
