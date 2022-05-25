package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.CartDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.model.Cart;

public interface ICartService {

    ResponseDTO getCartDetails();

    Cart getCartDetailsById(Integer cartId);

    Cart deleteCartItemById(Integer cartId);

    Cart updateRecordById(Integer cartId, CartDTO cartDTO);

    Cart insertItems(CartDTO cartdto);

    Cart getCartRecordByBookId(Integer bookID);
}
