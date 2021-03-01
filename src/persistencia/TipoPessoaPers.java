/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.TipoPessoa;

/**
 *
 * @author Thyago
 */
public class TipoPessoaPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirTipoPessoa(Conexao cx, TipoPessoa p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updateTipoPessoa(Conexao cx, TipoPessoa p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirTipoPessoa(Conexao cx, TipoPessoa p){ 
        try{
            cx.conectar();
            String query = "delete from TipoPessoa where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public TipoPessoa procuraCodTipoPessoa(Conexao cx, int codigo){
        cx.conectar();
        return (TipoPessoa)cx.s.get(TipoPessoa.class,codigo);
    }

    public TipoPessoa procuraNomeExato(Conexao cx, String nome) {
        String query = "from TipoPessoa where nome = '" + nome + "'";
        TipoPessoa c     = new TipoPessoa();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (TipoPessoa)it.next();
        } 
        cx.desconectar();
        return c;
    }    
    
    public List<TipoPessoa> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from TipoPessoa where nome like '%" + nome + "%' order by nome ASC";
        return cx.s.createQuery(query).list();
    }    
 
    public List<TipoPessoa> procuraTodos(Conexao cx){
        cx.conectar();
        String       query = "from TipoPessoa  order by nome ASC";
        return cx.s.createQuery(query).list();
    }    

}
