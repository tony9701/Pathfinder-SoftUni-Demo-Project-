package com.pathfinder.pathfinder.service;

import com.pathfinder.pathfinder.model.Picture;
import com.pathfinder.pathfinder.model.Route;
import com.pathfinder.pathfinder.repository.RouteRepository;
import com.pathfinder.pathfinder.service.dto.RouteShortInfoDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RouteService {

    private Random random;
    private RouteRepository routeRepository;
    private ModelMapper modelMapper;



    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
        this.random = new Random();
        this.modelMapper = new ModelMapper();
    }

    @Transactional
    public List<RouteShortInfoDTO> getAll() {
        return routeRepository.findAll()
                .stream()
                .map(this::mapToRouteDto)
                .toList();
    }

    private RouteShortInfoDTO mapToRouteDto(Route route) {
        RouteShortInfoDTO dto = modelMapper.map(route, RouteShortInfoDTO.class);

        Optional<Picture> randomPic = route.getPictures().stream().findFirst();
        dto.setImageUrl(randomPic.get().getUrl());

        return dto;
    }

    @Transactional
    public RouteShortInfoDTO getRandomRoute() {
        long routeCount = routeRepository.count();
        long randomId = random.nextLong(routeCount + 1);

        Optional<Route> routeById = routeRepository.findById(randomId);

        if (routeById.isEmpty()) {
            System.out.printf("no info");
        }

        return mapToRouteDto(routeById.get());
    }

}
