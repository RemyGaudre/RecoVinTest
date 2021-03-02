package ctie.dmf.RecoVinApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producer")
public class Producer {

	@Id  
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	@Column(name="producerid")
	private int producerid;
	
	@Column(name="producername")
	private String producername;
	
	@Column(name="address")
	private String address;
	
	@Column(name="city")
	private String city;
	
	@Column(name="postalcode")
	private String postalcode;
	
	@Column(name="country")
	private String country;
	
	@Column(name="website")
	private String website;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;

	public Producer(String producername, String address, String city, String postalcode, String country, String website,
			String phone, String email) {
		super();
		this.producername = producername;
		this.address = address;
		this.city = city;
		this.postalcode = postalcode;
		this.country = country;
		this.website = website;
		this.phone = phone;
		this.email = email;
	}

	public Producer() {
		super();
	}

	public int getProducerid() {
		return producerid;
	}

	public void setProducerid(int producerid) {
		this.producerid = producerid;
	}

	public String getProducername() {
		return producername;
	}

	public void setProducername(String producername) {
		this.producername = producername;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPostalcode() {
		return city;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Producer [producerid=" + producerid + ", producername=" + producername + ", address=" + address
				+ ", city=" + city + ", postalcode=" + postalcode + ", country=" + country + ", website=" + website
				+ ", phone=" + phone + ", email=" + email + "]";
	}
	
}
