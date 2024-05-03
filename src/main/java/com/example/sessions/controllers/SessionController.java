package com.example.sessions.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {

    @GetMapping("/set_session_id")
    public String setSessionId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("sessionId", session.getId());
        return "redirect:/show_session_id";
    }

    @GetMapping("/show_session_id")
    public String showSessionId(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            model.addAttribute("sessionId", (String) session.getAttribute("sessionId"));
        } else {
            model.addAttribute("sessionId", "Session not found!");
        }
        return "home/show_session_id";
    }

    @GetMapping("/")
    public String index() {
        return "home/index";
    }
}
