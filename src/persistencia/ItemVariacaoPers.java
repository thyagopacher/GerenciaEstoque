/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.ItemVariacao;

/**
 *
 * @author Thyago
 */
public class ItemVariacaoPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirItemVariacao(Conexao cx, ItemVariacao p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updateItemVariacao(Conexao cx, ItemVariacao p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirItemVariacao(Conexao cx, ItemVariacao p){ 
        try{
            cx.conectar();
            String query = "delete from ItemVariacao where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public ItemVariacao procuraCodItemVariacao(Conexao cx, int codigo){
        cx.conectar();
        return (ItemVariacao)cx.s.get(ItemVariacao.class,codigo);
    }

    public ItemVariacao procuraNomeExato(Conexao cx, String nome) {
        String query = "from ItemVariacao where nome = '" + nome + "'";
        ItemVariacao c     = new ItemVariacao();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (ItemVariacao)it.next();
        } 
        cx.desconectar();
        return c;
    }    
   
    public List<ItemVariacao> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from ItemVariacao where nome like '%" + nome + "%' order by nome ASC";
        return cx.s.createQuery(query).list();
    }    

     public List<ItemVariacao> procuraTodos(Conexao cx) {
        cx.conectar();
        String      query = "from ItemVariacao";
        return cx.s.createQuery(query).list();
    }   

     public List<ItemVariacao> procuraVariacao(Conexao cx, Integer codigo) {
        cx.conectar();
        String      query = "from ItemVariacao where variacao.codigo = '" + codigo + "'";
        return cx.s.createQuery(query).list();
     }
}
