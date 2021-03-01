/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.EstadoPers;
import vo.Estado;

/**
 *
 * @author Thyago
 */
public class EstadoRN {
   
    EstadoPers pp = new EstadoPers();
    
    public String valida(Estado e){
         String msg = "";
         if(e != null){
              if(e.getNome() == null || e.getNome().isEmpty()){
                   msg += "\nNome nulo";
              }
              if(e.getPais() == null || e.getPais().getNome() == null){
                   msg += "\nPaís nulo";
              }
         }else{
              msg += "\nEstado nulo";
         }
         return msg;
    }
    
    public String inserirEstado(Conexao cx, Estado p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.inserirEstado(cx, p);
         }
    }
    
    public String updateEstado(Conexao cx, Estado p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.updateEstado(cx, p);
         }
    } 
    
    public String excluirEstado(Conexao cx, Estado p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.excluirEstado(cx, p);
         }
    }     
    
    public Estado procuraCodEstado(Conexao cx, int codigo){
        return pp.procuraCodEstado(cx, codigo);
    }

    public Estado procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);       
    }
 
    public List<Estado> procuraNomeParcial(Conexao cx, String nome) {
        return pp.procuraNomeParcial(cx, nome);
    }
   
    public List<Estado> procuraTodos(Conexao cx){
        return pp.procuraTodos(cx);
    }      

     public Estado procuraSigla(Conexao cx, String uf) {
          return pp.procuraSigla(cx, uf);
     }
    
    
}
