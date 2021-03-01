/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.TipoPessoaPers;
import vo.TipoPessoa;

/**
 *
 * @author Thyago
 */
public class TipoPessoaRN {
   
    TipoPessoaPers pp = new TipoPessoaPers();
    
    public String valida(TipoPessoa tp){
         String msg = "";
         if(tp != null){
              if(tp.getNome() == null || tp.getNome().isEmpty()){
                   msg += "\nNome nulo";
              }
         }else{
              msg += "\nTipo de pessoa nulo";
         }
         return msg;
    }     
    
    public String inserirTipoPessoa(Conexao cx, TipoPessoa p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.inserirTipoPessoa(cx, p);
         }
    }
    
    public String updateTipoPessoa(Conexao cx, TipoPessoa p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.updateTipoPessoa(cx, p);
         }     
    } 
    
    public String excluirTipoPessoa(Conexao cx, TipoPessoa p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.excluirTipoPessoa(cx, p);
         }    
    }     
    
    public TipoPessoa procuraCodTipoPessoa(Conexao cx, int codigo){
        return pp.procuraCodTipoPessoa(cx, codigo);
    }
    
    public TipoPessoa procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);       
    }
 
    public List<TipoPessoa> procuraNomeParcial(Conexao cx, String nome) {
        return pp.procuraNomeParcial(cx, nome); 
    }       
    
    public List<TipoPessoa> procuraTodos(Conexao cx){
        return pp.procuraTodos(cx);
    }      
 
}
