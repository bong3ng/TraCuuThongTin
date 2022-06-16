package ghtk.excel.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import ghtk.excel.model.HocSinh;

public interface HocSinhRepository extends JpaRepository<HocSinh, Integer> {

	ArrayList<HocSinh> findByHoTen(String hoTen);

	ArrayList<HocSinh> findByMaHocSinh(String maHocSinh);


}
