/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.ItemCompra;

/**
 *
 * @author Thyago
 */
public class ItemCompraPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirItemCompra(Conexao cx, ItemCompra p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updateItemCompra(Conexao cx, ItemCompra p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirItemCompra(Conexao cx, ItemCompra p){ 
        try{
            cx.conectar();
            String query = "delete from ItemCompra where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public ItemCompra procuraCodItemCompra(Conexao cx, int codigo){
        cx.conectar();
        return (ItemCompra)cx.s.get(ItemCompra.class,codigo);
    }

    public ItemCompra procuraNomeExato(Conexao cx, String nome) {
        String query = "from ItemCompra where produto.nome = '" + nome + "'";
        ItemCompra c     = new ItemCompra();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (ItemCompra)it.next();
        } 
        cx.desconectar();
        return c;
    }    
 
    public List<ItemCompra> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from ItemCompra where produto.nome like '%" + nome + "%' order by produto.nome ASC";
        return cx.s.createQuery(query).list();
    }    

    public List<ItemCompra> procuraTodos(Conexao cx){
        cx.conectar();
        String       query = "from ItemCompra  order by produto.nome ASC";
        return cx.s.createQuery(query).list();
    }    

}
