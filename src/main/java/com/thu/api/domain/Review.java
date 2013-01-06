/**
 * 
 */
package com.thu.api.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.thu.api.adapter.IndividualCustomerXMLAdapter;

/**
 * @author LS
 *
 */

@Entity
@Table(name="Review")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "review")
public class Review implements DomainObject<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "re_id")
    private Long id;
	
    @Column(name = "re_image_url")
    private String imageUrl;
    
    @Column(name = "re_voice_url")
    private String voiceUrl;
    
    @Column(name = "re_voice_text")
	private String voiceText;

	@Column(name = "re_review_comment")
	private String reviewComment;

	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn (name="re_reviewer_id")
	@Fetch (FetchMode.JOIN)
	@XmlJavaTypeAdapter (IndividualCustomerXMLAdapter.class)
	private IndividualCustomer reviewer;

	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn (name="re_reviewee_id")
	@Fetch (FetchMode.JOIN)
	private IndividualCustomer reviewee;

	public String getImageUrl() {
		return imageUrl;
	}

	public String getVoiceUrl() {
		return voiceUrl;
	}

	public String getVoiceText() {
		return voiceText;
	}

	public String getReviewComment() {
		return reviewComment;
	}


	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public IndividualCustomer getReviewer() {
		return reviewer;
	}

	public void setReviewer(IndividualCustomer reviewer) {
		this.reviewer = reviewer;
	}

	public IndividualCustomer getReviewee() {
		return reviewee;
	}

	public void setReviewee(IndividualCustomer reviewee) {
		this.reviewee = reviewee;
	}

	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setVoiceUrl(String voiceUrl) {
		this.voiceUrl = voiceUrl;
	}

	public void setVoiceText(String voiceText) {
		this.voiceText = voiceText;
	}

	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}

}
