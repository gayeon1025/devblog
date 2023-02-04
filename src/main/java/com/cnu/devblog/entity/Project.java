package com.cnu.devblog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Entity(name = "projects")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Setter
    private String title;

    @Column
    @Setter
    private String summary;

    @Column
    @Setter
    private String description;

    @Column
    @Setter
    private LocalDateTime startDate;

    @Column
    @Setter
    private LocalDateTime endDate;

    @Column
    @Setter
    private Boolean isInProgress;

    @Builder
    private Project(String title,
                    String summary,
                    String description,
                    LocalDateTime startDate,
                    LocalDateTime endDate,
                    Boolean isInProgress) {
        this.title = title;
        this.summary = summary;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isInProgress = isInProgress;
    }
}
