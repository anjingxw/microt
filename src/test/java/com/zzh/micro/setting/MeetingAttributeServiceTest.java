package com.zzh.micro.setting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zzh.micro.BaseTest;
import com.zzh.micro.repository.MeetingAttributeReprository;
import com.zzh.micro.service.MeetingAttributeService;

public class MeetingAttributeServiceTest extends BaseTest {
	@Autowired
	MeetingAttributeService  meetingAttributeService;
	@Autowired
	MeetingAttributeReprository  meetingAttributeReprository;
	
	
	@Test
	public void Test(){
		Long addId = meetingAttributeService.Add("test", 1L).getData();
		assertEquals("test", meetingAttributeReprository.findOne(addId).getMeetingAttributeName());
		meetingAttributeService.Update(addId, "D");
		assertEquals("D", meetingAttributeReprository.findOne(addId).getMeetingAttributeName());
		meetingAttributeService.Delete(addId);
		assertEquals(false, meetingAttributeReprository.exists(addId));
	}

}
