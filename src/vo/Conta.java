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
public class Conta {
     
     private Integer codigo;
     private String tipo;
     private Date vencimento;
     private double valor;
     private String estado;
     
     public Integer getCodigo() {
          return codigo;
     }

     public void setCodigo(Integer codigo) {
          this.codigo = codigo;
     }

     public String getTipo() {
          return tipo;
     }

     public void setTipo(String tipo) {
          this.tipo = tipo;
     }

     public Date getVencimento() {
          return vencimento;
     }

     public void setVencimento(Date vencimento) {
          this.vencimento = vencimento;
     }

     public double getValor() {
          return valor;
     }

     public void setValor(double valor) {
          this.valor = valor;
     }

     public String getEstado() {
          return estado;
     }

     public void setEstado(String estado) {
          this.estado = estado;
     }
}
