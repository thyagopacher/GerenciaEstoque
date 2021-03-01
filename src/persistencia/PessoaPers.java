/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.Pessoa;

/**
 *
 * @author Thyago
 */
public class PessoaPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirPessoa(Conexao cx, Pessoa p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updatePessoa(Conexao cx, Pessoa p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirPessoa(Conexao cx, Pessoa p){ 
        try{
            cx.conectar();
            String query = "delete from Pessoa where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public Pessoa procuraCodPessoa(Conexao cx, int codigo){
        cx.conectar();
        return (Pessoa)cx.s.get(Pessoa.class,codigo);
    }

    public Pessoa procuraNomeExato(Conexao cx, String nome) {
        String query = "from Pessoa where nome = '" + nome + "'";
        Pessoa c     = new Pessoa();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Pessoa)it.next();
        } 
        cx.desconectar();
        return c;
    }    
   
    public List<Pessoa> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from Pessoa where nome like '%" + nome + "%' order by nome ASC";
        return cx.s.createQuery(query).list();
    }    

   public List<Pessoa> procuraTtipo(Conexao cx, String tipo) {
        cx.conectar();
        String      query = "from Pessoa where tipo.nome = '" + tipo + "' order by nome ASC";
        return cx.s.createQuery(query).list();
     }
       
     public List<Pessoa> procuraTodos(Conexao cx) {
        cx.conectar();
        String      query = "from Pessoa";
        return cx.s.createQuery(query).list();
    }   
}
