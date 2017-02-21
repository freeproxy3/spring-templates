package com.richard;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "address")
public class Address {
  @Id
  @GeneratedValue
  private Integer id;
  private String street;

  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }
  /**
   * @param id the id to set
   */
  public Address setId(Integer id) {
    this.id = id;
    return this;
  }
  /**
   * @return the street
   */
  public String getStreet() {
    return street;
  }
  /**
   * @param street the street to set
   */
  public Address setStreet(String street) {
    this.street = street;
    return this;
  }

}