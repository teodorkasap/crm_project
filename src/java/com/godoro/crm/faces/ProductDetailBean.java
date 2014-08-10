/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.faces;

import com.godoro.crm.entity.Customer;
import com.godoro.crm.entity.Employee;
import com.godoro.crm.entity.Product;
import com.godoro.crm.repository.ProductRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Erol
 */
@ManagedBean
@RequestScoped
public class ProductDetailBean {
    private Product product;
    private List<Customer> customerList;
    private List<Employee> employeeList;
    private long selectedCustomerId;
    private long selectedEmployeeId;
    

    /**
     * Creates a new instance of ProductDetailBean
     */
    public ProductDetailBean() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
        long productId = 0;
        if (request.getParameter("productId") != null) {
            productId = Long.parseLong(request.getParameter("productId"));
        }else{
            if (productId == 0) {
            product = new Product();

        } else {
            ProductRepository productRepository = new ProductRepository();
            product = productRepository.find(productId);
            productRepository.close();
        }
        }
        
            ProductRepository productRepository = new ProductRepository();
            product = productRepository.find(productId);
            productRepository.close();
        
        
    }

    
    public void save() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        long productId = 0;
        if (request.getParameter("productId") != null) {
            productId = Long.parseLong(request.getParameter("productId"));
        }
        
        ProductRepository productRepository=new ProductRepository();
        if(productId==0){
            productRepository.persist(product);
        }else{
            productRepository.merge(product);
        }
        productRepository.close();
    }
}
