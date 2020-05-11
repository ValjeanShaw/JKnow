package Base.proxy.staticproxy;

/**
 * 
 * 代理商
 * 
 * 可理解为电影院，
 * 
 * @author xiaoran
 * @date 2020/04/18
 */
public class Cinema implements Movie{
    private String adLogo;

    Movie movie;
    
    public Cinema(Movie movie){
        this.movie = movie;
    }
    
    
    @Override
    public void play() {
        //代理商自己接的广告
        ad();
        //执行代理的任务
        movie.play();
    }



    /**
     * 接收广告
     * @param adLogo
     * @return
     */
    public boolean receiveAds(String adLogo){
        this.adLogo = adLogo;
        return true;
    }
    /**
     * 代理商自己要做的事情
     * 
     * 接广告插播
     */
    private void ad(){
        System.out.println(adLogo);
    }
}
