/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.Regiao;

/**
 *
 * @author Thyago
 */
public class RegiaoPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirRegiao(Conexao cx, Regiao p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updateRegiao(Conexao cx, Regiao p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirRegiao(Conexao cx, Regiao p){ 
        try{
            cx.conectar();
            String query = "delete from Regiao where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public Regiao procuraCodRegiao(Conexao cx, int codigo){
        cx.conectar();
        return (Regiao)cx.s.get(Regiao.class,codigo);
    }

    public Regiao procuraNomeExato(Conexao cx, String nome) {
        String query = "from Regiao where nome = '" + nome + "'";
        Regiao c     = new Regiao();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Regiao)it.next();
        } 
        cx.desconectar();
        return c;
    }    
 
    public List<Regiao> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from Regiao where nome like '%" + nome + "%' order by nome ASC";
        return cx.s.createQuery(query).list();
    }    

    public List<Regiao> procuraTodos(Conexao cx){
        cx.conectar();
        String       query = "from Regiao  order by nome ASC";
        return cx.s.createQuery(query).list();
    }    

}
