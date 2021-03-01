/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.PaisPers;
import vo.Pais;

/**
 *
 * @author Thyago
 */
public class PaisRN {
   
    PaisPers pp = new PaisPers();
    
    public String valida(Pais p){
         String msg = "";
         if(p != null){
              if(p.getNome() == null || p.getNome().isEmpty()){
                   msg += "\nNome nulo";
              }
              if(p.getRegiao() == null || p.getRegiao().getNome() == null){
                   msg += "\nRegião nulo";
              }
         }else{
              msg += "\nPaís nulo";
         }
         return msg;
    }     
    
    public String inserirPais(Conexao cx, Pais p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.inserirPais(cx, p);
         }
    }
    
    public String updatePais(Conexao cx, Pais p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.updatePais(cx, p);
         }   
    } 
    
    public String excluirPais(Conexao cx, Pais p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.excluirPais(cx, p);
         }   
    }     
    
    public Pais procuraCodPais(Conexao cx, int codigo){
        return pp.procuraCodPais(cx, codigo);
    }

    public Pais procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);       
    }
 
    public List<Pais> procuraNomeParcial(Conexao cx, String nome) {
        return pp.procuraNomeParcial(cx, nome);
    }
   
    public List<Pais> procuraTodos(Conexao cx){
        return pp.procuraTodos(cx);
    }      

}
