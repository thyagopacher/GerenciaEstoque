/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author ThyagoHenrique
 */
public class Desconto {
     private Integer codigo;
     private Produto produto;
     private int qtdmin;
     private int qtdmax;
     private double valor;

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

     public int getQtdmin() {
          return qtdmin;
     }

     public void setQtdmin(int qtdmin) {
          this.qtdmin = qtdmin;
     }

     public int getQtdmax() {
          return qtdmax;
     }

     public void setQtdmax(int qtdmax) {
          this.qtdmax = qtdmax;
     }

     public double getValor() {
          return valor;
     }

     public void setValor(double valor) {
          this.valor = valor;
     }
}
