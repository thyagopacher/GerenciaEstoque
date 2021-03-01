/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.Loja;

/**
 *
 * @author Thyago
 */
public class LojaPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirLoja(Conexao cx, Loja p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updateLoja(Conexao cx, Loja p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirLoja(Conexao cx, Loja p){ 
        try{
            cx.conectar();
            String query = "delete from Loja where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public Loja procuraCodLoja(Conexao cx, int codigo){
        cx.conectar();
        return (Loja)cx.s.get(Loja.class,codigo);
    }

    public Loja procuraNomeExato(Conexao cx, String nome) {
        String query = "from Loja where site = '" + nome + "'";
        Loja c     = new Loja();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Loja)it.next();
        } 
        cx.desconectar();
        return c;
    }    
 
    public List<Loja> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from Loja where site like '%" + nome + "%' order by codigo ASC";
        return cx.s.createQuery(query).list();
    }    
 
    public List<Loja> procuraTodos(Conexao cx){
        cx.conectar();
        String       query = "from Loja  order by codigo ASC";
        return cx.s.createQuery(query).list();
    }    

}
