package com.cameronsmith.queriesandjoins.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameronsmith.queriesandjoins.models.Country;

@Repository
public interface CountryRepo extends CrudRepository<Country, Long>{
	List<Country> findAll();
	
	@Query("SELECT c FROM Country c")
	List<Country> findAllCountries();
	
	@Query("SELECT c.name From Country c")
    List<String> findAllCountryNames();
    
    @Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language IS ?1 ORDER BY l.percentage DESC")
    List<String> getCountryByLang(String language);
    	
    @Query("SELECT c.name, COUNT(i) AS number FROM Country c JOIN c.cities i GROUP BY c.id ORDER BY number DESC")
    List<String> CountCitiesInCountries();
    
    @Query("SELECT ci.name, ci.population FROM Country c JOIN c.cities ci WHERE c.name IS ?1 AND ci.population > ?2 ")
    List<String> largeCities(String country, Integer popFloor);
//    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    @Query("SELECT c FROM Country c WHERE id = ?1")
    List<Country> getCountryWhereId(Long id);
    
    @Query("SELECT c FROM Country c WHERE id = ?1")
    Country getSingleCountryWhereId(Long id);
    @Modifying
    @Query("update Country c set c.name = ?1 WHERE c.id = ?2")
    int setNameForOne(String name, Long id);
    
    @Modifying
    @Query("update Country c set c.name = ?1")
    int setNameForAll(String name);
    
    @Modifying
    @Query("delete Country c WHERE c.id = ?1")
    int deleteOneCountry(Long id);
    
 // get all the names of the countries with id. If we select all, we get a list of country objects back.
    @Query(value="SELECT * from countries", nativeQuery=true)
    List<Country> findAllCountriesNamesWithId();
    
    // get all the names of the countries with id. If we want to select specific column, we will get a list of Object arrays because it is no longer Dojo objects. Each index of the array will be the column selected respectively. Therefore 0 = id column, 1 = name column
    @Query(value="SELECT id, name from countries", nativeQuery=true)
    List<Object[]> findAllCountriesNamesWithId2();
    
    // get one country
    @Query(value="SELECT * FROM countries WHERE id = ?1", nativeQuery=true)
    Country getCountriesWhereId(Long id);
}
