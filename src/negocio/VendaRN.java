/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.VendaPers;
import vo.Venda;

/**
 *
 * @author Thyago
 */
public class VendaRN {
   
    VendaPers pp = new VendaPers();
    
    public String valida(Venda v){
         String msg = "";
         if(v != null){
              if(v.getPessoa() == null || v.getPessoa().getNome() == null){
                   msg += "\nCliente nulo";
              }
              if(v.getData() == null){
                   msg += "\nData nulo";
              }
              if(v.getValor() == 0){
                   msg += "\nValor zerado";
              }
         }else{
              msg += "\nVenda nulo";
         }
         return msg;
    }      
    
    public String inserirVenda(Conexao cx, Venda p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.inserirVenda(cx, p);
         }
    }
    
    public String updateVenda(Conexao cx, Venda p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.updateVenda(cx, p);
         } 
    } 
    
    public String excluirVenda(Conexao cx, Venda p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.excluirVenda(cx, p);
         } 
    }     
    
    public Venda procuraCodVenda(Conexao cx, int codigo){
        return pp.procuraCodVenda(cx, codigo);
    }

    public Venda procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);        
    }
 
    public List<Venda> procuraNomeParcial(Conexao cx, String nome) {
        return pp.procuraNomeParcial(cx, nome);  
    }       
  
    public List<Venda> procuraTodos(Conexao cx) {
        return pp.procuraTodos(cx);  
    }    
    
    public List<Venda> procuraEstado(Conexao cx, String nome) {
        return pp.procuraEstado(cx, nome);  
    }      
    
    public List<Venda> procuraVendasIncompletas(Conexao cx) {
        return pp.procuraVendasIncompletas(cx);  
    }          
}
