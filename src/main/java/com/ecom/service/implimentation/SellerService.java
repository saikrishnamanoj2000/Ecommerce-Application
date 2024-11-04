package com.ecom.service.implimentation;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.dto.Product;
import com.ecom.dto.Seller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

public interface SellerService {

	String loadRegister(ModelMap map);

	String loadRegister(Seller seller, BindingResult result, HttpSession session);

	String submitOtp(int id, int otp, HttpSession session);

	String loadHome(HttpSession session);

	String addProduct(HttpSession session, ModelMap map);

	String addProduct(HttpSession session, @Valid Product product, BindingResult bindingResult, MultipartFile file);

	String viewProducts(HttpSession session, ModelMap map);

	String deleteProduct(HttpSession session, int id);

	String editProduct(HttpSession session, int id, ModelMap map);

	String updateProduct(HttpSession session, @Valid Product product, BindingResult result, MultipartFile image);

	String resendOtp(int id, HttpSession session);

}