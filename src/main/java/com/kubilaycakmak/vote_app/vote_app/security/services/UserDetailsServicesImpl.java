package com.kubilaycakmak.vote_app.vote_app.security.services;

import com.kubilaycakmak.vote_app.vote_app.model.Person;
import com.kubilaycakmak.vote_app.vote_app.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailsServicesImpl implements UserDetailsService {

    @Autowired
    PersonRepository personRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Person person = personRepository.findByEmail(s).orElseThrow(() -> new UsernameNotFoundException("User Not Found with Email: " + s));
        return UserDetailsImpl.build(person);
    }
}
