package com.cart.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.Repository.AddressRepository;
import com.cart.Repository.CartRepository;
import com.cart.Repository.ReviewRepository;
import com.cart.Repository.ShoppingRepository;
import com.cart.Repository.SignUpRepository;
import com.cart.entity.AddProduct;
import com.cart.entity.Address;
import com.cart.entity.CartDto;
import com.cart.entity.Login;
import com.cart.entity.Review;
import com.cart.entity.SignUp;

@Service
public class ShoppingService {

	@Autowired
	private ShoppingRepository shopRepo;
	
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private SignUpRepository SignUpRepo;
	
	@Autowired
	private AddressRepository addrRepo;
	
	@Autowired
	private ReviewRepository rewRepo;
	
	public void saveSignUp(SignUp user) {
		SignUpRepo.save(user);
	}
	
	public String verifyLogin(Login verify) {
		System.out.println(verify.getEmail());
	    Optional<SignUp> opVerify=SignUpRepo.findByEmailAndPassword(verify.getEmail(), verify.getPassword());
	    System.out.println(opVerify);
		if(opVerify.isPresent()) {
			return "Yes";
		}else {
			return "No";
		}
	}
	
	public void AddToHome(AddProduct product) {
		shopRepo.save(product);
	}

	public List<AddProduct> getAllProducts() {
		List<AddProduct> products=shopRepo.findAll();
		
		System.out.println(products);
		return products;
	}
	
	public List<AddProduct> searchItems(String name){
		List<AddProduct> products=shopRepo.findAll();
		
		if(name!=null && !name.isEmpty()) {
			List<AddProduct> filterItems=products.stream().filter(product->product.getPName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
			return filterItems;
		}else {
			return products;
		}
	}
	
	public int findId(String email) {
		
		Optional<SignUp> opuser = SignUpRepo.findByEmail(email);
		SignUp user=opuser.get();
		System.out.println(user.getId());
		return (int)user.getId();
	}
	
	/*public void addToCart(CartDto cart){\
		int count=0;
		List<CartDto> cartPdts=cartRepo.findBySid(cart.getSId());
		for(CartDto cartPdt:cartPdts) {
			if(cartPdt.getPId())
		}
		cartRepo.save(cart);
	}*/
	
	public List<CartDto> addToCart(CartDto cart){
		System.out.println(cart.getPId());
		System.out.println(cart.getSId());
		int CId=cart.getPId();
		int CSid=cart.getSId();
		Optional<AddProduct> opProduct=shopRepo.findById((long)cart.getPId());
		AddProduct pdt=opProduct.get();
		long HId=pdt.getPId();
		Optional<SignUp> opuser = SignUpRepo.findById((long)CSid);
		SignUp user=opuser.get();
		long HSid=user.getId();
		System.out.println(HId);
		int count = 0;
		int count1 = 0;
		List<CartDto> cartPdts=cartRepo.findBySid(cart.getSId());
		for(CartDto cartPdt:cartPdts) {
			if((cartPdt.getPId()==HId)) {
				count++;
			}
		}
		List<CartDto> cartPdts1=cartRepo.findAll();
		for(CartDto cartPdt:cartPdts) {
			if(cartPdt.getSId()!=CSid) {
				count1++;
			}
		}
		if((count==0) && (count1==0)) {
			int pqty=pdt.getPQuantity();
			if(pqty==0) {
				pqty=pqty;
			}else {
				//pqty=pqty-1;
				cartRepo.save(cart);
			}
			pdt.setPQuantity(pqty);
			shopRepo.save(pdt);
			List<CartDto> cartProducts= cartRepo.findBySid(cart.getSId());
			return cartProducts;
		}else {
			List<CartDto> cartProducts= cartRepo.findBySid(cart.getSId());
			return cartProducts;
		}}
	
	public List<CartDto> findAllCart(int Id){
		List<CartDto> cartProducts=cartRepo.findBySid(Id);
		return cartProducts;
	}
	
	public List<CartDto> updateCart(long CId,int Id){
		Optional<CartDto> cartProduct=cartRepo.findById(CId);
		CartDto pdt=cartProduct.get();
		Optional<AddProduct> opProduct=shopRepo.findById((long)pdt.getPId());
		AddProduct opPdt=opProduct.get();
		if(cartProduct.isPresent()) {
			int price=pdt.getPPrice();
			int tqty=opPdt.getPQuantity();
			int qty=pdt.getPQuantity();
			System.out.println(price);
			System.out.println(price);
			if(tqty==qty) {
				qty=qty;
				tqty=tqty;
			}else {
				qty=qty+1;
				//tqty=tqty-1;
				price=price+opPdt.getPPrice();
			}
			pdt.setPPrice(price);
			pdt.setPQuantity(qty);
			opPdt.setPQuantity(tqty);
			shopRepo.save(opPdt);
			cartRepo.save(pdt);
			
		}else {
			cartRepo.save(pdt);
		}
		List<CartDto> cartProducts=cartRepo.findBySid(Id);
		return cartProducts;
	}
	
	public List<CartDto> updateCartd(long CId, int Id){
		Optional<CartDto> cartProduct=cartRepo.findById(CId);
		CartDto pdt=cartProduct.get();
		Optional<AddProduct> opProduct=shopRepo.findById((long)pdt.getPId());
		AddProduct opPdt=opProduct.get();
		if(cartProduct.isPresent()) {
			int price=pdt.getPPrice();
			int qty=pdt.getPQuantity();
			int tqty=opPdt.getPQuantity();
			System.out.println(price);
			price=price-opPdt.getPPrice();
			qty=qty-1;
			//tqty=tqty+1;
			System.out.println(price);
			if(price==0) {
				opPdt.setPQuantity(tqty);
				shopRepo.save(opPdt);
				cartRepo.deleteById(CId);
			}else {
				System.out.println(price);
				pdt.setPPrice(price);
				pdt.setPQuantity(qty);
				opPdt.setPQuantity(tqty);
				cartRepo.save(pdt);
				shopRepo.save(opPdt);
			}
		}else {
			cartRepo.save(pdt);
		}
		List<CartDto> cartProducts=cartRepo.findBySid(Id);
		return cartProducts;
	}
	
	public void deleteById(long Id) {
		shopRepo.deleteById(Id);
		List<CartDto> cartProducts=cartRepo.findAll();
		int count=0;
		for(CartDto product:cartProducts) {
			if(product.getPId()==Id) {
				count=count+1;
			}
		}
		if(count>0) {
			cartRepo.deleteById(Id);
		}
	}
	
	public AddProduct getProductById(long Id) {
		Optional<AddProduct> Opproduct=shopRepo.findById(Id);
		AddProduct product=Opproduct.get();
		return product;
	}
	
	public void saveAddress(Address addr) {
		addrRepo.save(addr);
	}
	
	public Iterable<Address> getAddressDetails(int Id){
		Iterable<Address> addresses=addrRepo.findBySid(Id);
		for(Address address: addresses) {
			System.out.println(address.getCity());
		}
		return addresses;
	}
	
	public AddProduct findById(long Id) {
		Optional<AddProduct> Op = shopRepo.findById(Id);
		AddProduct product=Op.get();
		return product;
	}
	
	public void deleteQty(int Id, long PId) {
		System.out.println(PId);
		if(PId==0) {
		List<CartDto> cartProducts = cartRepo.findBySid(Id);
		List<AddProduct> homeproducts=shopRepo.findAll();
		
		for(AddProduct hpdt:homeproducts) {
			for(CartDto cpdt:cartProducts) {
				if(hpdt.getPId()==cpdt.getPId()) {
					int hqty=hpdt.getPQuantity()-cpdt.getPQuantity();
					hpdt.setPQuantity(hqty);
					cpdt.setPQuantity(0);
					cpdt.setPPrice(0);
					shopRepo.save(hpdt);
					cartRepo.deleteById(cpdt.getCId());
				}
			}
		}
	}else {
		Optional<AddProduct> homeProduct= shopRepo.findById(PId);
		AddProduct hpdt=homeProduct.get();
		
		int hqty=hpdt.getPQuantity()-1;
		System.out.println(hqty);
		hpdt.setPQuantity(hqty);
		shopRepo.save(hpdt);
	}
	}
	
	public List<Review> saveRew(Review rew, long id) {
		rewRepo.save(rew);
		System.out.println(rew.getId());
		return rewRepo.findByPid(id);
	}
	
	public List<Review> getallReviews(long id){
		System.out.println(id);
		List<Review> byPid = rewRepo.findByPid(id);
		System.out.println(byPid);
		for(Review reqq:byPid ) {
			System.out.println(reqq.getReview());
		}
		return rewRepo.findByPid(id);
	}
	
	public int getRating() {
		List<Review> byPid = rewRepo.findAll();
		return 0;
	}
	
	public void savetoHome(float Trat, long Pid) {
		Optional<AddProduct> Opproduct=shopRepo.findById(Pid);
		AddProduct product=Opproduct.get();
		product.setpRating(Trat);
		System.out.println(product.getpRating());
		shopRepo.save(product);
	}
}

