package com.mladen.cikara.querydsl;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestEntity {

  private int id;

  private String description;

  public String getDescription() {
    return description;
  }

  @Id
  public int getId() {
    return id;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "TestEntity [id=" + id + ", description=" + description + "]";
  }
}
