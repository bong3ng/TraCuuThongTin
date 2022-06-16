package ghtk.excel.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cachocsinh")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HocSinh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stt;
	
	@Column
	private String truong;
	@Column
	private String quanHuyen;
	@Column
	private String maHocSinh;
	@Column
	private String lop;
	@Column
	private String hoTen;
	@Column
	private int ngay;
	@Column
	private int thang;
	@Column
	private int nam;
	@Column
	private String gioiTinh;
	@Column
	private String noiSinh;
	@Column
	private String danToc;
	@Column
	private String hoKhau;
	@Column
	private String dienThoai;
	@Column
	private int diem1;
	@Column
	private int diem2;
	@Column
	private int diem3;
	@Column
	private int diem4;
	@Column
	private int diem5;
	@Column
	private int diem5nam;
	@Column
	private int uuTien;
	@Column
	private int tongDiem;
	@Column
	private String ghiChu;
	
	
	
}
