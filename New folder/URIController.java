package com.capgemini.capstore.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.capstore.beans.MerchantFeedback;
import com.capgemini.capstore.beans.ProductFeedback;
import com.capgemini.capstore.beans.User;
import com.capgemini.capstore.services.CapstoreService;
import com.capgemini.capstore.services.ICapStoreAdminService;
import com.capgemini.capstore.services.ICapStoreCommonService;
import com.capgemini.capstore.services.ICapStoreCustomerService;
import com.capgemini.capstore.services.ICapStoreMerchantService;

@RestController
public class URIController {

	@Autowired
	ICapStoreCommonService commonService;

	@Autowired
	ICapStoreAdminService adminService;

	@Autowired
	ICapStoreMerchantService merchantService;

	@Autowired
	ICapStoreCustomerService customerService;
	
	@Autowired
	CapstoreService capstoreService;

	@RequestMapping("/")
	public String abc()
	{
		return "kuch bhi";
	}
	
	
	@RequestMapping(value = "/logIn", method = RequestMethod.POST)
	public String logIn(@RequestBody @Valid User user, HttpServletRequest request) {
		
		return "HomeCustomer";
		/*System.out.println(user);
		boolean result = false;
		try {
			
			result = commonService.ValidateLogIn(user);
			
			if(result) {
			
				HttpSession session = request.getSession(true);
				session.setAttribute("userId", user.getEmailId());
				session.setAttribute("role", user.getRole());
				
				if (user.getRole().equals("ADMIN")) {
					
					return "adminIndexLoginPage";
					
				}
				if (user.getRole().equals("MERCHANT")) {
									
					return "merchantIndexLoginPage";				
									
				}
				if (user.getRole().equals("CUSTOMER")) {
					
					return "customerIndexLoginPage";
					
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// set error msg
		return "indexPageWithErrorMsg";*/
	}

	@RequestMapping(value = "/logOut", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request) {
		
		request.getSession().invalidate();
		return "indexPage";
		
	}

	@RequestMapping(value = "/forgotPassword/{email}", method = RequestMethod.POST)
	public String forgotPassword(@PathVariable String email, HttpServletRequest request) {
		
		String securityQuestion;
		
		if ((securityQuestion = commonService.isValidEmail(email)) != null) {
			
			request.getSession().invalidate();
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			session.setAttribute("securityQuestion", securityQuestion);
			return "checkSecurityAnswer";
			
		}
		
		return "forgotPasswordWithErrorMsg";
	}

	@RequestMapping(value = "/checkSecurityAnswer/{securityAnswer}", method = RequestMethod.POST)
	public String checkSequirityAnswer(@PathVariable String securityAnswer, HttpServletRequest request) {

		HttpSession session = request.getSession();
		if (commonService.checkSequirityAnswer((String) session.getAttribute("email"), securityAnswer)) {
			
			session.setAttribute("securityAnswer", securityAnswer);
			return "passwordChangePage";
			
		}

		return "forgotPasswordWithErrorMsg";
	}

	@RequestMapping(value = "/passwordChangePage/{password}", method = RequestMethod.POST)
	public String passwordChangePage(@PathVariable String password, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		commonService.updatePassword(email, password);
		return "indexpage";
		
	}

	@RequestMapping(value = "/changePassword/{oldPassword}/{newPassword}", method = RequestMethod.PUT)
	public String changePassword(@PathVariable String oldPassword, @PathVariable String newPassword,
			HttpServletRequest request) {

		HttpSession session = request.getSession();
		
		if (session == null) {
			return "logIn page WIth Msg you need to log In first";
		}
		
		if (commonService.changePassword((String) session.getAttribute("userId"), oldPassword, newPassword)) {
			return "passwordChangeSuccessfully";
		}
		
		return "changePasswordwithErrorPage";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUp(@Valid @RequestBody User user) {
		
		
		System.out.println(user);
	
//		if (commonService.ValidateUserDetails(user)) {
//			if (user.getRole().equals("CUSTOMER")) {
//				return "RegisterCustomerPage";
//			} else if (user.getRole().equals("MERCHANT")) {
//				return "RegisterMerchantPage";
//			}
//		} else {
//			// set error msg details are incorrect
//			return "SignUpPage";
//		}
		return "SignUpPage";
	}
	
	@RequestMapping(value="/addFeedback",method=RequestMethod.POST)
	public ProductFeedback setProductFeedback(@RequestBody ProductFeedback productFeedBack)
	{
		return capstoreService.setFeedback(productFeedBack);
	}
	
	@RequestMapping(value="/getAll/{product_Id}",  method = RequestMethod.GET)
	public List<ProductFeedback> showAllProductFeedback(@PathVariable int product_Id)
	{
		return capstoreService.getAll(product_Id);
	}
	
	@RequestMapping(value="/addMerchantFeedback",method=RequestMethod.POST)
	public MerchantFeedback setProductFeedback(@RequestBody MerchantFeedback merchantFeedBack)
	{
		return capstoreService.setMerchantFeedback(merchantFeedBack);
	}
	
	
	@RequestMapping(value="/getAllMerchant",  method = RequestMethod.GET)
	public List<MerchantFeedback> showMerchantFeedback()
	{
		return capstoreService.getFinalMerchantFeedback();
	}
}
