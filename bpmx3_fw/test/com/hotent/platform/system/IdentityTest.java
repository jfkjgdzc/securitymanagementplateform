package com.hotent.platform.system;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import com.hotent.BaseTestCase;
import com.hotent.platform.service.system.IdentityService;

public class IdentityTest extends BaseTestCase {
	
	@Resource
	IdentityService identityService;
	
	
	@org.junit.Test
	public void GenIdentityTest(){
		final Set set=Collections.synchronizedSet(new HashSet()) ;
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10,20, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());  
        int n = 10;  
       
      
        for(int i=0; i<n; i++) {  
            executor.execute(new Runnable() {
				
				@Override
				public void run() {
					for(int k=1;k<=100;k++){
						
							String id = identityService.nextId("SX");
							set.add(id);
						
						
					}
				}
			});  
        }  
  
        executor.shutdown();  
        long start=System.currentTimeMillis();
       
        try {  
            boolean loop = true;   
            do {    //等待所有任务完成  
                loop = !executor.awaitTermination(1,TimeUnit.DAYS                		);
              
            } while(loop);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        System.out.println(set.size());
        System.out.println(System.currentTimeMillis()-start);
	}

}
