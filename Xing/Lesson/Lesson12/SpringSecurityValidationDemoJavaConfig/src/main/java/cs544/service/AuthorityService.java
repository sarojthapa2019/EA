package cs544.service;

import cs544.domain.Authority;

import java.util.List;

public interface AuthorityService {
    List<Authority> getAuthorities();

    Authority getById(Integer id);
}
