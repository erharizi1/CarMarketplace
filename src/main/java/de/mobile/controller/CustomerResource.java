package de.mobile.controller;

import de.mobile.exception.CustomerNotFoundException;
import de.mobile.model.MobileCustomer;
import de.mobile.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("customer")
public class CustomerResource {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public MobileCustomer create(@RequestBody @Valid MobileCustomer customer) {
        log.info("Creating new customer -- id: " + customer.getId());
        return customerService.createCustomer(customer);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<MobileCustomer> getList() {
        log.info("Retrive list of customer");
        return customerService.list();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteCusotmerById(@PathVariable("id") Long id) {
        log.info("Delete customer with id:" + id);

        Optional<MobileCustomer> customer = customerService.getById(id);
        if (customer.isPresent()) {
            customerService.deleteByid(id);
        } else {
            throw new CustomerNotFoundException(customer.get().getId());
        }
    }
}
