/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.EstadoVenda;

/**
 *
 * @author Thyago
 */
public class EstadoVendaPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirEstadoVenda(Conexao cx, EstadoVenda p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updateEstadoVenda(Conexao cx, EstadoVenda p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirEstadoVenda(Conexao cx, EstadoVenda p){ 
        try{
            cx.conectar();
            String query = "delete from EstadoVenda where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public EstadoVenda procuraCodEstadoVenda(Conexao cx, int codigo){
        cx.conectar();
        return (EstadoVenda)cx.s.get(EstadoVenda.class,codigo);
    }

    public EstadoVenda procuraNomeExato(Conexao cx, String nome) {
        String query = "from EstadoVenda where nome = '" + nome + "'";
        EstadoVenda c     = new EstadoVenda();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (EstadoVenda)it.next();
        } 
        cx.desconectar();
        return c;
    }    
 
    public List<EstadoVenda> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from EstadoVenda where nome like '%" + nome + "%' order by nome ASC";
        return cx.s.createQuery(query).list();
    }    

    public List<EstadoVenda> procuraTodos(Conexao cx){
        cx.conectar();
        String       query = "from EstadoVenda  order by nome ASC";
        return cx.s.createQuery(query).list();
    }    

}
