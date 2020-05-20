public class AdvertismentsThread extends Thread {
  @Override
  public void run(){
    while(true){
      System.out.println("This is an advertisment!");
      try{
        Thread.sleep(300000);
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }   
  }
}