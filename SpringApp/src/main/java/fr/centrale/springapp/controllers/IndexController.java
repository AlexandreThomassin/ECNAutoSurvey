/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.centrale.springapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Alex
 */
@Controller
public class IndexController {
    
    @RequestMapping(value="index.do")
    public ModelAndView handleIndexGet() {
        return new ModelAndView("index");
    }
    
    @RequestMapping(value="login.do")
    public ModelAndView handelIndexGet() {
        return new ModelAndView("login");
    }
    
}
