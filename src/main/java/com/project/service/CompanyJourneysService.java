package com.project.service;

import com.project.dto.JourneyEntity;
import com.project.dto.dao.Repository;
import com.project.repository.JourneyRepository;

import java.util.ArrayList;

public class CompanyJourneysService {
    private Repository<JourneyEntity> journeyRepository = new JourneyRepository();


    public String[][] getJourneys() {
        ArrayList<JourneyEntity> allJourneys = journeyRepository.findAll();
        String[][] result = new String[allJourneys.size()][4];

        int i = 0;
        for(JourneyEntity journey: allJourneys) {
            String[] data = new String[5];
            data[0] = journey.getId();
            data[1] = journey.getOrigin();
            data[2] = journey.getDestination();
            data[3] = journey.getCompany();
            data[4] = journey.getDescription();
            data[5] = journey.getContainerId();

            result[i] = data;
        }

        return result;
    }
}
