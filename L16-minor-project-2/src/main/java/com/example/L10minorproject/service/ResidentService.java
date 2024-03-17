package com.example.L10minorproject.service;

import com.example.L10minorproject.dto.AllVisitsByPageResponseBody;
import com.example.L10minorproject.dto.VisitDto;
import com.example.L10minorproject.entity.Flat;
import com.example.L10minorproject.entity.User;
import com.example.L10minorproject.entity.Visit;
import com.example.L10minorproject.enums.VisitStatus;
import com.example.L10minorproject.repo.UserRepo;
import com.example.L10minorproject.repo.VisitRepo;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResidentService {

    @Autowired
    private VisitRepo visitRepo;

    @Autowired
    private UserRepo userRepo;

    public String updateVisit(VisitStatus newStatus, Long id) throws BadRequestException {
        Visit visit = visitRepo.findById(id).get();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!visit.getFlat().getId().equals(user.getFlat().getId())){
            throw new BadRequestException("Flat id in Visit is Different");
        }
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


    @Transactional
    public AllVisitsByPageResponseBody getAllVisits(Long userId, Pageable pageable){
        AllVisitsByPageResponseBody responseBody = new AllVisitsByPageResponseBody();
        List<VisitDto> visitDtoList = new ArrayList<>();
        User user = userRepo.findById(userId).get();
        if(user != null){
            Flat flat = user.getFlat();
            Page<Visit> visitPage = visitRepo.findAll(pageable);
            List<Visit> visitList = visitPage.stream().toList();
            responseBody.setTotalPage(visitPage.getTotalPages());
            responseBody.setTotalRow(visitPage.getTotalElements());
            for(Visit visit: visitList){
                visitDtoList.add(fromVisit(visit));
            }
        }
        responseBody.setVisits(visitDtoList);
        return responseBody;
    }

    private VisitDto fromVisit(Visit visit){
        VisitDto visitDto = VisitDto.builder()
                .urlOfImage(visit.getImageUrl())
                .noOfPeople(visit.getNoOfPeople())
                .purpose(visit.getPurpose())
                .visitorName(visit.getVisitor().getName())
                .inTime(visit.getInTime())
                .outTime(visit.getOutTime())
                .idNumber(visit.getVisitor().getIdNumber())
                .status(visit.getStatus())
                .flatNumber(visit.getFlat().getNumber())
                .build();
        return visitDto;
    }

}
