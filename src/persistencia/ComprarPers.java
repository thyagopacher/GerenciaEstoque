/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.Comprar;

/**
 *
 * @author Thyago
 */
public class ComprarPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirComprar(Conexao cx, Comprar p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updateComprar(Conexao cx, Comprar p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirComprar(Conexao cx, Comprar p){ 
        try{
            cx.conectar();
            String query = "delete from Comprar where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public Comprar procuraCodComprar(Conexao cx, int codigo){
        cx.conectar();
        return (Comprar)cx.s.get(Comprar.class,codigo);
    }

    public Comprar procuraNomeExato(Conexao cx, String nome) {
        String query = "from Comprar where pessoa.nome = '" + nome + "'";
        Comprar c     = new Comprar();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Comprar)it.next();
        } 
        cx.desconectar();
        return c;
    }    

    public List<Comprar> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from Comprar where pessoa.nome like '%" + nome + "%' order by pessoa.nome ASC";
        return cx.s.createQuery(query).list();
    }    
  
    public List<Comprar> procuraTodos(Conexao cx) {
        cx.conectar();
        String      query = "from Comprar order by pessoa.nome asc";
        return cx.s.createQuery(query).list();
    }        
    
}
