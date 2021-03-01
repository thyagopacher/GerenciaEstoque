/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.Produto;

/**
 *
 * @author Thyago
 */
public class ProdutoPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirProduto(Conexao cx, Produto p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updateProduto(Conexao cx, Produto p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirProduto(Conexao cx, Produto p){ 
        try{
            cx.conectar();
            String query = "delete from Produto where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public Produto procuraCodProduto(Conexao cx, int codigo){
        cx.conectar();
        return (Produto)cx.s.get(Produto.class,codigo);
    }

    public Produto procuraNomeExato(Conexao cx, String nome) {
        String query = "from Produto where nome = '" + nome + "'";
        Produto c     = new Produto();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Produto)it.next();
        } 
        cx.desconectar();
        return c;
    }    
 
    public List<Produto> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from Produto where nome like '%" + nome + "%' order by nome ASC";
        return cx.s.createQuery(query).list();
    }    
   
    public List<Produto> procuraTodos(Conexao cx) {
        cx.conectar();
        String      query = "from Produto";
        return cx.s.createQuery(query).list();
    } 

     public Produto procuraCodigoBarra(Conexao cx, String codigo) {
        String query = "from Produto where codigobarra = '" + codigo + "'";
        Produto c     = new Produto();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Produto)it.next();
        } 
        cx.desconectar();
        return c;
     }
    
}
