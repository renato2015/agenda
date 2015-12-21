/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sql;

import Bean.BeanContato;
import java.util.List;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fox W8
 */
public class SqlContato {
    List<BeanContato> lista;
    public void gravar(Session session, Transaction tx, BeanContato bContato) {
        session.save(bContato);
        tx.commit();
    }

    public void excluir(Session session, Transaction tx, BeanContato bContato) {
        session.delete(bContato);
        tx.commit();
    }

    public void alterar(Session session, Transaction tx, BeanContato bContato) {
        session.update(bContato);
        tx.commit();
    }
    
    public List<BeanContato> listall(Session session, Transaction tx){
        String hql = "from BeanContato";        
        Query query = session.createQuery(hql);
        lista = query.list();
        return lista;
    }
    
    
    
    
}
