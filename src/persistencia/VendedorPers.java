/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.Vendedor;

/**
 *
 * @author Thyago
 */
public class VendedorPers {
    String  msg = "";
    Conexao cx  = new Conexao(); 
    public String inserirVendedor(Conexao cx, Vendedor p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updateVendedor(Conexao cx, Vendedor p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirVendedor(Conexao cx, Vendedor p){ 
        try{
            cx.conectar();
            String query = "delete from Vendedor where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public Vendedor procuraCodVendedor(Conexao cx, int codigo){
        cx.conectar();
        return (Vendedor)cx.s.get(Vendedor.class,codigo);
    }

    public Vendedor procuraNomeExato(Conexao cx, String nome) {
        String query = "from Vendedor where nome = '" + nome + "'";
        Vendedor c     = new Vendedor();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Vendedor)it.next();
        } 
        cx.desconectar();
        return c;
    }    
   
    public List<Vendedor> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from Vendedor where nome like '%" + nome + "%' order by nome ASC";
        return cx.s.createQuery(query).list();
    }    

     public List<Vendedor> procuraTodos(Conexao cx) {
        cx.conectar();
        String      query = "from Vendedor";
        return cx.s.createQuery(query).list();
    }   
}
