/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.CategoriaProduto;

/**
 *
 * @author Thyago
 */
public class CategoriaProdutoPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirCategoriaProduto(Conexao cx, CategoriaProduto p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updateCategoriaProduto(Conexao cx, CategoriaProduto p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirCategoriaProduto(Conexao cx, CategoriaProduto p){ 
        try{
            cx.conectar();
            String query = "delete from CategoriaProduto where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public CategoriaProduto procuraCodCategoriaProduto(Conexao cx, int codigo){
        cx.conectar();
        return (CategoriaProduto)cx.s.get(CategoriaProduto.class,codigo);
    }

    public CategoriaProduto procuraNomeExato(Conexao cx, String nome) {
        String query = "from CategoriaProduto where nome = '" + nome + "'";
        CategoriaProduto c     = new CategoriaProduto();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (CategoriaProduto)it.next();
        } 
        cx.desconectar();
        return c;
    }    
 
    public List<CategoriaProduto> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "select distinct cp from CategoriaProduto cp where cp.nome like '%" + nome + "%' order by cp.nome ASC";
        return cx.s.createQuery(query).list();
    }    
 
    public List<CategoriaProduto> procuraTodos(Conexao cx){
        cx.conectar();
        String       query = "select distinct cp from CategoriaProduto cp order by cp.nome ASC";
        return cx.s.createQuery(query).list();
    }    

}
