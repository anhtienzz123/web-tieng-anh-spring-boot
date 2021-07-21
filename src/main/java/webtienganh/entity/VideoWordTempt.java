package webtienganh.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@IdClass(VideoWordTempt_PK.class)
public class VideoWordTempt {

	@Id
	@ManyToOne
	@JoinColumn(name = "video_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_videowordtempt_video"))
	private Video video;

	@Id
	@ManyToOne
	@JoinColumn(name = "video_word_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_videowordtempt_videoWord"))
	private VideoWord videoWord;

	private int frequency;
}
