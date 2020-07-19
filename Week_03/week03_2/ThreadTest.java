package week03_2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadTest threadTest = new ThreadTest();

        //threadTest.map.put("age",10);
        threadTest.map.computeIfAbsent("age", key->new LongAdder()).add(10);

        int threadNum=500;
        Thread[] threads=new Thread[threadNum];
        for (int i = 0; i < threadNum; i++) {
            threads[i]=new Thread(()-> {
                threadTest.t1();
            });//.start();
        }

        for(int i = 0; i < threadNum; i++){
            threads[i].start();
        }

        for(int i = 0; i < threadNum; i++){
            threads[i].join();
        }
        System.out.println("map:" + threadTest.map);
    }
    //方式1：加锁 map
    /*public Map<String,Integer> map=new ConcurrentHashMap<String,Integer>();
    public void t1(){
        synchronized (map){
            map.put("age",(Integer)map.get("age")+1);
        }
    }*/

    //方式2：LongAdder
    public Map<String, LongAdder> map=new ConcurrentHashMap<String,LongAdder>();
    public void t1(){
        map.computeIfAbsent("age",key->new LongAdder()).increment();
    }
}