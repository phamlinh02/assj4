package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the share database table.
 * 
 */
@Entity
@Table(name="share")
@NamedQuery(name="Share.findAll", query="SELECT s FROM Share s")
public class Share implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String emails;

	private Timestamp shareDate;

	//bi-directional many-to-one association to Nguoidung
	@ManyToOne
	@JoinColumn(name="userId")
	private Nguoidung nguoidung;

	//bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name="videoId")
	private Video video;

	public Share() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmails() {
		return this.emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public Timestamp getShareDate() {
		return this.shareDate;
	}

	public void setShareDate(Timestamp shareDate) {
		this.shareDate = shareDate;
	}

	public Nguoidung getNguoidung() {
		return this.nguoidung;
	}

	public void setNguoidung(Nguoidung nguoidung) {
		this.nguoidung = nguoidung;
	}

	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}