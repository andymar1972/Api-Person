package com.everis.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonResponse {

  private Long id;
  private String document;
  private boolean fingerPrint;
  private boolean blackList;
  
}
