/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.Estado;

/**
 *
 * @author Thyago
 */
public class EstadoPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirEstado(Conexao cx, Estado p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updateEstado(Conexao cx, Estado p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirEstado(Conexao cx, Estado p){ 
        try{
            cx.conectar();
            String query = "delete from Estado where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public Estado procuraCodEstado(Conexao cx, int codigo){
        cx.conectar();
        return (Estado)cx.s.get(Estado.class,codigo);
    }

    public Estado procuraNomeExato(Conexao cx, String nome) {
        String query = "from Estado where nome = '" + nome + "'";
        Estado c     = new Estado();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Estado)it.next();
        } 
        cx.desconectar();
        return c;
    }    
 
     public Estado procuraSigla(Conexao cx, String uf) {
        String query = "from Estado where sigla = '" + uf + "'";
        Estado c     = new Estado();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Estado)it.next();
        } 
        cx.desconectar();
        return c;
     }    
    
    public List<Estado> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from Estado where nome like '%" + nome + "%' order by nome ASC";
        return cx.s.createQuery(query).list();
    }    

    public List<Estado> procuraTodos(Conexao cx){
        cx.conectar();
        String       query = "from Estado  order by nome ASC";
        return cx.s.createQuery(query).list();
    }    

}
