/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.FormaPagamento;

/**
 *
 * @author Thyago
 */
public class FormaPagamentoPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirFormaPagamento(Conexao cx, FormaPagamento p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updateFormaPagamento(Conexao cx, FormaPagamento p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirFormaPagamento(Conexao cx, FormaPagamento p){ 
        try{
            cx.conectar();
            String query = "delete from FormaPagamento where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public FormaPagamento procuraCodFormaPagamento(Conexao cx, int codigo){
        cx.conectar();
        return (FormaPagamento)cx.s.get(FormaPagamento.class,codigo);
    }

    public FormaPagamento procuraNomeExato(Conexao cx, String nome) {
        String query = "from FormaPagamento where nome = '" + nome + "'";
        FormaPagamento c     = new FormaPagamento();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (FormaPagamento)it.next();
        } 
        cx.desconectar();
        return c;
    }    
 
    public List<FormaPagamento> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from FormaPagamento where nome like '%" + nome + "%' order by nome ASC";
        return cx.s.createQuery(query).list();
    }    
  
    public List<FormaPagamento> procuraTodos(Conexao cx) {
        cx.conectar();
        String      query = "from FormaPagamento";
        return cx.s.createQuery(query).list();
    }      
    
}
