package com.thu.api.dao.jpa;

import com.thu.api.dao.ReviewDao;
import com.thu.api.domain.Review;
import com.thu.api.domain.IndividualCustomer;

public class ReviewDaoImpl extends GenericDaoImpl<Review, Long> implements
		ReviewDao {
	// TODO 我可以覆写父类的create函数从而实现关联关系
	/** {@inheritDoc} */
	public Review create(Review domainObject) {
		if (logger.isDebugEnabled()) {
			logger.debug("create called for Review DO: " + domainObject);

			logger.debug("id = " + domainObject.getId());
			logger.debug("voice = " + domainObject.getVoiceUrl());
			logger.debug("reviewer =" + domainObject.getReviewer());
			if (domainObject.getReviewer() != null) {
				logger.debug("user = " + domainObject.getReviewer().getId());
				logger.debug("user password = "
						+ domainObject.getReviewer().getEmail());
			} else {
				logger.debug("user of reviewer = null");
			}
		}
		try { // Review中的对象是unmarshal的一个只有id的pojo，这里从DB中load出来hibernate object，然后进行持久化
			IndividualCustomer individualCustomer = em.find(IndividualCustomer.class, domainObject.getReviewer().getId());
			domainObject.setReviewer(individualCustomer);
			em.persist(domainObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return domainObject;
	}
}
