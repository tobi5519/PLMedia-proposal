package plmedia.proposal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import plmedia.proposal.model.entities.*;
import plmedia.proposal.model.repositories.*;
import plmedia.proposal.model.services.*;

import java.sql.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    ContactPersonRepo contactPersonRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    PackageRepo packageRepo;

    @Autowired
    ProductCategoryRepo productCategoryRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ProposalRepo proposalRepo;

    @Autowired
    TemplateRepo templateRepo;


    public MainController(){}

    @RequestMapping(value = {"", "/", "index"}, method = RequestMethod.GET)
    public String index(){

        ProposalCreator proposalCreator = new ProposalCreator();
        Proposal proposal = proposalCreator.createProposal();
        System.out.println(proposal);
        proposalRepo.save(proposal);

        return "index";
    }

    @RequestMapping(value = {"products"}, method = RequestMethod.GET)
    public String products() {
        return "products";
    }

    @RequestMapping(value = {"productdetails"}, method = RequestMethod.GET)
    public String productdetails() {
        return "productdetails";
    }

    @RequestMapping(value = {"login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"statistics"}, method = RequestMethod.GET)
    public String statistics(Model model) {

        model.addAttribute("totalProposals", Double.valueOf(proposalRepo.findAll().size()));
        model.addAttribute("totalAcceptedProposals", Double.valueOf(proposalRepo.findAllByAcceptDateIsNotNull().size()));
        model.addAttribute("totalNotAcceptedProposals", Double.valueOf(proposalRepo.findAllByAcceptDateIsNull().size()));

        return "statistics";
    }

    @RequestMapping(value = {"statistics"}, method = RequestMethod.POST)
    public String statistics(@RequestParam("date") List<Date> dates, Model model) {

        // Period 1
        model.addAttribute("totalProposals", Double.valueOf(proposalRepo.findAllBySendDateBetween(dates.get(0), dates.get(1)).size()));
        model.addAttribute("totalAcceptedProposals", Double.valueOf(proposalRepo.findAllByAcceptDateIsNotNullAndSendDateIsBetween(dates.get(0), dates.get(1)).size()));
        model.addAttribute("totalNotAcceptedProposals", Double.valueOf(proposalRepo.findAllByAcceptDateIsNullAndSendDateIsBetween(dates.get(0), dates.get(1)).size()));

        // Period 2
        model.addAttribute("totalProposals1", Double.valueOf(proposalRepo.findAllBySendDateBetween(dates.get(2), dates.get(3)).size()));
        model.addAttribute("totalAcceptedProposals1", Double.valueOf(proposalRepo.findAllByAcceptDateIsNotNullAndSendDateIsBetween(dates.get(2), dates.get(3)).size()));
        model.addAttribute("totalNotAcceptedProposals1", Double.valueOf(proposalRepo.findAllByAcceptDateIsNullAndSendDateIsBetween(dates.get(2), dates.get(3)).size()));

        return "statistics";
    }

    @RequestMapping(value = {"editor"}, method = RequestMethod.GET)
    public String editor() {
        return "editor";
    }

    @RequestMapping(value = {"sentproposals"}, method = RequestMethod.GET)
    public String sentproposals() {
        return "sentproposals";
    }

}


