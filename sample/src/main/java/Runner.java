import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Runner
{
    private String id;
    private String status;
    private String withdrawn;
    private String name;
    private String volume;
    private Double handicap;
    @JsonProperty("asian-handicap")
    private String asianhandicap;
    private List<Price> prices;
    @JsonProperty("event-participant-id")
    private String eventparticipantid;
    @JsonProperty("event-id")
    private String eventid;
    @JsonProperty("market-id")
    private String marketid;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getWithdrawn()
    {
        return withdrawn;
    }

    public void setWithdrawn(String withdrawn)
    {
        this.withdrawn = withdrawn;
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

    public List<Price> getPrices()
    {
        return prices;
    }

    public void setPrices(List<Price> prices)
    {
        this.prices = prices;
    }

    public String getEventparticipantid()
    {
        return eventparticipantid;
    }

    public void setEventparticipantid(String eventparticipantid)
    {
        this.eventparticipantid = eventparticipantid;
    }

    public String getEventid()
    {
        return eventid;
    }

    public void setEventid(String eventid)
    {
        this.eventid = eventid;
    }

    public String getMarketid()
    {
        return marketid;
    }

    public void setMarketid(String marketid)
    {
        this.marketid = marketid;
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

    @Override
    public String toString()
    {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
