package ghtk.excel.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import ghtk.excel.model.HocSinh;
import ghtk.excel.model.MyFile;
import ghtk.excel.model.TimKiem;
import ghtk.excel.repository.HocSinhRepository;

@Controller
public class BaseController {
	String name;
	@Autowired
	private HocSinhRepository hocSinhRepository;
	@RequestMapping("/")
	public String index(Model model) {
//		model.addAttribute("myFile", new MyFile());
		return "trangchu";
	}
	
	
	@Autowired
	ServletContext application;
	
	@PostMapping("/uploadFile")
	public String uploadFile(MyFile myFile, Model model, @ModelAttribute("timkiem") TimKiem timkiem) {
		if(!myFile.getMultipartFile().isEmpty()) {
			String path = application.getRealPath("/");
		    
		    try {
		      MultipartFile multipartFile = myFile.getMultipartFile();
		      String fileName = multipartFile.getOriginalFilename();
		      String my_path = path + "/file/";
		      name = my_path + fileName;
		      File file = new File(my_path, fileName);
		      multipartFile.transferTo(file);
		      System.out.println("Uploadfile thanh cong");
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		}
		System.out.println(name);
		///ArrayList<HocSinh> hss = new ArrayList<HocSinh>();
        try
        {
            FileInputStream file = new FileInputStream(name);
 
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            Row row = rowIterator.next();
            row = rowIterator.next();
            row = rowIterator.next();
            row = rowIterator.next();
            row = rowIterator.next();
            
            while (rowIterator.hasNext()) 
            {
                row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                HocSinh hs = new HocSinh();
                int i = -1;
                 
                while (cellIterator.hasNext()) 
                {	
                	i++;
                    Cell cell = cellIterator.next();
                    String cellValue = "";
                    int number = 0;
                    //Check the cell type and format accordingly
                    switch (cell.getCellTypeEnum()) 
                    {
                        case NUMERIC:
                        	number = ((Double) cell.getNumericCellValue()).intValue();
                            break;
                        case STRING:
                        	cellValue =(String) cell.getStringCellValue();
                            break;
                        case BOOLEAN:  
                        	cellValue = "";
                        	break;
                        case BLANK:
                        	
                        	break;
                        case ERROR:
                        	break;
                        case FORMULA:
                            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                            number = ((Double) evaluator.evaluate(cell).getNumberValue()).intValue();
                            break;
                        	default:
                        		break;
                    }
                    switch(i) {
                    	case 1:
                    		hs.setTruong(cellValue);
                    		break;
                    	case 2:
                    		hs.setQuanHuyen(cellValue);
                    		break;
                    	case 3:
                    		hs.setMaHocSinh(cellValue);
                    		
                    		break;
                    	case 4:
                    		hs.setLop( cellValue);
                    		break;
                    	case 5:
                    		hs.setHoTen(cellValue);
                    		break;
                    	case 6:
                    		number = Integer.parseInt(cellValue);
                    		hs.setNgay(number);
                    		break;
                    	case 7:
                    		number = Integer.parseInt(cellValue);
                    		hs.setThang(number);
                    		break;
                    	case 8:
                    		number = Integer.parseInt(cellValue);
                    		hs.setNam(number);
                    		break;
                    	case 9:
                    		hs.setGioiTinh(cellValue);
                    		break;
                    	case 10:
                    		hs.setNoiSinh(cellValue);
                    		
                    		break;
                    	case 11:
                    		hs.setDanToc(cellValue);
                    		break;
                    	case 12:
                    		hs.setHoKhau(cellValue);
                    		break;
                    	case 13:
                    		hs.setDienThoai(cellValue);
                    		break;
                    	case 14:
                    		hs.setDiem1(number);
                    		break;
                    	case 15:
                    		hs.setDiem2(number);
                    		break;
                    	case 16:
                    		hs.setDiem3(number);
                    		break;
                    	case 17:
                    		hs.setDiem4(number);
                    		break;
                    	case 18:
                    		hs.setDiem5(number);
                    		break;
                    	case 19:
                    		hs.setDiem5nam(number);
                    		break;
                    	case 20:
                    		hs.setUuTien(number);
                    		break;
                    	case 21:
                    		hs.setTongDiem(number);
                    		break;
                    	case 22:
                    		hs.setGhiChu(cellValue);
                    		break;
                    	default:
                    		break;
                    }
                   
                }
                ///hss.add(hs);
                hocSinhRepository.save(hs);
          
            }
            file.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        Iterable<HocSinh> list = hocSinhRepository.findAll();
        model.addAttribute("CacHocSinh", list);
       
	    return "ketqua";
	  }
	
	@PostMapping("/search")
	public String search(@ModelAttribute("TimKiem") TimKiem timkiem, Model model) {
		ArrayList<HocSinh> hsFind = new ArrayList<HocSinh>();
		List<HocSinh> list = hocSinhRepository.findAll();
		String maHS = timkiem.getMaHocSinh();

		String tenHS = timkiem.getHoTen().toLowerCase();
		String[] part = maHS.split(" ");
		
//		
		
//		maHS.replace(" ", "%");
//		if(maHS.equals("")) {
//			hsFind = hocSinhRepository.findByHoTen(tenHS);
//			
//		}else {
//			if(hocSinhRepository.findByMaHocSinh(maHS).isEmpty()) {
//				hsFind = hocSinhRepository.findByHoTen(tenHS);
//				
//			}else {
//				hsFind = hocSinhRepository.findByMaHocSinh(maHS);
//			}
//		}
		for(HocSinh hs: list) {
			if(!(maHS.isBlank())) {
				for(String ma: part) {
					if(hs.getMaHocSinh().contains(ma)) {
						hsFind.add(hs);
						break;
					}
				}
			}
			else if(hs.getHoTen().toLowerCase().contains(tenHS) &&!(tenHS.isBlank())) {
				hsFind.add(hs);
			}
			else {
				continue;
			}
		}
		
		
		
		
		model.addAttribute("CacHocSinh", hsFind);

		return "search";
	}
	
	

}
