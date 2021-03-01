/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.DescontoPers;
import vo.Desconto;

/**
 *
 * @author Thyago
 */
public class DescontoRN {
   
    DescontoPers pp = new DescontoPers();
    
    public String valida(Desconto p){
         String msg = "";
         if(p != null){
              if(p.getProduto() == null){
                   msg += "\nProduto nulo";
              }
              if(String.valueOf(p.getValor()) == null){
                   msg += "\nValor nulo";
              }
         }else{
              msg += "\nDesconto nulo";
         }
         return msg;
    }         
    
    public String inserirDesconto(Conexao cx, Desconto p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.inserirDesconto(cx, p);
         }
    }
    
    public String updateDesconto(Conexao cx, Desconto p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.updateDesconto(cx, p);
         }
    } 
    
    public String excluirDesconto(Conexao cx, Desconto p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.excluirDesconto(cx, p);
         }
    }     
    
    public Desconto procuraCodDesconto(Conexao cx, int codigo){
        return pp.procuraCodDesconto(cx, codigo);
    }
    
    public Desconto procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);      
    }
 
    public List<Desconto> procuraNomeParcial(Conexao cx, String nome) {
        return pp.procuraNomeParcial(cx, nome); 
    }       
 
    public List<Desconto> procuraTodos(Conexao cx){
        return pp.procuraTodos(cx);
    }      

     public Desconto procuraCodProduto(Conexao cx, Integer codigo) {
          return pp.procuraCodProduto(cx, codigo);
     }

}
