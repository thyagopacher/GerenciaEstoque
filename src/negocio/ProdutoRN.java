/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.ProdutoPers;
import vo.Produto;

/**
 *
 * @author Thyago
 */
public class ProdutoRN {
   
    ProdutoPers pp = new ProdutoPers();
    
    public String valida(Produto p){
         String msg = "";
         if(p != null){
              if(p.getNome() == null || p.getNome().isEmpty()){
                   msg += "\nNome nulo";
              }
              if(p.getPrecovenda() == 0){
                   msg += "\nPreço venda não pode ficar em branco ou zerado";
              }
              if(p.getFabrica() == null || p.getFabrica().getCodigo() == null){
                   msg += "\nFábrica nulo";
              }
         }else{
              msg += "\nProduto nulo";
         }
         return msg;
    }         
    
    public String inserirProduto(Conexao cx, Produto p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.inserirProduto(cx, p);
         }
    }
    
    public String updateProduto(Conexao cx, Produto p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.updateProduto(cx, p);
         }
    } 
    
    public String excluirProduto(Conexao cx, Produto p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.excluirProduto(cx, p);
         }
    }     
    
    public Produto procuraCodProduto(Conexao cx, int codigo){
        return pp.procuraCodProduto(cx, codigo);
    }
    
    public Produto procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);      
    }
 
    public List<Produto> procuraNomeParcial(Conexao cx, String nome) {
        return pp.procuraNomeParcial(cx, nome); 
    }       
 
    public List<Produto> procuraTodos(Conexao cx){
        return pp.procuraTodos(cx);
    }      

     public Produto procuraCodigoBarra(Conexao cx, String codigo) {
          return pp.procuraCodigoBarra(cx, codigo);
     }

}
