/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.repository;

import com.godoro.crm.entity.Product;
import com.godoro.library.database.BaseRepository;

/**
 *
 * @author Erol
 */
public class ProductRepository extends BaseRepository<Product>{

    public ProductRepository(){
        super(Product.class);
    }
    
}
