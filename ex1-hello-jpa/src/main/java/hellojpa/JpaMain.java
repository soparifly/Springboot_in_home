package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {


    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

//트랜잭션을 설정해줘야함 트랜젝션안에서 해결해야함
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        //code 회원등록
        /**
         * 트랜젝션이 진행될때 어느 한 코드부분에서 오류가 발생되면
         * try catch 로 rollback 문제를 잡아주지않는코드는 문제가있다
         * 아래와같이 try catch finall 로 코드를 잡아주어야함
         *
         */
        try {
            //비영속
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
            //영속
            /**
             * 엔티티 매니저는 데이터 변경시 트랜잭션을 시작해야한다
             *
             * 영속 상태가 된상태라고해서 DB 쿼리가 실행되는것은아니다
             * commit( )을 해줘야한다
             *commit 을 하는 시점에
             * 데이터베이스에 Insert sql 을 보낸다
             * 이런 점을 이용해서 배치가 가능하다
             * hibernate에 사이즈만큼 모아놨다가 한번에 보낼수있다.
             */
//            em.persist(member);
            //회원 찾기
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember,id = " + findMember.getId());
//            System.out.println("findMember,name = " + findMember.getName());
            /**
             * Hibernate:
             *     select
             *         member0_.id as id1_0_0_,
             *         member0_.name as name2_0_0_
             *     from
             *         Member member0_
             *     where
             *         member0_.id=?
             * findMember,id = 1
             * findMember,name = HelloA
             */

            //회원삭제 찾은애를 삭제함
            //em.remove(findMember);

            //회원수정
            //찾아서 이름만 수정
//            findMember.setName("HelloJPA");
            /**
             * findMember,name = HelloA
             * Hibernate:
             *      update
             *         hellojpa.Member *
             *         update
             * Member
             * set
             * name =?
             *where
             * id =?
             */

//페이지네이션
            /**
             *  select
             *         m
             *     from
             *         Member as m select
                    * member0_.id as id1_0_,
             *member0_.name as name2_0_
                    * from
                    * Member member0_ limit ?offset ?
             *member.name = HelloB
             * ㄱ
                    */
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(8)
                    .getResultList();

            for (Member member : result) {
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
//Hibernate:
//    /* insert hellojpa.Member
//        */ insert
//        into
//            Member
//            (name, id)
//        values
//            (?, ?)


        // code end
    }
}
