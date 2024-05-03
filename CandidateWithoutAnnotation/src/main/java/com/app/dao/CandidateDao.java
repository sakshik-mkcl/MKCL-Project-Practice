package com.app.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.Candidate;

import static com.app.util.HibernateUtil.getFactory;

import java.util.List;

public class CandidateDao {
        
        public boolean addCandidate(Candidate can) throws Exception {
                boolean flag=false;
                
                Session session = getFactory().getCurrentSession();
                Transaction tx=session.beginTransaction();
                try {
                        session.persist(can);
                        tx.commit();
                        
                }catch(Exception e) {
                        if(tx!=null)tx.rollback();
                        throw e;
                }
                
                
                session.close();
                return flag;
        }
        
       

		@SuppressWarnings("deprecation")
        public int getCandidateId(Candidate can ) {
                int flag=-1;
                
                Session session = getFactory().getCurrentSession();
                Transaction tx = session.beginTransaction();
                try {
                        String hql = "FROM " + Candidate.class.getName() + " can WHERE can.user_name = :uname";
                        Query query = session.createQuery(hql);
                        query.setParameter("uname",  can.getUsername()); 
                        List<Candidate> candi= query.list();
                        flag=candi.get(0).getId();
                }catch(Exception e){
                        System.out.println(e);
                }
                session.close();
                return flag;
        }



		



        
}





