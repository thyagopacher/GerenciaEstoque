/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import persistencia.Conexao;

/**
 *
 * @author ThyagoHenrique
 */
public class CategoriasProduto {
     
     private Integer codigo;
     private Produto produto;
     private CategoriaProduto categoria;

     public Integer getCodigo() {
          return codigo;
     }

     public void setCodigo(Integer codigo) {
          this.codigo = codigo;
     }

     public Produto getProduto() {
          return produto;
     }

     public void setProduto(Produto produto) {
          this.produto = produto;
     }

     public CategoriaProduto getCategoria() {
          return categoria;
     }

     public void setCategoria(CategoriaProduto categoria) {
          this.categoria = categoria;
     }

     
}
