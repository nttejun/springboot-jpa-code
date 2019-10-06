package com.boot.jpa.webservice;

import com.boot.jpa.webservice.entity.Member;
import com.boot.jpa.webservice.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebserviceApplicationTests {

	@Test
	public void TEST_createJpabookEntityManagerFactory(){

	}

	@Test
	public void crud(){

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try{
			tx.begin();

			String id = "id1";
			Member member = new Member();
			member.setId(id);
			member.setUsername("지한");
			member.setAge(2);

			em.persist(member);

			member.setAge(20);

			Member findMember = em.find(Member.class, id);

			System.out.println("findMember = " + findMember.getUsername() + ", age = " + findMember.getAge());

			List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
			System.out.println("members.size=" + members.size());

			em.remove(member);

			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();

	}

}
