package com.app.dao;
import static com.app.util.HibernateUtil.getFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.ProgLang;

public class ProLangDao {
	
	public boolean addProLang(ProgLang p) throws Exception {
        boolean flag=false;
        
        Session session = getFactory().getCurrentSession();
        Transaction tx=session.beginTransaction();
        try {
                session.persist(p);
                tx.commit();
                
        }catch(Exception e) {
                if(tx!=null)tx.rollback();
                throw e;
        }
        
        
        session.close();
        return flag;
}

	
}
