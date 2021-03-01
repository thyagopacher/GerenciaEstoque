/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.VariacaoPers;
import vo.Variacao;

/**
 *
 * @author Thyago
 */
public class VariacaoRN {
   
    VariacaoPers pp = new VariacaoPers();
    
    public String valida(Variacao p){
         String msg = "";
         if(p != null){
              if(p.getNome() == null || p.getNome().isEmpty()){
                   msg += "\nNome em branco";
              }
         }else{
              msg += "\nVariacao veio nula";
         }
         return msg;
    }
    
    public String inserirVariacao(Conexao cx, Variacao p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.inserirVariacao(cx, p);
         }
    }
    
    public String updateVariacao(Conexao cx, Variacao p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.updateVariacao(cx, p);
         } 
    } 
    
    public String excluirVariacao(Conexao cx, Variacao p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.excluirVariacao(cx, p);
         } 
    }     
    
    public Variacao procuraCodVariacao(Conexao cx, int codigo){
        return pp.procuraCodVariacao(cx, codigo);
    }

    public Variacao procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);        
    }
   
    public List<Variacao> procuraNomeParcial(Conexao cx, String nome) {
        return pp.procuraNomeParcial(cx, nome);
    }       
  
    public List<Variacao> procuraTodos(Conexao cx){
        return pp.procuraTodos(cx);
    }      
  
}
