package com.winter.app.product;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.FileManager;
import com.winter.app.util.Pager;

@Service
public class ProductService {

	@Autowired
	public ProductDAO productDAO;
	
	@Autowired
	public ServletContext servletContext;
	
	@Autowired
	public FileManager fileManager;
	
	public List<ProductDTO> getList(Pager pager) throws Exception{
		pager.makeRow();
		Long totalCount = productDAO.totalData(pager);
		pager.makeNum(totalCount);
		List<ProductDTO> ar = productDAO.getList(pager);
		
		return ar;
	}
	
	public ProductDTO getDetail(ProductDTO pD) throws Exception {
		return productDAO.getDetail(pD);
	}
	
	public int addProduct(ProductDTO pD, MultipartFile[] file) throws Exception {
		int result = productDAO.addProduct(pD);
		
		String path = servletContext.getRealPath("resources/upload/product");
		
		for(MultipartFile f:file) {
			
			if(f.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(path, f);
			//4. DB에 정보 저장
			ProductFileDTO fileDTO = new ProductFileDTO();
			fileDTO.setFileName(fileName);
			fileDTO.setOriName(f.getOriginalFilename());
			fileDTO.setProductNum(pD.getProductNum());
			result = productDAO.addFile(fileDTO);			
			System.out.println(path);
		}
		return result;
	}
	
	public int updateProduct(ProductDTO pD) throws Exception {
		return productDAO.updateProduct(pD);
	}
	
	public int deleteProduct(ProductDTO pD) throws Exception {
		return productDAO.deleteProduct(pD);
	}
	
}
