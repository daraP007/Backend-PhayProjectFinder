package devDara.phayStudyBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project")
public class Project {
    private int projectId;


    private String title;
    private String author;
    private String description;
    private String languageOne;
    private String languageTwo;
    private String languageThree;
    private String languageFour;
    private String languageFive;
    private String frontEndFramework;
    private String backEndFramework;

}
