/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author ThyagoHenrique
 */
public class ItemVenda {
     
     private Integer     codigo;
     private int         quantidade;
     private double      valor;
     private Venda       venda;
     private Produto     produto;

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

     public Produto getProduto() {
          return produto;
     }

     public void setProduto(Produto produto) {
          this.produto = produto;
     }

     public Venda getVenda() {
          return venda;
     }

     public void setVenda(Venda venda) {
          this.venda = venda;
     }

     public double getValor() {
          return valor;
     }

     public void setValor(double valor) {
          this.valor = valor;
     }
     
}
