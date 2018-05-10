package plmedia.proposal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import plmedia.proposal.model.entities.*;
import plmedia.proposal.model.repositories.*;
import plmedia.proposal.model.services.*;

import java.util.ArrayList;
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

    @RequestMapping(value = {"productdetails"}, method = RequestMethod.GET, params = {"productId"})
    public String productDetails(Model model, @RequestParam int productId){
        model.addAttribute("product", productRepo.findById((productId)));
        Product product = productRepo.findById(productId);
        return "productdetails";
    }

    @RequestMapping(value = {"login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"statistics"}, method = RequestMethod.GET)
    public String statistics() {
        return "statistics";
    }
}


