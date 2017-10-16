package com.test;

import org.junit.Test;

import com.fish.util.DateUtil;
import com.service.rest.chat.WebChatService;

public class TestChat {

	@Test
	public void save() {
		WebChatService wcs = new WebChatService();
		wcs.save("3306", "Mr book", DateUtil.getCurrentTime(), "Are you all right, my dear?");
	}

}
