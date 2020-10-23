package com.everis.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class PersonRequest {

  private Long id;
  @NotNull(message = "Numero de documento es requerido")
  @Size(min = 2, max = 30, message = "El nombre debe tener entre {min} y {max} caracteres")
  private String document;
}
