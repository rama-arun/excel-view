package me.aboullaite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.aboullaite.service.UserService;

/**
 * Created by aboullaite on 2017-02-23.
 */

@Controller
public class Export {

    @Autowired
    UserService userService;

    /**
     * Handle request to download an Excel document
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public String download1(Model model, @RequestParam("user") String username, @RequestParam("client") String client ) {
        model.addAttribute("section1", userService.findAllSection1DataForUserAndClient(username, client));
        model.addAttribute("section2", userService.findAllSection2DataForUserAndClient(username, client));
        model.addAttribute("section3", userService.findAllSection3DataForUserAndClient(username, client));
        model.addAttribute("section4", userService.findAllSection4DataForUserAndClient(username, client));
        model.addAttribute("section5", userService.findAllSection5DataForUserAndClient(username, client));
        model.addAttribute("section6", userService.findAllSection6DataForUserAndClient(username, client));
        model.addAttribute("section7", userService.findAllSection7DataForUserAndClient(username, client));
        model.addAttribute("section8", userService.findAllSection8DataForUserAndClient(username, client));
        model.addAttribute("section9", userService.findAllSection9DataForUserAndClient(username, client));
        model.addAttribute("section10", userService.findAllSection10DataForUserAndClient(username, client));
        model.addAttribute("section11", userService.findAllSection11DataForUserAndClient(username, client));
        model.addAttribute("section12", userService.findAllSection12DataForUserAndClient(username, client));
        model.addAttribute("section13", userService.findAllSection13DataForUserAndClient(username, client));
        model.addAttribute("section14", userService.findAllSection14DataForUserAndClient(username, client));
        model.addAttribute("section15", userService.findAllSection15DataForUserAndClient(username, client));
        model.addAttribute("section16", userService.findAllSection16DataForUserAndClient(username, client));
        model.addAttribute("section17", userService.findAllSection17DataForUserAndClient(username, client));
        model.addAttribute("section18", userService.findAllSection18DataForUserAndClient(username, client));
        model.addAttribute("section19", userService.findAllSection19DataForUserAndClient(username, client));
        model.addAttribute("section20", userService.findAllSection20DataForUserAndClient(username, client));
        model.addAttribute("section21", userService.findAllSection21DataForUserAndClient(username, client));
        return "";
    }
}
