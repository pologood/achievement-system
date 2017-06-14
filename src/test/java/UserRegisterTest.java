/*

import com.achievement.event.UserRegisterEvent;
import com.achievement.factory.UserRegisterEventFactory;
import com.achievement.handler.UserRegisterEventHandler;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;


public class UserRegisterTest {
    public static void main(String args[]){
        EventFactory<UserRegisterEvent> eventFactory = new UserRegisterEventFactory();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        int ringBufferSize = 1024*1024;
        Disruptor<UserRegisterEvent> disruptor = new Disruptor<UserRegisterEvent>(eventFactory,
                ringBufferSize, new ThreadFactory() {
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                return thread;
            }
        }, ProducerType.SINGLE,
                new YieldingWaitStrategy());

        EventHandler<UserRegisterEvent> eventHandler = new UserRegisterEventHandler();

        disruptor.handleEventsWith(eventHandler,eventHandler);

        disruptor.start();

        // 发布事件；
        RingBuffer<UserRegisterEvent> ringBuffer = disruptor.getRingBuffer();
        for(int i=0;i<1;i++) {
            long sequence = ringBuffer.next();//请求下一个事件序号；
            ringBuffer.newBarrier();
            try {
                UserRegisterEvent event = ringBuffer.get(sequence);//获取该序号对应的事件对象；
                event.setName("achievement" + i);
            } finally {
                ringBuffer.publish(sequence);//发布事件；
            }
        }
    }
}
*/
