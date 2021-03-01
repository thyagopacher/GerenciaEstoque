/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.RegiaoPers;
import vo.Regiao;

/**
 *
 * @author Thyago
 */
public class RegiaoRN {
   
    RegiaoPers pp = new RegiaoPers();
    
    public String valida(Regiao r){
         String msg = "";
         if(r != null){
              if(r.getNome() == null || r.getNome().isEmpty()){
                   msg += "\nNome nulo";
              }
         }else{
              msg += "\nRegião nulo";
         }
         return msg;
    }         
    
    public String inserirRegiao(Conexao cx, Regiao p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.inserirRegiao(cx, p);
         }
    }
    
    public String updateRegiao(Conexao cx, Regiao p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.updateRegiao(cx, p);
         }  
    } 
    
    public String excluirRegiao(Conexao cx, Regiao p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.excluirRegiao(cx, p);
         }
    }     
    
    public Regiao procuraCodRegiao(Conexao cx, int codigo){
        return pp.procuraCodRegiao(cx, codigo);
    }

    public Regiao procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);       
    }
 
    public List<Regiao> procuraNomeParcial(Conexao cx, String nome) {
        return pp.procuraNomeParcial(cx, nome);
    }
   
    public List<Regiao> procuraTodos(Conexao cx){
        return pp.procuraTodos(cx);
    }      

}
