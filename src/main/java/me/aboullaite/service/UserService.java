package me.aboullaite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import me.aboullaite.model.Section1;
import me.aboullaite.model.Section10;
import me.aboullaite.model.Section11;
import me.aboullaite.model.Section12;
import me.aboullaite.model.Section13;
import me.aboullaite.model.Section14;
import me.aboullaite.model.Section15;
import me.aboullaite.model.Section16;
import me.aboullaite.model.Section17;
import me.aboullaite.model.Section18;
import me.aboullaite.model.Section19;
import me.aboullaite.model.Section2;
import me.aboullaite.model.Section20;
import me.aboullaite.model.Section21;
import me.aboullaite.model.Section3;
import me.aboullaite.model.Section4;
import me.aboullaite.model.Section5;
import me.aboullaite.model.Section6;
import me.aboullaite.model.Section7;
import me.aboullaite.model.Section8;
import me.aboullaite.model.Section9;

/**
 * Created by aboullaite on 2017-02-23.
 */

@Service
public class UserService {

	@Autowired
	MongoTemplate mongoTemplate;

	public List<Section1> findAllSection1DataForUserAndClient(String username, String client) {
		Query query = new Query(Criteria.where("user").is(username).andOperator(Criteria.where("client").is(client)));
		List<Section1> section1 = mongoTemplate.find(query, Section1.class);
		return section1;
	}

	public List<Section2> findAllSection2DataForUserAndClient(String username, String client) {
		Query query = new Query(Criteria.where("user").is(username).andOperator(Criteria.where("client").is(client)));
		List<Section2> section2 = mongoTemplate.find(query, Section2.class);
		return section2;
	}

	public List<Section3> findAllSection3DataForUserAndClient(String username, String client) {
		Query query = new Query(Criteria.where("user").is(username).andOperator(Criteria.where("client").is(client)));
		List<Section3> section3 = mongoTemplate.find(query, Section3.class);
		return section3;
	}

	public List<Section4> findAllSection4DataForUserAndClient(String username, String client) {
		Query query = new Query(Criteria.where("user").is(username).andOperator(Criteria.where("client").is(client)));
		List<Section4> section4 = mongoTemplate.find(query, Section4.class);
		return section4;
	}

	public List<Section5> findAllSection5DataForUserAndClient(String username, String client) {
		Query query = new Query(Criteria.where("user").is(username).andOperator(Criteria.where("client").is(client)));
		List<Section5> section5 = mongoTemplate.find(query, Section5.class);
		return section5;
	}

	public List<Section6> findAllSection6DataForUserAndClient(String username, String client) {
		Query query = new Query(Criteria.where("user").is(username).andOperator(Criteria.where("client").is(client)));
		List<Section6> section6 = mongoTemplate.find(query, Section6.class);
		return section6;
	}

	public List<Section7> findAllSection7DataForUserAndClient(String username, String client) {
		Query query = new Query(Criteria.where("user").is(username).andOperator(Criteria.where("client").is(client)));
		List<Section7> section7 = mongoTemplate.find(query, Section7.class);
		return section7;
	}

	public List<Section8> findAllSection8DataForUserAndClient(String username, String client) {
		Query query = new Query(Criteria.where("user").is(username).andOperator(Criteria.where("client").is(client)));
		List<Section8> section8 = mongoTemplate.find(query, Section8.class);
		return section8;
	}

	public List<Section9> findAllSection9DataForUserAndClient(String username, String client) {
		Query query = new Query(Criteria.where("user").is(username).andOperator(Criteria.where("client").is(client)));
		List<Section9> section9 = mongoTemplate.find(query, Section9.class);
		return section9;
	}

	public List<Section10> findAllSection10DataForUserAndClient(String username, String client) {
		Query query = new Query(Criteria.where("user").is(username).andOperator(Criteria.where("client").is(client)));
		List<Section10> section10 = mongoTemplate.find(query, Section10.class);
		return section10;
	}

	public List<Section11> findAllSection11DataForUserAndClient(String username, String client) {
		Query query = new Query(Criteria.where("user").is(username).andOperator(Criteria.where("client").is(client)));
		List<Section11> section11 = mongoTemplate.find(query, Section11.class);
		return section11;
	}

	public List<Section12> findAllSection12DataForUserAndClient(String username, String client) {
		Query query = new Query(Criteria.where("user").is(username).andOperator(Criteria.where("client").is(client)));
		List<Section12> section12 = mongoTemplate.find(query, Section12.class);
		return section12;
	}

	public List<Section13> findAllSection13DataForUserAndClient(String username, String client) {
		Query query = new Query(Criteria.where("user").is(username).andOperator(Criteria.where("client").is(client)));
		List<Section13> section13 = mongoTemplate.find(query, Section13.class);
		return section13;
	}

	public List<Section14> findAllSection14DataForUserAndClient(String username, String client) {
		Query query = new Query(Criteria.where("user").is(username).andOperator(Criteria.where("client").is(client)));
		List<Section14> section14 = mongoTemplate.find(query, Section14.class);
		return section14;
	}

	public List<Section15> findAllSection15DataForUserAndClient(String username, String client) {
		Query query = new Query(Criteria.where("user").is(username).andOperator(Criteria.where("client").is(client)));
		List<Section15> section15 = mongoTemplate.find(query, Section15.class);
		return section15;
	}

	public List<Section16> findAllSection16DataForUserAndClient(String username, String client) {
		Query query = new Query(Criteria.where("user").is(username).andOperator(Criteria.where("client").is(client)));
		List<Section16> section16 = mongoTemplate.find(query, Section16.class);
		return section16;
	}

	public List<Section17> findAllSection17DataForUserAndClient(String username, String client) {
		Query query = new Query(Criteria.where("user").is(username).andOperator(Criteria.where("client").is(client)));
		List<Section17> section17 = mongoTemplate.find(query, Section17.class);
		return section17;
	}

	public List<Section18> findAllSection18DataForUserAndClient(String username, String client) {
		Query query = new Query(Criteria.where("user").is(username).andOperator(Criteria.where("client").is(client)));
		List<Section18> section18 = mongoTemplate.find(query, Section18.class);
		return section18;
	}

	public List<Section19> findAllSection19DataForUserAndClient(String username, String client) {
		Query query = new Query(Criteria.where("user").is(username).andOperator(Criteria.where("client").is(client)));
		List<Section19> section19 = mongoTemplate.find(query, Section19.class);
		return section19;
	}

	public List<Section20> findAllSection20DataForUserAndClient(String username, String client) {
		Query query = new Query(Criteria.where("user").is(username).andOperator(Criteria.where("client").is(client)));
		List<Section20> section20 = mongoTemplate.find(query, Section20.class);
		return section20;
	}

	public List<Section21> findAllSection21DataForUserAndClient(String username, String client) {
		Query query = new Query(Criteria.where("user").is(username).andOperator(Criteria.where("client").is(client)));
		List<Section21> section21 = mongoTemplate.find(query, Section21.class);
		return section21;
	}

}
