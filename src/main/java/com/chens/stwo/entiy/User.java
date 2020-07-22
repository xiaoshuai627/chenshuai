package com.chens.stwo.entiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private int userAge;
    private String userEmail;
    private Address userAddress;
    private List<Book> books;
}
