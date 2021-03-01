/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.Conta;

/**
 *
 * @author Thyago
 */
public class ContaPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirConta(Conexao cx, Conta p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updateConta(Conexao cx, Conta p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirConta(Conexao cx, Conta p){ 
        try{
            cx.conectar();
            String query = "delete from Conta where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public Conta procuraCodConta(Conexao cx, int codigo){
        cx.conectar();
        return (Conta)cx.s.get(Conta.class,codigo);
    }

    public Conta procuraNomeExato(Conexao cx, String nome) {
        String query = "from Conta where tipo = '" + nome + "'";
        Conta c     = new Conta();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Conta)it.next();
        } 
        cx.desconectar();
        return c;
    }    
 
    public List<Conta> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from Conta where tipo like '%" + nome + "%' order by tipo ASC";
        return cx.s.createQuery(query).list();
    }    

    public List<Conta> procuraTodos(Conexao cx){
        cx.conectar();
        String       query = "from Conta order by tipo ASC";
        return cx.s.createQuery(query).list();
    }    

     public List<Conta> procuraEstado(Conexao cx, String estado) {
        cx.conectar();
        String      query = "from Conta where estado = '" + estado + "' order by tipo ASC";
        return cx.s.createQuery(query).list();
     }

}
