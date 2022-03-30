package com.etiya.rentACar.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//data anatasyon denir
@Data // get ve set
@AllArgsConstructor //
@NoArgsConstructor // parametresiz const
@Entity // veri tabanı
@Table(name = "brands") // tabla ismi
public class Brand {
	@Id // id diğer alanlardan farklı olduğunu
	@GeneratedValue(strategy = GenerationType.IDENTITY) // oluşturulan değer
	
	@Column(name = "brandId") // sütun
	private int id;

	@Column(name = "brandName") // ccolumn gösterme demek
	private String name;

	@OneToMany(mappedBy = "brand")
	private List<Car> cars;

}
