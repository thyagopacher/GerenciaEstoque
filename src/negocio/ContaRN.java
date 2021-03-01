/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.ContaPers;
import vo.Conta;

/**
 *
 * @author Thyago
 */
public class ContaRN {
   
    ContaPers pp = new ContaPers();
    
    public String valida(Conta c){
         String msg = "";
         if(c != null){
              if(c.getTipo() == null || c.getTipo().isEmpty()){
                   msg += "\nTipo de Conta nulo";
              }
              if(c.getEstado() == null || c.getEstado().isEmpty()){
                   msg += "\nEstado da conta nulo";
              }
              if(c.getValor() == 0){
                   msg += "\nValor zerado";
              }
              if(c.getVencimento() == null){
                   msg += "\nData de vencimento em branco";
              }
         }else{
              msg += "\nTipo de pessoa nulo";
         }
         return msg;
    }         
    
    public String inserirConta(Conexao cx, Conta p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.inserirConta(cx, p);
         }
    }
    
    public String updateConta(Conexao cx, Conta p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.updateConta(cx, p);
         }
    } 
    
    public String excluirConta(Conexao cx, Conta p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.excluirConta(cx, p);
         }
    }     
    
    public Conta procuraCodConta(Conexao cx, int codigo){
        return pp.procuraCodConta(cx, codigo);
    }

    public Conta procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);       
    }
 
    public List<Conta> procuraNomeParcial(Conexao cx, String nome) {
        return pp.procuraNomeParcial(cx, nome);
    }
   
    public List<Conta> procuraEstado(Conexao cx, String estado) {
        return pp.procuraEstado(cx, estado);
    }
    
    public List<Conta> procuraTodos(Conexao cx){
        return pp.procuraTodos(cx);
    }      
 

}
