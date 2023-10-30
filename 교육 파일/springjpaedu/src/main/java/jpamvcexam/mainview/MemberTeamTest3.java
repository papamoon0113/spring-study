package jpamvcexam.mainview;

import jpamvcexam.model.entity.Member;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class MemberTeamTest3 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        
        Scanner scan = new Scanner(System.in);
        System.out.print("회원명을 입력하세요 : ");
        String inputName = scan.nextLine();
        scan.close();

		// SQL 스러운 방법
		String jpql = "select m from Member m join m.team t join m.locker l where m.username = :mn";
		// JPQL의 방법 -> m.getTeam을 하면 Team 객체가 반환된다는 점을 이용한다.
		String jpql = "select m from Member m where m.username = :mn";

        TypedQuery<Member> q = em.createQuery(jpql, Member.class);
        q.setParameter("mn", inputName);
        Member dto;
        try {
            dto = q.getSingleResult();
            System.out.printf("%s님은 %s팀 소속이고 %s 락커를 사용중입니다.%n", dto.getUsername(), dto.getTeam().getName(), dto.getLocker().getName());
        } catch(NoResultException e) {
        	System.out.printf("%s님은 정보가 없습니다.%n", inputName);
        }
        em.close();
        factory.close();
	}
}
