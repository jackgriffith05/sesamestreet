import com.fasterxml.jackson.annotation.JsonProperty;
import org.eclipse.collections.impl.utility.Iterate;

import java.util.Date;
import java.util.List;

public class MatchBookMarket
{
    @JsonProperty("in-running-flag")
    private String inrunningflag;
    private String status;
    @JsonProperty("allow-live-betting")
    private String allowlivebetting;
    private String type;
    private String id;
    @JsonProperty("back-overround")
    private String backoverround;
    private String start;
    private String name;
    private String volume;
    private Double handicap;
    @JsonProperty("asian-handicap")
    private String asianhandicap;
    private List<Runner> runners;
    @JsonProperty("lay-overround")
    private String layoverround;
    @JsonProperty("market-type")
    private String markettype;
    @JsonProperty("event-id")
    private String eventid;
    private String live;

    private volatile MatchBookEvent matchBookEvent; // added by us locally to maintain market->matchBookEvent relationship
    private Date apiRequestTime;

    public String getInrunningflag()
    {
        return inrunningflag;
    }

    public void setInrunningflag(String inrunningflag)
    {
        this.inrunningflag = inrunningflag;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getAllowlivebetting()
    {
        return allowlivebetting;
    }

    public void setAllowlivebetting(String allowlivebetting)
    {
        this.allowlivebetting = allowlivebetting;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getBackoverround()
    {
        return backoverround;
    }

    public void setBackoverround(String backoverround)
    {
        this.backoverround = backoverround;
    }

    public String getStart()
    {
        return start;
    }

    public void setStart(String start)
    {
        this.start = start;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getVolume()
    {
        return volume;
    }

    public void setVolume(String volume)
    {
        this.volume = volume;
    }

    public List<Runner> getRunners()
    {
        return runners;
    }

    public void setRunners(List<Runner> runners)
    {
        this.runners = runners;
    }

    public String getLayoverround()
    {
        return layoverround;
    }

    public void setLayoverround(String layoverround)
    {
        this.layoverround = layoverround;
    }

    public String getMarkettype()
    {
        return markettype;
    }

    public void setMarkettype(String markettype)
    {
        this.markettype = markettype;
    }

    public String getEventid()
    {
        return eventid;
    }

    public void setEventid(String eventid)
    {
        this.eventid = eventid;
    }

    public String getLive()
    {
        return live;
    }

    public void setLive(String live)
    {
        this.live = live;
    }

    public Double getHandicap()
    {
        return handicap;
    }

    public void setHandicap(Double handicap)
    {
        this.handicap = handicap;
    }

    public String getAsianhandicap()
    {
        return asianhandicap;
    }

    public void setAsianhandicap(String asianhandicap)
    {
        this.asianhandicap = asianhandicap;
    }

    public MatchBookEvent getEvent()
    {
        return matchBookEvent;
    }

    public void setEvent(MatchBookEvent matchBookEvent)
    {
        this.matchBookEvent = matchBookEvent;
    }

    @Override
    public String toString()
    {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", matchBookEvent=" + matchBookEvent +
                '}';
    }

    public Runner getRunner(String matchBookRunnerId)
    {
        return Iterate.detect(this.getRunners(), runner -> runner.getId().equals(matchBookRunnerId)); // TODO: can we index these? what about in-place runner updates, do those happen? would runner refs get stale?
    }

    public void setApiRequestTime(Date apiRequestTime)
    {
        this.apiRequestTime = apiRequestTime;
    }

    public Date getApiRequestTime()
    {
        return apiRequestTime;
    }
}
