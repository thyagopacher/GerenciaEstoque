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
public class Venda {
     
     private Integer codigo;
     private Date data;
     private Date vencimento;
     private Pessoa pessoa;
     private int parcela;
     private EstadoVenda estadovenda;
     private double valor;
     private double frete;
     private String envio;
     private int codvendedor;
     
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

  
     public double getValor() {
          return valor;
     }

     public void setValor(double valor) {
          this.valor = valor;
     }

     public Date getVencimento() {
          return vencimento;
     }

     public void setVencimento(Date vencimento) {
          this.vencimento = vencimento;
     }

     public double getFrete() {
          return frete;
     }

     public void setFrete(double frete) {
          this.frete = frete;
     }

     public String getEnvio() {
          return envio;
     }

     public void setEnvio(String envio) {
          this.envio = envio;
     }

     public Pessoa getPessoa() {
          return pessoa;
     }

     public void setPessoa(Pessoa pessoa) {
          this.pessoa = pessoa;
     }

     public EstadoVenda getEstadovenda() {
          return estadovenda;
     }

     public void setEstadovenda(EstadoVenda estadovenda) {
          this.estadovenda = estadovenda;
     }

     public int getParcela() {
          return parcela;
     }

     public void setParcela(int parcela) {
          this.parcela = parcela;
     }

     public int getCodvendedor() {
          return codvendedor;
     }

     public void setCodvendedor(int codvendedor) {
          this.codvendedor = codvendedor;
     }
}
