import com.fasterxml.jackson.annotation.JsonProperty;

public class Metatag
{
    private String id;
    @JsonProperty("url-name")
    private String urlname;
    private String name;
    private String type;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUrlname()
    {
        return urlname;
    }

    public void setUrlname(String urlname)
    {
        this.urlname = urlname;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
