/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.Desconto;

/**
 *
 * @author Thyago
 */
public class DescontoPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirDesconto(Conexao cx, Desconto p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updateDesconto(Conexao cx, Desconto p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirDesconto(Conexao cx, Desconto p){ 
        try{
            cx.conectar();
            String query = "delete from Desconto where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public Desconto procuraCodDesconto(Conexao cx, int codigo){
        cx.conectar();
        return (Desconto)cx.s.get(Desconto.class,codigo);
    }

    public Desconto procuraNomeExato(Conexao cx, String nome) {
        String query = "from Desconto where nome = '" + nome + "'";
        Desconto c     = new Desconto();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Desconto)it.next();
        } 
        cx.desconectar();
        return c;
    }    
 
    public List<Desconto> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from Desconto where nome like '%" + nome + "%' order by nome ASC";
        return cx.s.createQuery(query).list();
    }    
   
    public List<Desconto> procuraTodos(Conexao cx) {
        cx.conectar();
        String      query = "from Desconto";
        return cx.s.createQuery(query).list();
    } 

     public Desconto procuraCodProduto(Conexao cx, Integer codigo) {
        String query = "from Desconto where produto.codigo = '" + codigo + "'";
        Desconto c     = new Desconto();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Desconto)it.next();
        } 
        cx.desconectar();
        return c;
     }
    
}
