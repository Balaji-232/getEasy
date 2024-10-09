package com.cart.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cart.Service.ShoppingService;
import com.cart.emailService.EmailService;
import com.cart.entity.AddProduct;
import com.cart.entity.Address;
import com.cart.entity.CartDto;
import com.cart.entity.Login;
import com.cart.entity.SignUp;
import com.cart.entity.Review;

@Controller
public class AddCartController {
	
	@Autowired
	private ShoppingService shopService;
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/signUp")
	public String signUp() {
		return "signUp_Cart";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login_ShoppingCart";
	}
	
	@PostMapping("/createSignUp")
	public String createSignUp(SignUp user) {
		System.out.println(user.getEmail());
		System.out.println(user.getMobile());
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		emailService.sendEmail(user.getEmail(), "Registration for Ecart", 
				"Hi "+user.getName()+",\n"+"\n"
				+ "Welcome!!!!\n"+"\nYour Registration is Successfull\n"
				+ "Thanks and Regards \n getEasy");
		
		System.out.println(user.getEmail());
		
		shopService.saveSignUp(user);
		return "login_ShoppingCart";
	}
	
	@RequestMapping("/view")
	public String homeView() {
		return "AddProduct";
	}
	
	@RequestMapping("/addhome")
	public String addhome(AddProduct product,
			ModelMap model) {
		emailService.sendEmail(product.getSellerEmail(), "Registration for Ecart", 
				"Hi "+product.getSeller()+",\n"+"\n"
				+ "Welcome!!!!\n"+"\nYour product" + product.getPName() + "of quantity" + product.getPQuantity()
				+ "has been added to our portal.\n\n Thanks for joining hands with getEasy"
				+ "\n\n Have Nice Experience!!!!\n\n"
				+ "Thanks and Regards \n getEasy");
		shopService.AddToHome(product);
		model.addAttribute("product", product);
		return "AddProduct";
	}
	
	@PostMapping("/home")
	public String getAllProduct(Login verify,ModelMap model,
			HttpSession session) {
		System.out.println(verify.getEmail());
		String verified= shopService.verifyLogin(verify);
		if(verified=="Yes") {
		session.setAttribute("email", verify.getEmail());
		List<AddProduct> products=shopService.getAllProducts();
		int rating=shopService.getRating();
		model.addAttribute("products",products);
		return "home";
		}else {
			model.addAttribute("msg","Wrong Password or UserName");
			return "login_ShoppingCart";
		}
		
	}
	
	@GetMapping("/home")
	public String getAllPoducts(HttpSession session, ModelMap model) {
		if(session.getAttribute("email")!=null) {
		List<AddProduct> products=shopService.getAllProducts();
		model.addAttribute("products", products);
		return "home";
		}else {
			return "login_ShoppingCart";
		}
	}
	
	@PostMapping("/search")
	public String search(ModelMap model,
			@RequestParam("search") String search) {
		System.out.println(search);
		List<AddProduct> products= shopService.searchItems(search);
		model.addAttribute("products", products);
		return "home";
	}
	
	@PostMapping("/cart")
	public String cartProducts(
			@RequestParam("PId") int PId,
			@RequestParam("PImage") String PImage,
			@RequestParam("PName") String PName,
			@RequestParam("PPrice") int PPrice,
			@RequestParam("PQuantity") int PQuantity,
			@RequestParam("Pseller") String PSeller,
			HttpSession session,
			ModelMap model
			){
		if(session.getAttribute("email")!=null) {
		String email=(String)session.getAttribute("email");
		int Id=shopService.findId(email);
		CartDto cart=new CartDto();
		cart.setSId(Id);
		cart.setPId(PId);
		cart.setPImage(PImage);
		cart.setPName(PName);
		cart.setPPrice(PPrice);
		cart.setPQuantity(PQuantity);
		cart.setSeller(PSeller);
		shopService.addToCart(cart);
		/*if(cartProducts.isEmpty()) {
			List<AddProduct> products=shopService.getAllProducts();
			model.addAttribute("products",products);
			return "home";
		}else {
		model.addAttribute("cartProducts", cartProducts);
		return "cart";}*/
		List<AddProduct> products=shopService.getAllProducts();
		model.addAttribute("products",products);
		return "home";
		}else {
			return "login_ShoppingCart";
		}
	}
	
	@GetMapping("/cart")
	public String getCartProducts(HttpSession session, ModelMap model) {
		if(session.getAttribute("email")!=null) {
			String email=(String)session.getAttribute("email");
			int Id=shopService.findId(email);
			List<CartDto> cartProducts=shopService.findAllCart(Id);
			model.addAttribute("cartProducts", cartProducts);
			return "cart";
		}else {
			return "login_ShoppingCart";
		}
	}
	
	@PostMapping("/cartIncrease")
	public String cartIncrease(
			@RequestParam("CId") long CId,
			HttpSession session,
			ModelMap model
			) {
		if(session.getAttribute("email")!=null) {
		System.out.println(CId);
		String email=(String)session.getAttribute("email");
		int Id=shopService.findId(email);
		List<CartDto> cartProducts=shopService.updateCart(CId, Id);
		model.addAttribute("cartProducts", cartProducts);
		return "cart";
	}else {
		return "login_ShoppingCart";
	}}
	
	@PostMapping("/cartDecrease")
	public String cartDecrease(
			@RequestParam("CId") long CId,
			HttpSession session,
			ModelMap model
			) {
		System.out.println(CId);
		String email=(String)session.getAttribute("email");
		int Id=shopService.findId(email);
		List<CartDto> cartProducts=shopService.updateCartd(CId, Id);
		model.addAttribute("cartProducts", cartProducts);
		return "cart";
	}
	
	@PostMapping("/payment")
	public String Payment(
			@RequestParam("TPrice") int TPrice,
			@RequestParam("TQty") int TQty,
			ModelMap model,
			HttpSession session){
		if(session.getAttribute("email")!=null) {
			System.out.println(session.getAttribute("email"));
			if(TQty!=0) {
				model.addAttribute("Price", TPrice);
				model.addAttribute("Quantity", TQty);
				model.addAttribute("msg", "cart");
				model.addAttribute("PId", 0);
					System.out.println(TQty);
				return "payment";
			}else {
				List<AddProduct> products=shopService.getAllProducts();
				model.addAttribute("products",products);
				return "home";
			}
			}else {
				System.out.println(session.getAttribute("email"));
				return "login_ShoppingCart";
			}
	}
	
	@PostMapping("/payment1")
	public String Payment1(
			@RequestParam("TPrice") int TPrice,
			@RequestParam("TQty") int TQty,
			@RequestParam("PId") long Id,
			ModelMap model,
			HttpSession session){
		if(session.getAttribute("email")!=null) {
			System.out.println(session.getAttribute("email"));
			if(TQty!=0) {
				/*AddProduct product=shopService.findById(Id);
				int Qty=product.getPQuantity()-1;
				product.setPQuantity(Qty);
				shopService.AddToHome(product);*/
				model.addAttribute("Quantity",1);
				model.addAttribute("Price", TPrice);
				model.addAttribute("msg", "home");
				model.addAttribute("PId", Id);
				return "payment";
			}else {
				List<AddProduct> products=shopService.getAllProducts();
				model.addAttribute("products",products);
				return "home";
			}
			}else {
				System.out.println(session.getAttribute("email"));
				return "login_ShoppingCart";
			}
	}
	
	@PostMapping("/orderDetails")
	public String orderDetails(
			@RequestParam("Price") int price,
			@RequestParam("Shipping_Fee") int SFee,
			@RequestParam("Qty") int Qty,
			@RequestParam("PId") int PId,
			//@RequestParam("msg") String msg,
			ModelMap model, HttpSession session
			) {
		if(session.getAttribute("email")!=null) {
		String email=(String)session.getAttribute("email");
		int Id=shopService.findId(email);
		Iterable<Address> addresses= shopService.getAddressDetails(Id);
		model.addAttribute("addresses", addresses);
		model.addAttribute("Price", price);
		model.addAttribute("Sfee", SFee);
		model.addAttribute("Qty", Qty);
		model.addAttribute("PId", PId);
		//model.addAttribute("msg", msg);
		System.out.println(Qty);
		return "order_Details";
		}else {
			return "login_ShoppingCart";
		}
	}
	
	@RequestMapping("/list_All")
	public String listAllProducts(ModelMap model, HttpSession session) {
		if(session.getAttribute("email")!=null) {
		List<AddProduct> products=shopService.getAllProducts();
		model.addAttribute("products", products);
		return "list_All";
		}else {
			return "login_ShoppingCart";
		}
	}
	
	@GetMapping("/deleteProduct")
	public String deleteReg(
			@RequestParam long id, ModelMap model,
			HttpSession session) {
		if(session.getAttribute("email")!=null) {
		shopService.deleteById(id);
		List<AddProduct> products=shopService.getAllProducts();
		model.addAttribute("products", products);
		return "list_All";
		}else {
			return "login_ShoppingCart";
		}
	}
	
	@GetMapping("/getProductById")
	public String getProductById(
			@RequestParam long id,
			ModelMap model,
			HttpSession session) {
		if(session.getAttribute("email")!=null) {
		AddProduct product=shopService.getProductById(id);
		model.addAttribute("product", product);
		return "update";
		}else {
			return "login_ShoppingCart";
		}
	}
	
	@PostMapping("/update")
	public String updateProduct(AddProduct product,
			ModelMap model,
			HttpSession session) {
		if(session.getAttribute("email")!=null) {
		shopService.AddToHome(product);
		List<AddProduct> products=shopService.getAllProducts();
		model.addAttribute("products", products);
		return "list_All";
		}else {
			return "login_ShoppingCart";
		}
	}
	
	@RequestMapping("/address")
	public String addAddress(HttpSession session){
		if(session.getAttribute("email")!=null) {
		return "addAddress";
		}else {
			return "login_ShoppingCart";
		}
	}
	
	@PostMapping("/saveAddress")
	public String saveAddress(Address addr, HttpSession session) {
		if(session.getAttribute("email")!=null) {
		String email=(String)session.getAttribute("email");
		int Id=shopService.findId(email);
		System.out.println(Id);
		System.out.println(addr.getsId());
		addr.setsId(Id);
		System.out.println(addr.getsId());
		shopService.saveAddress(addr);
		return "addAddress";
		}else {
			return "login_ShoppingCart";
		}
	}
	
	@PostMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "login_ShoppingCart";
	}
	
	@PostMapping("/pay")
	public String finalPayment(HttpSession session,
			@RequestParam("FinalPrice") int FinalPrice,
			@RequestParam("addr") String addr,
			//@RequestParam("msg") String msg,
			@RequestParam("PId") long PId,
			ModelMap model) {
		if(session.getAttribute("email")!=null) {
			String email=(String)session.getAttribute("email");
			int Id= shopService.findId(email);
			shopService.deleteQty(Id, PId);
			model.addAttribute("FinalPrice", FinalPrice);
			model.addAttribute("addr",addr);
			return "order_Placed";
		}else {
			return "login_Shopping";
		}
	}
	
	@RequestMapping("/review")
	public String Review(@RequestParam("PId") long Pid, 
			@RequestParam("Trat") float Trat,
			ModelMap model) {
		model.addAttribute("rating", 0);
		model.addAttribute("reviews",null);
		model.addAttribute("Pid", Pid);
		shopService.savetoHome(Trat, Pid);
		System.out.println(Pid);
		//model.addAttribute("reviews", rews);
		return "review";
	}
	
	@PostMapping("/saveRew")
	public String saveRew(@RequestParam("rating") int rating,
						  @RequestParam("review") String review,
						  @RequestParam("Rid") long PId,
						  ModelMap model) {
		Review rev=new Review();
		rev.setRid(PId);
		rev.setRating(rating);
		rev.setReview(review);
		System.out.println(PId);
	    List<Review> rews = shopService.saveRew(rev, PId);
	    AddProduct product= shopService.getProductById(PId);
	    model.addAttribute("reviews", rews);
	    model.addAttribute("product", product);
	    return "product"; // Update with your success page URL
	}
	
	@GetMapping("/product")
	public String getProduct(@RequestParam long id, ModelMap model) {
		AddProduct product = shopService.getProductById(id);
		List<Review> rews = shopService.getallReviews(id);
		model.addAttribute("product", product);
		model.addAttribute("reviews", rews);
		return "product";
	}

}

