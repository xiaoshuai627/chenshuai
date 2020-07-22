package com.chens.stwo.entiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int bookId;
    private String bookName;
    private int totalPage;
    private int price;
}
