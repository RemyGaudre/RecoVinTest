package ctie.dmf.RecoVinApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="winetype")
public class WineType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="winetypeid")
	private int winetypeid;
	
	@Column(name="winetypename")
	private String winetypename;

	public WineType(String winetypename) {
		this.winetypename = winetypename;
	}
	
	public WineType() {
	}
	
	public int getWinetypeid() {
		return winetypeid;
	}
	
	public String getWinetypename() {
		return winetypename;
	}

	public void setWinetypename(String winetypename) {
		this.winetypename = winetypename;
	}

	@Override
	public String toString() {
		return "WineType [winetypeid=" + winetypeid + ", winetypename=" + winetypename + "]";
	}
	
}
