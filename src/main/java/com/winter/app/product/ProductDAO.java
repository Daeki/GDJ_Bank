package com.winter.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.util.Pager;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String nameSpace = "com.winter.app.product.ProductDAO.";
	
	//LIST
	public List<ProductDTO> getList(Pager pager) throws Exception{
		return sqlSession.selectList(nameSpace+"getList", pager);
	}
	
	//PAGE
	public Long totalData(Pager pager) throws Exception {
		return sqlSession.selectOne(nameSpace+"totalData", pager);
	}
	
	//DETAIL
	public ProductDTO getDetail(ProductDTO pD) throws Exception {
		return sqlSession.selectOne(nameSpace+"getDetail", pD);
	}
	
	public List<ProductFileDTO> getDetailFiles(ProductDTO pD) throws Exception{
		return sqlSession.selectList(nameSpace+"getDetailFiles", pD);
	}
	
	//ADD
	public int addProduct(ProductDTO pD) throws Exception{
		return sqlSession.insert(nameSpace+"addProduct", pD);
	}
	
	public int addFile(ProductFileDTO pFileDTO) throws Exception {
		return sqlSession.insert(nameSpace+"addFile", pFileDTO);
	}
	
	//UPDATE
	public int updateProduct(ProductDTO pD) throws Exception {
		return sqlSession.update(nameSpace+"updateProduct", pD);
	}
	
	//DELETE
	public int deleteProduct(ProductDTO pD) throws Exception {
		return sqlSession.update(nameSpace+"deleteProduct", pD);
	}
}
