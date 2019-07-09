package cs544.service;

import cs544.domain.Authority;
import cs544.repository.AuthorityRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService{

    private AuthorityRepository authorityRepository;

    public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public List<Authority> getAuthorities() {
        return authorityRepository.findAll();
    }

    @Override
    public Authority getById(Integer id) {
        return authorityRepository.getOne(id);
    }
}
