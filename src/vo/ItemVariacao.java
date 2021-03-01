/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author ThyagoHenrique
 */
public class ItemVariacao {
     
     private Integer codigo;
     private String nome;
     private String valor;
     private Variacao variacao;
     private int ordem_nome;
     private int ordem_valor;
     
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

     public String getValor() {
          return valor;
     }

     public void setValor(String valor) {
          this.valor = valor;
     }

     public int getOrdem_nome() {
          return ordem_nome;
     }

     public void setOrdem_nome(int ordem_nome) {
          this.ordem_nome = ordem_nome;
     }

     public int getOrdem_valor() {
          return ordem_valor;
     }

     public void setOrdem_valor(int ordem_valor) {
          this.ordem_valor = ordem_valor;
     }

     public Variacao getVariacao() {
          return variacao;
     }

     public void setVariacao(Variacao variacao) {
          this.variacao = variacao;
     }

   
}
