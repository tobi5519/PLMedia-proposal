package plmedia.proposal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import plmedia.proposal.model.entities.*;
import plmedia.proposal.model.repositories.*;
import plmedia.proposal.model.services.*;

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

    @RequestMapping(value = {"editor"}, method = RequestMethod.GET)
    public String editor() {
        return "editor";
    }

    @RequestMapping(value = {"sentproposals"}, method = RequestMethod.GET)
    public String sentproposals() {
        return "sentproposals";
    }

}


