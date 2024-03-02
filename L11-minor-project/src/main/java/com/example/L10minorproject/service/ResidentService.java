package com.example.L10minorproject.service;

import com.example.L10minorproject.dto.VisitDto;
import com.example.L10minorproject.entity.Flat;
import com.example.L10minorproject.entity.User;
import com.example.L10minorproject.entity.Visit;
import com.example.L10minorproject.enums.VisitStatus;
import com.example.L10minorproject.repo.UserRepo;
import com.example.L10minorproject.repo.VisitRepo;
import jakarta.transaction.Transactional;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResidentService {

    @Autowired
    private VisitRepo visitRepo;

    @Autowired
    private UserRepo userRepo;

    public String updateVisit(VisitStatus newStatus, Long id){
        Visit visit = visitRepo.findById(id).get();
        if(VisitStatus.WAITING.equals(visit.getStatus())){
            visit.setStatus(newStatus);
            visitRepo.save(visit);
            return "Done";
        }
        else {

        }
        return "Error";
    }

    @Transactional
    public List<VisitDto> getPendingVisits(Long userId){
        List<VisitDto> visitDtoList = new ArrayList<>();
        User user = userRepo.findById(userId).get();
        if(user != null){
            Flat flat = user.getFlat();
            List<Visit> visitList = visitRepo.findByStatusAndFlat(VisitStatus.WAITING, flat);
            for(Visit visit: visitList){
                visitDtoList.add(fromVisit(visit));
            }
        }
        return visitDtoList;
    }

    private VisitDto fromVisit(Visit visit){
        VisitDto visitDto = VisitDto.builder()
                .urlOfImage(visit.getImageUrl())
                .noOfPeople(visit.getNoOfPeople())
                .purpose(visit.getPurpose())
                .visitorName(visit.getVisitor().getName())
                .build();
        return visitDto;
    }

}
