package com.boot.jpa.webservice;

import com.boot.jpa.webservice.entity.Member;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@SpringBootApplication
public class WebserviceApplication {



	public static void main(String[] args) {

		SpringApplication.run(WebserviceApplication.class, args);

		WebserviceApplication webserviceApplication = new WebserviceApplication();
		System.out.println("test");
		webserviceApplication.example1();
	}

	public void example1(){

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try{
			tx.begin();
			logic(em);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();

	}

	private static void logic(EntityManager em) {
		String id = "id1";
		Member member = new Member();
		member.setId(id);
		member.setUsername("지한");
		member.setAge(2);

		em.persist(member);

		member.setAge(20);

		Member findMember = em.find(Member.class, id);
		System.out.println("findMember = " + findMember.getUsername() + ", age = " + findMember.getAge());

		List<Member> members = em.createQuery("SELECT M.ID, M.NAME, M.AGE FROM MEMBER M", Member.class).getResultList();
		System.out.println("members.size=" + members.size());

		em.remove(member);

	}

}
