/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author ThyagoHenrique
 */
public class FormaPagamento {
     
     private Integer codigo;
     private String nome;
     private double juros;
     private double adiantamento;
     private int data;
     private String formafaturamento;
     
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

     public double getJuros() {
          return juros;
     }

     public void setJuros(double juros) {
          this.juros = juros;
     }

     public int getData() {
          return data;
     }

     public void setData(int data) {
          this.data = data;
     }

     public String getFormafaturamento() {
          return formafaturamento;
     }

     public void setFormafaturamento(String formafaturamento) {
          this.formafaturamento = formafaturamento;
     }

     public double getAdiantamento() {
          return adiantamento;
     }

     public void setAdiantamento(double adiantamento) {
          this.adiantamento = adiantamento;
     }
}
