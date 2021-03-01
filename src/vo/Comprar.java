/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.util.Date;

/**
 *
 * @author ThyagoHenrique
 */
public class Comprar {
     
     private Integer codigo;
     private Date data;
     private Date vencimento;
     private Pessoa pessoa;
     private Double valor;
     private int parcela;
     
     public Integer getCodigo() {
          return codigo;
     }

     public void setCodigo(Integer codigo) {
          this.codigo = codigo;
     }

     public Date getData() {
          return data;
     }

     public void setData(Date data) {
          this.data = data;
     }

     public Double getValor() {
          return valor;
     }

     public void setValor(Double valor) {
          this.valor = valor;
     }

     public Date getVencimento() {
          return vencimento;
     }

     public void setVencimento(Date vencimento) {
          this.vencimento = vencimento;
     }

     public Pessoa getPessoa() {
          return pessoa;
     }

     public void setPessoa(Pessoa pessoa) {
          this.pessoa = pessoa;
     }

     public int getParcela() {
          return parcela;
     }

     public void setParcela(int parcela) {
          this.parcela = parcela;
     }
}
