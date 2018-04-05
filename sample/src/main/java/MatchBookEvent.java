import com.fasterxml.jackson.annotation.JsonProperty;
import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.tuple.Tuples;

import java.util.List;

public class MatchBookEvent
{
    private String id;
    @JsonProperty("in-running-flag")
    private String inrunningflag;
    private List<MatchBookMarket> markets;
    private String status;
    private String start;
    private String name;
    @JsonProperty("meta-tags")
    private List<Metatag> metatags;
    private String volume;
    @JsonProperty("category-id")
    private List<String> categoryid;
    @JsonProperty("allow-live-betting")
    private String allowlivebetting;
    @JsonProperty("sport-id")
    private String sportid;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getInrunningflag()
    {
        return inrunningflag;
    }

    public void setInrunningflag(String inrunningflag)
    {
        this.inrunningflag = inrunningflag;
    }

    public List<MatchBookMarket> getMarkets()
    {
        return markets;
    }

    public void setMarkets(List<MatchBookMarket> markets)
    {
        this.markets = markets;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
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

    public List<Metatag> getMetatags()
    {
        return metatags;
    }

    public void setMetatags(List<Metatag> metatags)
    {
        this.metatags = metatags;
    }

    public String getVolume()
    {
        return volume;
    }

    public void setVolume(String volume)
    {
        this.volume = volume;
    }

    public List<String> getCategoryid()
    {
        return categoryid;
    }

    public void setCategoryid(List<String> categoryid)
    {
        this.categoryid = categoryid;
    }

    public String getAllowlivebetting()
    {
        return allowlivebetting;
    }

    public void setAllowlivebetting(String allowlivebetting)
    {
        this.allowlivebetting = allowlivebetting;
    }

    public String getSportid()
    {
        return sportid;
    }

    public void setSportid(String sportid)
    {
        this.sportid = sportid;
    }

    @Override
    public String toString()
    {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sportid='" + sportid + '\'' +
                '}';
    }

    public Twin<String> getTeams()
    {
        int i = this.name.indexOf(" vs ");
        if (i < 0)
        {
            return Tuples.twin(this.name, this.name);
        }
        String teamA = this.name.substring(0, i);
        String teamB = this.name.substring(i + 4, this.name.length());
        return Tuples.twin(teamA, teamB);
    }
}
