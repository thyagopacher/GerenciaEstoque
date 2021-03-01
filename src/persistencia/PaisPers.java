/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.Pais;

/**
 *
 * @author Thyago
 */
public class PaisPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirPais(Conexao cx, Pais p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updatePais(Conexao cx, Pais p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirPais(Conexao cx, Pais p){ 
        try{
            cx.conectar();
            String query = "delete from Pais where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public Pais procuraCodPais(Conexao cx, int codigo){
        cx.conectar();
        return (Pais)cx.s.get(Pais.class,codigo);
    }

    public Pais procuraNomeExato(Conexao cx, String nome) {
        String query = "from Pais where nome = '" + nome + "'";
        Pais c     = new Pais();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Pais)it.next();
        } 
        cx.desconectar();
        return c;
    }    
 
    public List<Pais> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from Pais where nome like '%" + nome + "%' order by nome ASC";
        return cx.s.createQuery(query).list();
    }    

    public List<Pais> procuraTodos(Conexao cx){
        cx.conectar();
        String       query = "from Pais  order by nome ASC";
        return cx.s.createQuery(query).list();
    }    

}
