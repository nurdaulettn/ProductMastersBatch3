package org.example.easy;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movie {
    private String title;
    private String director;
    private int year;
}
