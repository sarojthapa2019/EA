package edu.mum.cs544.apigateway.domain;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Role {
  private Long rid;
  private String role;

  public Role() {
    this.role="Admin";
  }

  @Override
  public String toString() {
    return role;
  }
}