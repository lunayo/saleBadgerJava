package app.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import app.model.Product;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

	@Autowired MongoTemplate mongoTemplate;
	@Override
	public List<Product> findNearby(Point point, int skip, int limit) {

		List<Product> nearestProducts = 
			    mongoTemplate.find(new Query(Criteria.where("location").nearSphere(point)).skip(skip).limit(limit), Product.class);
		return nearestProducts;
		
	}

}
