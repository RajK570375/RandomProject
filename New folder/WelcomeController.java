package com.capgemini.capstore;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.ProductFeedback;

@Controller
public class WelcomeController {

	// inject via application.properties
	/*
	 * @Value("${welcome.message:test}") private String message = "Hello World";
	 * 
	 * @RequestMapping("/") public String welcome(Map<String, Object> model) {
	 * model.put("message", this.message); return "welcome"; }
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getHomepage(ModelMap map)
	{
		RestTemplate rest = new RestTemplate();
		
		List<ProductFeedback> feedbackList = rest.getForObject("http://localhost:8088/getAll", List.class);
		map.addAttribute("list", feedbackList);
		//System.out.println("\n\n\n\njjjjjj"+temp);
		return "FeedbackProduct";
	}  
	@RequestMapping("/FeedbackProduct")
	public String getFeedbackForm(ModelMap map)
	{
		return "FeedbackParticularProduct";
	}
	
	@RequestMapping(value="/Merchant")
	public String getmerchantFeedback(ModelMap map)
	{
		RestTemplate rest = new RestTemplate();
		
		List<ProductFeedback> MerchantfeedbackList = rest.getForObject("http://localhost:8088/getAllMerchant", List.class);
		map.addAttribute("list", MerchantfeedbackList);
		System.out.println(MerchantfeedbackList);
		return "FeedbackMerchant";
	}
	@RequestMapping(value="/MerchantFeedback")
	public String addMerchantFeedback()
	{
		return "FeedbackParticularMerchant";
	}
	

	/*@RequestMapping("/")
	public String getResponse(ModelMap map){
			
	
		return "Login";
		
		}
	
	@RequestMapping(value="/Ask", method=RequestMethod.POST,produces = "application/json")
	public String getSignUp(HttpServletRequest request) {
		RestTemplate rest = new RestTemplate();
		
		User user = new User();
		String email = request.getParameter("email");
		user.setEmailId(email);
		user.setPassword("qwerty");
		user.setRole("CUSTOMER");
		user.setSecurityAnswer("me");
		user.setSecurityQuestion("asd");
		
		RestResponseUser restRes = new RestResponseUser();
		restRes.setUser(user);
		
		String str = rest.postForObject("http://localhost:8088/logIn", user, String.class);
		System.out.println(str);
		return str;
	}
	
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public void getSignUpDetails(@RequestBody User user) {
		
		
		
	}*/
	
//	@RequestMapping("/CustomerSignUpDone")
	
	@RequestMapping(value = "/addProductFeedback", method = RequestMethod.GET)
	public String setFeedbackForParticularProduct(HttpServletRequest request)
	{
		RestTemplate rest = new RestTemplate();
		String feedback = request.getParameter("feedback");
		String rating = request.getParameter("rating");
		System.out.println("\nfeedback: "+feedback+"\nrating: "+rating);
		Customer customer = new Customer();
		customer.setCustomerAddress("Agra");
		customer.setCustomerEmail("xyz@gmail.com");
		customer.setCustomerId(10000);
		customer.setCustomerMobileNumber("8989898989");
		customer.setCustomerName("ABC");
		customer.setCustomerPincode("787878");
		Product product = new Product();
		product.setProductBrand("aaa");
		product.setProductCategory("gggh");
		product.setProductFeature("hh");
		product.setProductImageUrl("asasas");
		product.setProductId(30000);
		product.setProductType("hhhh");
		product.setProductModel("ssa");
		product.setProductName("gaggsa");
		ProductFeedback pfeedback  = new ProductFeedback();
		pfeedback.setProductFeedback(feedback);
		pfeedback.setRating(Integer.parseInt(rating));
		pfeedback.setCustomer(customer);
		pfeedback.setId(6001);
		pfeedback.setProduct(product);
		RestResponseFeedback resfeedback = new RestResponseFeedback();
		resfeedback.setProductFeedback(pfeedback);
		String str = rest.postForObject("http://localhost:8088/addFeedback", pfeedback, String.class);
		return "FeedbackProduct";
		
	}
	
	@RequestMapping(value="/addMerchantFeedback", method=RequestMethod.GET)
	public void addMerchantFeedback(HttpServletRequest request)
	{
		
	}
	
	/*@RequestMapping(value = "/h", method=RequestMethod.GET)
	public void getAllfeedback(HttpServletRequest request,Model map)
	{
		RestTemplate rest = new RestTemplate();
		List<ProductFeedback> feedbackList = new ArrayList<ProductFeedback>();
		map.addAttribute("list", feedbackList);
		ArrayList<ProductFeedback> temp = rest.postForObject("http://localhost:8088/getAll", feedbackList, ArrayList.class);
		//System.out.println("\n\n\n\njjjjjj"+temp);
	}*/
	
	
}
