/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author ThyagoHenrique
 */
public class ImagemProduto {
     
     private Integer codigo;
     private String nome;
     private Produto produto;
     
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

     public Produto getProduto() {
          return produto;
     }

     public void setProduto(Produto produto) {
          this.produto = produto;
     }
     
}
