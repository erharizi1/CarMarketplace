package de.mobile.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import de.mobile.model.MobileAd;
import de.mobile.dto.Ad;
import de.mobile.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdService {

    @Autowired
    private AdRepository adRepository;


    public MobileAd create(Ad adData) {
        MobileAd ad = inbound(adData);
        return adRepository.save(ad);
    }

    public Optional<MobileAd> get(Long adId) {
        Optional<MobileAd> mobileAd = adRepository.findById(adId);
        return mobileAd;
    }

    public List<Ad> list() {
        return adRepository.findAll() //
                .stream() //
                .map(this::outbound) //
                .collect(Collectors.toList());
    }

    private Ad outbound(MobileAd mobileAd) {
        Ad adData = new Ad();
        adData.setId(mobileAd.getId());
        adData.setCategory(mobileAd.getCategory());
        adData.setMake(mobileAd.getMake());
        adData.setModel(mobileAd.getModel());
        adData.setDescription(mobileAd.getDescription());
        adData.setPrice(mobileAd.getPrice());
        return adData;
    }

    private MobileAd inbound(Ad adData) {
        MobileAd mobileAd = new MobileAd();
        mobileAd.setId(adData.getId());
        mobileAd.setCategory(adData.getCategory());
        mobileAd.setMake(adData.getMake());
        mobileAd.setModel(adData.getModel());
        mobileAd.setDescription(adData.getDescription());
        mobileAd.setPrice(adData.getPrice());
        mobileAd.setCustomer(adData.getCustomer());
        return mobileAd;
    }

}
