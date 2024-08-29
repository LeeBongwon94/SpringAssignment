package com.sparta.springassignment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "manage")
@NoArgsConstructor
public class Manage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manage_id;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedules schedulesManage;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
}
