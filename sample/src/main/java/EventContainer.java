import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

import java.util.List;

public class EventContainer
{
    private String total;
    private List<MatchBookEvent> matchBookEvents;
    @JsonProperty("per-page")
    private String perpage;
    private String offset;
    private final DateTime arrivalTime;

    public EventContainer()
    {
        this.arrivalTime = new DateTime();
    }

    public String getTotal()
    {
        return total;
    }

    public void setTotal(String total)
    {
        this.total = total;
    }

    public List<MatchBookEvent> getEvents()
    {
        return matchBookEvents;
    }

    public void setEvents(List<MatchBookEvent> matchBookEvents)
    {
        this.matchBookEvents = matchBookEvents;
    }

    public String getPerpage()
    {
        return perpage;
    }

    public void setPerpage(String perpage)
    {
        this.perpage = perpage;
    }

    public String getOffset()
    {
        return offset;
    }

    public void setOffset(String offset)
    {
        this.offset = offset;
    }

    public DateTime getArrivalTime()
    {
        return arrivalTime;
    }
}
