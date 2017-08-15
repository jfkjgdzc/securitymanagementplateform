package com.hotent.core.util;

import com.hotent.BaseTestCase;

public class UniqueIdTest extends BaseTestCase {
	
	@org.junit.Test
	public void GenUid(){
		for(int i=0;i<100000;i++){
			UniqueIdUtil.genId();
		}
		
	}

}
