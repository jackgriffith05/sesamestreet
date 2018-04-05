import com.fasterxml.jackson.annotation.JsonProperty;

public class Price
{
    @JsonProperty("exchange-type")
    private String exchangetype;
    @JsonProperty("decimal-odds")
    private String decimalodds;
    private String side;
    @JsonProperty("odds-type")
    private String oddstype;
    @JsonProperty("available-amount")
    private double availableamount;
    private double odds;
    private String currency;

    public String getExchangetype()
    {
        return exchangetype;
    }

    public void setExchangetype(String exchangetype)
    {
        this.exchangetype = exchangetype;
    }

    public String getDecimalodds()
    {
        return decimalodds;
    }

    public void setDecimalodds(String decimalodds)
    {
        this.decimalodds = decimalodds;
    }

    public String getSide()
    {
        return side;
    }

    public void setSide(String side)
    {
        this.side = side;
    }

    public String getOddstype()
    {
        return oddstype;
    }

    public void setOddstype(String oddstype)
    {
        this.oddstype = oddstype;
    }

    public double getAvailableamount()
    {
        return availableamount;
    }

    public void setAvailableamount(double availableamount)
    {
        this.availableamount = availableamount;
    }

    public double getOdds()
    {
        return odds;
    }

    public void setOdds(double odds)
    {
        this.odds = odds;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    @Override
    public String toString()
    {
        return "£" + this.availableamount + "@" + this.odds;
    }
}
