package com.example.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "attendance")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @Column(name = "group_name")
    private String groupName;

    private Boolean attended;
}
