package com.app.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static com.app.util.HibernateUtil.getFactory;
import com.app.entity.Skills;

public class SkillsDao {
	
	public boolean addskills(Skills skills, int cid) throws Exception {
        boolean flag=false;
        
        Session session = getFactory().getCurrentSession();
        Transaction tx=session.beginTransaction();
        try {
                session.persist(skills);
                tx.commit();
                
        }catch(Exception e) {
                if(tx!=null)tx.rollback();
                throw e;
        }
        
        
        session.close();
        return flag;
}

	

}
