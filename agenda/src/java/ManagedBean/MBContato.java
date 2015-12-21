/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Bean.BeanContato;
import Sql.SqlContato;
import Util.HibernateUtil;
import Util.Mensagem;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author Fox W8
 */
@ManagedBean(name = "mbContato")
public class MBContato {
    BeanContato bContato = new BeanContato();
    SqlContato sContato = new SqlContato();
    
    Mensagem msg = new Mensagem();
    Session session;
    Transaction tx;

    public MBContato() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }
    
    public void gravar(){
        try {
            sContato.gravar(session, tx, bContato);
        } catch (Exception e) {
            tx.rollback();
            msg.erro("Erro ao gravar o registro!");
        }
    }
    
    public void excluir(){
        try {
            sContato.excluir(session, tx, bContato);
        } catch (Exception e) {
            tx.rollback();
            msg.erro("Erro ao excluir o registro!");
        }
    }
    
    public void alterar(){
        try {
            sContato.alterar(session, tx, bContato);
        } catch (Exception e) {
            tx.rollback();
            msg.erro("Erro ao alterar o registro!");
        }
    }
    
    public List<BeanContato> listaTudo(){
        List<BeanContato> lista;
        lista = sContato.listall(session, tx);
        return lista;
    }
    
    public BeanContato getbContato() {
        return bContato;
    }

    public void setbContato(BeanContato bContato) {
        this.bContato = bContato;
    }
}
