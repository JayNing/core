package com.jay.demo.spi;

import com.jay.demo.spi.dubbo.service.DubboLoadBalance;
import com.jay.demo.spi.java.service.LoadBalance;
import com.jay.demo.spi.spring.service.SpringLoadBalance;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.extension.LoadingStrategy;
import org.junit.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * desc:
 * createBy: Ningjianjian
 */
public class SPIDemo {

    public static void main(String[] args) {

        ServiceLoader<LoadBalance> load = ServiceLoader.load(LoadBalance.class);
        Iterator<LoadBalance> iterator = load.iterator();
        while (iterator.hasNext()) {
            LoadBalance next = iterator.next();
            next.invoke();
        }

    }

    @Test
    public void testJavaSPI(){
        ServiceLoader<LoadBalance> load = ServiceLoader.load(LoadBalance.class);
        Iterator<LoadBalance> iterator = load.iterator();
        while (iterator.hasNext()) {
            LoadBalance next = iterator.next();
            next.invoke();
        }
    }

    @Test
    public void testSpringSPI() throws ClassNotFoundException {
        //方式一
        List<String> stringLoadBalances = SpringFactoriesLoader.loadFactoryNames(Class.forName("com.jay.demo.spi.spring.service.SpringLoadBalance"), EnableAutoConfiguration.class.getClassLoader());
        for (String stringLoadBalance : stringLoadBalances) {
            System.out.println(stringLoadBalance);
        }
        System.out.println("=================================================================");
        //方式二
        List<SpringLoadBalance> springLoadBalances = SpringFactoriesLoader.loadFactories(SpringLoadBalance.class, EnableAutoConfiguration.class.getClassLoader());
        Iterator<SpringLoadBalance> iterator = springLoadBalances.iterator();
        while (iterator.hasNext()) {
            SpringLoadBalance next = iterator.next();
            next.invoke();
        }
    }

    @Test
    public void testDubboSPI() {
//        List<LoadingStrategy> loadingStrategies = ExtensionLoader.getLoadingStrategies();
//        Iterator<LoadingStrategy> iterator = loadingStrategies.iterator();
//        while (iterator.hasNext()) {
//            LoadingStrategy next = iterator.next();
//
//        }

        ExtensionLoader<DubboLoadBalance> extensionLoader = ExtensionLoader.getExtensionLoader(DubboLoadBalance.class);

        DubboLoadBalance random = extensionLoader.getExtension("random");
        DubboLoadBalance lru = extensionLoader.getExtension("lru");
        System.out.println("random....." );
        random.invoke();
        System.out.println("lru....." );
        lru.invoke();
        System.out.println("===================");
        DubboLoadBalance defaultExtension = extensionLoader.getDefaultExtension();
        System.out.println("default....." );
        defaultExtension.invoke();
        DubboLoadBalance adaptiveExtension = extensionLoader.getAdaptiveExtension();
        System.out.println("adaptive....." );
        adaptiveExtension.invoke();

    }
}
