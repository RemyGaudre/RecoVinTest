package ctie.dmf.RecoVinApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "wine")
public class Wine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="wineid")
	private int wineid;
	
	@OneToOne
	@JoinColumn( name="id_winetype")
	private WineType winetype;
	
	@OneToOne
	@JoinColumn(name="id_producer")
	private Producer producer;
	
	@Column(name="year_production")
	@Nullable @JsonIgnore
	private Integer year_production;

	public Wine(WineType winetype, Producer producer, int year_production) {
		super();
		this.winetype = winetype;
		this.producer = producer;
		this.year_production = year_production;
	}
	
	public Wine() {
		super();
	}

	public int getWineid() {
		return wineid;
	}

	public void setWineid(int wineid) {
		this.wineid = wineid;
	}

	public WineType getWinetype() {
		return winetype;
	}

	public void setWineType(WineType winetype) {
		this.winetype = winetype;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducteur(Producer producer) {
		this.producer = producer;
	}

	public int getYear_production() {
		try {
			return year_production;
		}catch(Exception e) {
			return 0;
		}
	}

	public void setYear_production(int year_production) {
		this.year_production = year_production;
	}

	@Override
	public String toString() {
		return "Wine [wineid=" + wineid + ", winetype=" + winetype + ", producer=" + producer + ", year_production="
				+ year_production + "]";
	}
	
	
}
