/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.ItemCompraPers;
import vo.ItemCompra;

/**
 *
 * @author Thyago
 */
public class ItemCompraRN {
   
    ItemCompraPers pp = new ItemCompraPers();
    
    public String valida(ItemCompra e){
         String msg = "";
         if(e != null){
              if(e.getProduto() == null || e.getProduto().getNome() == null){
                   msg += "\nProduto nulo";
              }
              if(e.getComprar() == null || e.getComprar().getCodigo() == null){
                   msg += "\nCompra nulo";
              }
         }else{
              msg += "\nItem Venda nulo";
         }
         return msg;
    }
    
    public String inserirItemCompra(Conexao cx, ItemCompra p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.inserirItemCompra(cx, p);
         }
    }
    
    public String updateItemCompra(Conexao cx, ItemCompra p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.updateItemCompra(cx, p);
         }
    } 
    
    public String excluirItemCompra(Conexao cx, ItemCompra p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.excluirItemCompra(cx, p);
         }
    }     
    
    public ItemCompra procuraCodItemCompra(Conexao cx, int codigo){
        return pp.procuraCodItemCompra(cx, codigo);
    }

    public ItemCompra procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);       
    }
 
    public List<ItemCompra> procuraNomeParcial(Conexao cx, String nome) {
        return pp.procuraNomeParcial(cx, nome);
    }
   
    public List<ItemCompra> procuraTodos(Conexao cx){
        return pp.procuraTodos(cx);
    }      

}
