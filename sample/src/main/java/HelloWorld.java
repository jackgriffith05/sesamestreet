import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld
{
    private static final Logger LOG = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args)
    {
        Api api = new Api();
        MutableList<Long> runtimes = Lists.mutable.of();
        while (true)
        {
            long startTime = System.currentTimeMillis();
            EventContainer events = api.getEvents(args[0]);
            long endTime = System.currentTimeMillis();

            long runtime = endTime - startTime;
            runtimes.add(runtime);

            LOG.info("{}, numEvents={}, latest={}", runtimes.summarizeLong(l -> l), events.getEvents().size(), runtime);
        }
    }
}
