package com.mladen.cikara.querydsl;

import static org.assertj.core.api.Assertions.assertThat;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAUpdateClause;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class JPAQueryTest {

  @Autowired
  private EntityManager entityManager;

  @Test
  public void testQueryStatemen() {
    final JPAQuery<TestEntity> query = new JPAQuery<>(entityManager);
    final QTestEntity testEntity = QTestEntity.testEntity;

    final List<TestEntity> list = query.from(testEntity).fetch();

    System.out.println(list);
  }

  @Test
  public void testUpdateStatement() {
    final QTestEntity testEntity = QTestEntity.testEntity;

    final long number = new JPAUpdateClause(entityManager, testEntity)
        .set(testEntity.description, "Bye")
        .where(testEntity.id.eq(1))
        .execute();

    assertThat(number).isEqualTo(1);

    final JPAQuery<TestEntity> query = new JPAQuery<>(entityManager);
    final List<TestEntity> list = query.from(testEntity).fetch();

    System.out.println(list);
  }
}
