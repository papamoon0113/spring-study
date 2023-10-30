package jpamvcexam.mainview;

import jpamvcexam.model.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MemberTeamTest4 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
     
        Member m1 = new Member("토토로", null, null);
        Member m2 = new Member("듀크", null, null);
        em.persist(m1);
        em.persist(m2);
        
        System.out.println("Member에 추가 데이터 저장~~ ");
        em.getTransaction().commit();       
        em.close();
        factory.close();
	}
}
