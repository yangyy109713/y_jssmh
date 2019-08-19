package designPrincinple;

/**
 * 设计模式-迪米特原则 示例说明
 * 如果两个软件实体无须直接通信，那么就不应当发生直接的相互调用，可以通过第三方转发该调用。
 * 目的是降低类之间的耦合度，提高模块的相对独立性
 */
public class LoDtest
{
    public static void main(String[] args)
    {
        Agent agent=new Agent();
        agent.setStar(new Star("路招摇"));
        agent.setFans(new Fans("粉丝韩。。"));
        agent.setCompany(new Company("中国传媒有限公司"));
        agent.meeting();
        agent.business();
    }
}
//经纪人
class Agent
{
    private Star myStar;
    private Fans myFans;
    private Company myCompany;
    public void setStar(Star myStar)
    {
        this.myStar=myStar;
    }
    public void setFans(Fans myFans)
    {
        this.myFans=myFans;
    }
    public void setCompany(Company myCompany)
    {
        this.myCompany=myCompany;
    }
    public void meeting()
    {
        System.out.println(myFans.getName()+"与明星"+myStar.getName()+"见面了。");
    }
    public void business()
    {
        System.out.println(myCompany.getName()+"与明星"+myStar.getName()+"洽淡业务。");
    }
}
//明星
class Star
{
    private String name;
    Star(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
}
//粉丝
class Fans
{
    private String name;
    Fans(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
}
//媒体公司
class Company
{
    private String name;
    Company(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
}

