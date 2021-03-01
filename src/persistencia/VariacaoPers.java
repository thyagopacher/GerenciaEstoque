/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.Variacao;

/**
 *
 * @author Thyago
 */
public class VariacaoPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirVariacao(Conexao cx, Variacao p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updateVariacao(Conexao cx, Variacao p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirVariacao(Conexao cx, Variacao p){ 
        try{
            cx.conectar();
            String query = "delete from Variacao where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public Variacao procuraCodVariacao(Conexao cx, int codigo){
        cx.conectar();
        return (Variacao)cx.s.get(Variacao.class,codigo);
    }

    public Variacao procuraNomeExato(Conexao cx, String nome) {
        String query = "from Variacao where nome = '" + nome + "'";
        Variacao c     = new Variacao();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Variacao)it.next();
        } 
        cx.desconectar();
        return c;
    }    
   
    public List<Variacao> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from Variacao where nome like '%" + nome + "%' order by nome ASC";
        return cx.s.createQuery(query).list();
    }    

     public List<Variacao> procuraTodos(Conexao cx) {
        cx.conectar();
        String      query = "from Variacao";
        return cx.s.createQuery(query).list();
    }   
}
