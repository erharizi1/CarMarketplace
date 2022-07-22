package de.mobile.controller;

import java.util.List;

import de.mobile.dto.Ad;
import de.mobile.exception.AdNotFoundException;
import de.mobile.model.MobileAd;
import de.mobile.service.AdService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@RestController
@RequestMapping("ad")
public class AdResource {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdService adService;


    @RequestMapping("/welcome")
    public ModelAndView loginMessage(Model model) {
        log.info(" Create UI list of Cars " );
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        List<Ad> list = adService.list();
        modelAndView.addObject("listOfAds", list);
        return modelAndView;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public MobileAd get(@PathVariable("id") Long adId) {
        log.info("Find new ad by id: " + adId);
        return adService.get(adId)
                .orElseThrow(() -> new AdNotFoundException(adId));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Ad> list() {
        log.info("Retrive list of ads");
        return adService.list();
    }

    @PostMapping("/create")
    public MobileAd create(@RequestBody @Valid Ad mobileAd) {
        log.info("Creating new customer -- id: " + mobileAd.getId());
        return adService.create(mobileAd);
    }


}
