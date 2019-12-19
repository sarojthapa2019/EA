package edu.mum.cs544.repository;

import edu.mum.cs544.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("select u,a from User u left join u.addr a")
    List<User> fetchAllUsers();

    @Query("from User u left join u.addr a where u.uid=?1")
    User fetchUserFromId(long id);

    @Query("from User u where u.email=?1 and u.password=?2")
    User fetchUserFromEmailAndPassword(String email,String password);

    @Query("from User u left join u.addr a where u.email=?1")
    User fetchUserFromEmail(String email);
}
