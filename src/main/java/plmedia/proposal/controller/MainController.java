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

//        ProposalCreator proposalCreator = new ProposalCreator();
//        Proposal proposal = proposalCreator.createProposal();
//        System.out.println(proposal);
//        proposalRepo.save(proposal);

        return "index";
    }

    @RequestMapping(value = {"products"}, method = RequestMethod.GET)
    public String products(Model model) {
        model.addAttribute("products", productRepo.findAll());
        return "products";
    }

    @RequestMapping(value = {"productdetails"}, method = RequestMethod.GET)
    public String productdetails(Model model, @RequestParam int productId) {
        model.addAttribute(productRepo.findById(productId));
        return "productdetails";
    }

//    @RequestMapping(value = {"productdetails"}, method = RequestMethod.POST)
//    public String updateproduct(@ModelAttribute("product") Product newProduct) {
////        System.out.println(newProduct.getName());
//        Product product = productRepo.findById(newProduct.getId());
//        product.setName("Andreas");
//        product.setPrice(9000);
//        product.setDescription("Altid glad og imødekommende");
//        productRepo.save(product);
//        return "redirect:/products";
//    }

    @RequestMapping (value = {"productdetails"}, method = RequestMethod.POST)
    public String updateproduct(@ModelAttribute("movie") Product newProduct, @RequestParam int productId)
    {
        try {
            Product product = productRepo.findById(productId);
            product.setName(newProduct.getName());
            product.setDescription(newProduct.getDescription());
            product.setPrice(newProduct.getPrice());
            productRepo.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/products";
    }


    @RequestMapping (value = {"deleteproduct"}, method = RequestMethod.GET)
    public String deleteShowing(@RequestParam int productId) {
        productRepo.deleteById(productId);
        return "redirect:/products";
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


    @RequestMapping(value = {"test"}, method = RequestMethod.GET)
    public String test() {

        // Creation

//        ProductCreator productCreator = new ProductCreator();
//        Product product = productCreator.createProduct("SEO", 200.0, "Search Engine Optimization");
//        List<Product> productList = new ArrayList<>();
//        productList.add(product);
//
//        ProposalCreator proposalCreator = new ProposalCreator();
//        Proposal proposal =  proposalCreator.createProposal(10);
//
//        CustomerCreator customerCreator = new CustomerCreator();
//        Customer customer = customerCreator.createCustomer("KEA", "123");
//
//        ContactPersonCreator contactPersonCreator = new ContactPersonCreator();
//        ContactPerson contactPerson = contactPersonCreator.createContactPerson("Andreas", "Nissemand@nordpolen.dk", "88888888");
//
//        contactPersonRepo.save(contactPerson);
//
//        List<ContactPerson> contactPersonList = new ArrayList<>();
//
//        contactPersonList.add(contactPerson);
//
//        // Putting things together
//
//        customer.setContactPersons(contactPersonList);
//        customerRepo.save(customer);
//
//        proposal.setCustomer(customer);
//        proposal.setProducts(productList);
//
//        proposalRepo.save(proposal);

        List<Customer> customers = customerRepo.findAll();
        for (Customer c : customers) {
            if (c.getCvr().equals("123")){
                System.out.println(c.getCompanyName());
                break;
            }
    }


        return "test";
    }



}


