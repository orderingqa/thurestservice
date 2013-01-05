
package com.thu.api.domain.service;

import com.thu.api.dao.UserDao;
import com.thu.api.domain.User;

/**
 *
 * @author craigmackay
 */
public class UserServiceImpl 
        extends GenericDomainObjectServiceImpl<UserDao, User, Long> 
        implements UserService {

}
