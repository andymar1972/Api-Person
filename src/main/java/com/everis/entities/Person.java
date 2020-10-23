package com.everis.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Persons")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Person implements Serializable {

  private static final long serialVersionUID = -8223691636805126522L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id")
  private Long id;
  @Column(name = "Document", length = 8, unique = true)
  private String document;
  @Column(name = "Fingerprint")
  private boolean fingerPrint;
  @Column(name = "Blacklist")
  private boolean blackList;

}
