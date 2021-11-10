package com.tunghai.server_demo.Model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "test_art_work_information")
@Getter
@Setter
@NoArgsConstructor
public class ArtWorkModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="ART_NAME")
    private String artName;
    @Column(name="AUTHOR")
    private String author;
    @Column(name="OVER_VIEW")
    private String overView;
    @Column(name="CREATE_DATE")
    private String createDate;
    @Column(name="FILE_PATH")
    private String filePath;

}
