package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.BookDTO;
import com.bridgelabz.bookstore.exception.BookStoreException;
import com.bridgelabz.bookstore.model.Book;
import com.bridgelabz.bookstore.repository.BookStoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j


public class BookService implements IBookService{


    @Autowired
    BookStoreRepository bookStoreRepository;


    @Override
    public Book createBook(BookDTO bookDTO) {
        Book newBook = new Book(bookDTO);
        return  bookStoreRepository.save(newBook);
    }


    @Override
    public Book getBookDataById(int BookId) {
        Optional<Book> getBook=bookStoreRepository.findById(BookId);
        if(getBook.isPresent()){
            return getBook.get();

        }
        throw new BookStoreException("Book Store Details for id not found");

    }

    @Override
    public List<Book> getAllBookData() {
        List<Book> getBooks=bookStoreRepository.findAll();
        return getBooks;
    }

    @Override
    public Book updateRecordById(Integer BookId, BookDTO bookDTO) {

        Optional<Book> updateBook = bookStoreRepository.findById(BookId);
        if (updateBook.isPresent()) {
            Book updateUser = new Book(BookId, bookDTO);
            bookStoreRepository.save(updateUser);
            return updateUser;

        } else {

            throw new BookStoreException("Book record does not found");
        }
    }

    @Override
    public String deleteRecordById(int BookId) {
        Optional<Book> newBook = bookStoreRepository.findById(BookId);
        if (newBook.isPresent()) {
            bookStoreRepository.deleteById(BookId);

        } else {
            throw new BookStoreException("Book record does not found");
        }
        return "data deleted successful";
    }
    @Override
    public List<Book> getBookByName(String bookName) {
        List<Book> findBook= bookStoreRepository.findByBookName(bookName);
        if(findBook.isEmpty()){
            throw new BookStoreException(" Details for provided Book is not found");
        }
        return findBook;
    }

    @Override
    public List<Book> sortedListOfBooksInAscendingOrder() {
        List<Book> getSortedList=  bookStoreRepository.getSortedListOfBooksInAsc();
        return getSortedList;
    }

    @Override
    public List<Book> sortedListOfBooksInDescendingOrder() {
        List<Book> getSortedListInDesc=  bookStoreRepository.getSortedListOfBooksInDesc();
        return getSortedListInDesc;
    }

    @Override
    public List<Book> getBookByAuthorName(String authorName) {
        List<Book> findBook= bookStoreRepository.findByBookAuthorName(authorName);
        if(findBook.isEmpty()){
            throw new BookStoreException(" Details for provided Book is not found");
        }
        return findBook;
    }



}