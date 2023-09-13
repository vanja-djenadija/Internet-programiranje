package org.unibl.etf.ip.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.models.entities.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

	List<Country> findByRegionId(Integer regionId);
}
