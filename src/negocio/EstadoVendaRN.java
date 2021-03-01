/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.EstadoVendaPers;
import vo.EstadoVenda;

/**
 *
 * @author Thyago
 */
public class EstadoVendaRN {
   
    EstadoVendaPers pp = new EstadoVendaPers();
    
    public String valida(EstadoVenda e){
         String msg = "";
         if(e != null){
              if(e.getNome() == null || e.getNome().isEmpty()){
                   msg += "\nNome nulo";
              }
         }else{
              msg += "\nEstado Venda nulo";
         }
         return msg;
    }
    
    public String inserirEstadoVenda(Conexao cx, EstadoVenda p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.inserirEstadoVenda(cx, p);
         }
    }
    
    public String updateEstadoVenda(Conexao cx, EstadoVenda p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.updateEstadoVenda(cx, p);
         }
    } 
    
    public String excluirEstadoVenda(Conexao cx, EstadoVenda p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.excluirEstadoVenda(cx, p);
         }
    }     
    
    public EstadoVenda procuraCodEstadoVenda(Conexao cx, int codigo){
        return pp.procuraCodEstadoVenda(cx, codigo);
    }

    public EstadoVenda procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);       
    }
 
    public List<EstadoVenda> procuraNomeParcial(Conexao cx, String nome) {
        return pp.procuraNomeParcial(cx, nome);
    }
   
    public List<EstadoVenda> procuraTodos(Conexao cx){
        return pp.procuraTodos(cx);
    }      

}
