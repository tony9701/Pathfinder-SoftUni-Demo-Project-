package com.pathfinder.pathfinder.web;


import com.pathfinder.pathfinder.service.RouteService;
import com.pathfinder.pathfinder.service.dto.RouteShortInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Random;

@Controller
public class RouteController {

    private RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public String routes(Model model) {
        List<RouteShortInfoDTO> allRoutes = routeService.getAll();
        model.addAttribute("routes", allRoutes);
        return "routes";
    }
}
