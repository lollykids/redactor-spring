package org.beanio.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.beanio.BeanReader;
import org.beanio.BeanReaderIOException;
import org.beanio.StreamFactory;
import org.beanio.model.Beanio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.service.ResourceService;
import org.springframework.stereotype.Service;

@Service
public class BeanioService {

	 @Autowired ResourceService resourceService;
	 @Autowired Beanio beanio;
	 
	@SuppressWarnings({"rawtypes","unchecked"})
	public List<Object> load(String obj){
		List objs = new ArrayList<Object>();
		StreamFactory factory = StreamFactory.newInstance();
		try {
			Resource resource = resourceService.getResource(String.format("classpath:%s.xml", beanio.getPath(), obj.toLowerCase()));
			InputStream is = resource.getInputStream();
			factory.load(is);
			Resource resource2 = resourceService.getResource(String.format("%s%s.csv", beanio.getPath() ,obj.toLowerCase()));
			BeanReader in = factory.createReader(obj.toLowerCase() + "s", resource2.getFile());
			Object record = null;
			while ((record = in.read()) != null) {
				if (obj.toLowerCase().equals(in.getRecordName())) {
					objs.add(record);
				}
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BeanReaderIOException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		}
		return objs;
	}
}
