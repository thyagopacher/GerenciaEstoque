/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author ThyagoHenrique
 */
public class ItemCompra {
     
     private Integer     codigo;
     private int         quantidade;
     private Comprar     comprar;
     private Produto     produto;
     private double      valor;
     
     public Integer getCodigo() {
          return codigo;
     }

     public void setCodigo(Integer codigo) {
          this.codigo = codigo;
     }

     public int getQuantidade() {
          return quantidade;
     }

     public void setQuantidade(int quantidade) {
          this.quantidade = quantidade;
     }

     public Comprar getComprar() {
          return comprar;
     }

     public void setComprar(Comprar comprar) {
          this.comprar = comprar;
     }

     public Produto getProduto() {
          return produto;
     }

     public void setProduto(Produto produto) {
          this.produto = produto;
     }

     public double getValor() {
          return valor;
     }

     public void setValor(double valor) {
          this.valor = valor;
     }
     
}
