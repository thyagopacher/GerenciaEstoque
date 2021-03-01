/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.ItemVariacaoPers;
import vo.ItemVariacao;

/**
 *
 * @author Thyago
 */
public class ItemVariacaoRN {
   
    ItemVariacaoPers pp = new ItemVariacaoPers();
    
    public String valida(ItemVariacao p){
         String msg = "";
         if(p != null){
              if(p.getNome() == null || p.getNome().isEmpty()){
                   msg += "\nNome em branco";
              }
         }else{
              msg += "\nItemVariacao veio nula";
         }
         return msg;
    }
    
    public String inserirItemVariacao(Conexao cx, ItemVariacao p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.inserirItemVariacao(cx, p);
         }
    }
    
    public String updateItemVariacao(Conexao cx, ItemVariacao p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.updateItemVariacao(cx, p);
         } 
    } 
    
    public String excluirItemVariacao(Conexao cx, ItemVariacao p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.excluirItemVariacao(cx, p);
         } 
    }     
    
    public ItemVariacao procuraCodItemVariacao(Conexao cx, int codigo){
        return pp.procuraCodItemVariacao(cx, codigo);
    }

    public ItemVariacao procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);        
    }
   
    public List<ItemVariacao> procuraNomeParcial(Conexao cx, String nome) {
        return pp.procuraNomeParcial(cx, nome);
    }       
  
    public List<ItemVariacao> procuraTodos(Conexao cx){
        return pp.procuraTodos(cx);
    }      

     public List<ItemVariacao> procuraVariacao(Conexao cx, Integer codigo) {
          return pp.procuraVariacao(cx, codigo);
     }
  
}
