package com.example.ec.service;

import com.example.ec.domain.TourPackage;
import com.example.ec.repo.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.ToIntBiFunction;

@Service
public class TourPackageService {
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    /**
     * Create a tour package
     * @param code of the package
     * @param name of the package
     * @return new or existing tour package
     */
    public TourPackage createTourPackage (String code, String name){
        return tourPackageRepository.findById(code).
                orElse(tourPackageRepository.save(new TourPackage(code, name)));
    }

    /**
     * Lookup for all tour packages
     * @return list of tour packages
     */
    public Iterable<TourPackage> lookUp(){
        return tourPackageRepository.findAll();
    }

    public long total(){
        return tourPackageRepository.count();
    }

}
