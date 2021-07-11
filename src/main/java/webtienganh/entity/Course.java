package webtienganh.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String slug;
	private String image;
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "topic_id", referencedColumnName = "id", foreignKey = @ForeignKey(name="fk_course_topic"))
	private Topic topic;
	
	@OneToMany(mappedBy = "course")
	private List<CourseWord> words;
	
	@OneToMany
	private List<CourseSubscribe> users;
	
}
