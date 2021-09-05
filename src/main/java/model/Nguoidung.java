package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nguoidung database table.
 * 
 */
@Entity
@Table(name="nguoidung")
@NamedQuery(name="Nguoidung.findAll", query="SELECT n FROM Nguoidung n")
public class Nguoidung implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private boolean admin;

	private String email;

	private String fullname;

	private String password;

	//bi-directional many-to-one association to Favorite
	@OneToMany(mappedBy="nguoidung")
	private List<Favorite> favorites;

	//bi-directional many-to-one association to Share
	@OneToMany(mappedBy="nguoidung")
	private List<Share> shares;

	public Nguoidung() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean getAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Favorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public Favorite addFavorite(Favorite favorite) {
		getFavorites().add(favorite);
		favorite.setNguoidung(this);

		return favorite;
	}

	public Favorite removeFavorite(Favorite favorite) {
		getFavorites().remove(favorite);
		favorite.setNguoidung(null);

		return favorite;
	}

	public List<Share> getShares() {
		return this.shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	public Share addShare(Share share) {
		getShares().add(share);
		share.setNguoidung(this);

		return share;
	}

	public Share removeShare(Share share) {
		getShares().remove(share);
		share.setNguoidung(null);

		return share;
	}

}