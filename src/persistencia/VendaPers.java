/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.Venda;

/**
 *
 * @author Thyago
 */
public class VendaPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirVenda(Conexao cx, Venda p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updateVenda(Conexao cx, Venda p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirVenda(Conexao cx, Venda p){ 
        try{
            cx.conectar();
            String query = "delete from Venda where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public Venda procuraCodVenda(Conexao cx, int codigo){
        cx.conectar();
        return (Venda)cx.s.get(Venda.class,codigo);
    }

    public Venda procuraNomeExato(Conexao cx, String nome) {
        String query = "from Venda where pessoa.nome = '" + nome + "'";
        Venda c     = new Venda();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Venda)it.next();
        } 
        cx.desconectar();
        return c;
    }    

    public List<Venda> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from Venda where pessoa.nome like '%" + nome + "%' order by pessoa.nome ASC";
        return cx.s.createQuery(query).list();
    }    
    
    public List<Venda> procuraTodos(Conexao cx){
        cx.conectar();
        String       query = "from Venda  order by pessoa.nome ASC";
        return cx.s.createQuery(query).list();
    }    

     public List<Venda> procuraEstado(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from Venda where estadovenda.nome = '" + nome + "' order by codigo ASC";
        return cx.s.createQuery(query).list();
     }

     public List<Venda> procuraVendasIncompletas(Conexao cx) {
        cx.conectar();
        String      query = "from Venda where estadovenda.nome <> 'Completo' order by codigo ASC";
        return cx.s.createQuery(query).list();
     }
    

}
