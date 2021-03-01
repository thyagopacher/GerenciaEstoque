/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.FormaPagamentoPers;
import vo.FormaPagamento;

/**
 *
 * @author Thyago
 */
public class FormaPagamentoRN {
   
    FormaPagamentoPers pp = new FormaPagamentoPers();
    
    public String valida(FormaPagamento f){
         String msg = "";
         if(f != null){
              if(f.getNome() == null || f.getNome().isEmpty()){
                   msg += "\nNome nulo";
              }
         }else{
              msg += "\nForma pagamento nulo";
         }
         return msg;
    }    
    
    public String inserirFormaPagamento(Conexao cx, FormaPagamento p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.inserirFormaPagamento(cx, p);
         }
    }
    
    public String updateFormaPagamento(Conexao cx, FormaPagamento p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.updateFormaPagamento(cx, p);
         }   
    } 
    
    public String excluirFormaPagamento(Conexao cx, FormaPagamento p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.excluirFormaPagamento(cx, p);
         }   
    }     
    
    public FormaPagamento procuraCodFormaPagamento(Conexao cx, int codigo){
        return pp.procuraCodFormaPagamento(cx, codigo);
    }

    public FormaPagamento procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);        
    }
 
    public List<FormaPagamento> procuraNomeParcial(Conexao cx, String nome) {
        return pp.procuraNomeParcial(cx, nome);
    }       
  
    public List<FormaPagamento> procuraTodos(Conexao cx) {
        return pp.procuraTodos(cx);
    }  
}
