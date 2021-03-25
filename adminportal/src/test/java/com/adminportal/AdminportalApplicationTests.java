package com.adminportal;
  
   
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.adminportal.entities.Book;
import com.adminportal.entities.User;
import com.adminportal.repository.BookRepository;
import com.adminportal.repository.UserRepository; 
import com.adminportal.service.impl.BookServiceImpl;
import com.adminportal.service.impl.UserServiceImpl; 

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminportalApplicationTests {

   
    
    @Autowired
    BookServiceImpl bookServiceImpl;
    
    @Autowired
    UserServiceImpl userServiceImpl; 
     
    @MockBean
    BookRepository bookRepo;
    
    @MockBean
    UserRepository userRepo;
    
    
    @Test
    public void getBookListTest() {
    	
    	when(bookRepo.findAll()).thenReturn(Stream.of(new Book(1, "Water Theory", "Himesh Mohan", "Good books", "2011-12-12", "English", "Management", "PaperBack", 200, 120, 2, 10, 400, false, 2, "Good Book", 1),
    			new Book(2, "Water body", "Hitesh Mohan", "Good books", "2015-12-12", "English", "Management", "PaperBack", 200, 120, 2, 10, 400, false, 2, "Good Book", 1))
    			.collect(Collectors.toList()));
    	
    	assertEquals(2,bookServiceImpl.findAll().size());
    }
      
    
   
    
    
    @Test
    public void saveBookTest() {
    	
    	Book b1 =new Book(2, "Indian Economics", "Brijesh Bhanu", "HiTide books", "2016-04-12", "English", "Management", "PaperBack", 400, 120, 2, 10, 400, false, 2, "A Book for Economist", 1);
    	 
    	when(bookRepo.save(b1)).thenReturn(b1);
    	 
    	assertEquals(b1,bookServiceImpl.save(b1));
    	
    	
    }
    
    @Test
    public void deleteBookTest() {
    	
    	Book b1 =new Book(2, "Indian Economics", "Brijesh Bhanu", "HiTide books", "2016-04-12", "English", "Management", "PaperBack", 400, 120, 2, 10, 400, false, 2, "A Book for Economist", 1);
   	 
    	bookServiceImpl.remove(b1);
    	
    	verify(bookRepo , times(1)).delete(b1) ;
    	
    }
    
    @Test
    public void getUserListTest() {
    
    	when(userRepo.findAll()).thenReturn(Stream.of(new User(1,"prasannap","prasannap","Prasanna","Phadtare","8329245532","prasannaphadtare9876@gmail.com")
    												,new User(2,"pratikp","pratikp","Pratik","Patil","7972162972","aakashvp77@gmail.com")
    												,new User(3,"prasadj", "prasadj", "Prasad", "Jagtap", "9895461230", "prasad@gmail.com")
    			 ).collect(Collectors.toList()));
    	
    	assertEquals(3,userServiceImpl.getAllUser().size());
     
    }
    
    
    @Test
    public void saveUserTest() {
    	
    	User testUser=new User(3,"rushi","rushi","Rushikesh","Chandile","8988501972","rushi.c77@gmail.com");
    	
    	when(userRepo.save(testUser)).thenReturn(testUser);
   	 
    	assertEquals(testUser,userServiceImpl.save(testUser));
    	
    	
    }
    
    @Test
    public void deleteUserTest() {
    	
    	  
        User testUser=new User(3,"rushi","rushi","Rushikesh","Chandile","8988501972","rushi.c77@gmail.com");
    	
    	userServiceImpl.remove(testUser);
    	
    	verify(userRepo , times(1)).delete(testUser) ;
    	
    }
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
}