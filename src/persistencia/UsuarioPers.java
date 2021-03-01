/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.Usuario;

/**
 *
 * @author Thyago
 */
public class UsuarioPers {
    
    String  msg = "";
    
    public String inserirUsuario(Conexao cx, Usuario p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updateUsuario(Conexao cx, Usuario p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirUsuario(Conexao cx, Usuario p){ 
        try{
            cx.conectar();
            String query = "delete from Usuario where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public Usuario procuraCodUsuario(Conexao cx, int codigo){
        cx.conectar();
        return (Usuario)cx.s.get(Usuario.class,codigo);
    }

    public Usuario procuraNomeExato(Conexao cx, String nome) {
        String query = "from Usuario where primeironome = '" + nome + "'";
        Usuario c     = new Usuario();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Usuario)it.next();
        } 
        cx.desconectar();
        return c;
    }    
   
    public List<Usuario> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from Usuario where primeironome like '%" + nome + "%' order by primeironome ASC";
        return cx.s.createQuery(query).list();
    }    

     public List<Usuario> procuraTodos(Conexao cx) {
        cx.conectar();
        String      query = "from Usuario order by primeironome ASC";
        return cx.s.createQuery(query).list();
    }   

     public Usuario procuraVendedor(Conexao cx, Integer codigo) {
        String query = "from Usuario where codvendedor = '" + codigo + "'";
        Usuario c     = new Usuario();
        cx.conectar();
        Iterator    it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Usuario)it.next();
        } 
        cx.desconectar();
        return c;
     }

     public Usuario verificarLogin(Conexao cx, String login, String senha) {
        String query = "from Usuario where usuario = '" + login + "' and senha = '" + senha + "'";
        cx.conectar();
        Usuario  c     = new Usuario();
        Iterator it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Usuario)it.next();
        } 
        cx.desconectar();
        return c;
     }
}
