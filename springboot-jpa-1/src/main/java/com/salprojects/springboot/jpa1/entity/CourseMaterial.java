package com.salprojects.springboot.jpa1.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
        @Id
        @SequenceGenerator(name = "course_material_sequence", sequenceName = "course_material_sequence", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sequence")
        private Long courseMaterialId;
        private String url;

        @OneToOne(
                cascade = CascadeType.ALL ,
//                Using fetch parameter , you can derive info according to our needs.
                fetch = FetchType.LAZY,
                optional = false
        )
        @JoinColumn(name = "course_id", referencedColumnName = "courseId")
        private Course course;
}
