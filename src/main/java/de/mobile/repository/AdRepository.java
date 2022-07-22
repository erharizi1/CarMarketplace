package de.mobile.repository;

import java.util.ArrayList;
import java.util.List;

import de.mobile.model.MobileAd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdRepository extends JpaRepository<MobileAd, Long> {



}
