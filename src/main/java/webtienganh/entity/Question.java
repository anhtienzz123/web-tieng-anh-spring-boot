package webtienganh.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int stt;
	private String type;
	private String content;
	private String a;
	private String b;
	private String c;
	private String d;
	private String result;
	private String extra;
	
	@ManyToOne
	@JoinColumn(name = "exam_id", referencedColumnName = "id", foreignKey = @ForeignKey(name="fk_question_exam"))
	private Exam exam;
	
	@ManyToOne
	@JoinColumn(name = "paragraph_id", referencedColumnName = "id", foreignKey = @ForeignKey(name="fk_question_paragraph"))
	private Paragraph paragraph;
	
	
}
