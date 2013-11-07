package org.beanio;

import java.io.File;
import java.net.URL;

import org.junit.Test;

import com.lollykids.biz.model.User;

/**
 * @author hdlee
 * User csv sample
 */
public class UserCsvReaderTest {
	@Test
    public void main() throws Exception {
        StreamFactory factory = StreamFactory.newInstance();
        URL url2 = ClassLoader.getSystemResource("users.xml");
        factory.load(url2.openStream());
        URL url = ClassLoader.getSystemResource("input.csv");
        BeanReader in = factory.createReader("users", new File(url.toURI()));
        Object record = null;
        while ((record = in.read()) != null) {
            if ("user".equals(in.getRecordName())) {
                User user = (User) record;
                System.out.println(user);
            }
        }
        in.close();
    }
}