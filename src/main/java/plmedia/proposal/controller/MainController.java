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
        return "index";
    }

    @RequestMapping(value = {"products"}, method = RequestMethod.GET)
    public String products(Model model) {
        model.addAttribute("products", productRepo.findAll());
        model.addAttribute("product", new Product());
        return "products";
    }

    @RequestMapping (value = {"createproduct"}, method = RequestMethod.POST)
    public String createProduct(@ModelAttribute("product") Product product){
        productRepo.save(product);
        return "redirect:/products";
    }

    @RequestMapping(value = {"productdetails"}, method = RequestMethod.GET)
    public String productDetails(Model model, @RequestParam int productId) {
        model.addAttribute("product", productRepo.findById(productId));
        return "productdetails";
    }

    @RequestMapping (value = {"updateproduct"}, method = RequestMethod.POST)
    public String updateProduct(@ModelAttribute("product") Product product){
        System.out.println(product);
            productRepo.save(product);

        return "redirect:/products";
    }

    @RequestMapping (value = {"deleteproduct"}, method = RequestMethod.GET)
    public String deleteProduct(@RequestParam int productId) {
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
    public String sentProposals(Model model) {
        model.addAttribute("sentProposals", proposalRepo.findAll());

        return "sentproposals";
    }

    @RequestMapping(value = {"sentproposals"}, method = RequestMethod.POST)
        public String sentProposals(@RequestParam(value = "searchfield", required = false) String searchField,
                                    @RequestParam(value = "searchtype", required = false) String searchType,
                                    Model model) {

        if (searchType.equalsIgnoreCase("cvr")) { // Fx. 123
            model.addAttribute("sentProposals", proposalRepo.findAllByCustomer_Cvr(searchField));
        } else if (searchType.equalsIgnoreCase("companyname")) { // Fx. Cofoco ApS
            model.addAttribute("sentProposals", proposalRepo.findAllByCustomerCompanyName(searchField));
        } else if (searchType.equalsIgnoreCase("email")) { // fx. Julemand@nordpolen.dk
            model.addAttribute("sentProposals", proposalRepo.findAllByCustomerContactPersonsEmail(searchField));
        } else if (searchType.equalsIgnoreCase("search")) { // In case you do not type anything in searchfield
            model.addAttribute("sentProposals", proposalRepo.findAll());
        }
        return "sentproposals";
    }

    @RequestMapping(value = {"proposaldetails"}, method = RequestMethod.GET)
    public String proposalDetails(Model model, @RequestParam("proposalId") int proposalId) {
        model.addAttribute("p", proposalRepo.findById(proposalId));
        return "proposaldetails";
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


