package com.mladen.cikara.querydsl;

import com.querydsl.jpa.impl.JPAQuery;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPAQueryTest {

  @Autowired
  private EntityManager entityManager;

  @Test
  public void testQuery() {
    final JPAQuery<TestEntity> query = new JPAQuery<>(entityManager);
    final QTestEntity testEntity = QTestEntity.testEntity;

    final List<TestEntity> list = query.from(testEntity).fetch();

    System.out.println(list);
  }
}
