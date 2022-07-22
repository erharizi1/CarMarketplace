package de.mobile.service;

import de.mobile.dto.Ad;
import de.mobile.model.MobileCustomer;
import de.mobile.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;


    public MobileCustomer createCustomer(MobileCustomer c) {
        return customerRepo.save(c);
    }

    public Optional<MobileCustomer> getById(Long id) {
        return customerRepo.findById(id);
    }

    public List<MobileCustomer> list() {
        return customerRepo.findAll() //
                .stream() //
                .collect(Collectors.toList());
    }


    public void deleteByid(Long id) {
        customerRepo.deleteById(id);
    }

}
