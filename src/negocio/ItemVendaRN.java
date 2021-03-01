/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.ItemVendaPers;
import vo.ItemVenda;

/**
 *
 * @author Thyago
 */
public class ItemVendaRN {
   
    ItemVendaPers pp = new ItemVendaPers();
    
    public String valida(ItemVenda e){
         String msg = "";
         if(e != null){
              if(e.getProduto() == null || e.getProduto().getNome() == null){
                   msg += "\nProduto nulo";
              }
              if(e.getVenda() == null || e.getVenda().getCodigo() == null){
                   msg += "\nVenda nulo";
              }
         }else{
              msg += "\nItem Venda nulo";
         }
         return msg;
    }
    
    public String inserirItemVenda(Conexao cx, ItemVenda p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.inserirItemVenda(cx, p);
         }
    }
    
    public String updateItemVenda(Conexao cx, ItemVenda p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.updateItemVenda(cx, p);
         }
    } 
    
    public String excluirItemVenda(Conexao cx, ItemVenda p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.excluirItemVenda(cx, p);
         }
    }     
    
    public ItemVenda procuraCodItemVenda(Conexao cx, int codigo){
        return pp.procuraCodItemVenda(cx, codigo);
    }

    public ItemVenda procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);       
    }
 
    public List<ItemVenda> procuraNomeParcial(Conexao cx, String nome) {
        return pp.procuraNomeParcial(cx, nome);
    }
   
    public List<ItemVenda> procuraTodos(Conexao cx){
        return pp.procuraTodos(cx);
    }      

     public List<ItemVenda> procuraVenda(Conexao cx, Integer codigo) {
          return pp.procuraVenda(cx, codigo);
     }

}
