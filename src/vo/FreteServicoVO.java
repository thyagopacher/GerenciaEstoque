/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author ThyagoHenrique
 */
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("cServico")
public class FreteServicoVO {
     
     @XStreamAlias("Codigo")
     private int codigo;
     
     @XStreamAlias("Valor")
     private String valor;
     
     @XStreamAlias("PrazoEntrega")
     private int prazoEntrega;
     
     @XStreamAlias("ValorMaoPropria")
     private String valorMaoPropria;
     
     @XStreamAlias("ValorAvisoRecebimento")
     private String valorAvisoRecebimento;
     
     @XStreamAlias("ValorValorDeclarado")
     private String valorValorDeclarado;
     
     @XStreamAlias("EntregaDomiciliar")
     private String entregaDomiciliar;
     
     @XStreamAlias("EntregaSabado")
     private String entregaSabado;     
     
     @XStreamAlias("Erro")
     private int erro;
     
     @XStreamAlias("MsgErro")
     private String msgErro;     

     public int getCodigo() {
          return codigo;
     }

     public void setCodigo(int codigo) {
          this.codigo = codigo;
     }

     public String getValor() {
          return valor;
     }

     public void setValor(String valor) {
          this.valor = valor;
     }

     public int getPrazoEntrega() {
          return prazoEntrega;
     }

     public void setPrazoEntrega(int prazoEntrega) {
          this.prazoEntrega = prazoEntrega;
     }

     public String getValorMaoPropria() {
          return valorMaoPropria;
     }

     public void setValorMaoPropria(String valorMaoPropria) {
          this.valorMaoPropria = valorMaoPropria;
     }

     public String getValorAvisoRecebimento() {
          return valorAvisoRecebimento;
     }

     public void setValorAvisoRecebimento(String valorAvisoRecebimento) {
          this.valorAvisoRecebimento = valorAvisoRecebimento;
     }

     public String getValorValorDeclarado() {
          return valorValorDeclarado;
     }

     public void setValorValorDeclarado(String valorValorDeclarado) {
          this.valorValorDeclarado = valorValorDeclarado;
     }

     public String getEntregaDomiciliar() {
          return entregaDomiciliar;
     }

     public void setEntregaDomiciliar(String entregaDomiciliar) {
          this.entregaDomiciliar = entregaDomiciliar;
     }

     public String getEntregaSabado() {
          return entregaSabado;
     }

     public void setEntregaSabado(String entregaSabado) {
          this.entregaSabado = entregaSabado;
     }

     public int getErro() {
          return erro;
     }

     public void setErro(int erro) {
          this.erro = erro;
     }

     public String getMsgErro() {
          return msgErro;
     }

     public void setMsgErro(String msgErro) {
          this.msgErro = msgErro;
     }
}
