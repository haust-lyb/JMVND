package com.haust.lyb.jmvnd.entitys;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class VisitLog {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="TEXT")
    private String msg;
    private Date createTime;

}
