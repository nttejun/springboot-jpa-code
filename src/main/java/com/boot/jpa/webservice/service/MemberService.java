package com.boot.jpa.webservice.service;

import com.boot.jpa.webservice.entity.Member;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@Service
public class MemberService {

    public void crudExample(){

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

    public void logic(EntityManager em) {
        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("테스트");
        member.setAge(2);

        em.persist(member);

        member.setAge(20);

        Member findMember = em.find(Member.class, id);

        System.out.println("findMember = " + findMember.getUsername() + ", age = " + findMember.getAge());

        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("members.size=" + members.size());

        em.remove(member);

    }

}
