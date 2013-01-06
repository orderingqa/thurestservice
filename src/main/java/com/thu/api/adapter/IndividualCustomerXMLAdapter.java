package com.thu.api.adapter;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.log4j.Logger;

import com.thu.api.domain.IndividualCustomer;

public class IndividualCustomerXMLAdapter extends XmlAdapter<Long, IndividualCustomer> {
	protected final Logger logger = Logger.getLogger(getClass());
	
//	@Context
//	private IndividualCustomerService userService;
	
	@Override
	public Long marshal(IndividualCustomer arg0) throws Exception {
		return arg0.getId();
	}

	@Override
	public IndividualCustomer unmarshal(Long arg0) throws Exception {
		// JAXB.unmarshal完全可以从数据库中load出来一个User对象，但遗憾的是，这个对象给ReviewDaompl来填充Review对象，
		// 然后对em.persist(domainObject)时还是会报如下错误。
//		javax.persistence.PersistenceException: org.hibernate.PersistentObjectException: detached entity passed to persist: com.thu.api.domain.IndividualCustomer
//		return JAXB.unmarshal("http://localhost:8080/example-1.0-SNAPSHOT/api/user/"+arg0, IndividualCustomer.class);
		IndividualCustomer u = new IndividualCustomer();
		u.setId(arg0);
		return u;
	}
	
//    public void setUserService(IndividualCustomerService userService) {
//        this.userService = userService;
//    }

}
