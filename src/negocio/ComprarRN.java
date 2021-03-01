/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.ComprarPers;
import persistencia.Conexao;
import vo.Comprar;

/**
 *
 * @author Thyago
 */
public class ComprarRN {
   
    ComprarPers pp = new ComprarPers();
    
    public String valida(Comprar c){
         String msg = "";
         if(c != null){
              if(c.getData() == null){
                   msg += "Data da compra em nulo\n";
              }
              if(c.getPessoa() == null || c.getPessoa().getNome() == null){
                   msg += "Fornecedor da compra nulo\n";
              }
              if(c.getValor() == null){
                   msg += "Valor da compra em nulo\n";
              }
              if(c.getVencimento() == null){
                   msg += "Vencimento da compra em nulo\n";
              }
         }
         return msg;
    }
    
    public String inserirComprar(Conexao cx, Comprar p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.inserirComprar(cx, p);
         }
    }
    
    public String updateComprar(Conexao cx, Comprar p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.updateComprar(cx, p);
         }
    } 
    
    public String excluirComprar(Conexao cx, Comprar p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.excluirComprar(cx, p);
         }
    }     
    
    public Comprar procuraCodComprar(Conexao cx, int codigo){
        return pp.procuraCodComprar(cx, codigo);
    }
    
    public Comprar procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);       
    }
 
    public List<Comprar> procuraNomeParcial(Conexao cx, String nome) {
        return pp.procuraNomeParcial(cx, nome);
    }       

    public List<Comprar> procuraTodos(Conexao cx){
        return pp.procuraTodos(cx);
    }      

}
