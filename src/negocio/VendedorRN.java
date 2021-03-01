/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.VendedorPers;
import vo.Vendedor;

/**
 *
 * @author Thyago
 */
public class VendedorRN {
   
    VendedorPers pp = new VendedorPers();
    
    public String valida(Vendedor p){
         String msg = "";
         if(p != null){
              if(p.getNome() == null || p.getNome().isEmpty()){
                   msg += "\nNome em branco";
              }
              if(p.getTelefone() == null || p.getTelefone().isEmpty()){
                   msg += "\nTelefone em branco";
              }
         }else{
              msg += "\nVendedor veio nula";
         }
         return msg;
    }
    
    public String inserirVendedor(Conexao cx, Vendedor p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.inserirVendedor(cx, p);
         }
    }
    
    public String updateVendedor(Conexao cx, Vendedor p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.updateVendedor(cx, p);
         } 
    } 
    
    public String excluirVendedor(Conexao cx, Vendedor p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.excluirVendedor(cx, p);
         } 
    }     
    
    public Vendedor procuraCodVendedor(Conexao cx, int codigo){
        return pp.procuraCodVendedor(cx, codigo);
    }

    public Vendedor procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);        
    }
   
    public List<Vendedor> procuraNomeParcial(Conexao cx, String nome) {
        return pp.procuraNomeParcial(cx, nome);
    }       
  
    public List<Vendedor> procuraTodos(Conexao cx){
        return pp.procuraTodos(cx);
    }      
  
}
