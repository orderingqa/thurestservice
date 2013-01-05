
package com.thu.api.domain;

import java.io.Serializable;

/**
 *
 * @author craigmackay
 */
public interface DomainObject<ID extends Serializable> extends Serializable {

    ID getId();
    
    void setId(ID id);
    
}
