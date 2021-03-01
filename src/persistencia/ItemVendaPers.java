/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.ItemVenda;

/**
 *
 * @author Thyago
 */
public class ItemVendaPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirItemVenda(Conexao cx, ItemVenda p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updateItemVenda(Conexao cx, ItemVenda p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirItemVenda(Conexao cx, ItemVenda p){ 
        try{
            cx.conectar();
            String query = "delete from ItemVenda where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public ItemVenda procuraCodItemVenda(Conexao cx, int codigo){
        cx.conectar();
        return (ItemVenda)cx.s.get(ItemVenda.class,codigo);
    }

    public ItemVenda procuraNomeExato(Conexao cx, String nome) {
        String query = "from ItemVenda where produto.nome = '" + nome + "'";
        ItemVenda c     = new ItemVenda();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (ItemVenda)it.next();
        } 
        cx.desconectar();
        return c;
    }    
 
    public List<ItemVenda> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from ItemVenda where produto.nome like '%" + nome + "%' order by produto.nome ASC";
        return cx.s.createQuery(query).list();
    }    

    public List<ItemVenda> procuraTodos(Conexao cx){
        cx.conectar();
        String       query = "from ItemVenda  order by produto.nome ASC";
        return cx.s.createQuery(query).list();
    }    

     public List<ItemVenda> procuraVenda(Conexao cx, Integer codigo) {
        cx.conectar();
        String       query = "from ItemVenda where venda.codigo = '" + codigo + "'";
        return cx.s.createQuery(query).list();
     }

}
