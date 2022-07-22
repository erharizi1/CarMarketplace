import de.mobile.controller.AdResource;
import de.mobile.dto.Ad;
import de.mobile.model.Category;
import de.mobile.model.MobileAd;
import de.mobile.model.MobileCustomer;
import jdk.dynalink.linker.support.Guards;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


import javax.inject.Inject;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@SpringBootTest
public class ApplicationTets {

    @Autowired
    public AdResource adController;


    @Test
    public void testCreateAd() throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:8080"+"/ad/create";
        URI uri = new URI(baseUrl);

        Ad newAd = new Ad();
        newAd.setMake("Audi");
        newAd.setModel("A5");
        newAd.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, ");
        newAd.setCategory(Category.Car);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<Ad> request = new HttpEntity<>(newAd, headers);

        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);

        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
    }


    @Test
    public void testCreateCustomer() throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:8080"+"/customer/create";
        URI uri = new URI(baseUrl);

        MobileCustomer customer = new MobileCustomer();
        customer.setFirstName("eraldo");
        customer.setLastName("harizi");
        customer.setCompanyName("Car Gmbh");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<MobileCustomer> request = new HttpEntity<>(customer, headers);

        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);

        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
    }
}
