package hs.dcl.test.controller.redis;

import java.util.concurrent.TimeUnit;

public class Ticket {

    //初始库存量
    Integer ticketNum = 8;

    public static void main(String[] args) throws InterruptedException {
        Ticket ticket = new Ticket();
        //开启10个线程进行抢票，按理说应该有两个人抢不到票
        for(int i = 0 ; i <10;i++){
            new Thread(()-> ticket.reduce(1),"用户"+(i + 1)).start();
        }
        Thread.sleep(1000L);
    }
    public  synchronized void reduce(int num){
        //判断库存是否够用
        if((ticketNum - num) >= 0){
            try{
                TimeUnit.MILLISECONDS.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            ticketNum -= num;
            System.out.println(Thread.currentThread().getName()
                    +"成功卖出："+ num +"张，剩余："+ticketNum + "张票"
            );
        }else{
            System.out.println(Thread.currentThread().getName()
                    +"没有卖出："+ num +"张，剩余："+ticketNum + "张票"
            );
        }
    }

}
